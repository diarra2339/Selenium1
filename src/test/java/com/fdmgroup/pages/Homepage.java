package com.fdmgroup.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	
	public static WebElement searchField(WebDriver driver) {
		return driver.findElement(By.name("q"));
	}
	
	public static WebElement myBooksButton(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.className("siteHeader__topLevelItem"));
		for (WebElement element : list) {
			if(element.getText().contains("My Books")) {
				return element;
			}
		}
		return null;
	}
	
	public static WebElement bookSectionCurrentlyReading(WebDriver driver, String book) {
		List<WebElement> list = driver.findElements(By.cssSelector(".gr-mediaBox.gr-book--medium.gr-book.u-marginBottomSmall"));
		for (WebElement element : list) {
			if(element.getText().contains(book)) {
				return element;
			}
		}
		return null;
	}
	
	public static WebElement updateProgressButton(WebDriver driver, String book) {
		WebElement section = bookSectionCurrentlyReading(driver, book);
		return section.findElement(By.tagName("button"));
	}
	
	public static WebElement pagesReadField(WebDriver driver) {
		return driver.findElement(By.className("longTextPopupForm")).findElement(By.tagName("input"));
	}
	
	public static WebElement finishedButton(WebDriver driver) {
		return driver.findElement(By.className("updateReadingProgress__finishedReading")).findElement(By.tagName("button"));
	}
}
