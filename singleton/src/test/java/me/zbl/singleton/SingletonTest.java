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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * 测试单例模式
 * <p>
 * 提供测试单例结构的测试用例
 * <p>
 * 第一个验证，在同一个线程中，对 getInstance() 的多次调用结果是相同的
 * 第二个验证，在不同的线程中，对 getInstance() 的多次调用结果也是一样的
 */
public abstract class SingletonTest<S> {

  /**
   * 获取单例实例的方法
   */
  private final Supplier<S> singletonInstanceMethod;

  /**
   * 创建一个测试用例
   *
   * @param singletonInstanceMethod 实例类中获取实例的方法
   */
  public SingletonTest(final Supplier<S> singletonInstanceMethod) {
    this.singletonInstanceMethod = singletonInstanceMethod;
  }

  /**
   * 测试在同一线程中的多次调用返回结果是相同的
   */
  @Test
  public void testMultipleCallsReturnSameObjectInSameThread() {
    // 在同一线程中创建多个实例
    S instance1 = singletonInstanceMethod.get();
    S instance2 = singletonInstanceMethod.get();
    S instance3 = singletonInstanceMethod.get();

    // 分别验证是否相同
    assertSame(instance1, instance2);
    assertSame(instance2, instance3);
    assertSame(instance3, instance1);
  }

  /**
   * 测试在不同线程中的多次调用返回的结果也是相同的
   */
  @Test(timeout = 5000L)
  public void testMultipleCallsReturnSameObjectInMultipleThread() throws InterruptedException, ExecutionException {

    // 创建 5000 个任务，并在每个任务中实例化单例类
    List<Callable<S>> tasks = new ArrayList<>();
    for (int i = 0; i < 5000; i++) {
      tasks.add(singletonInstanceMethod::get);
    }

    // 使用 10 个不同的线程来分别执行这 5000 个任务
    final ExecutorService pool = Executors.newFixedThreadPool(10);
    final List<Future<S>> results = pool.invokeAll(tasks);

    // 预期结果
    S expectedResult = singletonInstanceMethod.get();

    // 分别验证是否是同一个对象
    for (Future<S> res : results) {
      final S result = res.get();
      assertNotNull(result);
      assertSame(expectedResult, result);
    }
  }
}
