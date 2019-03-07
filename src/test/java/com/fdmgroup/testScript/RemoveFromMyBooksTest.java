package com.fdmgroup.testScript;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import com.fdmgroup.pages.MyBooksPage;
import com.fdmgroup.testData.DataFile;
import com.fdmgroup.util.DriverUtilities;

public class RemoveFromMyBooksTest {
	
	private DriverUtilities driverUtilities;
	private WebDriver driver;

	@Before
	public void init() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}
	
	private void removeFromBooks(String book) {
		if(!MyBooksPage.isInMyBooks(driver, book)) {
			return;
		}
		MyBooksPage.removeBookButton(driver, book).click();
		MyBooksPage.removeBookButton(driver, book).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Remove book1, book2, book3 and book4 from the Want to Read list; check that they are gone
	 * @throws InterruptedException
	 */
	@Test
	public void RemoveFromBooksTest() throws InterruptedException {
		//Go to MyBooks page and remove books 1, 2, 3 and 4
		driver.get(DataFile.myBooksLink);
		String books[] = {DataFile.book1, DataFile.book2, DataFile.book3, DataFile.book4};
		for (String book : books) {
			try {
				removeFromBooks(book);
			}
			catch(UnhandledAlertException e) {
				Alert alert = driver.switchTo().alert();
				//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				Thread.sleep(2000);
				alert.accept();
			}
		}
		
		//check that books 1, 2, 3 and 4 are gone
		driver.navigate().refresh();
		assertFalse(MyBooksPage.isInMyBooks(driver, DataFile.book1));
		assertFalse(MyBooksPage.isInMyBooks(driver, DataFile.book2));
		assertFalse(MyBooksPage.isInMyBooks(driver, DataFile.book3));		
		assertFalse(MyBooksPage.isInMyBooks(driver, DataFile.book4));		
	}
	


}
