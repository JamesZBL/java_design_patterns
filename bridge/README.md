# 桥接模式 ( Bridge )

## 别名

> Handle/Body

## 用途

> 将抽象部分与它的实现部分分离， 使它们都可以独立地变化。
>
> 当一个抽象可能有多个实现时， 通常用继承来协调它们。 抽象类定义对诱抽象的接口，而具体的子类则用不同方式加以实现。 但是此方法有时不够灵活。 继承机制将抽象部分与它的实现部分固定在一起， 使得难以对抽象部分和实现部分独立地进行修改、 扩充和重用。

## 实例

> 假定两种战争——现代战争和古代战争，战争中的敌人分为实力雄厚和不堪一击两种，两种战争使用不同的武器装备，同样，两种敌人在战争中受到的打击也不同，装备优良、善于作战的和我方打成了平手，而另一中敌人装备落后，管理混乱，士气低迷，最终被我方打败。

## 模式分析

> 定义战争接口

```
public interface War {
  Enemy getEnemy();
  void startWar();
  void combatting();
  void stopWar();
}
```
> 定义敌人接口

```
public interface Enemy {
  void onStartWar();
  void onCombatting();
  void onStopWar();
}
```

> 定义两种不同战争的实现类

```
/**
 * 现代战争
 */
public class MordernWar implements War {
  private static final Logger LOGGER = LoggerFactory.getLogger(MordernWar.class);
  private final Enemy enemy;
  public MordernWar(Enemy enemy) {
    this.enemy = enemy;
  }
  @Override
  public Enemy getEnemy() {
    return this.enemy;
  }
  @Override
  public void startWar() {
    LOGGER.info("一场现代战争开始了");
    enemy.onStartWar();
  }
  @Override
  public void combatting() {
    LOGGER.info("现代战争正在激烈进行中");
    enemy.onCombatting();
  }
  @Override
  public void stopWar() {
    LOGGER.info("这场现代战争结束了");
    enemy.onStopWar();
  }
}

/**
 * 古代战争
 */
public class AncientWar implements War {
  private static final Logger LOGGER = LoggerFactory.getLogger(AncientWar.class);
  private final Enemy enemy;
  public AncientWar(Enemy enemy) {
    this.enemy = enemy;
  }
  @Override
  public Enemy getEnemy() {
    return this.enemy;
  }
  @Override
  public void startWar() {
    LOGGER.info("一场古代战争开始了");
    enemy.onStartWar();
  }
  @Override
  public void combatting() {
    LOGGER.info("古代战争正在激烈进行中");
    enemy.onCombatting();
  }
  @Override
  public void stopWar() {
    LOGGER.info("这场古代战争结束了");
    enemy.onStopWar();
  }
}
```

> 两种敌人根据战争的不同进展作出表现出不同的状态
```
/**
 * 强大的敌人
 */
public class IntrepidEnemy implements Enemy {
  private static final Logger LOGGER = LoggerFactory.getLogger(IntrepidEnemy.class);
  @Override
  public void onStartWar() {
    LOGGER.info("敌人信心满满，准备迎战");
  }
  @Override
  public void onCombatting() {
    LOGGER.info("敌人正在积极反抗");
  }
  @Override
  public void onStopWar() {
    LOGGER.info("双方达成了平手");
  }
}

/**
 * 不堪一击的敌人
 */
public class TenderEnemy implements Enemy {
  private static final Logger LOGGER = LoggerFactory.getLogger(TenderEnemy.class);
  @Override
  public void onStartWar() {
    LOGGER.info("敌人士气不足，无奈迎战");
  }
  @Override
  public void onCombatting() {
    LOGGER.info("敌人纷纷溃败");
  }
  @Override
  public void onStopWar() {
    LOGGER.info("敌人不堪一击，只得投降");
  }
}
```

```
// 古代战争和强大的敌人
War war1 = new AncientWar(new IntrepidEnemy());
// 战争开始
war1.startWar();
// 战争进行中
war1.combatting();
war1.stopWar();
// 战争结束
LOGGER.info("\n");

// 现代战争和不堪一击的敌人
War war2 = new MordernWar(new TenderEnemy());
// 战争开始
war2.startWar();
// 战争进行中
war2.combatting();
// 战争结束
war2.stopWar();
LOGGER.info("\n");
```

## 适用场景

>* 你不希望在抽象和它的实现部分之间有一个固定的绑定关系。例如这种情况可能是因为,在程序运行时刻实现部分应可以被选择或者切换
>
>* 类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充。 这时 Bridge 模式使你可以对不同的抽象接口和实现部分进行组合， 并分别对它们进行扩充
>
>* 对一个抽象的实现部分的修改应对客户不产生影响， 即客户端的代码不必重新编译
>
>* 你想在多个对象间共享实现（可能使用引用计数）， 但同时要求客户端并不知道这一点