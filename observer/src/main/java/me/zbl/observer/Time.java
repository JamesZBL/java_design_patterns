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
package me.zbl.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间
 */
public class Time {

  private static final Logger LOGGER = LoggerFactory.getLogger(Time.class);

  private TimePoint point;
  private List<TimeObserver> observers;

  public Time() {
    this.point = TimePoint.MORNING;
    observers = new ArrayList<>();
  }

  public void addObserver(TimeObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(TimeObserver observer) {
    observers.remove(observer);
  }

  public void passing() {
    TimePoint[] points = TimePoint.values();
    point = points[(point.ordinal() + 1) % points.length];
    LOGGER.info("时间来到了{}", point);
    notifyObservers();
  }

  public void notifyObservers() {
    for (TimeObserver observer : observers) {
      observer.update(point);
    }
  }
}
