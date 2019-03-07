package com.fdmgroup.testScript;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.fdmgroup.pages.BookPage;
import com.fdmgroup.pages.Homepage;
import com.fdmgroup.testData.DataFile;
import com.fdmgroup.util.DriverUtilities;

public class ReadingBookTest {
	
	private DriverUtilities driverUtilities;
	private WebDriver driver;

	@Before
	public void init() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}
	
	private void updateProgress(String book, String pagesRead) {
		Homepage.updateProgressButton(driver, book).click();
		WebElement pagesReadInput = Homepage.pagesReadField(driver);
		pagesReadInput.clear();
		pagesReadInput.sendKeys(pagesRead);
		pagesReadInput.sendKeys(Keys.ENTER);
	}
	
	/**
	 * 1. Pick a book from my list
	 * 2. Set it to currently reading
	 * 3. Go to homepage and update the number of pages I've read
	 * 4. Check if the correct number of pages is displayed
	 * @throws InterruptedException 
	 */
	@Test
	public void ReadAndProgressBookTest() {
		//driver.get(DataFile.myBooksLink);
		
		//Select the book and set it to "currently reading"
		driver.findElement(By.linkText(DataFile.book4)).click();
		BookPage.downArrowButton(driver).click();
		BookPage.downArrowButton(driver).click();
		driver.findElement(By.xpath("//*[contains(@id,'1_book_')]/div[2]/div/div[1]/ul[1]/li[2]/button")).click();
		
		//Go to homepage and update the number of pages read
		driver.get(DataFile.homeLink);
		driver.navigate().refresh(); //make sure the book is added to the homepage
		updateProgress(DataFile.book4, DataFile.numPagesRead);
		driver.navigate().refresh();
		
		//Check that the update has been made
		String currentlyReadingText = driver.findElement(By.className("currentlyReadingShelf")).getText();
		assertTrue(currentlyReadingText.contains(DataFile.numPagesRead + "/" + DataFile.numPagesBook4));
	}
	

}
