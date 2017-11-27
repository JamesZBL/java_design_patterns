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
package me.zbl.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 焦躁的状态
 */
public class ImpatientState implements State {

  private static final Logger LOGGER = LoggerFactory.getLogger(ImpatientState.class);

  private Coder coder;

  public ImpatientState(Coder coder) {
    this.coder = coder;
  }

  @Override
  public void onPreparing() {
    LOGGER.info("{}面对一堆 bug，开始逐渐焦躁起来", coder);
  }

  @Override
  public void onEnterState() {
    LOGGER.info("{}已经被 bug 搞的进入了极度狂躁的状态", coder);
  }
}
