package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;

public class LoginTest {

	public static void main(String[] args) {

		HomePage homePage = new HomePage(Browser.CHROME);
		String username = homePage.goToLoginPage().doLoginWith("kawohip932@gzeos.com", "Pwd@123").getUserName();
		System.out.println(username);
	}

}
