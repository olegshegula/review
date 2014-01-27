package com.review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class AccountPage {
	@FindBy(id = "LoggedInUsername")
	private WebElement avatarName;
	private WebDriver driver;


	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isSigned() {
		return avatarName.isDisplayed();
	}	

	
}
