package com.steeleye.iris.automation.tests;

import com.steeleye.iris.automation.core.*;
import com.steeleye.iris.automation.pages.*;

import org.junit.*;

public class LoginFeatureTest extends BaseIrisTestCase {

  @Test
  @TestDescription("value = IRIS:0001 Verify Login Functionality - Incorrect username and Password")
  public void Iris_0001() {
    TestLogger.info("Given a user attempts to access the IRIS Login Page");
    LoginPage.open(LoginPage.pageUrl);

    TestLogger.info("When i input the username in the email field");
    Element.typeIn(LoginPage.Locators.emailField, "Hello");

    TestLogger.info("And i input the password in the password field");
    Element.typeIn(LoginPage.Locators.passWordField, "djdj");

    TestLogger.info("And press the submit button");
    Element.click(LoginPage.Locators.loginButton);

    LoginPage.waitForDOMToLoad(10);

    TestLogger.assertTrue("Error message should appear..", Element.isElementDisplayed(LoginPage.Locators.errorMessage));
    TestLogger.assertTrue("Error message should match as expected",
        Element.getText(LoginPage.Locators.errorMessage).equals(LoginPage.Expected.errorText));
  }

  @Test
  @TestDescription("value = IRIS:0002 Verify Login Fucntionality - Correct username and Password")
  public void Iris_0002() {
    TestLogger.info("Given a user attempts to access the IRIS Login Page");
    LoginPage.open(LoginPage.pageUrl);

    TestLogger.info("When i input the username in the email field");
    Element.typeIn(LoginPage.Locators.emailField, Config.getUserName());

    TestLogger.info("And i input the password in the password field");
    Element.typeIn(LoginPage.Locators.passWordField, Config.getPassword());

    TestLogger.info("And press the submit button");
    Element.click(LoginPage.Locators.loginButton);

    TestLogger.assertTrue("Successfull Login - No Error message displayed",
        !Element.isElementDisplayed(LoginPage.Locators.errorMessage));
  }
}
