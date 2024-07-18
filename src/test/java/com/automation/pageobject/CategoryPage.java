package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

			//create object of webdriver
			WebDriver driver;
			
			public CategoryPage(WebDriver rdriver) {
				driver= rdriver;
				
				PageFactory.initElements(rdriver, this);
			}
			
			//identify webelements
			@FindBy(xpath = "//h2[@class='title text-center']")
			WebElement categorytitle;
			
			public String getCategoryPageTitle() {
				return driver.getTitle();
			}
			
			public String getCategorypagetext() {
				return categorytitle.getText();
			}
}
