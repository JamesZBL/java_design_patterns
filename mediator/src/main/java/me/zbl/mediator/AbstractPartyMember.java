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
package me.zbl.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 派对成员抽象类
 */
public abstract class AbstractPartyMember implements PartyMember {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPartyMember.class);

  private Party party;

  @Override
  public void joinParty(Party party) {
    LOGGER.info("{}加入了派对", this);
    this.party = party;
  }

  @Override
  public void act(Activity activity) {
    if (null != activity) {
      LOGGER.info("{}提议进行{}活动", this, activity);
      party.letAct(this, activity);
    }
  }

  @Override
  public void partyActivity(Activity activity) {
    LOGGER.info("进行派对活动，名称：{}，介绍：{}", activity, activity.getDescription());
  }

  @Override
  public abstract String toString();
}
