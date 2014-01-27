package com.review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterSuccessfulPage {
	@FindBy(xpath = "//p[text()='You have been sent a confirmation email, please follow the link to activate your Review Centre Account.']")
	private WebElement message;

	private WebDriver driver;

	public RegisterSuccessfulPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isSuccessfullRegistered() {
		return message.isDisplayed();
	}
}
