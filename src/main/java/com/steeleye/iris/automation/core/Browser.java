package com.steeleye.iris.automation.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public class Browser {

  public static WebDriver driver;
  static BrowserType browserType;
  static BrowserEnvironment environment;
  static boolean driverOpened;

  public static void openBrowser() {
    TestLogger.debug("Executing: openBrowser()");
    driver = createDriver();
  }

  public static void closeBrowser() {
    TestLogger.debug("Executing: closeBrowser()");
    driver.quit();
  }
  
  public static WebDriver createDriver() {
    WebDriver returnedDriver = null;
    try {
      switch (getEnvironment()) {
      case Local:
        returnedDriver = getBrowserType().createDriver();
        returnedDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        break;
      case Remote:
        // returnedDriver = (RemoteWebDriver)
        // BrowserEnvironment.Remote.getRemoteCapabilities(getBrowserType());
        break;
      default:
        returnedDriver = null;
        break;
      }
      driverOpened = true;
      return returnedDriver;
    } catch (Throwable e) {
      TestLogger.fatal("=>Unable to create browser instance. Please check automation.properties file for the correct values..");
      driverOpened = false;
      return null;
    }
  }

  public static BrowserEnvironment getEnvironment() {
    return Config.getEnvironment();
  }

  public static BrowserType getBrowserType() {
    return Config.getBrowserType();
  }

  public static void openPage(String pageURL) {
    TestLogger.info("Executing openPage(" + pageURL + ")");
    try {
      driver.get(pageURL);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
