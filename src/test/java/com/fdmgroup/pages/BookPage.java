package com.fdmgroup.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPage {
	
	public static WebElement myBooksButton(WebDriver driver) {
		return Homepage.myBooksButton(driver);
	}
	
	public static WebElement wantToReadButton(WebDriver driver) {
		return driver.findElement(By.className("progressTrigger"));
	}
	
	public static WebElement downArrowButton(WebDriver driver) {
		return driver.findElement(By.className("wtrShelfButton"));
	}

	public static WebElement shelfMenu(WebDriver driver) {
		return driver.findElement(By.className("wtrShelfMenu"));
	}
	
	public static WebElement currentlyReading(WebDriver driver) {
		return driver.findElement(By.name("currently-reading"));
	}
	
	public static boolean isRead(WebDriver driver) {
		WebElement bookColumn = driver.findElement(By.id("imagecol"));
		List<WebElement> list = bookColumn.findElements(By.cssSelector(".wtrDown.wtrLeft.wtrStatusRead"));
		return !list.isEmpty();
	}
	
	public static boolean isCurrentlyReading(WebDriver driver) {
		WebElement bookColumn = driver.findElement(By.id("imagecol"));
		List<WebElement> list = bookColumn.findElements(By.cssSelector(".wtrDown.wtrLeft.wtrStatusReadingNow"));
		return !list.isEmpty();
	}
	
	public static boolean isWantToRead(WebDriver driver) {
		WebElement bookColumn = driver.findElement(By.id("imagecol"));
		List<WebElement> list = bookColumn.findElements(By.cssSelector(".wtrDown.wtrLeft.wtrShelfSortable.wtrStatusToRead"));
		return !list.isEmpty();
	}
}
