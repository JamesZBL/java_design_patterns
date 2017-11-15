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
package me.zbl.prototype;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * 测试团队工厂
 */
public class FactoryTest {

  @Test
  public void testFactory() throws Exception {
    final Driver driver = mock(Driver.class);
    final Passenger passenger = mock(Passenger.class);
    final Vehicle vehicle = mock(Vehicle.class);

    when(driver.clone()).thenThrow(CloneNotSupportedException.class);
    when(passenger.clone()).thenThrow(CloneNotSupportedException.class);
    when(vehicle.clone()).thenThrow(CloneNotSupportedException.class);

    final TeamFactoryImpl factory = new TeamFactoryImpl(driver, passenger, vehicle);
    assertNull(factory.createDriver());
    assertNull(factory.createPassenger());
    assertNull(factory.createVehicle());

    verify(driver).clone();
    verify(passenger).clone();
    verify(vehicle).clone();
    verifyNoMoreInteractions(driver, passenger, vehicle);
  }
}
