package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(LoginTest.class);
	boolean isLambdaTest = true;
	boolean isHeadless = true;

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp(ITestResult result) {
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			logger.info("Loading the home page of the website");
			homePage = new HomePage(Browser.CHROME, isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear Doen the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quiteSession();
		} else {
			homePage.quit();
		}
	}

}
