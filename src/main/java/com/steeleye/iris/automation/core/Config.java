package com.steeleye.iris.automation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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
  static String debug;
  
  @Getter @Setter
  private static String testName;
  
  @Getter @Setter
  private static String testClass;
  
  static Properties prop = new Properties();
  static InputStream input = null;

  public static void readAutomationProperty() {
    try {
      input = new FileInputStream("src/main/resources/automation.properties");
    } catch (FileNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    try {
      prop.load(input);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static String getBaseURL() {
    readAutomationProperty();
    return baseURL = prop.getProperty("baseURL").trim();
  }

  public static BrowserEnvironment getEnvironment() {
    readAutomationProperty();
    return environment = BrowserEnvironment.valueOf(prop.getProperty("environment").trim());
  }

  public static String getPlatform() {
    readAutomationProperty();
    return platform = prop.getProperty("platform").trim();
  }

  public static BrowserType getBrowserType() {
    readAutomationProperty();
    return browserType = BrowserType.valueOf(prop.getProperty("browserType").trim());
  }

  public static String getGridURL() {
    readAutomationProperty();
    return gridURL = prop.getProperty("gridURL").trim();
  }

  public static String getUserName() {
    readAutomationProperty();
    return userName = prop.getProperty("username").trim();
  }

  public static String getPassword() {
    readAutomationProperty();
    return passWord = prop.getProperty("password").trim();
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
  
  public static String isDebug() {
    readAutomationProperty();
    return debug = prop.getProperty("isDebug").trim();
  }
    
   public static String getRunCondition(String value) {
   readAutomationProperty(); return value = prop.getProperty("runCondition"); 
   }
}
