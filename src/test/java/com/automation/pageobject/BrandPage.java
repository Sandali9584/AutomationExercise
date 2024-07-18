package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandPage {

	//create object of webdriver
	WebDriver driver;
	
	public BrandPage(WebDriver rdriver) {
		driver= rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelements
	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement brandtitle;
	
	public String getBrandPageTitle() {
		return driver.getTitle();
	}
	
	public String getBrandpagetext() {
		return brandtitle.getText();
	}
}
