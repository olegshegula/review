package com.review.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.review.data.LoginData;
import com.review.data.RegistrationData;
import com.review.pages.AccountPage;
import com.review.pages.LoginPage;
import com.review.pages.MainPage;
import com.review.pages.RegisterSuccessfulPage;
import com.review.pages.RegistrationPage;
import com.review.util.Base;

public class ReviewTest extends Base {

	// *Data driven testing using logdata.csv file (Login)

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

	// *Data driven testing using regdata.csv file (Registration)

	@Test(dataProvider = "registrationCSVData", dataProviderClass = RegistrationData.class)
	public void testRegistration(RegistrationData registrationData) {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		Assert.assertTrue(mainPage.isLoginButtonExits());
		mainPage.loginSite();
		RegistrationPage registr = PageFactory.initElements(driver,
				RegistrationPage.class);
		Assert.assertTrue(registr.isPageOpened());
		registr.setIagree();
		registr.registerUser(registrationData);
		RegisterSuccessfulPage successfullPage = PageFactory.initElements(
				driver, RegisterSuccessfulPage.class);
		Assert.assertTrue(successfullPage.isSuccessfullRegistered());
		
		successfullPage.clickSuccessfulMessageButtonClose();
	}
}
