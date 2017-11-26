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

import java.util.ArrayList;
import java.util.List;

/**
 * 书架
 */
public class BookShelf {

  private List<Item> items;

  public BookShelf() {
    items = new ArrayList<>();
    items.add(new Item(ItemType.FICTION, "西游记"));
    items.add(new Item(ItemType.FICTION, "水浒传"));
    items.add(new Item(ItemType.FICTION, "三国演义"));
    items.add(new Item(ItemType.FICTION, "红楼梦"));
    items.add(new Item(ItemType.CARTOON, "阿衰"));
    items.add(new Item(ItemType.CARTOON, "七龙珠"));
    items.add(new Item(ItemType.CARTOON, "火影忍者"));
    items.add(new Item(ItemType.IT, "设计模式-可复用面向对象软件的基础"));
    items.add(new Item(ItemType.IT, "重构-改善既有代码的设计"));
    items.add(new Item(ItemType.IT, "Effective Java"));
    items.add(new Item(ItemType.IT, "Java编程思想"));
  }

  public List<Item> getItemList() {
    List<Item> list = new ArrayList<>();
    list.addAll(items);
    return list;
  }
}
