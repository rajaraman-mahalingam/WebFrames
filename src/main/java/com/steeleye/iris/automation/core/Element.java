package com.steeleye.iris.automation.core;

import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public class Element {

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
        TestLogger.debug("Found Locator by Xpath");
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

  public static WebElement findElement(String Locator) {
    return Browser.driver.findElement(getElement(locatorIdentifier(Locator).actualLocator));
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

    return findElement(Locator).isEnabled();
  }

  public static void typeIn(String Locator, String keys) {

    findElement(Locator).clear();
    findElement(Locator).sendKeys(keys);
  }

  public static String getText(String Locator) {

    return findElement(Locator).getText();
  }
}
