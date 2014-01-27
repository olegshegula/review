package com.review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.review.data.RegistrationData;

public class RegistrationPage {
	@CacheLookup
	@FindBy(id = "registerLoginForm-submitbutton")
	private WebElement submit;

	@CacheLookup
	@FindBy(id = "registerLoginForm-loginName")
	private WebElement username;

	@CacheLookup
	@FindBy(id = "registerLoginForm-emailAddress")
	private WebElement email;

	@CacheLookup
	@FindBy(id = "registerLoginForm-password")
	private WebElement pass;

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;

	}

	public boolean isPageOpened() {
		return submit.isDisplayed();
	}

	public RegistrationPage enterUserName(String login) {
		username.sendKeys(login);
		return this;
	}

	public RegistrationPage enterEmail(String mail) {
		email.sendKeys(mail);
		return this;
	}

	public RegistrationPage enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}

	public RegisterSuccessfulPage clickLogin() {
		submit.click();
		return PageFactory.initElements(driver, RegisterSuccessfulPage.class);
	}

	public RegisterSuccessfulPage loginUser(RegistrationData registrationData) {
		return enterUserName(registrationData.getLogin())
				.enterEmail(registrationData.getEmail())
				.enterPassword(registrationData.getPassword()).clickLogin();

	}
}
