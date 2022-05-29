package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String url = lp.getLoginPageUrl();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}
	
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		
		Assert.assertTrue(lp.isForgotPwdLinkExist());
	}
	
	@Test(priority = 4)
	public void doLoginTest() {
		
		try {
			lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
