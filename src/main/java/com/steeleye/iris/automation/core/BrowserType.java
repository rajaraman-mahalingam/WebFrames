package com.steeleye.iris.automation.core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public enum BrowserType {
  IE11("[IE11]", "IE", Platform.WIN8_1, "11", "Internet explorer"), Chrome("[Chrome]", "CH", Platform.WIN8_1, "50.0",
      "Chrome"), HeadLess("[Chrome]", "CH", Platform.WIN8_1, "50.0", "HeadLess");

  public String browser;
  public String shortName;
  public Platform platform;
  public String version;
  public String sourceName;

  BrowserType(String browser, String shortName, Platform platform, String version, String sourceName) {
    this.browser = browser;
    this.shortName = shortName;
    this.platform = platform;
    this.version = version;
    this.sourceName = sourceName;
  }

  public WebDriver createDriver() {
    try {
      switch (this) {
      case IE11:
        return new InternetExplorerDriver(Config.getEnvironment().getCapabilities());
      case Chrome:
        return new ChromeDriver(Config.getEnvironment().getCapabilities());
      case HeadLess:
        return new ChromeDriver(Config.getEnvironment().getCapabilities());
      default:
        TestLogger.fatal("Cannot create Driver of type" + this);
        return null;
      }
    } catch (Exception e) {
      TestLogger.fatal("=>Cannot create any of the Driver");
      return null;
    }
  }
}
