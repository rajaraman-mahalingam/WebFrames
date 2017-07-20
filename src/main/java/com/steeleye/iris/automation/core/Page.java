package com.steeleye.iris.automation.core;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Cookie;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public class Page {

  public static void open(String url) {
    Browser.driver.get(url);
  }

  public static void close() {
    Browser.driver.close();
  }

  public void refresh() {
    Browser.driver.navigate().refresh();
  }

  public void getPageCookies() {
    Browser.driver.manage().getCookies();
  }

  public static void waitForDOMToLoad(long unit) {
    Browser.driver.manage().timeouts().implicitlyWait(unit, TimeUnit.SECONDS);
  }

  public void addPageCookies(Cookie cookie) {
    Browser.driver.manage().addCookie(cookie);
  }

  public void deletePageCookies(Cookie cookie) {
    Browser.driver.manage().deleteCookie(cookie);
  }

  public void deleteSpecificCookie(Cookie cookie) {
    Browser.driver.manage().deleteCookie(cookie);
  }

  public void getPageSource() {
    Browser.driver.getPageSource();
  }

  public static String getPageTitle() {
    return Browser.driver.getTitle();
  }

  public void switchToParentFrame() {
    Browser.driver.switchTo().parentFrame();
  }

  public void switchToSpecificFrameByName(String frame) {
    Browser.driver.switchTo().frame(frame);
  }

  public void switchToSpecificFrameById(int id) {
    Browser.driver.switchTo().frame(id);
  }

  public static void setPageWait(long wait) {
    try {
      Browser.driver.manage().wait(wait);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public String getPageWindowHandle() {
    return Browser.driver.getWindowHandle();
  }

  public Set<String> getPageAllWindowHandle() {
    return Browser.driver.getWindowHandles();
  }
}
