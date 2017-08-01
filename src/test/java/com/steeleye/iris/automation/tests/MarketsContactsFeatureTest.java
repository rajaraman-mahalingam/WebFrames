package com.steeleye.iris.automation.tests;

import org.junit.Test;

import com.steeleye.iris.automation.components.CheckboxActions;
import com.steeleye.iris.automation.core.BaseIrisTestCase;
import com.steeleye.iris.automation.core.TestDescription;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.pages.market.MarketsContactsPage;
import com.steeleye.iris.automation.pages.market.MarketsContactsPage.Locators;

public class MarketsContactsFeatureTest extends BaseIrisTestCase {
	@Test
	@TestDescription("IRIS:0013/MarketContacts/ Verify if the Contacts listed matches the count displayed in the top section")
	public void Iris_0013() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketsContactsPage.open(MarketsContactsPage.pageUrl);
		MarketsContactsPage.waitForDOMToLoad(5);
		
		TestLogger.assertTrue("Then the Count of counterparties should be displayed in the top section",
		    MarketsContactsPage.isElementDisplayed(MarketsContactsPage.Locators.countOfContacts));
		TestLogger.debug("count displayed:"
		    + MarketsContactsPage.countOfItems(MarketsContactsPage.Locators.countOfContacts));
		TestLogger.debug("List of items:" + MarketsContactsPage.getChildren(Locators.listOfContacts).size());
				
		TestLogger.assertTrue("And the count displayed should match the list of contacts",
		    MarketsContactsPage
		        .countOfItems(MarketsContactsPage.Locators.countOfContacts) == MarketsContactsPage
		            .getCountOfChildren(Locators.listOfContacts));
	}

	@Test
	@TestDescription("IRIS:0014/MarketContacts/ Verify if the counterparties selected by checkbox matches the count displayed in the top section")
	public void Iris_0014() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketsContactsPage.open(MarketsContactsPage.pageUrl);
		MarketsContactsPage.waitForDOMToLoad(5);
		
		TestLogger.info("When user randomly selects a few counterparties");
		CheckboxActions.checkItems(MarketsContactsPage.Locators.listOfContacts);
		TestLogger.debug("count displayed:"
		    + MarketsContactsPage.countOfItems(MarketsContactsPage.Locators.countOfContacts));
		TestLogger
		    .debug("List of items:" + CheckboxActions.getCheckboxOfChild(Locators.listOfContacts).size());
		
		TestLogger.assertTrue("Then the count displayed should match the list of selected contacts",
		    MarketsContactsPage
		        .countOfItems(MarketsContactsPage.Locators.countOfContacts) == CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfContacts));
	}

	@Test
	@TestDescription("IRIS:0015/MarketCounterParties/ Verify if selecting the all checkbox selects all of the counterparties"
	    + " and count displayed in the top section equals the total counterparties")
	public void Iris_0015() {
		TestLogger.info("Given the user is in the Markets Counterparties Page");
		MarketsContactsPage.open(MarketsContactsPage.pageUrl);
		MarketsContactsPage.waitForDOMToLoad(5);
		
		TestLogger.info("When user selects all counterparties");
		CheckboxActions.checkAllItems(MarketsContactsPage.Locators.allContactsCheckbox);
		
		TestLogger.assertTrue("Then the count displayed should match the list of all contacts selected in that page",
		    MarketsContactsPage
		        .countOfItems(MarketsContactsPage.Locators.countOfContacts) == CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfContacts)
		        && CheckboxActions
		            .getCountOfSelectedChildren(Locators.listOfContacts) == MarketsContactsPage
		                .getCountOfChildrenDisplayedOnThisPage(Locators.listOfContacts));
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
