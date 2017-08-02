package com.steeleye.iris.automation.pages.market;

import com.steeleye.iris.automation.components.CheckboxActions;
import com.steeleye.iris.automation.components.PageActions;
import com.steeleye.iris.automation.core.Config;
import com.steeleye.iris.automation.core.Page;

public class MarketCounterpartyPage extends Page implements PageActions {
	
	private static String pageUrl = Config.getBaseURL() + "market/counterparties";
	
	private static class Locators {
	private static String countOfCounterParties ="xpath=//*[@id='app']/div/div/main/div/div/div/div[2]/div";
	private static String listOfCounterparties ="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/tbody/tr";
	private static String allCounterPartiesCheckbox="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/thead/tr/th[1]/div/label/input";
	private static String checkboxElement = "/td[1]/div/label/input";
	private static String checkboxIdentifier = "/td[1]/div/label/span";
	}
	
	public static void open() {
		open(pageUrl);
		waitForDOMToLoad(5);
	}

	public static long countOfAllCounterParties() {
		return countOfItems(Locators.countOfCounterParties);
	}
	
	public static long countOfCounterPartiesListed() {
		return getCountOfChildren(Locators.listOfCounterparties);
	}
	
	public static long countOfSelectedCounterParties() {
		return CheckboxActions
        .getCountOfSelectedChildren(Locators.listOfCounterparties, Locators.checkboxElement, Locators.checkboxIdentifier);
	}
	
	public static long countOfCounterPartiesDisplayed(){
		return getCountOfChildrenDisplayedOnThisPage(Locators.listOfCounterparties);
	}
	
	public static boolean countDisplayedEqualsListedCounterparties() {
		return countOfAllCounterParties() == countOfCounterPartiesListed();
	}
	
	public static boolean countDisplayedEqualsSelectedCounterparties() {
		return countOfAllCounterParties() == countOfSelectedCounterParties();
	}
	
	public static boolean countDisplayedEqualsCounterPartiesListedInThisPage() {
		return countOfSelectedCounterParties() == countOfCounterPartiesDisplayed() ;
	}
	
	public static boolean isCountOfCounterPartiesDisplayed() {
		return isElementDisplayed(Locators.countOfCounterParties);
	}
	
	public static void selectCounterParties() {
		CheckboxActions.checkItems(Locators.listOfCounterparties,Locators.checkboxIdentifier);
	}
	
	public static void selectAllCounterParties() {
		CheckboxActions.checkAllItems(Locators.allCounterPartiesCheckbox);
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
