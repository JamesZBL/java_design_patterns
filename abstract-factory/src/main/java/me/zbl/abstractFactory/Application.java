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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractFactory
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
  private Ship mShip;
  private Captain mCaptain;
  private Sailor mSailor;

  public void createTeam(final TeamFactory factory) {
    setmCaptain(factory.createCaptain());
    setmShip(factory.createShip());
    setmSailor(factory.createSailor());
  }

  public static void main(String[] args) {

    Application app = new Application();

    app.createTeam(new YoungTeamFactory());
    LOGGER.info("正在创建一支年轻的队伍...");
    LOGGER.info("-->" + app.getmCaptain().getDescription());
    LOGGER.info("-->" + app.getmShip().getDescription());
    LOGGER.info("-->" + app.getmSailor().getDescription());

    app.createTeam(new PermanentTeamFactory());
    LOGGER.info("正在创建一支久经考验的队伍...");
    LOGGER.info("-->" + app.getmCaptain().getDescription());
    LOGGER.info("-->" + app.getmShip().getDescription());
    LOGGER.info("-->" + app.getmSailor().getDescription());
  }

  public Ship getmShip() {
    return mShip;
  }

  public void setmShip(Ship mShip) {
    this.mShip = mShip;
  }

  public Captain getmCaptain() {
    return mCaptain;
  }

  public void setmCaptain(Captain mCaptain) {
    this.mCaptain = mCaptain;
  }

  public Sailor getmSailor() {
    return mSailor;
  }

  public void setmSailor(Sailor mSailor) {
    this.mSailor = mSailor;
  }
}
