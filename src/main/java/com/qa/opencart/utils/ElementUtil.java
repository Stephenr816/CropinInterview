package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtil {

private WebDriver driver;

public ElementUtil(WebDriver driver) {
	
	this.driver = driver;
}

public WebElement getElement(By locator) {
	
	return driver.findElement(locator);

}

public List<WebElement> getElements(By locator) {
	
	return driver.findElements(locator);

}

public void doSendKeys(By locator, String value) {
	
	WebElement element = getElement(locator);
	element.clear();
	element.sendKeys(value);

}

public String doGetText(By locator) {
	
	return getElement(locator).getText();
}

public String doGetTitle() {
	
	return driver.getTitle();
}

public String getPageUrl() {
	
	return driver.getCurrentUrl();
}

public boolean doIsDisplayed(By locator) {
	
	return getElement(locator).isDisplayed();
}

public void doClick(By locator) {
	
	getElement(locator).click();
}

}
