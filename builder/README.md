# 创建者模式 ( Builder )

## 用途

> 将一个复杂对象的构造与它分开，使得同样的构造过程可以产生不同的对象。

## 实例

> 假定需要生成一个虚拟的人物模型，人物主要包括几个简单的属性：姓名、年龄、国籍以及肤色。假如一个数据模型的拥有很多属性，如果单纯使用构造方法来实例化对象，势必会造成构造方法参数爆炸的问题，也可以称之为“反可伸缩构造方法模式”。代码的可读性和可靠性大大降低。此时，可以为这个对象创建的过程指定一个创建者，我们只需要向创建者描述该对象的一些具体细节，接下来的构造过程就统统交给创建者完成了。

> 以下是“反可伸缩构造方法模式”的一个实例：

```
public Person(String name,Integer age,Nationality nationality,SkinColor skinColor...){...}
```
> 如果一直这样下去，随着属性的增多，构造方法的参数的数量也会变得越来越多，对于开发人员是非常头疼的。对属性的更改使得构造方法的维护难度增加了不少，这就是所谓的“反可伸缩构造方法模式”。

## 模式分析

**Person 类**

```
public class Person {
  private final String name;
  private final Integer age;
  private final Nationality nationality;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Nationality getNationality() {
    return nationality;
  }

  public SkinColor getSkinColor() {
    return skinColor;
  }

  private final SkinColor skinColor;

  public Person(Builder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.skinColor = builder.skinColor;
    this.nationality = builder.nationality;
  }
}
```
**Person 类的创建者**

```
public static class Builder {

    private String name;
    private Integer age;
    private Nationality nationality;
    private SkinColor skinColor;

    public Builder age(Integer age) {
      this.age = age;
      return this;
    }

    public Builder name(String name) {
      if (null == name) {
        throw new IllegalArgumentException("人必须有名字!");
      }
      this.name = name;
      return this;
    }

    public Builder nationality(Nationality nationality) {
      this.nationality = nationality;
      return this;
    }

    public Builder skinColor(SkinColor skinColor) {
      this.skinColor = skinColor;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
}
```

**Person 类对象的构造过程**

```
Person personWang = new Person.Builder()
    .name("小王")
    .age(25)
    .nationality(Nationality.CHINA)
    .skinColor(SkinColor.YELLOW)
    .build();
```

## 适用场景

> * 创建一个复杂对象的算法应该独立于组成对象的组成部分以及它们是如何组合的
> * 构建过程必须为所构造的对象提供不同的表示形式