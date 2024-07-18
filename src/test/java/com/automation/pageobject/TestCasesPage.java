package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

	//create object of webdriver
		WebDriver driver;
		
		public TestCasesPage(WebDriver rdriver) {
			driver= rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		public String getpagetitle() {
			return driver.getTitle();
		}
}
