# 工厂方法 ( Factory Method )

## 用途

> 定义一个用于创建对象的接口， 让子类决定实例化哪一个类。 Factory Method使一个类的
  实例化延迟到其子类
   
## 别名

> 虚构造器 ( Virtual Constructor )

## 实例

> 假定现在有两个厨师，一个只会做中餐，另一个只会做西餐，餐品分为熟食和生食两类。顾客需要顾客需要根据自己的口味来选择对应的厨师并告知其需要熟食还是生食，厨师根据顾客的口味来进行烹制

## 模式分析

> 在基于类的设计中，工厂方法模式通常作为创建模式来使用。它使用工厂方法来处理创建对象的过程，无需指定创建对象的确切类型。客户端通过调用工厂方法来创建对象，这里的方法是在接口中指定的，或是由子类实现的，或是由基类实现，或者通过子类进行方法覆盖，从头至尾无需调用具体类的构造函数
>
> 以厨师为例，首先定义厨师和食物两个接口

```
public interface Cook {
  Food cookFood(FoodType foodType);
}

public interface Food {
  FoodType getFoodType();
}
```

> 定义食物的枚举类型
```
public enum FoodType {
  HOT("热的"), COLD("凉的");
  private String name;
  FoodType(String foodType) {
    this.name = foodType;
  }
  public String getName() {
    return name;
  }
}
```

> 定义两种厨师的实现类，分别负责西餐和中餐的烹饪工作
```
public class WesternCook implements Cook {
  public Food cookFood(FoodType foodType) {
    return new WesternFood(foodType);
  }
}

public class ChineseCook implements Cook {
  public Food cookFood(FoodType foodType) {
    return new ChineseFood(foodType);
  }
}
```
> 生成食物对象时只需调用厨师对象的工厂方法即可
```
Cook cook1 = new WesternCook();
Cook cook2 = new ChineseCook();
Food food1 = cook1.cookFood(FoodType.COLD);
Food food2 = cook2.cookFood(FoodType.HOT);
```

## 适用场景

>* 当一个类不知道它所必须创建的对象的类的时候
>* 当一个类希望由它的子类来指定它所创建的对象的时候
>* 当类将创建对象的职责委托给多个帮助子类中的某一个， 并且你希望将哪一个帮助子类是代理者这一信息局部化的时候