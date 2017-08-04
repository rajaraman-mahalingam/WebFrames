package com.steeleye.iris.automation.tests;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;
import com.steeleye.iris.automation.core.BaseIrisTestCase;
import com.steeleye.iris.automation.core.Priorities;
import com.steeleye.iris.automation.core.RunConditions;
import com.steeleye.iris.automation.core.TestDescription;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.pages.market.MarketsPeoplePage;

public class MarketsPeopleFeatureTest extends BaseIrisTestCase {

	@Test
	@RunConditions("All") @Priorities("low")
	@TestDescription("IRIS:0013/MarketPeople/ Verify if the People listed matches the count displayed in the top section")
	public void Iris_0013() throws ConfigurationException {
		TestLogger.info("Given the user is in the Markets People Page");
		MarketsPeoplePage.open();
				
		TestLogger.assertTrue("Then the Count of people should be displayed in the top section",
		    MarketsPeoplePage.isCountOfPeopleDisplayed());
					
		TestLogger.assertTrue("And the count displayed should match the list of people",
				MarketsPeoplePage.countDisplayedEqualsListedPeople());
	}

	@Test
	@RunConditions("All") @Priorities("low")
	@TestDescription("IRIS:0014/MarketPeople/ Verify if the People selected by checkbox matches the count displayed in the top section")
	public void Iris_0014() throws ConfigurationException {
		TestLogger.info("Given the user is in the Markets People Page");
		MarketsPeoplePage.open();
		
		TestLogger.info("When user randomly selects a few people");
		MarketsPeoplePage.selectPeople();
		
		TestLogger.assertTrue("Then the count displayed should match the list of selected people",
				MarketsPeoplePage.countDisplayedEqualsSelectedPeople());
	}

	@Test
	@RunConditions("All") @Priorities("low")
	@TestDescription("IRIS:0015/MarketPeople/ Verify if selecting the all checkbox selects all of the People in that page"
	    + " and count displayed in the top section equals the total people displayed in that page")
	public void Iris_0015() throws ConfigurationException {
		TestLogger.info("Given the user is in the Markets People Page");
		MarketsPeoplePage.open();
				
		TestLogger.info("When user selects all people");
		MarketsPeoplePage.selectAllPeople();
		
		TestLogger.assertTrue("Then the count displayed should match the list of all People selected in that page",
				 MarketsPeoplePage.countDisplayedEqualsSelectedPeople()
	        && MarketsPeoplePage.countDisplayedEqualsPeopleListedInThisPage());
	}

	@TestDescription("IRIS:0016 Verify if a person could be added successfully - Ideal flow journey")
	public void Iris_0016() {

	}

	@TestDescription("IRIS:0017 Verify if a person could be added successfully - Negative flow journey")
	public void Iris_0017() {

	}

	@TestDescription("IRIS:0018 Verify if a person could be amended successfully")
	public void Iris_0018() {

	}

	@TestDescription("IRIS:0019 Verify if a person could be deleted successfully")
	public void Iris_0019() {

	}

	@TestDescription("IRIS:0020 Verify if a person could be searched with parameters successfully")
	public void Iris_0020() {

	}

	@TestDescription("IRIS:0021 Verify if the results are refined based on the criteria")
	public void Iris_0021() {

	}

	@TestDescription("IRIS:0022 Verify if a person can be viewed")
	public void Iris_0022() {

	}

}
