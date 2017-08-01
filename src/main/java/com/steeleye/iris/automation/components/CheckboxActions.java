package com.steeleye.iris.automation.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.steeleye.iris.automation.core.Page;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.utilities.Utils;

public class CheckboxActions extends Page{
	
	public static void checkItems(String Locators) {
		int count = Utils.randomize(getCheckboxOfChild(Locators).size());
		TestLogger.info("value:"+count);
		for(int i=0; i<count;i++){
			getCheckboxOfChild(Locators).get(i).click();
		}
	}
	
	public static void checkAllItems(String Locators) {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(Locators)).click().perform();
	}
	
	public static List<WebElement> getCheckboxOfChild(String Locator) {
		List<WebElement> element = new ArrayList<WebElement>();
		for (int i = 0; i < getCountOfChildrenDisplayedOnThisPage(Locator); i++) {
			element.add(findElement(Locator + "[" + (i + 1) + "]" + "/td[1]/div/label/span"));
		}
		return element;
	}

	public static int getCountOfSelectedChildren(String Locator) {
		List<WebElement> element = new ArrayList<WebElement>();
		for (int i = 0; i < getCheckboxOfChild(Locator).size(); i++) {
			if (isElementSelected(Locator + "[" + (i + 1) + "]" + "/td[1]/div/label/input")) {
				element.add(findElement(Locator + "[" + (i + 1) + "]" + "/td[1]/div/label/span"));
			}
		}
		return element.size();
	}

}
