package com.fdmgroup.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyBooksPage {
	
	public static WebElement removeBookButton(WebDriver driver, String book) {
		WebElement section = bookSection(driver, book);
		return section.findElement(By.cssSelector(".actionLinkLite.smallText.deleteLink"));
		
	}
	
	public static WebElement bookSection(WebDriver driver, String book) {
		List<WebElement> list = driver.findElements(By.cssSelector(".bookalike.review"));
		WebElement titleField;
		for (WebElement section : list) {
			titleField = section.findElement(By.cssSelector(".field.title"));
			if(titleField.getText().contains(book)) {
				return section;
			}
		}
		return null;
	}
	

	public static boolean isInMyBooks(WebDriver driver, String book) {
		WebElement section = bookSection(driver, book);
		return section != null;
	}
	
	public static WebElement starsBook(WebDriver driver, String book) {
		return bookSection(driver, book).findElement(By.className("stars"));
	}
	
	public static int reviewStars(WebDriver driver, String book) {
		List<WebElement> stars = starsBook(driver, book).findElements(By.cssSelector(".star.on"));
		return stars.size();
	}
	

}
