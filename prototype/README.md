# 原型模式  ( Prototype )

## 用途

> 用原型实例指定创建对象的种类， 并且通过拷贝这些原型创建新的对象

## 实例

> 首先要联想到克隆，最经典的一个例子就是克隆羊多利了。原型模式的核心就是在已经提供的对象的基础上来构造一个新的对象

## 模式分析

> 在 Java 中，克隆操作可以通过实现 Cloneable 接口并且重写定义于 Object 类中的 clone() 方法
```
public Sheep implements Cloneable {
    private String name;
    public Sheep(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    @Override
      public Sheep clone() throws CloneNotSupportedException {
        return new Sheep(this.name);
    }
}
```
> 克隆一个羊对象可以这样操作
```
...
Sheep origin = new Sheep("团团");
System.out.println(origin.getName());   //团团

origin.setName("圆圆");
Sheep clone = origin.clone();
System.out.println(clone.getName());    //圆圆
...
```

## 适用场景

> 当一个系统应该独立于它的产品创建、 构成和表示时， 要使用Prototype模式； 以及
>* 当要实例化的类是在运行时刻指定时， 例如， 通过动态装载
>* 为了避免创建一个与产品类层次平行的工厂类层次时
>* 当一个类的实例只能有几个不同状态组合中的一种时，建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些