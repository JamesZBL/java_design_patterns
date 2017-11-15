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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Prototype
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    Driver driver;
    Passenger passenger;
    Vehicle vehicle;
    TeamFactory factory;

    factory = new TeamFactoryImpl(new EstateDriver(), new EstatePassanger(), new EstateVehicle());
    driver = factory.createDriver();
    passenger = factory.createPassenger();
    vehicle = factory.createVehicle();
    LOGGER.info(">> 开始生产旅行车组合");
    LOGGER.info(driver.toString());
    LOGGER.info(passenger.toString());
    LOGGER.info(vehicle.toString());

    factory = new TeamFactoryImpl(new OffRoadDriver(), new OffRoadPassanger(), new OffRoadVehicle());
    driver = factory.createDriver();
    passenger = factory.createPassenger();
    vehicle = factory.createVehicle();
    LOGGER.info(">> 开始生产越野车组合");
    LOGGER.info(driver.toString());
    LOGGER.info(passenger.toString());
    LOGGER.info(vehicle.toString());
  }
}
