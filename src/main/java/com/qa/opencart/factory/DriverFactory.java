package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Stephen Raj
 *
 */
public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionsManager op;
	
	/**
	 * 
	 * @param browserName
	 * @return This method returns the driver
	 */
	public WebDriver init_driver(Properties prop) {
		
		op = new OptionsManager(prop);
		
		String browserName = prop.getProperty("browser").trim();

		if (browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(op.getChromeOptions());
			
		} else if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(op.getFirefoxOptions());
			
		} else if (browserName.equals("safari")) {

			driver = new SafariDriver();
		} else {

			System.out.println("Please pass the correct browser Name");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());

		return driver;

	}
	
	public Properties init_properties() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}

}
