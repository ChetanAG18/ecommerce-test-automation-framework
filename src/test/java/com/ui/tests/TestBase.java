package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(LoginTest.class);

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		logger.info("Loading the home page of the website");
		homePage = new HomePage(Browser.CHROME);
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

}
