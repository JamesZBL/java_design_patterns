# 抽象工厂模式 ( Abstract Factory )

## 用途

> 工厂 ( Factory ) 和产品 ( Product ) 是 Abstract Factory 模式的主要参与者。 该模式描述了怎样在不直接实例化类的情况下创建一系列相关的产品对象。 它最适用于产品对象的数目和种类不变， 而具体产品系列之间存在不同的情况。 我们通过实例化一个特定的具体工厂对象来选择产品系列， 并且以后一直使用该工厂生产产品对象。 我们也能够通过用一个不同的具体工厂实例来替换原来的工厂对象以改变整个产品系列。 抽象工厂模式对产品系列的强调使它区别于其他只与一种产品对象有关的创建性模式。

## 实例

> 假定一支远洋的队伍由船、船长以及水手组成，队伍有年轻和成熟之分。年轻的队伍有着年轻的船长、年轻的水手以及崭新的船只；而成熟的队伍有着老船长、老水手以及老旧的船只。不同队伍有着不同的主题，队伍中不同的物体存在一定的依赖性。

## 模式分析

> 首先定义队伍中几种组成部分的接口以及实现类

```
public interface Member {

  String getDescription();
}

public interface Captain extends Member {

}

public interface Sailor extends Member {

}

public interface Ship extends Member {

}
```

> 接下来定义工厂的接口以及两种不同主题的实现类

```
public interface TeamFactory {

  Ship createShip();

  Captain createCaptain();

  Sailor createSailor();
}
```
```
public class YoungTeamFactory implements TeamFactory {

  public Ship createShip() {
    return new NewShip();
  }

  public Captain createCaptain() {
    return new YoungCaptain();
  }

  public Sailor createSailor() {
    return new YoungSailor();
  }
}
```
```
public class PermanentTeamFactory implements TeamFactory {

  public Ship createShip() {
    return new OldShip();
  }

  public Captain createCaptain() {
    return new OldCaptain();
  }

  public Sailor createSailor() {
    return new OldSailor();
  }
}
```

> 现在，创建一个团队前则需要首先创建一个工厂对象，根据不同的主题创建不同的工厂

```
TeamFactory factory = new YoungTeamFactory();

Ship ship = factory.createShip();
Captain = factory.createCaptain();
Sailor = factory.createSailor();

ship.getDescription();      // 崭新的船
captain.getDescription();   // 年轻的船长
sailor.getDescription();    // 年轻的水手
```

## 适用场景

> * 一个系统应该独立于其产品是如何创建、组合和表示的
> * 一个系统需要配置多个系列中的一种产品
> * 一个相关产品对象的集合被设计用于一起使用，并且需对这个集合进行约束
> * 关于一个类的产品，使用者要特别关注它们的接口，而不是它们的实现
> * 依赖关系的生命周期理论上比使用者的生命周期短
> * 需要一个在运行时才能确定的参数来构造一个特定的依赖对象
> * 需要在运行时决定从一个集合中调用哪个系列的产品
> * 需要提供若干个只在运行时才知道的参数，然后才能解决依赖关系