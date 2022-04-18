package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//1. Private Locators

	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	
	//2. Constructor
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
	}
	
	//3. Public page actions (methods)
	
	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		
		return driver.getCurrentUrl();
	}
	
	public boolean isForgotPwdLinkExist() {
		
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void doLogin(String un, String pwd) {
		
		driver.findElement(username).sendKeys("stephenr816@gmail.com");
		driver.findElement(password).sendKeys("stephen@123");
		driver.findElement(loginButton).click();
	}
   
}
