package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//Private By Locators
	
	private By productHeader = By.xpath("//div[@id='content']//h1");
	private By productImages = By.xpath("//ul[@class='thumbnails']//li");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]//li");
	private By productPricing = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]//li");
	private By productQty = By.id("input-quantity");
	private By cartBtn = By.id("button-cart");
	private By addToCartSuccessMessage = By.xpath("//div[@class='alert alert-success']");
	
	//Constructor
	
		public ProductInfoPage(WebDriver driver) {
			
			elementUtil = new ElementUtil(driver);
			this.driver = driver;
		}
		
	//public actions
		
	public String getProductHeaderText() {
		
		return elementUtil.doGetText(productHeader);
	}
	
	public int getProductImagesCount() {
		
		return elementUtil.getElements(productImages).size();
	}
	
	/**
	 * This method will collect the product meta data and pricing data information in the form
	 * of HashMap.
	 * @return This method will return productInfoMap.
	 */
	public Map<String, String> getProductInformations() {
		
		Map<String, String> productInfoMap = new HashMap<String, String>();
		
		productInfoMap.put("name", getProductHeaderText());
		
		//metadata:
		List<WebElement> metaData = elementUtil.getElements(productMetaData);
		for (WebElement e : metaData) {
			
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
		
		//price:
		
		List<WebElement> priceList = elementUtil.getElements(productPricing);
		String price = priceList.get(0).getText().trim();
		String exTaxPrice = priceList.get(1).getText().trim();
		productInfoMap.put("price", price);
		productInfoMap.put("exTaxPrice", exTaxPrice);
		
		return productInfoMap;
	}
	
	public void selectQty(String qty) {
		
		elementUtil.doSendKeys(productQty, qty);
	}
	
	public void addToCart() {
		
		elementUtil.doClick(cartBtn);
	}
	
	public void getSuccessMessage() {
		
		elementUtil.doGetText(addToCartSuccessMessage);
		
	}
		

}
