package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class LoginPageTest {
	
	WebDriver driver;
	LoginPage lp;

	@BeforeTest
	public void setUp() {
		
		DriverFactory df = new DriverFactory();
		driver = df.init_driver("chrome");
		lp=new LoginPage(driver);
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.getLoginPageTitle();
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String url = lp.getLoginPageUrl();
		Assert.assertTrue(url.contains("account/login"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	 
	
	public static void main(String[] args) {
		

	}

}
