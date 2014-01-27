package com.review.util;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	protected FirefoxDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.reviewcentre.com/");
	}

	@AfterMethod
	public void tearDown() {	
		
		driver.close();
		driver.quit();
		
	}

}
