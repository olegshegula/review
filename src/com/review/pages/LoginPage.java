package com.review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.review.data.LoginData;

public class LoginPage {
	@CacheLookup
	@FindBy(id = "frmLogin-submitbutton")
	private WebElement submit;
	@CacheLookup
	@FindBy(id = "frmLogin-loginName")
	private WebElement username;
	@CacheLookup
	@FindBy(id = "frmLogin-password")
	private WebElement pass;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public boolean isPageOpened() {
		return submit.isDisplayed();
	}

	public LoginPage enterLogin(String login) {
		username.sendKeys(login);
		return this;
	}

	public LoginPage enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}

	public AccountPage clickLogin() {
		submit.click();
		return PageFactory.initElements(driver, AccountPage.class);
	}

	public AccountPage loginUser(LoginData loginData) {
		return enterLogin(loginData.getLogin()).enterPassword(
				loginData.getPassword()).clickLogin();

	}

}
