/**
 * MIT License
 * <p>
 * Copyright (c) 2017 James
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package me.zbl.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
