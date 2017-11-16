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
package me.zbl.singleton;

/**
 * “懒汉式”的单例模式-线程安全的
 */
public final class ThreadSafeLazyLoadDirector {

  private static volatile ThreadSafeLazyLoadDirector INSTANCE;

  private ThreadSafeLazyLoadDirector() {
    // 防止通过反射进行实例化
    if (null != INSTANCE) {
      throw new IllegalStateException("该实例已经存在");
    }
  }

  /**
   * 此方法被第一次调用时才会生成单例实例，实现懒加载
   */
  public static synchronized ThreadSafeLazyLoadDirector getInstance() {
    if (null == INSTANCE) {
      INSTANCE = new ThreadSafeLazyLoadDirector();
    }
    return INSTANCE;
  }
}
