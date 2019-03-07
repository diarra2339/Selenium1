package com.fdmgroup.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {
	
	private static DriverUtilities driverUtilities;
	private WebDriver driver;

	private DriverUtilities() {
		super();
	}
	
	public static DriverUtilities getInstance() {
		if(driverUtilities == null) {
			driverUtilities = new DriverUtilities();
		}
		return driverUtilities;
	}
	
	public WebDriver getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
	}

	private void createDriver() {
		String driverName = getDriverName();
		
		if(driverName.equals("Google Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			this.driver = new ChromeDriver();
		}
		else if(driverName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			this.driver = new FirefoxDriver();
		}
		else {
			System.out.println("Not appropriate driver");
		}	
			
	}

	private String getDriverName() {
		Properties config = new Properties();
		String driverName = "";
		try {
			config.load(new FileInputStream("config.properties"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String key : config.stringPropertyNames()) {
			if(key.equals("browser")) {
				driverName = config.getProperty(key);
			}	
		}
		return driverName;
	
	}
	
	
	
	
	
	
}
