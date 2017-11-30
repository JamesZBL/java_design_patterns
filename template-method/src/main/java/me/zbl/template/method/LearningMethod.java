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
package me.zbl.template.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 学习方法的抽象类
 */
public abstract class LearningMethod {

  private static final Logger LOGGER = LoggerFactory.getLogger(LearningMethod.class);

  /**
   * 预习效果
   *
   * @return
   */
  protected abstract String preLearning();

  /**
   * 状态
   *
   * @param description 学习状态
   */
  protected abstract void Learning(String description);

  /**
   * 请教对象
   *
   * @param adviser 请教对象
   */
  protected abstract void afterLearning(String adviser);

  /**
   * 学习过程
   *
   * @param description 听课状态
   * @param adviser     请假对象
   */
  public void learn(String description, String adviser) {
    String preLearningResult = preLearning();
    LOGGER.info("{}", preLearningResult);
    Learning(description);
    afterLearning(adviser);
  }
}
