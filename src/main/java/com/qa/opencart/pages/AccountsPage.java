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
	private By accPageHeader = By.xpath("//a//img[@title='Antropy Demo Store']");
	private By logoutLink = By.xpath("//div[@class='list-group']//a[text()='Logout']");
	private By searchBar = By.xpath("//div[@id='search']/input");
	private By searchButton = By.xpath("//div[@id='search']//button");
	
	//Constructor
	
	public AccountsPage(WebDriver driver) {
		
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	//Public page Actions
	
	public String getAccPageTitle() {
		
		return elementUtil.doGetTitle();
	}
	
	public String getAccountPageUrl() {
		
		return elementUtil.getPageUrl();
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
	
	public SearchResultsPage searchProduct(String productName) {
		
		elementUtil.doSendKeys(searchBar, productName);
		elementUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}
}
