# 享元模式 ( Flyweight )

## 用途

运用共享技术有效地支持大量细粒度的对象。

## 适用场景

Flyweight模式的有效性很大程度上取决于如何使用它以及在何处使用它。 当以下情况都成立时使用flyweight模式：
* 一个应用程序使用了大量的对象。
* 完全由于使用大量的对象，造成很大的存储开销。
* 对象的大多数状态都可变为外部状态。
* 如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象。
* 应用程序不依赖于对象标识。由于Flyweight对象可以被共享，对于概念上明显有别的对象，标识测试将返回真值。

## 模式要点

![](https://github.com/JamesZBL/java_design_patterns/blob/develop/flyweight/uml/Flyweight.png?raw=true)

### 组成部分

* Flyweight - 描述一个接口， 通过这个接口 flyweight 可以接受并作用于外部状态。
* ConcreteFlyweight — 实现 Flyweight 接口，并为内部状态（如果有的话）增加存储空间 。ConcreteFlyweight对象必须是可共享的。 它所存储的状态必须是内部的；即它必须独立于 ConcreteFlyweight 对象的场景。
* UnsharedConcreteFlyweight — 并非所有的 Flyweight 子类都需要被共享。Flyweight 接口使共享成为可能， 但它并不强制共享。 在 Flyweight 对象结构的某些层次，UnsharedConcreteFlyweight 对象通常将ConcreteFlyweight 对象作为子节点（ Row和Column 就是这样）。
* FlyweightFactory — 创建并管理 flyweight 对象。确保合理地共享 flyweight。当用户请求一个 flyweight 时，FlyweightFactory 对象提供一个已创建的实例或者创建一个（如果不存在的话)。
* Client：持有一个对 flyweight 的引用。计算或存储一个（多个）flyweight 的外部状态。

### 协作原理



## 实例分析



## 效果
