package com.steeleye.iris.automation.tests;

import org.junit.Test;

import com.steeleye.iris.automation.core.BaseIrisTestCase;
import com.steeleye.iris.automation.core.Priorities;
import com.steeleye.iris.automation.core.RunConditions;
import com.steeleye.iris.automation.core.TestDescription;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.pages.market.MarketsContactsPage;

public class MarketsContactsFeatureTest extends BaseIrisTestCase {
	@Test
	@RunConditions("All") @Priorities("low")
	@TestDescription("IRIS:0013/MarketContacts/ Verify if the Contacts listed matches the count displayed in the top section")
	public void Iris_0013() {
		TestLogger.info("Given the user is in the Markets Contacts Page");
		MarketsContactsPage.open();
		
		TestLogger.assertTrue("Then the Count of contacts should be displayed in the top section",
				 MarketsContactsPage.isCountOfContactsDisplayed());
	
		TestLogger.assertTrue("And the count displayed should match the list of contacts",
				 MarketsContactsPage.countDisplayedEqualsListedContacts());
	}

	@Test
	@RunConditions("All") @Priorities("low")
	@TestDescription("IRIS:0014/MarketContacts/ Verify if the contacts selected by checkbox matches the count displayed in the top section")
	public void Iris_0014() {
		TestLogger.info("Given the user is in the Markets Contacts Page");
		MarketsContactsPage.open();
		
		TestLogger.info("When user randomly selects a few contacts");
		MarketsContactsPage.selectContacts();
				
		TestLogger.assertTrue("Then the count displayed should match the list of selected contacts",
		   MarketsContactsPage.countDisplayedEqualsSelectedContacts());
	}

	@Test
	@RunConditions("All") @Priorities("low")
	@TestDescription("IRIS:0015/MarketContacts/ Verify if selecting the all checkbox selects all of the contacts in that page"
	    + " and count displayed in the top section equals the total contacts displayed in that page")
	public void Iris_0015() {
		TestLogger.info("Given the user is in the Markets Contacts Page");
		MarketsContactsPage.open();
		
		TestLogger.info("When user selects all contacts");
		MarketsContactsPage.selectAllContacts();
		
		TestLogger.assertTrue("Then the count displayed should match the list of all contacts selected in that page",
				 MarketsContactsPage.countDisplayedEqualsSelectedContacts()
	        && MarketsContactsPage.countDisplayedEqualsContactsListedInThisPage());
	}

	@TestDescription("IRIS:0016 Verify if a contact could be added successfully - Ideal flow journey")
	public void Iris_0016() {

	}

	@TestDescription("IRIS:0017 Verify if a contact could be added successfully - Negative flow journey")
	public void Iris_0017() {

	}

	@TestDescription("IRIS:0018 Verify if a contact could be amended successfully")
	public void Iris_0018() {

	}

	@TestDescription("IRIS:0019 Verify if a contact could be deleted successfully")
	public void Iris_0019() {

	}

	@TestDescription("IRIS:0020 Verify if a contact could be searched with parameters successfully")
	public void Iris_0020() {

	}

	@TestDescription("IRIS:0021 Verify if the results are refined based on the criteria")
	public void Iris_0021() {

	}

	@TestDescription("IRIS:0022 Verify if a contact can be viewed")
	public void Iris_0022() {

	}

}
