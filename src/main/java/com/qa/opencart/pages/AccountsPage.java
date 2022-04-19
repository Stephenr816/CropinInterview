package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Private By Locators

	private By accSections = By.xpath("//div[@id='content']//h2");
	private By accPageHeader = By.xpath("//a[text()='Your Store']");
	private By logoutLink = By.xpath("//div[@class='list-group']//a[text()='Logout']");
	
	
	//Constructor
	
	public AccountsPage(WebDriver driver) {
		
		elementUtil = new ElementUtil(driver);
	}
	
	//Public page Actions
	
	public String getAccPageTitle() {
		
		return elementUtil.doGetTitle();
	}
	
	public String getAccountPageUrl() {
		
		return elementUtil.getPageUrl();
	}
	
	public String getAccountPageHeader() {
		
		return elementUtil.doGetText(accPageHeader);
	}
	
	public List<String> getAccountPageSectionList() {
		
		List<String> accSecValList = new ArrayList<String>();
		
		List<WebElement> accSecList = elementUtil.getElements(accSections);
		
		for (WebElement e : accSecList) {
			
			accSecValList.add(e.getText());
			
		}
		
		return accSecValList;
	}
	
	public boolean isLogoutExist() {
		
		return elementUtil.doIsDisplayed(logoutLink);
	}
}
