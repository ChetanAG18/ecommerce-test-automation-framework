package com.ui.listener;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	
	Logger logger = LoggerUtility.getLogger(TestListener.class);

	public void onTestStart(ITestResult result) {
		logger.info("Test Started: {}", result.getName());
		logger.info("Test Class: {}", result.getMethod().getTestClass());
		logger.info("Test Description: {}", result.getMethod().getDescription());
		logger.info("Test Groups: {}", Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("{} Test Passed", result.getName());
		ExtentReporterUtility.getExtentTest().log(Status.PASS, result.getName() +" "+ "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error("{} Test Failed", result.getName());
		logger.error("Error Message: {}", result.getThrowable().getMessage());
		logger.error(result.getThrowable());
		ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getName() +" "+ "FAILED");
		ExtentReporterUtility.getExtentTest().log(Status.FAIL, "Error Message: "+ result.getThrowable().getMessage());
		
		Object testClass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase)testClass).getInstance();
		
		logger.info("Capturing the Screenshot for the failed tests");
		String screenshotPath = browserUtility.takeScreenshot(result.getName());
		
		logger.info("Attaching the screenshot to the HTML File");
		ExtentReporterUtility.getExtentTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn("{} Test Skipped", result.getName());
		logger.warn("Error Message: {}", result.getThrowable().getMessage());
		ExtentReporterUtility.getExtentTest().log(Status.SKIP, result.getName() +" "+ "SKIPPED");
		ExtentReporterUtility.getExtentTest().log(Status.SKIP, "Error Message: "+ result.getThrowable().getMessage());
	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkReporter("reports.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReporterUtility.flushReport();
	}

}
