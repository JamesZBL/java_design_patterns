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
package me.zbl.abstractFactory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 抽象工厂测试类
 */
public class AbstractFactoryTest {

  private Application mApplication;
  private PermanentTeamFactory mPermanentTeamFactory;
  private YoungTeamFactory mYoungTeamFactory;

  @Before
  public void setUp() {
    mApplication = new Application();
    mPermanentTeamFactory = new PermanentTeamFactory();
    mYoungTeamFactory = new YoungTeamFactory();
  }

  @Test
  public void testCreateYoungTeam() {
    mApplication.createTeam(mYoungTeamFactory);
    final Ship ship = mApplication.getmShip();
    final Captain captain = mApplication.getmCaptain();
    final Sailor sailor = mApplication.getmSailor();

    assertTrue(ship instanceof NewShip);
    assertTrue(captain instanceof YoungCaptain);
    assertTrue(sailor instanceof YoungSailor);

    assertEquals(ship.getDescription(), NewShip.DESCRIPTION);
    assertEquals(captain.getDescription(), YoungCaptain.DESCRIPTION);
    assertEquals(sailor.getDescription(), YoungSailor.DESCRIPTION);
  }

  @Test
  public void testApplication() {
    String[] args = {};
    Application.main(args);
  }
}
