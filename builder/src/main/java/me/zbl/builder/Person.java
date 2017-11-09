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
package me.zbl.builder;

/**
 * 人
 */
public final class Person {

  private final String name;
  private final Integer age;
  private final Nationality nationality;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Nationality getNationality() {
    return nationality;
  }

  public SkinColor getSkinColor() {
    return skinColor;
  }

  private final SkinColor skinColor;

  public Person(Builder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.skinColor = builder.skinColor;
    this.nationality = builder.nationality;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name);
    if (null != nationality) {
      sb.append(" 是来自 " + nationality.toString() + " 的");
    }
    if (null != age) {
      sb.append(" " + age + "岁的");
    }
    if (null != skinColor) {
      sb.append(" 有着" + skinColor + "皮肤的");
    }
    sb.append("一个人");
    return sb.toString();
  }

  /**
   * 创建者
   */
  public static class Builder {

    private String name;
    private Integer age;
    private Nationality nationality;
    private SkinColor skinColor;

    public Builder age(Integer age) {
      this.age = age;
      return this;
    }

    public Builder name(String name) {
      if (null == name) {
        throw new IllegalArgumentException("人必须有名字!");
      }
      this.name = name;
      return this;
    }

    public Builder nationality(Nationality nationality) {
      this.nationality = nationality;
      return this;
    }

    public Builder skinColor(SkinColor skinColor) {
      this.skinColor = skinColor;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
