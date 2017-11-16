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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {

    // “饿汉式” 单例模式
    Director director1 = Director.getInstance();
    Director director2 = Director.getInstance();
    LOGGER.info("饿汉式单例1 = {}", director1);
    LOGGER.info("饿汉式单例2 = {}", director2);

    // “懒汉式” 单例模式
    LazyInitializationDirector lazyDirector1 = LazyInitializationDirector.getInstance();
    LazyInitializationDirector lazyDirector2 = LazyInitializationDirector.getInstance();
    LOGGER.info("懒汉式单例1 = {}", lazyDirector1);
    LOGGER.info("懒汉式单例2 = {}", lazyDirector2);

    // 双检锁
    ThreadSafeDoubleCheckLocking doubleCheckLocking1 = ThreadSafeDoubleCheckLocking.getInstance();
    LOGGER.info("双检锁单例1 = {}", doubleCheckLocking1);
    ThreadSafeDoubleCheckLocking doubleCheckLocking2 = ThreadSafeDoubleCheckLocking.getInstance();
    LOGGER.info("双检锁单例2 = {}", doubleCheckLocking2);

    // 线程安全的“懒汉式” 单例模式
    ThreadSafeLazyLoadDirector lazyLoadDirector1 = ThreadSafeLazyLoadDirector.getInstance();
    LOGGER.info("线程安全的懒汉式单例1 = {}", lazyLoadDirector1.toString());
    ThreadSafeLazyLoadDirector lazyLoadDirector2 = ThreadSafeLazyLoadDirector.getInstance();
    LOGGER.info("线程安全的懒汉式单例2 = {}", lazyLoadDirector2.toString());

    // 枚举型的单例模式
    EnumDirector enumDirector1 = EnumDirector.INSTANCE;
    LOGGER.info("枚举型单例1 = {}", enumDirector1);
    EnumDirector enumDirector2 = EnumDirector.INSTANCE;
    LOGGER.info("枚举型单例2 = {}", enumDirector2);
  }
}
