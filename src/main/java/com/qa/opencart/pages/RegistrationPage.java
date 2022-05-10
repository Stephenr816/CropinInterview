package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php?route=account/register");
		driver.manage().window().maximize();
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Stephen");
		
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Raj");
		
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("stephenr816@gmail.com");
		
		WebElement telephone = driver.findElement(By.id("input-telephone"));
		telephone.sendKeys("9500985631");
		
		WebElement address = driver.findElement(By.id("input-address-1"));
		address.sendKeys("4/370, Sakthi Nagar, 1st Street");
		
		WebElement city = driver.findElement(By.id("input-city"));
		city.sendKeys("Trichy");
		
		WebElement postCode = driver.findElement(By.id("input-postcode"));
		postCode.sendKeys("620019");
		
		WebElement country = driver.findElement(By.id("input-country"));
		Select selectCountry = new Select(country);
	    selectCountry.selectByVisibleText("India");
		
		Thread.sleep(5000);
		
		WebElement state = driver.findElement(By.xpath("//div[@class='col-sm-10']/select[@name='zone_id']"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Tamil Nadu");
		
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("stephen@123");
		
		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys("stephen@123");
		
		WebElement subscribe = driver.findElement(By.xpath("//label[@class='radio-inline'][1]/input"));
		subscribe.click();
		
		WebElement agreeCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		agreeCheckBox.click();
		
		WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']"));
		continueButton.click();
		
		Thread.sleep(5000);

		WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your Account Has Been Created!']"));
		String message = successMessage.getText();
		
		if (message.equals("Your Account Has Been Created!")) {
			
			WebElement logoutLink = driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Logout']"));
			
		}else {
			
			
		}
	}
	
	
}
