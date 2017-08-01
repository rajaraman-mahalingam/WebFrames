package com.steeleye.iris.automation.core;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.steeleye.iris.automation.pages.LoginPage.Locators;
import com.steeleye.iris.automation.utilities.Utils;

import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public class Page extends Browser {

	public static String pagination = "xpath=//*[@id='app']/div/div/main/div/section/div/div/div[2]/div/button";

	public static class Element {

		public enum LocatorStrategy {

			byClassName("className="), byId("id="), byXpath("xpath="), byCssPath("css="), byName("name="), byLinkText(
			    "linktext="), byTagName("tagname="), byPartialLinkText("partiallinktext=");

			public String name;

			LocatorStrategy(String name) {
				this.name = name;
			}
		}

		public LocatorStrategy locatorStrategy;
		public String actualLocator;

		Element(LocatorStrategy locatorStrategy, String actualLocator) {
			this.locatorStrategy = locatorStrategy;
			this.actualLocator = actualLocator;
		}

		public static Element locatorIdentifier(String locator) {
			for (LocatorStrategy e : LocatorStrategy.values()) {
				if (locator.startsWith(e.name)) {
					return new Element(e, locator.substring(e.name.length(), locator.length()));
				}
			}
			if (locator.startsWith("/") || locator.startsWith("(/")) {
				return new Element(LocatorStrategy.byXpath, locator);
			}
			return new Element(LocatorStrategy.byCssPath, locator);
		}

		public static By getElement(String element) {
			Element el = locatorIdentifier(element);
			try {
				switch (el.locatorStrategy) {
				case byClassName:
					TestLogger.debug("Found Locator by Class Name");
					return new ByClassName(element);
				case byId:
					TestLogger.debug("Found Locator by ID");
					return new ById(element);
				case byXpath:
					TestLogger.debug("Found Locator by Xpath" + element);
					return new ByXPath(element);
				case byName:
					TestLogger.debug("Found Locator by Name");
					return new ByName(element);
				case byLinkText:
					TestLogger.debug("Found Locator by Link Text");
					return new ByLinkText(element);
				case byTagName:
					TestLogger.debug("Found Locator by Tag Name");
					return new ByTagName(element);
				case byPartialLinkText:
					TestLogger.debug("Found Locator by Partial Link Text");
					return new ByPartialLinkText(element);
				case byCssPath:
					TestLogger.debug("Found Locator by Css");
					return new ByCssSelector(element);
				default:
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				TestLogger.fatal("Unable to Locate Element.. Check the Locator string!");
				return null;
			}
		}
	}

	public static WebElement findElement(String Locator) {
		return Browser.driver.findElement(Element.getElement(Element.locatorIdentifier(Locator).actualLocator));
	}

	public static List<WebElement> findElements(String Locator) {
		return Browser.driver.findElements(Element.getElement(Element.locatorIdentifier(Locator).actualLocator));
	}

	public static void click(String Locator) {
		findElement(Locator).click();
	}

	public static void submit(String Locator) {

		findElement(Locator).submit();
	}

	public static boolean isElementDisplayed(String Locator) {
		try {
			findElement(Locator).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementSelected(String Locator) {
		return findElement(Locator).isSelected();
	}

	public static boolean isElementEnabled(String Locator) {
		try {
			findElement(Locator).isEnabled();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void typeIn(String Locator, String keys) {

		findElement(Locator).clear();
		findElement(Locator).sendKeys(keys);
	}

	public static String getText(String Locator) {
		return findElement(Locator).getText();
	}

	public static void open(String url) {
		if (!Config.getTestClass().matches("^Login$")) {
			openPage(url);
			if (isElementDisplayed(Locators.emailField)) {
				typeIn(Locators.emailField, Config.getUserName());
				typeIn(Locators.passWordField, Config.getPassword());
				click(Locators.loginButton);
			}
		}
	}

	public static boolean hasChildren(String Locator) {
		return findElements(Locator).size() > 0;
	}

	public static int getCountOfChildrenDisplayedOnThisPage(String Locator) {
		return findElements(Locator).size();
	}

	public static boolean doesPaginationExist() {
		return isElementDisplayed(pagination);
	}

	public static int getCountOfPages() {
		return findElements(pagination).size();
	}

	public static List<WebElement> getPages() {
		List<WebElement> element = new ArrayList<WebElement>();
		for (int i = 0; i < getCountOfPages(); i++) {
			if (!findElement(pagination + "[" + (i + 1) + "]").getText().equals("")) {
				element.add(findElement(pagination + "[" + (i + 1) + "]"));
			}
		}
		return element;
	}

	public static List<WebElement> getChildren(String Locator) {
		List<WebElement> element = new ArrayList<WebElement>();
		if (hasChildren(Locator)) {
			if (!doesPaginationExist()) {
				for (int i = 0; i < getCountOfChildrenDisplayedOnThisPage(Locator); i++) {
					element.add(i, findElement(Locator + "[" + (i + 1) + "]"));
				}
			} else {
				for (int j = 0; j < getPages().size(); j++) {
					getPages().get(j).click();
					for (int i = 0; i < getCountOfChildrenDisplayedOnThisPage(Locator); i++) {
						element.add(i, findElement(Locator + "[" + (i + 1) + "]"));
					}
				}
			}
		}
		return element;
	}
	
	public static int getCountOfChildren(String Locator) {
		return getChildren(Locator).size();
	}

	public static long countOfItems(String Locators) {
		return Utils.convertStringToNumber(convertStringToNum(Locators));
	}

	public static String convertStringToNum(String Locators) {
		String[] split = findElement(Locators).getText().split("\\s+");
		return split[0];
	}

}
