package com.steeleye.iris.automation.core;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;

/**
 * Created by rajaramanmahalingam on 14/07/2017.
 */
public abstract class BaseTestCase {
  
  public static boolean testStarted, testEnded;

  @Rule
  public TestName testName = new TestName();
  
  @Rule
  public TestWatcher watchman = new TestWatcher() {
    
    @Override
    public void failed(Throwable e, Description description) { TestLogger.setResult(ExecutionStatus.FAILED, e);}
   
    @Override
    public void succeeded(Description description) {TestLogger.setResult(ExecutionStatus.PASSED);}
  };

  @BeforeClass
  public static void classInit() {
    TestLogger.init();
    try {
      Browser.openBrowser();
    } catch (Exception e) {
      TestLogger.info("=>Setup Error!", e);
      TestLogger.quit();
    }
    /**
     * Check if the site is up and Running using http methods and if its a 200
     * proceed. If not, catch the error, write to Log, fail the test and quit!
     */
  }

  @AfterClass
  public static void classQuit() {
    try {
      Browser.closeBrowser();
    }catch (Exception e) {
      TestLogger.fatal("=>Unable to close instance...");
    }
    TestLogger.quit();
   }

  @Before
  public void testSetup() {
    /**
     * Set the testName and then open the browser. If browser open failed, catch
     * the exception, write to Log, fail the test and quit!
     */
    if(Browser.driverOpened) {
    Config.setTestName(testName.getMethodName());
    Config.setTestClass(this.getClass().getName());
    try {
      TestRunManager.getTestDescription();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    TestLogger.doTestStart();
    testStarted = true;
    }   
  }
  

  @After
  public void testTearDown() {
    /**
     * Do not close the browser instance, clear browser session for this test.
     * And continue test!
     */
    if(testStarted) {
    TestLogger.doTestEnd();
    testEnded = true;
    Config.setTestName(testName.getMethodName());
    Config.setTestClass(this.getClass().getName());
    try {
      TestRunManager.getTestDescription();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  }
  }
