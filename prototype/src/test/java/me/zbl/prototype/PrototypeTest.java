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
package me.zbl.prototype;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * 测试原型模式
 */
@RunWith(Parameterized.class)
public class PrototypeTest<P extends Prototype> {

  @Parameterized.Parameters
  public static Collection<Object[]> setupData() {
    return Arrays.asList(
            new Object[]{new EstateDriver(), "这是一名旅行车司机"},
            new Object[]{new EstateVehicle(), "这是一辆旅行车"},
            new Object[]{new EstatePassanger(), "这是一名旅行车乘客"},
            new Object[]{new OffRoadDriver(), "这是一名越野车司机"},
            new Object[]{new OffRoadVehicle(), "这是一辆越野车"},
            new Object[]{new OffRoadPassanger(), "这是一名越野车乘客"}
    );
  }

  private final P prototype;

  private final String expectedString;

  public PrototypeTest(P prototype, String expectedString) {
    this.prototype = prototype;
    this.expectedString = expectedString;
  }

  @Test
  public void testPrototype() throws Exception {
    assertEquals(this.prototype.toString(), this.expectedString);
    final Object clone = this.prototype.clone();
    assertNotNull(clone);
    assertSame(clone.getClass(), this.prototype.getClass());
    assertNotSame(this.prototype, clone);
  }
}
