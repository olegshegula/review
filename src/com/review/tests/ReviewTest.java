package com.review.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.review.data.LoginData;
import com.review.pages.AccountPage;
import com.review.pages.LoginPage;
import com.review.pages.MainPage;
import com.review.util.Base;

public class ReviewTest extends Base {

	//*Data driven testing using csv file
	
	@Test(dataProvider = "loginCSVData", dataProviderClass = LoginData.class)
	public void signInTestPositive(LoginData loginData) {

		
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		Assert.assertTrue(mainPage.isLoginButtonExits());
		mainPage.loginSite();
        
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(login.isPageOpened());
		login.loginUser(loginData);	
		
		AccountPage accountPage = PageFactory.initElements(driver,
				AccountPage.class);
		Assert.assertTrue(accountPage.isSigned());

	}
	
}
