# 单例模式 ( Singleton )

## 用途

> 保证一个类仅有一个实例， 并提供一个访问它的全局访问点。让类自身负责保存它的唯一实例。 这个类可以保证没有其他实例可以被创建（通过截取创建新对象的请求 ）， 并且它可以提供一个访问该实例的方法

## 实例

> 在一部电影中，导演的作用是至关重要的，通常一部电影只有一个总导演。在电影的拍摄过程中，可能会设计多个片场，导演需要对不同的演员进行分别指导，但所有演员导演都是同一个人，“把导演叫过来” 这个过程可以视为单例模式获取实例的过程

## 模式分析

> 先来看最简单的写法

```
public class Single {
    private static Single instance;
    public static Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }
} 
```

> 稍作修改，把构造器改为私有的，防止被外部的类调用

```
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

> 每次获取实例对象之前先进行判空，如果对象为 null 则实例化一个 instance，如果存在则直接返回该实例。这种方法表面上看是完美的，仿佛实例只存在一个。但是，在多线程运行的时候，如果两个不同的线程同时运行到判空操作，会各自分别创建一个实例，这样一来，这种方法就不是单例了

> 在 getInstance() 方法上添加 synchronized 关键字

```
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
} 
```
> 这样写保证了 getInstance 方法同一时刻只会有一个线程执行，但是这样做会使得除了执行这个方法的线程顺利执行外，其他所有线程都要等待，这会造成极大的系统开销，降低了程序的运行效率

> 这种方法代价过高，因为无论 instance 是否为 null ,每次执行时，整个方法都加上了锁，我们不妨将锁的范围尽可能的缩小，把对性能的影响降到最低，于是有了如下写法

```
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
} 
```
> 只有当 instance 为 null 的时候才执行同步代码块，二次判空保证了不会产生多个实例

> 这样看似没问题了，但是在计算机中，有时为了提高运行效率，会对指令进行重拍，比如

```
int a;      //语句 A
a = 3;      //语句 B
int b = 5;      //语句 C
int c = a + b;  //语句 D
```
> 可能会被重排成 A-C-B-D 或者 C-A-B-D
>
> 语句 C 和语句 D 不具备原子性，因此也有可能被重排
> getInstance 操作如果被重排，那么 instance 会存在一种 “不为 null 但是仍然未被初始化” 的状态，即已经给 instance 分配了内存空间但是并没有调用 Singleton 的构造方法来初始化 instance，执行判空的线程抢在了初始化的操作完成之前，则直接返回 instance 肯定会报错
> 
> 于是有了最终版本，添加 volatile 关键字

```
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
} 
```
> volatile 关键字具有屏蔽指令重排的功能，即对 instance 加上了一把锁，在完成写操作之前不会允许其他线程进行读操作，因此，在初始化完成前，无法对其进行读操作

> 枚举类型是线程安全的，因此采用枚举类作为单例模式的一种实现是非常方便的

```
public enum Singleton {
    INSTANCE;
}
```

> 通过枚举类获取单例的实例
```
Singleton result = Singleton.INSTANCE;
```

## 适用场景

>* 类只能有一个实例而且客户可以从一个众所周知的访问点访问它
>* 这个唯一实例应该是通过子类化可扩展的， 并且客户应该无需更改代码就能使用一个扩展的实例