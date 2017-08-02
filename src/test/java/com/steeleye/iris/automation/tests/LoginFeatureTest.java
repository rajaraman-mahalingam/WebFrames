package com.steeleye.iris.automation.tests;

import com.steeleye.iris.automation.core.*;
import com.steeleye.iris.automation.pages.*;

import org.junit.*;

public class LoginFeatureTest extends BaseIrisTestCase {

	@Test
	@RunConditions("SANITY")
	@Priorities("LOW")
	@TestDescription("IRIS:0001/Login Functionality/ Verify Login Functionality - Incorrect username and Password")

	public void Iris_0001() {
		TestLogger.info("Given a user attempts to access the IRIS Login Page");
		LoginPage.open();

		TestLogger.info("When i input an incorrect username and password");
		LoginPage.typeInInvalidCredentials();

		TestLogger.info("And press the submit button");
		LoginPage.pressSubmitButton();

		TestLogger.assertTrue("Error message should appear..",
		    LoginPage.isErrorMessageDisplayed());
		TestLogger.assertTrue("Error message displayed should match expected error text",
		    LoginPage.errorMessageMatchesExpectedText());
	}

	@Test
	@RunConditions("Regression")
	@Priorities("HIGH")
	@TestDescription("IRIS:0002/Login Functionality/ Verify Login Functionality - Correct username and Password")

	public void Iris_0002() {
		TestLogger.info("Given a user attempts to access the IRIS Login Page");
		LoginPage.open();

		TestLogger.info("When i input a valid username and password");
		LoginPage.typeInValidCredentials();

		TestLogger.info("And press the submit button");
		LoginPage.pressSubmitButton();
		
		TestLogger.assertFalse("Successfull Login - No Error message displayed",
		    LoginPage.isErrorMessageDisplayed());
	}
}
