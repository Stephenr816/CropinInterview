package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//1. Private Locators

	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	
	//2. Constructor
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3. Public page actions (methods)
	
	public String getLoginPageTitle() {
		
		return elementUtil.doGetTitle();
	}
	
	public String getLoginPageUrl() {
		
		return elementUtil.getPageUrl();
	}
	
	public boolean isForgotPwdLinkExist() {
		
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public void doLogin(String un, String pwd) {
		
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
	}
   
}
