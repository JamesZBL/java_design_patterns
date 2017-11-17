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
 * Bridge
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    War war1 = new AncientWar(new IntrepidEnemy());
    war1.startWar();
    war1.combatting();
    war1.stopWar();
    LOGGER.info("\n");

    War war2 = new AncientWar(new TenderEnemy());
    war2.startWar();
    war2.combatting();
    war2.stopWar();
    LOGGER.info("\n");

    War war3 = new MordernWar(new IntrepidEnemy());
    war3.startWar();
    war3.combatting();
    war3.stopWar();
    LOGGER.info("\n");

    War war4 = new MordernWar(new TenderEnemy());
    war4.startWar();
    war4.combatting();
    war4.stopWar();
  }
}
