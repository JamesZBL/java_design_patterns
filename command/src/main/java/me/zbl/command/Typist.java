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
package me.zbl.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 打字员
 */
public final class Typist {

  private static final Logger LOGGER = LoggerFactory.getLogger(Typist.class);

  private Deque<Command> redoStack = new LinkedList<>();
  private Deque<Command> undoStack = new LinkedList<>();

  public void cast(Command command, AbstractFont font) {
    LOGGER.info("{}正在处理字体，命令为：{}，处理的字体为：{}", this, command, font);
    command.execute();
    undoStack.offerLast(command);
  }

  public void undo() {
    if (!undoStack.isEmpty()) {
      Command previousCommand = undoStack.pollLast();
      redoStack.offerLast(previousCommand);
      LOGGER.info("{}正在进行撤销操作，命令为：{}", this, previousCommand);
      previousCommand.undo();
    } else {
      LOGGER.info("没有可以撤销的操作了");
    }
  }

  public void redo() {
    if (!redoStack.isEmpty()) {
      Command previousCommand = redoStack.pollLast();
      undoStack.offerLast(previousCommand);
      LOGGER.info("{}正在进行重做操作，命令为：{}", this, previousCommand);
      previousCommand.redo();
    } else {
      LOGGER.info("没有可以重做的操作了");
    }
  }

  @Override
  public String toString() {
    return "打字员";
  }
}
