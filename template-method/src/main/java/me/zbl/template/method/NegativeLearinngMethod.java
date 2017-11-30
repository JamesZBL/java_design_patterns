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
 * 消极的学习方法
 */
public class NegativeLearinngMethod extends LearningMethod {

  private static final Logger LOGGER = LoggerFactory.getLogger(NegativeLearinngMethod.class);

  @Override
  protected String preLearning() {
    return "几乎没有预习，对上课要学的内容一无所知";
  }

  @Override
  protected void Learning(String description) {
    LOGGER.info("学习状态：{}", description);
  }

  @Override
  protected void afterLearning(String adviser) {
    if (!adviser.equals("")) {
      LOGGER.info("只有很少的知识点没有听懂，于是找{}提问", adviser);
    }
  }
}
