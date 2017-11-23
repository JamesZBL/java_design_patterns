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
package me.zbl.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 课堂参与者抽象类
 */
public abstract class CourseParticipator {

  private static final Logger LOGGER = LoggerFactory.getLogger(CourseParticipator.class);

  public void prepareCourse() {
    LOGGER.info("{}准备上课", name());
  }

  public void proceedCourse() {
    LOGGER.info("{}正在上课", name());
  }

  public void stopCourse() {
    LOGGER.info("{}下课", name());
  }

  public void goToSchool() {
    LOGGER.info("{}赶往学校", name());
  }

  public void goHome() {
    LOGGER.info("{}回家", name());
  }

  public abstract String name();

  public void action(Event... events) {
    for (Event e : events) {
      action(e);
    }
  }

  private void action(Event e) {
    switch (e) {
      case EVENT_PREPARE: {
        prepareCourse();
        break;
      }
      case EVENT_PROCEED: {
        proceedCourse();
        break;
      }
      case EVENT_STOP: {
        stopCourse();
        break;
      }
      case EVENT_GO_HOME: {
        goHome();
        break;
      }
      case EVENT_GOTO_SCHOOL: {
        goToSchool();
        break;
      }
      default: {
        LOGGER.info("未知操作");
        break;
      }
    }
  }

  static enum Event {
    EVENT_GOTO_SCHOOL, EVENT_PREPARE, EVENT_PROCEED, EVENT_STOP, EVENT_GO_HOME;
  }
}
