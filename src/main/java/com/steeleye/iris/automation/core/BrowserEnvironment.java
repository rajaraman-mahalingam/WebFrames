package com.steeleye.iris.automation.core;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public enum BrowserEnvironment {

	Local("Local"), Grid("Grid"), External("External");

	public String name;
	public String chromeDriverPath;

	BrowserEnvironment(String name) {
		this.name = name;
	}

	public DesiredCapabilities getCapabilities() {
		try {
			switch (this) {
			case Local:
			default:
				return getLocalCapabilities();
			case Grid:
				return getGridCapabilities();
			case External:
				return getExternalCapabilities();
			}
		} catch (Exception e) {
			TestLogger.debug("Unable to get Capabilities", e);
			return null;
		}
	}

	private DesiredCapabilities getExternalCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	public DesiredCapabilities getLocalHeadLessCapabilities() throws ConfigurationException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		if (Config.getPlatform().toString().equals("Windows")) {
			chromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
		} else if (Config.getPlatform().toString().equals("Mac")) {
			chromeDriverPath = "src/main/resources/drivers/chromedrivermac";
		}
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		return caps;
	}

	public DesiredCapabilities getLocalChromeCapabilities() throws ConfigurationException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		if (Config.getPlatform().equals("Windows")) {
			chromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
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
		//caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//caps.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 20000);
		//caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		caps.setCapability("pageLoadStrategy", "none");
		//caps.setCapability("enablePersistentHover", true);
		return caps;
	}

	public DesiredCapabilities getGridHeadLessCapabilities() throws ConfigurationException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		if (Config.getPlatform().toString().equals("Windows")) {
			chromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
		} else if (Config.getPlatform().toString().equals("Mac")) {
			chromeDriverPath = "src/main/resources/drivers/chromedrivermac";
		}
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		return caps;
	}

	public DesiredCapabilities getGridChromeCapabilities() throws ConfigurationException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		if (Config.getPlatform().toString().equals("Windows")) {
			chromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
		} else if (Config.getPlatform().toString().equals("Mac")) {
			chromeDriverPath = "src/main/resources/drivers/chromedrivermac";
		}
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		options.addArguments("chrome.switches", "--disable-extensions");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		return caps;
	}

	public DesiredCapabilities getGridIECapabilities() {
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\IEDriverServer.exe");
		//caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//caps.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 20000);
		//caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		caps.setCapability("pageLoadStrategy", "none");
		//caps.setCapability("enablePersistentHover", true);
		return caps;
	}

	public DesiredCapabilities getLocalCapabilities() {
		DesiredCapabilities caps = null;
		try {
			switch (Config.getBrowserType()) {
			case IE11:
				caps = getLocalIECapabilities();
				break;
			case Chrome:
			default:
				caps = getLocalChromeCapabilities();
				break;
			case HeadLess:
				caps = getLocalHeadLessCapabilities();
				break;
			}
			return caps;
		} catch (Exception e) {
			TestLogger.debug("UnSupported browser", e);
			return null;
		}
	}

	public DesiredCapabilities getGridCapabilities() {
		DesiredCapabilities caps = null;
		try {
			switch (Config.getBrowserType()) {
			case IE11:
				caps = getGridIECapabilities();
				break;
			case Chrome:
			default:
				caps = getGridChromeCapabilities();
				break;
			case HeadLess:
				caps = getGridHeadLessCapabilities();
				break;
			}
			return caps;
		} catch (Exception e) {
			TestLogger.debug("Unsupported Remote browser", e);
			return null;
		}
	}

}
