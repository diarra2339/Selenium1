package com.fdmgroup.testScript;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.Login;
import com.fdmgroup.testData.DataFile;
import com.fdmgroup.util.DriverUtilities;

public class LoginTest {

	private DriverUtilities driverUtilities;
	private WebDriver driver;

	@Before
	public void init() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}

	@Test
	public void testLogin() {
		driver.get(DataFile.homeLink);
		driver.manage().window().maximize();
		Login.emailField(driver).sendKeys(DataFile.userEmail);
		Login.passwordField(driver).sendKeys(DataFile.userPassword);
		Login.passwordField(driver).sendKeys(Keys.ENTER);
	}



}
