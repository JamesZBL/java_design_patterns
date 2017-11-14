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
package me.zbl.factory.method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 测试工厂方法
 */
public class FactoryMethodTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(FactoryMethodTest.class);

  @Test
  public void testWesternHot() {
    Cook cook = new WesternCook();
    Food food = cook.cookFood(FoodType.HOT);
    verifyFood(food, WesternFood.class, FoodType.HOT);
  }

  @Test
  public void testWesternCold() {
    Cook cook = new WesternCook();
    Food food = cook.cookFood(FoodType.COLD);
    verifyFood(food, WesternFood.class, FoodType.COLD);
  }

  @Test
  public void testChineseHot() {
    Cook cook = new ChineseCook();
    Food food = cook.cookFood(FoodType.HOT);
    verifyFood(food, ChineseFood.class, FoodType.HOT);
  }

  @Test
  public void testChineseCold() {
    Cook cook = new ChineseCook();
    Food food = cook.cookFood(FoodType.COLD);
    verifyFood(food, ChineseFood.class, FoodType.COLD);
  }

  private void verifyFood(Food food, Class<?> clazz, FoodType type) {
    assertTrue("食物必须是" + clazz.getName() + "的子类", clazz.isInstance(food));
    assertEquals("食物必须是" + type.getName(), type, food.getFoodType());
  }
}
