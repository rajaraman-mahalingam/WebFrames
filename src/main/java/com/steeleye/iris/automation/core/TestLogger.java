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

  private static Logger logger = Logger.getLogger("steeleye");

  public static TestName testName = new TestName();

  public Timeout globalTimeout = Timeout.seconds(5 * 60);

  public static void init() {
    if (Config.isDebug().equals("true")) {
    logger.setLevel(Level.DEBUG);
    }
    else logger.setLevel(Level.INFO);
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
    info("________________________________________________________________________________________________________________________________________________________");
    try {
      info("[" + getTimeStamp() + "] New test started:\n" + Config.getTestClass() +"."+ Config.getTestName() +"-" + Config.getTestDescription());
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
      info("[" + getTimeStamp() + "] Test Ended:\n" + Config.getTestClass() +"."+ Config.getTestName() +"-" + Config.getTestDescription());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static void setResult(ExecutionStatus status) {
    info("Execution Status:" + status.name());
  }
  
  public static void setResult(ExecutionStatus status, Throwable e) {
    info("Execution Status:" + status.name() + e.getMessage());
    }
  }
