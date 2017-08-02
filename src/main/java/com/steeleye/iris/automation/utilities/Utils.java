package com.steeleye.iris.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.steeleye.iris.automation.core.Browser;
import com.steeleye.iris.automation.core.Config;
import com.steeleye.iris.automation.core.TestLogger;

public class Utils {

	public static Properties prop = new Properties();
	public static InputStream input = null;

	public static void takeScreenShot() {
		try {
			File Screenshot = ((TakesScreenshot) Browser.driver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screenshot, new File("\\surefire-report\\screenshots\\" + Config.getTestName() + ".jpg"));
		} catch (Throwable e) {
			TestLogger.debug("Unable to get Screen shot.. Check Config", e);
		}
	}

	public static void readAutomationPropertiesFromFile() {
		try {
			input = new FileInputStream("src/main/resources/automation.properties");
		} catch (FileNotFoundException e) {
			TestLogger.fatal("Properties file Not found", e);
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			TestLogger.fatal("Unable to load properties file", e);
		}
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
}
