package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreated {

	//create object of webdriver
	WebDriver driver;
	
	public AccountCreated(WebDriver rdriver) {
		driver= rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelements
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	WebElement accountcreatedtitle;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continuebtn;

	public String getAccountCreatedPageTitle() {
		return driver.getTitle();
	}
	
	public String getaccountcreatedlabeltext() {
		return accountcreatedtitle.getText();	
	}
	
	public void clickOnContinue() {
		continuebtn.click();
	}
}
