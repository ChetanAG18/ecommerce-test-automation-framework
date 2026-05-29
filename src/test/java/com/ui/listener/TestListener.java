package com.ui.listener;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	
	Logger logger = LoggerUtility.getLogger(TestListener.class);

	public void onTestStart(ITestResult result) {
		logger.info("Test Started: {}", result.getName());
		logger.info("Test Class: {}", result.getMethod().getTestClass());
		logger.info("Test Description: {}", result.getMethod().getDescription());
		logger.info("Test Groups: {}", Arrays.toString(result.getMethod().getGroups()));
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("{} Test Passed", result.getName());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("{} Test Failed", result.getName());
		logger.error("Error Message: {}", result.getThrowable().getMessage());
		logger.error(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn("{} Test Skipped", result.getName());
		logger.warn("Error Message: {}", result.getThrowable().getMessage());
	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
	}

}
