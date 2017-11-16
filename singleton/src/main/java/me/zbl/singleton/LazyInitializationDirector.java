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
 * “懒汉式” 的单例模式
 * <p>
 * 内部类在被引用之前不会被类加载器加载，直到客户端调用的时候才被加载
 * <p>
 * 这个方案是线程安全的
 */
public final class LazyInitializationDirector {

  /**
   * 私有构造方法
   */
  private LazyInitializationDirector() {
  }

  /**
   * @return 单例实例
   */
  public static LazyInitializationDirector getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * 延迟加载，生成 {@link LazyInitializationDirector} 的实例
   */
  private static class InstanceHolder {

    private static final LazyInitializationDirector INSTANCE = new LazyInitializationDirector();
  }
}
