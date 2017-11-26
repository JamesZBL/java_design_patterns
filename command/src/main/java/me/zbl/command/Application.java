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

/**
 * Command
 */
public class Application {

  public static void main(String[] args) {
    Typist sizeTypist = new Typist();
    Typist colorTypist = new Typist();
    RegularScript font = new RegularScript();

    Command rubify = new Rubify(font);
    Command enlarge = new Enlarge(font);

    font.printStatus();

    // 设置字体颜色
    colorTypist.cast(rubify, font);
    font.printStatus();

    // 设置字体大小
    sizeTypist.cast(enlarge, font);
    font.printStatus();

    // 撤销颜色更改
    colorTypist.undo();
    font.printStatus();
    colorTypist.undo();

    // 撤销大小更改
    sizeTypist.undo();
    font.printStatus();
    sizeTypist.undo();

    // 字体颜色重做
    colorTypist.redo();
    font.printStatus();
    colorTypist.redo();

    // 大小重做
    sizeTypist.redo();
    font.printStatus();
    sizeTypist.redo();
  }
}
