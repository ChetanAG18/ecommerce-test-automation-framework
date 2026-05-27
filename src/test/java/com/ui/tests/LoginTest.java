package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;

public class LoginTest {
	private HomePage homePage;
	
	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		homePage = new HomePage(Browser.CHROME);
	}

	@Test(description = "Verifies if the valid user is able to login into the application", groups = { "sanity",
			"smoke", "regression" })
	public void loginTest() {
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith("kawohip932@gzeos.com", "Pwd@123").getUserName(),
				"Chetan AG");
	}

}
