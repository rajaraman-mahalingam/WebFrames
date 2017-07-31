package com.steeleye.iris.automation.core;

import java.util.Set;
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
			case Grid:
				// returnedDriver = (RemoteWebDriver)
				// BrowserEnvironment.Remote.getRemoteCapabilities(getBrowserType());
				break;
			default:
				TestLogger.fatal(
				    "=>Unable to create browser instance. Please check automation.properties file for the correct values..");
				returnedDriver = null;
				break;
			}
			driverOpened = true;
			return returnedDriver;
		} catch (Throwable e) {
			TestLogger.debug(
			    "=>Unable to create browser instance. Please check automation.properties file for the correct values..");
			driverOpened = false;
			return null;
		}
	}

	public static WebDriver driver() {
		return driver;
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
			TestLogger.debug("Error Opening page", e);
		}
	}

	public static void navigate(String url) {
		driver.navigate().to(url);
	}

	public static void close() {
		driver.close();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void getPageCookies() {
		driver.manage().getCookies();
	}

	public static void waitForDOMToLoad(long unit) {
		driver.manage().timeouts().implicitlyWait(unit, TimeUnit.SECONDS);
	}

	public void addPageCookies(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

	public void deletePageCookies(Cookie cookie) {
		driver.manage().deleteCookie(cookie);
	}

	public void deleteSpecificCookie(Cookie cookie) {
		driver.manage().deleteCookie(cookie);
	}

	public void getPageSource() {
		driver.getPageSource();
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchToSpecificFrameByName(String frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToSpecificFrameById(int id) {
		driver.switchTo().frame(id);
	}

	public static void setPageWait(long wait) {
		try {
			driver.manage().wait(wait);
		} catch (InterruptedException e) {
			TestLogger.debug("Unable to set wait", e);
		}
	}

	public String getPageWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getPageAllWindowHandle() {
		return driver.getWindowHandles();
	}
}
