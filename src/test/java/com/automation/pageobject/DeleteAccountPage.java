package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {

			//create object of webdriver
			WebDriver driver;
			
			public DeleteAccountPage(WebDriver rdriver) {
				driver= rdriver;
				
				PageFactory.initElements(rdriver, this);
			}
			
			//identify webelements
			
			@FindBy(xpath = "//b[text()='Account Deleted!']")
			WebElement accountdeletedtitle;
			
			@FindBy(xpath = "//a[text()='Continue']")
			WebElement continuebtn;
			
			public String getaccountdeletedlabeltext() {
				return accountdeletedtitle.getText();	
			}
			
			public void clickOnContinue() {
				continuebtn.click();
			}
			
	
}
