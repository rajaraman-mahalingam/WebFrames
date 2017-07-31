package com.steeleye.iris.automation.tests;

import org.junit.Test;

import com.steeleye.iris.automation.core.BaseIrisTestCase;
import com.steeleye.iris.automation.core.TestDescription;
import com.steeleye.iris.automation.core.TestLogger;
import com.steeleye.iris.automation.pages.market.MarketCounterpartyPage;
import com.steeleye.iris.automation.pages.market.MarketCounterpartyPage.Locators;

public class MarketsCounterpartiesFeatureTest extends BaseIrisTestCase {

	@Test
	@TestDescription("IRIS:0003 Verify if the Counterparties listed matches the count displayed in the top section")
	public void Iris_0003() {
		MarketCounterpartyPage.open(MarketCounterpartyPage.pageUrl);
		MarketCounterpartyPage.waitForDOMToLoad(5);
		TestLogger.assertTrue("Count matches with the list:",
		    MarketCounterpartyPage.getNumberFromCounterPartiesString() == MarketCounterpartyPage
		        .getCountOfChildren(Locators.listOfCounterparties));
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

	@Test
	@TestDescription("IRIS:0011 Verify if the counterparties selected by checkbox matches the count displayed in the top section")
	public void Iris_0011() {
		MarketCounterpartyPage.open(MarketCounterpartyPage.pageUrl);
		MarketCounterpartyPage.waitForDOMToLoad(5);
		TestLogger.assertTrue("Selected counterparty matches count displayed",
		    MarketCounterpartyPage.selectCounterparties() == MarketCounterpartyPage.getNumberFromCounterPartiesString());
	}
}
