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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Iterator
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    // 查找小说
    ItemIterator iterator = new BookShelfIterator(ItemType.FICTION, new BookShelf());
    LOGGER.info("正在查找小说类图书");
    while (iterator.hasNext()) {
      Item nextItem = iterator.next();
      LOGGER.info("找到了符合条件的图书，书名为：{}", nextItem.toString());
    }

    // 查找IT
    ItemIterator iterator2 = new BookShelfIterator(ItemType.IT, new BookShelf());
    LOGGER.info("正在查找IT类图书");
    while (iterator2.hasNext()) {
      Item nextItem = iterator2.next();
      LOGGER.info("找到了符合条件的图书，书名为：{}", nextItem.toString());
    }

    // 查找漫画
    ItemIterator iterator3 = new BookShelfIterator(ItemType.CARTOON, new BookShelf());
    LOGGER.info("正在查找漫画类图书");
    while (iterator3.hasNext()) {
      Item nextItem = iterator3.next();
      LOGGER.info("找到了符合条件的图书，书名为：{}", nextItem.toString());
    }
  }
}
