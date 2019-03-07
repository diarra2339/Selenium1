package com.fdmgroup.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewPage {
	
	public static WebElement starSection(WebDriver driver) {
		return driver.findElement(By.className("stars"));
	}

	public static WebElement starOne(WebDriver driver) {
		List<WebElement> list = starSection(driver).findElements(By.tagName("a"));
		for (WebElement element : list) {
			if(element.getText().contains("1 of 5 stars")) {
				return element;
			}
		}
		return null;
	}
	
	public static WebElement starTwo(WebDriver driver) {
		List<WebElement> list = starSection(driver).findElements(By.tagName("a"));
		for (WebElement element : list) {
			if(element.getText().contains("2 of 5 stars")) {
				return element;
			}
		}
		return null;
	}
	
	public static WebElement starThree(WebDriver driver) {
		List<WebElement> list = starSection(driver).findElements(By.tagName("a"));
		for (WebElement element : list) {
			if(element.getText().contains("3 of 5 stars")) {
				return element;
			}
		}
		return null;
	}
	
	public static WebElement starFour(WebDriver driver) {
		List<WebElement> list = starSection(driver).findElements(By.tagName("a"));
		for (WebElement element : list) {
			if(element.getText().contains("4 of 5 stars")) {
				return element;
			}
		}
		return null;
	}
	
	public static WebElement starFive(WebDriver driver) {
		List<WebElement> list = starSection(driver).findElements(By.tagName("a"));
		for (WebElement element : list) {
			if(element.getText().contains("5 of 5 stars")) {
				return element;
			}
		}
		return null;
	}
	
	public static WebElement saveButton(WebDriver driver) {
		return driver.findElement(By.name("next"));
	}
	
	
}
