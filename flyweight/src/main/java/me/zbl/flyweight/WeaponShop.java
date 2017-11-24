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
package me.zbl.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static me.zbl.flyweight.GunType.*;

/**
 * 武器商店
 */
public class WeaponShop {

  private static final Logger LOGGER = LoggerFactory.getLogger(WeaponShop.class);

  private List<Shooting> shelfA;
  private List<Shooting> shelfB;

  public WeaponShop() {
    shelfA = new ArrayList<>();
    shelfB = new ArrayList<>();
    fillShelves();
  }

  private void fillShelves() {
    GunFactory factory = new GunFactory();

    shelfA.add(factory.createGun(HANDGUN));
    shelfA.add(factory.createGun(HANDGUN));
    shelfA.add(factory.createGun(MUSKET));
    shelfA.add(factory.createGun(MUSKET));
    shelfA.add(factory.createGun(SNIPER));
    shelfA.add(factory.createGun(SNIPER));
    shelfA.add(factory.createGun(MUSKET));
    shelfA.add(factory.createGun(HANDGUN));

    shelfB.add(factory.createGun(SUBMACHINE));
    shelfB.add(factory.createGun(SUBMACHINE));
    shelfB.add(factory.createGun(SUBMACHINE));
    shelfB.add(factory.createGun(SNIPER));
  }

  public final List<Shooting> getGunsOnShelfA() {
    return Collections.unmodifiableList(shelfA);
  }

  public final List<Shooting> getGunOnShelfB() {
    return Collections.unmodifiableList(shelfB);
  }

  public void enumrateShelves() {
    enumerateShelfA();
    enumerateShelfB();
  }

  private void enumerateShelfA() {
    LOGGER.info("从A货架上拿走所有武器");
    for (Shooting gun : shelfA) {
      gun.shoot();
    }
  }

  private void enumerateShelfB() {
    LOGGER.info("从B货架上拿走所有武器");
    for (Shooting gun : shelfB) {
      gun.shoot();
    }
  }
}