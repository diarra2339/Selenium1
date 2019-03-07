package com.fdmgroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public static WebElement emailField(WebDriver driver) {
		return driver.findElement(By.id("userSignInFormEmail"));
	}
	
	public static WebElement passwordField(WebDriver driver) {
		return driver.findElement(By.id("user_password"));
	}
	
	public static WebElement signInButton(WebDriver driver) {
		return driver.findElement(By.id("//*[@id='sign_in']/div[3]/input[1]"));
	}
	
	

}
