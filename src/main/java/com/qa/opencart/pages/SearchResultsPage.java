package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//Private By Locators
	
	private By searchResultItems = By.xpath("//div[@class='product-thumb']");
	private By resultItem = By.xpath("//div[@class='product-thumb']//h4/a");
	
	public SearchResultsPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
		
   public int getProductResultsCount() {
	   
	   return elementUtil.getElements(searchResultItems).size();
   }
   
   public ProductInfoPage selectProductFromResults(String productName) {
	   
	   List<WebElement> resultItemsList = elementUtil.getElements(resultItem);
	   
	   for (WebElement e : resultItemsList) {
		   
		   if (e.getText().equals(productName)) {
			   
			   e.click();
			   break;
			
		}
		
	}
	   
	   return new ProductInfoPage(driver);
	   
   }
   
}
   
		
	
	
	


