package com.steeleye.iris.automation.tests;

import org.junit.Test;

import com.steeleye.iris.automation.components.CheckboxActions;
import com.steeleye.iris.automation.core.BaseIrisTestCase;
import com.steeleye.iris.automation.core.TestDescription;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.pages.market.MarketCounterpartyPage;
import com.steeleye.iris.automation.pages.market.MarketCounterpartyPage.Locators;

public class MarketsCounterpartiesFeatureTest extends BaseIrisTestCase {

	@Test
	@TestDescription("IRIS:0003/MarketCounterParties/ Verify if the Counterparties listed matches the count displayed in the top section")
	public void Iris_0003() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketCounterpartyPage.open(MarketCounterpartyPage.pageUrl);
		MarketCounterpartyPage.waitForDOMToLoad(5);
		
		TestLogger.assertTrue("Then the Count of counterparties should be displayed in the top section",
		    MarketCounterpartyPage.isElementDisplayed(MarketCounterpartyPage.Locators.countOfCounterParties));
		TestLogger.debug("count displayed:"
		    + MarketCounterpartyPage.countOfItems(MarketCounterpartyPage.Locators.countOfCounterParties));
		TestLogger.debug("List of items:" + MarketCounterpartyPage.getCountOfChildren(Locators.listOfCounterparties));
		TestLogger.info(MarketCounterpartyPage.doesPaginationExist());
		
		TestLogger.assertTrue("And the count displayed should match the list of counterparties",
		    MarketCounterpartyPage
		        .countOfItems(MarketCounterpartyPage.Locators.countOfCounterParties) == MarketCounterpartyPage
		            .getCountOfChildren(Locators.listOfCounterparties));
	}

	@Test
	@TestDescription("IRIS:0011/MarketCounterParties/ Verify if the counterparties selected by checkbox matches the count displayed in the top section")
	public void Iris_0011() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketCounterpartyPage.open(MarketCounterpartyPage.pageUrl);
		MarketCounterpartyPage.waitForDOMToLoad(5);
		
		TestLogger.info("When user randomly selects a few counterparties");
		CheckboxActions.checkItems(MarketCounterpartyPage.Locators.listOfCounterparties);
		TestLogger.info("count displayed:"
		    + MarketCounterpartyPage.countOfItems(MarketCounterpartyPage.Locators.countOfCounterParties));
		TestLogger
		    .info("List of items:" + CheckboxActions.getCountOfSelectedChildren(Locators.listOfCounterparties));
		
		TestLogger.assertTrue("Then the count displayed should match the list of selected counterparties",
		    MarketCounterpartyPage
		        .countOfItems(MarketCounterpartyPage.Locators.countOfCounterParties) == CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfCounterparties));
	}

	@Test
	@TestDescription("IRIS:0012/MarketCounterParties/ Verify if selecting the all checkbox selects all of the counterparties"
	    + " and count displayed in the top section equals the total counterparties")
	public void Iris_0012() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketCounterpartyPage.open(MarketCounterpartyPage.pageUrl);
		MarketCounterpartyPage.waitForDOMToLoad(5);
		
		TestLogger.info("When user selects all counterparties");
		CheckboxActions.checkAllItems(MarketCounterpartyPage.Locators.allCounterPartiesCheckbox);
		
		TestLogger.assertTrue("Then the count displayed should match the list of all counterparties",
		    MarketCounterpartyPage
		        .countOfItems(MarketCounterpartyPage.Locators.countOfCounterParties) == CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfCounterparties)
		        && CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfCounterparties) == MarketCounterpartyPage
		                .getCountOfChildrenDisplayedOnThisPage(Locators.listOfCounterparties));
	}

	@TestDescription("IRIS:0004 Verify if a counterparty could be added successfully - Ideal flow journey")
	public void Iris_0004() {

	}

	@TestDescription("IRIS:0005 Verify if a counterparty could be added successfully - Negative flow journey")
	public void Iris_0005() {

	}

	@TestDescription("IRIS:0006 Verify if a counterparty could be amended successfully")
	public void Iris_0006() {

	}

	@TestDescription("IRIS:0007 Verify if a counterparty could be deleted successfully")
	public void Iris_0007() {

	}

	@TestDescription("IRIS:0008 Verify if a counterparty could be searched with parameters successfully")
	public void Iris_0008() {

	}

	@TestDescription("IRIS:0009 Verify if the results are refined based on the criteria")
	public void Iris_0009() {

	}

	@TestDescription("IRIS:0010 Verify if a counterparty can be viewed")
	public void Iris_0010() {

	}
}
