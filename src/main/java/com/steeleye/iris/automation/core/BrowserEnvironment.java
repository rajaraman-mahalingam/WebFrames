package com.steeleye.iris.automation.core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public enum BrowserEnvironment {

  Local("Local"), Remote("Remote");

  public String name;
  public String chromeDriverPath;

  BrowserEnvironment(String name) {
    this.name = name;
  }

  public DesiredCapabilities getCapabilities() {
    try {
      switch (this) {
      case Local:
        return getLocalCapabilities();
      case Remote:
        return getRemoteCapabilities();
      default:
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public DesiredCapabilities getLocalHeadLessCapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    if (Config.getPlatform().toString() .equals("Windows")) {
      chromeDriverPath = "src\\main\\resources\\drivers\\chromedriverWin.exe";
    } else if (Config.getPlatform().toString() .equals("Mac")) {
      chromeDriverPath = "src/main/resources/drivers/chromedrivermac";
    }
    ChromeOptions options = new ChromeOptions();
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    options.addArguments("--headless");
    options.addArguments("--disable-gpu");
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    return caps;
  }

  public DesiredCapabilities getLocalChromeCapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    if (Config.getPlatform().equals("Windows")) {
      chromeDriverPath = "src\\main\\resources\\drivers\\chromedriverWin.exe";
    } else if (Config.getPlatform().equals("Mac")) {
      chromeDriverPath = "src/main/resources/drivers/chromedrivermac";
    }
    ChromeOptions options = new ChromeOptions();
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    options.addArguments("chrome.switches", "--disable-extensions");
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    return caps;
  }

  public DesiredCapabilities getLocalIECapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
    System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\IEDriverServer.exe");
    caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    caps.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 20000);
    caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
    caps.setCapability("pageLoadStrategy", "none");
    caps.setCapability("enablePersistentHover", true);
    return caps;
  }

  public DesiredCapabilities getRemoteHeadLessCapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    if (Config.getPlatform().toString() .equals("Windows")) {
      chromeDriverPath = "src\\main\\resources\\drivers\\chromedriverWin.exe";
    } else if (Config.getPlatform().toString() .equals("Mac")) {
      chromeDriverPath = "src/main/resources/drivers/chromedrivermac";
    }
    ChromeOptions options = new ChromeOptions();
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    options.addArguments("--headless");
    options.addArguments("--disable-gpu");
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    return caps;
  }

  public DesiredCapabilities getRemoteChromeCapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    if (Config.getPlatform().toString() .equals("Windows")) {
      chromeDriverPath = "src\\main\\resources\\drivers\\chromedriverWin.exe";
    } else if (Config.getPlatform().toString() .equals("Mac")) {
      chromeDriverPath = "src/main/resources/drivers/chromedrivermac";
    }
    ChromeOptions options = new ChromeOptions();
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    options.addArguments("chrome.switches", "--disable-extensions");
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    return caps;
  }

  public DesiredCapabilities getRemoteIECapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
    System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\IEDriverServer.exe");
    caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    caps.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 20000);
    caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
    caps.setCapability("pageLoadStrategy", "none");
    caps.setCapability("enablePersistentHover", true);
    return caps;
  }

  public DesiredCapabilities getLocalCapabilities() {
    DesiredCapabilities caps = null;
    switch (Config.getBrowserType()) {
    case IE11:
      caps = getLocalIECapabilities();
      break;
    case Chrome:
      caps = getLocalChromeCapabilities();
      break;
    case HeadLess:
      caps = getLocalHeadLessCapabilities();
      break;
    default:
      TestLogger.fatal("UnSupported browser");
      break;
    }
    return caps;
  }

  public DesiredCapabilities getRemoteCapabilities() {
    DesiredCapabilities caps = null;
    switch (Config.getBrowserType()) {
    case IE11:
      caps = getRemoteIECapabilities();
      break;
    case Chrome:
      caps = getRemoteChromeCapabilities();
      break;
    case HeadLess:
      caps = getRemoteHeadLessCapabilities();
      break;
    default:
      TestLogger.fatal("=>UnSupported browser");
      break;
    }
    return caps;
  }

}
