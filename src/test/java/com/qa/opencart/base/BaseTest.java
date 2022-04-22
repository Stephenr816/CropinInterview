package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {

	WebDriver driver;
	public LoginPage lp;
	public AccountsPage accPage;
	public SearchResultsPage searchResPage;
	public ProductInfoPage productInfoPage;
	public Properties prop;

	@BeforeTest
	public void setUp() {
		
		DriverFactory df = new DriverFactory();
		prop = df.init_properties();
		driver = df.init_driver(prop);
		lp=new LoginPage(driver);

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	 
	

}
