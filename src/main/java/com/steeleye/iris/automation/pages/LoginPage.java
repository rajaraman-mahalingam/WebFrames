package com.steeleye.iris.automation.pages;

import org.apache.commons.configuration2.ex.ConfigurationException;

import com.steeleye.iris.automation.core.*;

public class LoginPage extends Page {

	private static String pageUrl =  "login";

	  public static class Locators {
		public static String root = "xpath=//*[@id='app']/div/div/div/div/div/div/div/form";
		public static String emailField = root + "/div[2]/div/div/div[1]/input";
		public static String passWordField = root + "/div[2]/div/div/div[2]/input";
		public static String loginButton = root + "/div[3]/div/div/button";
		//private static String forgotPasswordLink = root + "/div[3]/div/div/a";
		private static String errorMessage = root + "/div[2]/div/div/span/span";

	}
	
	public static void open() throws ConfigurationException {
		openPage(Config.getBaseURL()+pageUrl);
		waitForDOMToLoad(5);
	}
	
	public static void typeInInvalidCredentials() {
		typeIn(Locators.emailField, "Hello");
		typeIn(Locators.passWordField,"dfjkdfjkd");
	}
	
	public static void typeInValidCredentials() throws ConfigurationException {
		typeIn(Locators.emailField, Config.getUserName());
		typeIn(Locators.passWordField,Config.getPassword());
	}
	
	public static void pressSubmitButton(){
		click(Locators.loginButton);
	}
	
	public static boolean isErrorMessageDisplayed() {
		return isElementDisplayed(Locators.errorMessage);
	}
	
	public static boolean errorMessageMatchesExpectedText() {
		return getText(Locators.errorMessage).equals(Expected.errorText);
	}
	
	private static class Expected {
		private static String errorText = "The credentials you entered are invalid. Please try again.";
	}
}
