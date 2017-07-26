package com.steeleye.iris.automation.pages;

import com.steeleye.iris.automation.core.*;

public class LoginPage extends Page {

	public static String pageUrl = Config.getBaseURL() + "login";

	public static class Locators {
		public static String root = "xpath=//*[@id='app']/div/div/div/div/div/div/div/form";
		public static String emailField = root + "/div[2]/div/div/div[1]/input";
		public static String passWordField = root + "/div[2]/div/div/div[2]/input";
		public static String loginButton = root + "/div[3]/div/div/button";
		public static String forgotPasswordLink = root + "/div[3]/div/div/a";
		public static String errorMessage = root + "/div[2]/div/div/span/span";

	}

	public static class Expected {
		public static String errorText = "The credentials you entered are invalid. Please try again.";
	}
}
