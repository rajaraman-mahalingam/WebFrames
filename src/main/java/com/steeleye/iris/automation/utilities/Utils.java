package com.steeleye.iris.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.steeleye.iris.automation.core.Browser;
import com.steeleye.iris.automation.core.Config;
import com.steeleye.iris.automation.core.TestLogger;

public class Utils {

	public static Properties prop = new Properties();
	public static InputStream input = null;
	public static String filePath = "src/main/resources/automation.properties";

	public static void takeScreenShot() {
		try {
			File Screenshot = ((TakesScreenshot) Browser.driver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screenshot,
					new File("\\surefire-report\\screenshots\\" + Config.getTestName() + ".jpg"));
		} catch (Throwable e) {
			TestLogger.debug("Unable to get Screen shot.. Check Config", e);
		}
	}

	public static void readAutomationPropertiesFromFile() {
		try {
			input = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			TestLogger.fatal("Properties file Not found", e);
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			TestLogger.fatal("Unable to load properties file", e);
		}
	}

	public static void readAutomationPropertiesFromEnvironmentVariables(String key, String value)
			throws ConfigurationException {
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
				PropertiesConfiguration.class).configure(params.properties().setFileName(Utils.filePath));
		Configuration config = builder.getConfiguration();
		config.setProperty(key, value);
		builder.save();
	}

	public static String getProperty(String property) {
		return prop.getProperty(property).trim();
	}

	public static long convertStringToNumber(String element) {
		return Long.parseLong(element);
	}

	public static String getSubString(String element, int start, int end) {
		return element.substring(start, end);
	}

	public static int randomize(int number) {
		Random rand = new Random();
		return rand.nextInt(number);
	}

	public static IntStream randomize(int start, int end) {
		Random rand = new Random();
		return rand.ints(start, end);
	}

	public static String readAutomationPropertiesFromFileUsingKey(String key) {
		try {
			input = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			TestLogger.fatal("Properties file Not found", e);
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			TestLogger.fatal("Unable to load properties file", e);
		}
		return prop.getProperty(key).trim();
	}
}
