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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建者模式的用途是为反可伸缩构造方法找到一个解决方案。当对象数量增加时，反可伸缩构造方法模式的弊端就出现了。
 * 构造方法的参数过多导致构造方法的参数呈指数级别的趋势增长。
 * <p>
 * 创建者不需要使用许多构造方法，创建者模式使用另一个对象，也就是创建者，
 * <p>
 * 它一步一步地接收对象创建需要初始化参数，然后立即返回所生成的对象。
 * 使用构造方法创建一个 {@link Person} 对象可能很复杂，因为构造方法的参数太多了，所以使用一个创建者
 * {@link Person.Builder} 的对象来一步步的对参数进填充，最终完成 {@link Person} 对象的创建。
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {

    Person personWang =
            new Person.Builder().name("小王").age(25).nationality(Nationality.CHINA).skinColor(SkinColor.YELLOW).build();
    Person personZhang =
            new Person.Builder().name("小张").age(28).nationality(Nationality.USA).skinColor(SkinColor.WHITE).build();
    Person personLiu =
            new Person.Builder().name("老王").age(48).nationality(Nationality.JAPAN).skinColor(SkinColor.YELLOW).build();

    LOGGER.info(personWang.toString());
    LOGGER.info(personZhang.toString());
    LOGGER.info(personLiu.toString());

  }
}
