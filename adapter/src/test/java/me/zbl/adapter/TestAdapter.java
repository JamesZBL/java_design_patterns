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
package me.zbl.adapter;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * 测试适配器
 */
public class TestAdapter {

  private Map<String, Object> beans;
  static final String CAR_BEAN = "CAR_BEAN";
  static final String BUS_BEAN = "BUS_BEAN";

  /**
   * 在测试执行之前运行，在 bean 映射中注册 bean 对象
   */
  @Before
  public void setUp() {
    beans = new HashMap<>();

    BusAdapter busAdapter = spy(new BusAdapter());
    beans.put(BUS_BEAN, busAdapter);

    Driver driver = new Driver((BusAdapter) beans.get(BUS_BEAN));
    beans.put(CAR_BEAN, driver);
  }

  /**
   * 测试适配器
   * <p>
   * 作用：确定当在一个 Driver 对象（客户端）中调用 drive() 方法时，其实是在调用 Bus 对象中的 run() 方法
   * <p>
   * verify() 方法的作用是验证某一行为是否发生过
   * <p>
   * 适配器的作用就是将目标接口类型转换成客户端所需要的类型
   */
  @Test
  public void testAdapter() {
    Car driver = (Car) beans.get(CAR_BEAN);
    driver.drive();

    Car adapter = (Car) beans.get(BUS_BEAN);
    verify(adapter).drive();
  }
}
