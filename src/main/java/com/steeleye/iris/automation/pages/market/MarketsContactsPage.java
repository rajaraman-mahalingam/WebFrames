package com.steeleye.iris.automation.pages.market;

import org.apache.commons.configuration2.ex.ConfigurationException;

import com.steeleye.iris.automation.components.CheckboxActions;
import com.steeleye.iris.automation.components.PageActions;
import com.steeleye.iris.automation.core.Config;
import com.steeleye.iris.automation.core.Page;

public class MarketsContactsPage extends Page implements PageActions {
	
	public static String pageUrl =  "market/contacts";
		
		private static class Locators {
		private static String countOfContacts ="xpath=//*[@id='app']/div/div/main/div/div/div/div[2]/div";
		private static String listOfContacts ="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/tbody/tr";
		private static String allContactsCheckbox="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/thead/tr/th[1]/div/label/input";
		private static String checkboxElement = "/td[1]/div/label/input";
		private static String checkboxIdentifier = "/td[1]/div/label/span";
		}
		
		public static void open() throws ConfigurationException {
			open(Config.getBaseURL() +pageUrl);
			waitForDOMToLoad(5);
		}

		public static long countOfAllContacts() {
			return countOfItems(Locators.countOfContacts);
		}
		
		public static long countOfContactsListed() {
			return getCountOfChildren(Locators.listOfContacts);
		}
		
		public static long countOfSelectedContacts() {
			return CheckboxActions
	        .getCountOfSelectedChildren(Locators.listOfContacts, Locators.checkboxElement, Locators.checkboxIdentifier);
		}
		
		public static long countOfContactsDisplayed(){
			return getCountOfChildrenDisplayedOnThisPage(Locators.listOfContacts);
		}
		
		public static boolean countDisplayedEqualsListedContacts() {
			return countOfAllContacts() == countOfContactsListed();
		}
		
		public static boolean countDisplayedEqualsSelectedContacts() {
			return countOfAllContacts() == countOfSelectedContacts();
		}
		
		public static boolean countDisplayedEqualsContactsListedInThisPage() {
			return countOfSelectedContacts() == countOfContactsDisplayed() ;
		}
		
		public static boolean isCountOfContactsDisplayed() {
			return isElementDisplayed(Locators.countOfContacts);
		}
		
		public static void selectContacts() {
			CheckboxActions.checkItems(Locators.listOfContacts,Locators.checkboxIdentifier);
		}
		
		public static void selectAllContacts() {
			CheckboxActions.checkAllItems(Locators.allContactsCheckbox);
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
