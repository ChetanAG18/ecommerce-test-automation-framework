package com.ui.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	int currentAttempt = 1;
	//private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.getProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (currentAttempt < MAX_NUMBER_OF_ATTEMPTS) {
				currentAttempt++;
				return true;
			}
		}

		return false;
	}

}
