package com.steeleye.iris.automation.core;

import org.apache.commons.configuration2.ex.ConfigurationException;
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

	public static String readAutomationProperty(String key) throws ConfigurationException {
		String value = System.getenv(key);
		if(value != null)
		{
			Utils.readAutomationPropertiesFromEnvironmentVariables(key, value);
		}
		if(value == null) {
			value = System.getProperty(key);
			if(value !=null) {
			Utils.readAutomationPropertiesFromEnvironmentVariables(key, value);
			}
		}
		if(value == null)
		{
			value = Utils.readAutomationPropertiesFromFileUsingKey(key);
		}
		return value;
	}	

	public static String getBaseURL() throws ConfigurationException {
		return baseURL = readAutomationProperty("baseURL");
	}

	public static BrowserEnvironment getEnvironment() throws ConfigurationException {
		return environment = BrowserEnvironment.valueOf(readAutomationProperty("environment"));
	}

	public static String getPlatform() throws ConfigurationException {
		return platform = readAutomationProperty("platform");
	}

	public static BrowserType getBrowserType() throws ConfigurationException {
		return browserType = BrowserType.valueOf(readAutomationProperty("browserType"));
	}

	public static String getGridURL() throws ConfigurationException {
		return gridURL = readAutomationProperty("gridURL");
	}

	public static String getUserName() throws ConfigurationException {
		return userName = readAutomationProperty("username");
	}

	public static String getPassword() throws ConfigurationException {
		return passWord = readAutomationProperty("password");
	}

	public static boolean isDebug() throws ConfigurationException {
		//readAutomationProperty();
		return debug = Boolean.parseBoolean(readAutomationProperty("isDebug"));
	}

	public static String getRunCondition() throws ConfigurationException {
		return runCondition = readAutomationProperty("runCondition");
	}

	public static String getPriority() throws ConfigurationException {
		return priority = readAutomationProperty("priority");
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
		if ((description == null) || (description.equals(""))) {
			description = "Priority Not set. Will execute on all Test Runs!";
		}
		return description;
	}

	public static boolean verifyRunCondition() throws ClassNotFoundException, NoSuchMethodException, ConfigurationException {
		if ((getRunCondition().equalsIgnoreCase("All")) || (getRunCondition().equalsIgnoreCase(""))) {
			return true;
		}
		return getRunCondition().equalsIgnoreCase(getTestRunCondition());
	}

	public static boolean verifyPriority() throws ClassNotFoundException, NoSuchMethodException, ConfigurationException {
		if ((getRunCondition().equalsIgnoreCase("All")) || (getRunCondition().equalsIgnoreCase("Sanity"))
		    || ((getRunCondition().equalsIgnoreCase("Regression")) && (getPriority().equalsIgnoreCase("")))
		    || (getRunCondition().equalsIgnoreCase("") && (getPriority().equalsIgnoreCase("")))) {
			return true;
		} else if ((getRunCondition().equalsIgnoreCase("Regression")) && (!getPriority().equalsIgnoreCase(""))
		    || (getRunCondition().equalsIgnoreCase("")) && (!getPriority().equalsIgnoreCase(""))) {
			return getPriority().equalsIgnoreCase(getTestPriority());
		}
		return false;
	}
}
