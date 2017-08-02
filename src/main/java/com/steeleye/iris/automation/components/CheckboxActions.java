package com.steeleye.iris.automation.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.steeleye.iris.automation.core.Page;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.utilities.Utils;

public class CheckboxActions extends Page{

	public static void checkAllItems(String Locators) {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(Locators)).click().perform();
	}
	
	public static void checkItems(String Parent, String Child) {
		int count = Utils.randomize(getCheckboxOfChild(Parent, Child).size());
		if(count==0) {
			count ++;
		}
		TestLogger.info("Selecting "+ count + "items....");
		for(int i=0; i<count;i++){
			getCheckboxOfChild(Parent, Child).get(i).click();
		}
	}
	
	public static List<WebElement> getCheckboxOfChild(String Parent, String Child) {
		List<WebElement> element = new ArrayList<WebElement>();
		for (int i = 0; i < getCountOfChildrenDisplayedOnThisPage(Parent); i++) {
			element.add(findElement(Parent + "[" + (i + 1) + "]" + Child));
		}
		return element;
	}

	
	public static int getCountOfSelectedChildren(String Parent, String ChildElement, String Child) {
		List<WebElement> element = new ArrayList<WebElement>();
		for (int i = 0; i < getCheckboxOfChild(Parent, Child).size(); i++) {
			if (isElementSelected(Parent + "[" + (i + 1) + "]" + ChildElement)) {
				element.add(findElement(Parent + "[" + (i + 1) + "]" + Child));
			}
		}
		return element.size();
	}
	
}
