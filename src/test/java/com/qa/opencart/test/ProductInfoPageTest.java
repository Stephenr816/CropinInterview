package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void productInfoSetup() {
		
		accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void productCountTest() {
		
		searchResPage = accPage.searchProduct("Macbook");
		Assert.assertTrue(searchResPage.getProductResultsCount() == 3);
	}
	
	@Test
	public void productHeaderTest() {
		
		searchResPage = accPage.searchProduct("iMac");
		productInfoPage = searchResPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductHeaderText(), "iMac");
	}
	
	@Test
	public void productImagesTest() {
		
		searchResPage = accPage.searchProduct("Macbook");
		productInfoPage = searchResPage.selectProductFromResults("MacBook Pro");
		Assert.assertTrue(productInfoPage.getProductImagesCount() == 4);
	}
	
	@Test
	public void getProductInfoTest() throws InterruptedException {
		Thread.sleep(5000);
		searchResPage = accPage.searchProduct("Macbook");
		Thread.sleep(5000);
		productInfoPage = searchResPage.selectProductFromResults("MacBook Pro");
		Thread.sleep(5000);
		Map<String, String> actProductMetaData = productInfoPage.getProductInformations();
		
		actProductMetaData.forEach((k,v) -> System.out.println(k + " " + v));
		
		softAssert.assertEquals(actProductMetaData.get("name"), "MacBook Pro");
		softAssert.assertEquals(actProductMetaData.get("Brand"), "Apple");
		softAssert.assertEquals(actProductMetaData.get("Availability"), "In Stock");
		softAssert.assertEquals(actProductMetaData.get("price"), "$2000");	
		
		softAssert.assertAll();
	}

}
