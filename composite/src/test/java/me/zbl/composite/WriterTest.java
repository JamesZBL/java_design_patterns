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
package me.zbl.composite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * 测试语句生成器
 */
public class WriterTest {

  private ByteArrayOutputStream stdOutBuffer;

  private final PrintStream realStdOut = System.out;

  @Before
  public void setUp() throws Exception {
    this.stdOutBuffer = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOutBuffer));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(realStdOut);
  }

  @Test
  public void sentenceByChinese() throws Exception {
    final Writer writer = new Writer();
    testWriterCn(writer.sentenceByChinese(), "我是来自北京的小明。");
  }

  @Test
  public void sentenceByEnglish() throws Exception {
    final Writer writer = new Writer();
    testWriter(writer.sentenceByEnglish(), "I am a student from London.");
  }

  /**
   * 测试输出是否和预期相等
   *
   * @param givenComposite 输入的组件
   * @param expectedString 期望值
   */
  private void testWriter(final CharacterComposite givenComposite, final String expectedString) {
    final String[] words = expectedString.trim().split(" ");
    assertNotNull(givenComposite);
    assertEquals(givenComposite.count(), words.length);

    givenComposite.print();

    assertEquals(expectedString, new String(this.stdOutBuffer.toByteArray()).trim());
  }

  /**
   * 测试输出是否和预期相等_中文
   *
   * @param givenComposite 输入的组件
   * @param expectedString 期望值
   */
  private void testWriterCn(final CharacterComposite givenComposite, final String expectedString) {
    assertNotNull(givenComposite);

    givenComposite.print();

    assertEquals(expectedString, new String(this.stdOutBuffer.toByteArray()).trim());
  }
}