package com.steeleye.iris.automation.tests;

import org.junit.Test;
import com.steeleye.iris.automation.components.CheckboxActions;
import com.steeleye.iris.automation.core.BaseIrisTestCase;
import com.steeleye.iris.automation.core.TestDescription;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.pages.market.MarketsPeoplePage;
import com.steeleye.iris.automation.pages.market.MarketsPeoplePage.Locators;

public class MarketsPeopleFeatureTest extends BaseIrisTestCase {

	@Test
	@TestDescription("IRIS:0013/MarketPeople/ Verify if the Contacts listed matches the count displayed in the top section")
	public void Iris_0013() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketsPeoplePage.open(MarketsPeoplePage.pageUrl);
		MarketsPeoplePage.waitForDOMToLoad(5);
		
		TestLogger.assertTrue("Then the Count of counterparties should be displayed in the top section",
		    MarketsPeoplePage.isElementDisplayed(MarketsPeoplePage.Locators.countOfPeople));
		TestLogger.debug("count displayed:"
		    + MarketsPeoplePage.countOfItems(MarketsPeoplePage.Locators.countOfPeople));
		TestLogger.debug("List of items:" + MarketsPeoplePage.getChildren(Locators.listOfPeople).size());
				
		TestLogger.assertTrue("And the count displayed should match the list of contacts",
		    MarketsPeoplePage
		        .countOfItems(MarketsPeoplePage.Locators.countOfPeople) == MarketsPeoplePage
		            .getCountOfChildren(Locators.listOfPeople));
	}

	@Test
	@TestDescription("IRIS:0014/MarketPeople/ Verify if the counterparties selected by checkbox matches the count displayed in the top section")
	public void Iris_0014() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketsPeoplePage.open(MarketsPeoplePage.pageUrl);
		MarketsPeoplePage.waitForDOMToLoad(5);
		
		TestLogger.info("When user randomly selects a few counterparties");
		CheckboxActions.checkItems(MarketsPeoplePage.Locators.listOfPeople);
		TestLogger.debug("count displayed:"
		    + MarketsPeoplePage.countOfItems(MarketsPeoplePage.Locators.countOfPeople));
		TestLogger
		    .debug("List of items:" + CheckboxActions.getCheckboxOfChild(Locators.listOfPeople).size());
		
		TestLogger.assertTrue("Then the count displayed should match the list of selected contacts",
		    MarketsPeoplePage
		        .countOfItems(MarketsPeoplePage.Locators.countOfPeople) == CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfPeople));
	}

	@Test
	@TestDescription("IRIS:0015/MarketCounterParties/ Verify if selecting the all checkbox selects all of the counterparties"
	    + " and count displayed in the top section equals the total counterparties")
	public void Iris_0015() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketsPeoplePage.open(MarketsPeoplePage.pageUrl);
		MarketsPeoplePage.waitForDOMToLoad(5);
		
		TestLogger.info("When user selects all counterparties");
		CheckboxActions.checkAllItems(MarketsPeoplePage.Locators.allPeopleCheckbox);
		
		TestLogger.assertTrue("Then the count displayed should match the list of all contacts selected in that page",
		    MarketsPeoplePage
		        .countOfItems(MarketsPeoplePage.Locators.countOfPeople) == CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfPeople)
		        && CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfPeople) == MarketsPeoplePage
		                .getCountOfChildrenDisplayedOnThisPage(Locators.listOfPeople));
	}

	@TestDescription("IRIS:0016 Verify if a counterparty could be added successfully - Ideal flow journey")
	public void Iris_0016() {

	}

	@TestDescription("IRIS:0017 Verify if a counterparty could be added successfully - Negative flow journey")
	public void Iris_0017() {

	}

	@TestDescription("IRIS:0018 Verify if a counterparty could be amended successfully")
	public void Iris_0018() {

	}

	@TestDescription("IRIS:0019 Verify if a counterparty could be deleted successfully")
	public void Iris_0019() {

	}

	@TestDescription("IRIS:0020 Verify if a counterparty could be searched with parameters successfully")
	public void Iris_0020() {

	}

	@TestDescription("IRIS:0021 Verify if the results are refined based on the criteria")
	public void Iris_0021() {

	}

	@TestDescription("IRIS:0022 Verify if a counterparty can be viewed")
	public void Iris_0022() {

	}

}
