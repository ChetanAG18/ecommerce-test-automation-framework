package com.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;
import com.ui.tests.LoginTest;

public abstract class BrowserUtility {

	private WebDriver driver;
	Logger logger = LoggerUtility.getLogger(BrowserUtility.class);

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtility(String browserName) {
		logger.info("Launching the browser for", browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} 
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else {
			logger.error("{} is Invalid Browser Name.... Please Select chrome or edge or firefox", browserName);
		}
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching the browser for {}", browserName);
		if(browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		} 
		
		else if(browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		}
		
		else if(browserName == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
		
		else {
			logger.error("{} is Invalid Browser Name.... Please Select chrome or edge or firefox", browserName);
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the url: {}", url);
		driver.get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximize the window");
		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding the locator {}", locator);
		WebElement element = driver.findElement(locator);
		logger.info("Locator found now performing the click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding the locator {}", locator);
		WebElement element = driver.findElement(locator);
		logger.info("Locator found now enter the text {}", textToEnter);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding the locator {}", locator);
		WebElement element = driver.findElement(locator);
		logger.info("Locator found now get the visible text {}", element.getText());
		return element.getText();
	}

}
