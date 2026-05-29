package com.ui.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listener.TestListener.class)
public class LoginTest {
	private HomePage homePage;
	//private static final Logger LOGGER = LogManager.getLogger(LoginTest.class);
	Logger logger = LoggerUtility.getLogger(LoginTest.class);
	
	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		logger.info("Loading the home page of the website");
		homePage = new HomePage(Browser.CHROME);
	}

	@Test(description = "Verifies if the valid user is able to login into the application", groups = { "sanity",
			"smoke", "regression" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
			dataProvider = "LoginDataProvider")
	public void loginTest(User user) {
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Chetan AG");
	}
	
	@Test(description = "Verifies if the valid user is able to login into the application", groups = { "sanity",
			"smoke", "regression" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
			dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {
		logger.info("Starting Login Csv Data Driven Test");
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Chetan AG");
		logger.info("Login Csv Data Driven Test is Finished");
	}
	
	@Test(description = "Verifies if the valid user is able to login into the application", groups = { "sanity",
			"smoke", "regression" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
			dataProvider = "LoginTestEXCELDataProvider",
			retryAnalyzer = com.ui.listener.MyRetryAnalyzer.class)
	public void loginEXCELTest(User user) {
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Chetan AG");
	}

}
