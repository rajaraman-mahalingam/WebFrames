package com.steeleye.iris.automation.core;

import java.sql.Timestamp;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public class TestLogger {

	private static final Logger logger = Logger.getLogger("steeleye");
	public static ExecutionStatus executionStatus;

	public static TestName testName = new TestName();

	public Timeout globalTimeout = Timeout.seconds(5 * 60);

	public static void init() {
		if (Config.isDebug()) {
			logger.setLevel(Level.DEBUG);
		} else
			logger.setLevel(Level.INFO);
	}

	public static void quit() {
		LogManager.shutdown();
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void debug(String message, Throwable e) {
		logger.debug(message, e);
	}

	public static void info(String message) {
		logger.info(message);
	}

	public static void info(String message, Throwable e) {
		logger.info(message, e);
	}

	public static void info(Boolean value) {
		logger.info(value);
	}

	public static void fatal(String message, Throwable e) {
		logger.fatal(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
	}

	public static void assertTrue(String message, boolean condition) {
		Assert.assertTrue(message, condition);
		info("Verification Passed:" + message);
	}

	public static void assertFalse(String message, boolean condition) {
		Assert.assertFalse(message, condition);
		info("Verification Passed:" + message);
	}

	public static void assertEquals(String message, Object expected, Object actual) {
		Assert.assertEquals(message, expected, actual);
		info("Verification Passed: " + message + " Expected: " + expected);
	}

	public static void verifyTrue(String message, boolean condition) {
		try {
			assertTrue(message, condition);
		} catch (Error e) {
			info("Verification Failed" + e);
		}
		info("Verification Passed:" + message);
	}

	public static void verifyFalse(String message, boolean condition) {
		try {
			assertFalse(message, condition);
		} catch (Error e) {
			info("Verification Failed" + e);
		}
		info("Verification Passed:" + message);
	}

	public static void verifyEquals(String message, Object expected, Object actual) {
		Assert.assertEquals(message, expected, actual);
		info("Verification Passed: " + message + " Expected: " + expected);
	}

	public static String getTimeStamp() {
		java.util.Date date = new java.util.Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		return timeStamp.toString();
	}

	public static void doTestStart() {
		info(
		    "________________________________________________________________________________________________________________________________________________________");
		try {
			info("[" + getTimeStamp() + "] New test started:\n" + Config.getTestDescription());
			debug("[" + Config.getTestClass() + "." + Config.getTestName() + "]");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void doTestEnd() {
		try {
			info("[" + getTimeStamp() + "] Test Ended:\n" + Config.getTestDescription());
			debug("[" + Config.getTestClass() + "." + Config.getTestName() + "]");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setResult(ExecutionStatus status) {
		debug("Execution Status:" + status.name());
	}

	public static void setResult(ExecutionStatus status, Throwable e) {
		debug("Execution Status:" + status.name() + " " + e.getMessage());
	}

	public static void setExecutionStatus(ExecutionStatus status) {
		executionStatus = status;
	}

	public static ExecutionStatus getExecutionStatus() {
		return executionStatus;
	}
}
