package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(BrowserUtility.class);

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching the browser for", browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		}

		else {
			logger.error("{} is Invalid Browser Name.... Please Select chrome or edge or firefox", browserName);
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching the browser for {}", browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}

		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}

		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}

		else {
			logger.error("{} is Invalid Browser Name.... Please Select chrome or edge or firefox", browserName);
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching the browser for {}", browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}

		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		}

		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}
		}

		else {
			logger.error("{} is Invalid Browser Name.... Please Select chrome or edge or firefox", browserName);
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the url: {}", url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximize the window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding the locator {}", locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Locator found now performing the click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding the locator {}", locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Locator found now enter the text {}", textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding the locator {}", locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Locator found now get the visible text {}", element.getText());
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat dateFormater = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = dateFormater.format(date);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

	public void quit() {
		driver.get().quit();
	}

}
