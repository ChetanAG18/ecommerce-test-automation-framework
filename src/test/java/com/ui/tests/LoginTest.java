package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {
	private HomePage homePage;
	
	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
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
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Chetan AG");
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
