package com.steeleye.iris.automation.core;

import org.junit.Before;

import com.steeleye.iris.automation.utilities.Utils;

import lombok.Getter;
import lombok.Setter;

public class Config {
	static BrowserEnvironment environment;
	static BrowserType browserType;
	static String baseURL;
	static String platform;
	static String gridURL;
	static String userName;
	static String passWord;
	static boolean debug;
	static String runCondition;
	static String priority;
	
	@Getter
	@Setter
	private static String testName;

	@Getter
	@Setter
	private static String testClass;

	@Before
	public static void readAutomationProperty() {
		Utils.readAutomationPropertiesFromFile();
	}
	
	public static String getBaseURL() {
		return baseURL = Utils.getProperty("baseURL");
	}

	public static BrowserEnvironment getEnvironment() {
		return environment = BrowserEnvironment.valueOf(Utils.getProperty("environment"));
	}

	public static String getPlatform() {
		return platform = Utils.getProperty("platform").trim();
	}

	public static BrowserType getBrowserType() {
		return browserType = BrowserType.valueOf(Utils.getProperty("browserType"));
	}

	public static String getGridURL() {
		return gridURL = Utils.getProperty("gridURL");
	}

	public static String getUserName() {
		return userName = Utils.getProperty("username");
	}

	public static String getPassword() {
		return passWord = Utils.getProperty("password");
	}
	
	public static boolean isDebug() {
		readAutomationProperty();
		return debug = Boolean.parseBoolean(Utils.getProperty("isDebug"));
	}

	public static String getRunCondition() {
		return runCondition = Utils.getProperty("runCondition");
	}

	public static String getPriority() {
		return priority = Utils.getProperty("priority");
	}
	
	public static String getTestDescription() throws ClassNotFoundException, NoSuchMethodException {
		String description = null;
		description = TestRunManager.getTestDescription();
		if (description == null) {
			description = "Error searching for test description !!!";
		} else if (description.equals("")) {
			description = "Test description is empty !!!";
		}
		return description;
	}

	public static String getTestRunCondition() throws ClassNotFoundException, NoSuchMethodException {
		String description = null;
		description = TestRunManager.getTestRunConditon();
		if (description == null) {
			description = "Run Condition Not Set. Will execute on all Test Runs!";
		} else if (description.equals("")) {
			description = "Run Condition is empty. Will execute on all Test Runs!  !!!";
		}
		return description;
	}

	public static String getTestPriority() throws ClassNotFoundException, NoSuchMethodException {
		String description = null;
		description = TestRunManager.getTestPriority();
		if ( (description == null) || (description.equals("")) ) {
			description = "Priority Not set. Will execute on all Test Runs!";
		}
		return description;
	}
	
	public static boolean verifyRunCondition() throws ClassNotFoundException, NoSuchMethodException {
		if ((getRunCondition().equalsIgnoreCase("All")) || (getRunCondition().equalsIgnoreCase(""))) {
			return true;
		}
		return getRunCondition().equalsIgnoreCase(getTestRunCondition());
	}
	
	public static boolean verifyPriority() throws ClassNotFoundException, NoSuchMethodException {
		if ( (getRunCondition().equalsIgnoreCase("All") ) || (getRunCondition().equalsIgnoreCase("Sanity")) 
		|| ( (getRunCondition().equalsIgnoreCase("Regression"))  && (getPriority().equalsIgnoreCase("")) )
			 )	{
						return true;
		}
		if ( (getRunCondition().equalsIgnoreCase("Regression") ) && (!getPriority().equalsIgnoreCase("")) ) {
					return getPriority().equalsIgnoreCase(getTestPriority());
	}
		return false;
 }
}
