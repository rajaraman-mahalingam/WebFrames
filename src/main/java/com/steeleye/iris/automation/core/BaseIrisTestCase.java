package com.steeleye.iris.automation.core;

import org.junit.BeforeClass;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.AfterClass;

public class BaseIrisTestCase extends BaseTestCase {

	@BeforeClass
	public static void classInit() throws ConfigurationException {
		BaseTestCase.classInit();
	}

	@AfterClass
	public static void classQuit() {
		BaseTestCase.classQuit();
	}
}
