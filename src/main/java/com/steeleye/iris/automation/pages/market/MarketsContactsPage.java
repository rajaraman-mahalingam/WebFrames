package com.steeleye.iris.automation.pages.market;

import com.steeleye.iris.automation.components.PageActions;
import com.steeleye.iris.automation.core.Config;
import com.steeleye.iris.automation.core.Page;

public class MarketsContactsPage extends Page implements PageActions {
	
	public static String pageUrl = Config.getBaseURL() + "market/contacts";
		
		public static class Locators {
		public static String pageTitle;
		public static String countOfContacts ="xpath=//*[@id='app']/div/div/main/div/div/div/div[2]/div";
		public static String listOfContacts ="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/tbody/tr";
		public static String allContactsCheckbox="xpath=//*[@id='app']/div/div/main/div/section/div/div/div/table/thead/tr/th[1]/div/label/input";
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
