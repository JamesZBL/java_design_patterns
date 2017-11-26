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

import java.util.List;

/**
 * 图书的迭代器
 */
public class BookShelfIterator implements ItemIterator {

  private ItemType type;
  private BookShelf shelf;
  private int idx;

  public BookShelfIterator(ItemType type, BookShelf shelf) {
    this.type = type;
    this.shelf = shelf;
    this.idx = -1;
  }

  @Override
  public boolean hasNext() {
    return -1 != getNexIdx();
  }

  @Override
  public Item next() {
    idx = getNexIdx();
    if (-1 != idx) {
      return shelf.getItemList().get(idx);
    }
    return null;
  }

  private int getNexIdx() {
    List<Item> list = shelf.getItemList();
    int tempIdx = idx;
    boolean found = false;
    while (!found) {
      tempIdx++;
      if (tempIdx >= list.size()) {
        tempIdx = -1;
        break;
      }
      if (list.get(tempIdx).getType().equals(type)) {
        break;
      }
    }
    return tempIdx;
  }
}
