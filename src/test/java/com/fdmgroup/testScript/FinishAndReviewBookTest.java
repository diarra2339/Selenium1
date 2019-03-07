package com.fdmgroup.testScript;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.Homepage;
import com.fdmgroup.pages.MyBooksPage;
import com.fdmgroup.pages.ReviewPage;
import com.fdmgroup.testData.DataFile;
import com.fdmgroup.util.DriverUtilities;

public class FinishAndReviewBookTest {
	
	private DriverUtilities driverUtilities;
	private WebDriver driver;

	@Before
	public void init() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}
	
	private void finishBook(String book) {
		Homepage.updateProgressButton(driver, book).click();
		Homepage.finishedButton(driver).click();
	}
	
	private void reviewBook(String book, int numOfStars) {
		if(numOfStars == 1) {
			ReviewPage.starOne(driver).click();
		}
		else if(numOfStars == 2) {
			ReviewPage.starTwo(driver).click();
		}
		else if(numOfStars == 3) {
			ReviewPage.starThree(driver).click();
		}
		else if(numOfStars == 4) {
			ReviewPage.starFour(driver).click();
		}
		else if(numOfStars == 5) {
			ReviewPage.starFive(driver).click();
		}
	}
	
	@Test
	public void FinishAndRateBook() {
		//1. finish the book
		finishBook(DataFile.book4);
		
		//2. Rate the book
		reviewBook(DataFile.book4, DataFile.goodBookRating);
		ReviewPage.saveButton(driver).click();
		
		//3. Check that the rating is saved and the book is marked as read
		driver.get(DataFile.myBooksLink);
		driver.navigate().refresh();
		assertEquals(DataFile.goodBookRating, MyBooksPage.reviewStars(driver, DataFile.book4));
	}

}
