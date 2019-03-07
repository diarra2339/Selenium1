package com.fdmgroup.testScript;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.BookPage;
import com.fdmgroup.pages.Homepage;
import com.fdmgroup.pages.MyBooksPage;
import com.fdmgroup.testData.DataFile;
import com.fdmgroup.util.DriverUtilities;

public class FindBooksWantToReadTest {

	private DriverUtilities driverUtilities;
	private WebDriver driver;

	@Before
	public void init() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}
	
	private void findBookWantToRead(String book) {
		//Search the book and click on it
		Homepage.searchField(driver).sendKeys(book);
		Homepage.searchField(driver).sendKeys(Keys.ENTER);
		driver.findElement(By.linkText(book)).click();
		
		//Set the book to "Want to read"
		BookPage.wantToReadButton(driver).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void testFindBooksWantToRead() {
		//Add the books 1, 2, 3 and 4
		findBookWantToRead(DataFile.book1);
		findBookWantToRead(DataFile.book2);
		findBookWantToRead(DataFile.book3);
		findBookWantToRead(DataFile.book4);
		
		
		//Go to my books
		BookPage.myBooksButton(driver).click();
		driver.navigate().refresh();

		//Verify the books are added to my list
		assertTrue(MyBooksPage.isInMyBooks(driver, DataFile.book1));
		assertTrue(MyBooksPage.isInMyBooks(driver, DataFile.book2));
		assertTrue(MyBooksPage.isInMyBooks(driver, DataFile.book3));
		assertTrue(MyBooksPage.isInMyBooks(driver, DataFile.book4));
	}
	
}
