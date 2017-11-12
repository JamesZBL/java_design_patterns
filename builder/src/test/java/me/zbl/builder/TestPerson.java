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
package me.zbl.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Person 类测试
 */
public class TestPerson {

  /**
   * 测试姓名异常
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoName() throws Exception {
    new Person.Builder()
            .name(null)
            .age(17)
            .nationality(Nationality.JAPAN)
            .skinColor(SkinColor.YELLOW)
            .build();
  }

  /**
   * 测试创建 Person 对象
   */
  @Test
  public void testPersonBuild() throws Exception {

    String name = "老张";
    Integer age = 57;
    Person person = new Person.Builder()
            .name(name)
            .age(age)
            .nationality(Nationality.JAPAN)
            .skinColor(SkinColor.YELLOW)
            .build();

    assertNotNull(person);
    assertNotNull(person.toString());
    assertEquals(name, person.getName());
    assertEquals(age, person.getAge());
    assertEquals(Nationality.JAPAN, person.getNationality());
    assertEquals(SkinColor.YELLOW, person.getSkinColor());
  }
}
