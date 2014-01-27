package com.review.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	

	@FindBy(id = "headerRegisterLoginButton")
	private WebElement loginButton;
	

	public void loginSite() {
		loginButton.click();
	}

	public boolean isLoginButtonExits() {
		return loginButton.isDisplayed();
	}

	
}
