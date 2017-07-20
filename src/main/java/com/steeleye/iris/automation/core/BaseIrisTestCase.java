package com.steeleye.iris.automation.core;

import org.junit.BeforeClass;
import org.junit.AfterClass;
public class BaseIrisTestCase extends BaseTestCase {
  
  @BeforeClass
  public static void classInit() { BaseTestCase.classInit(); }
  
  @AfterClass
  public static void classQuit() { BaseTestCase.classQuit(); }
  
}
