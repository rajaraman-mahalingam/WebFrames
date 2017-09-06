package com.steeleye.iris.automation.pages.market;

import org.apache.commons.configuration2.ex.ConfigurationException;

import com.steeleye.iris.automation.components.CheckboxActions;
import com.steeleye.iris.automation.components.PageActions;
import com.steeleye.iris.automation.core.Config;
import com.steeleye.iris.automation.core.Page;

public class MarketsPeoplePage extends Page implements PageActions {
	
	public static String pageUrl =  "market/people";
	
	private static class Locators {
	private static String countOfPeople ="xpath=//*[@id='app']/div/div/main/div/div/div/div[2]/div";
	private static String listOfPeople ="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/tbody/tr";
	private static String allPeopleCheckbox="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/thead/tr/th[1]/div/label/input";
	private static String checkboxElement = "/td[1]/div/label/input";
	private static String checkboxIdentifier = "/td[1]/div/label/span";
	}
	
	public static void open() throws ConfigurationException {
		open(Config.getBaseURL() +pageUrl);
		waitForDOMToLoad(5);
	}

	public static long countOfAllPeople() {
		return countOfItems(Locators.countOfPeople);
	}
	
	public static long countOfPeopleListed() {
		return getCountOfChildren(Locators.listOfPeople);
	}
	
	public static long countOfSelectedPeople() {
		return CheckboxActions
        .getCountOfSelectedChildren(Locators.listOfPeople, Locators.checkboxElement, Locators.checkboxIdentifier);
	}
	
	public static long countOfPeopleDisplayed(){
		return getCountOfChildrenDisplayedOnThisPage(Locators.listOfPeople);
	}
	
	public static boolean countDisplayedEqualsListedPeople() {
		return countOfAllPeople() == countOfPeopleListed();
	}
	
	public static boolean countDisplayedEqualsSelectedPeople() {
		return countOfAllPeople() == countOfSelectedPeople();
	}
	
	public static boolean countDisplayedEqualsPeopleListedInThisPage() {
		return countOfSelectedPeople() == countOfPeopleDisplayed() ;
	}
	
	public static boolean isCountOfPeopleDisplayed() {
		return isElementDisplayed(Locators.countOfPeople);
	}
	
	public static void selectPeople() {
		CheckboxActions.checkItems(Locators.listOfPeople,Locators.checkboxIdentifier);
	}
	
	public static void selectAllPeople() {
		CheckboxActions.checkAllItems(Locators.allPeopleCheckbox);
	}


	public void addNew() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void refine() {
		// TODO Auto-generated method stub
		
	}

	public void search() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void view() {
		// TODO Auto-generated method stub
		
	}

}
