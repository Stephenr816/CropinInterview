package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//Constructor
	
		public ProductInfoPage(WebDriver driver) {
			
			elementUtil = new ElementUtil(driver);
			this.driver = driver;
		}
		

}
