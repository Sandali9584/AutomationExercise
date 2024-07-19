package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

			//create object of webdriver
			WebDriver driver;
			
			public ProductDetailPage(WebDriver rdriver) {
				driver= rdriver;
				
				PageFactory.initElements(rdriver, this);
			}
			
			@FindBy(xpath = "//h2[contains(text(),'Blue Top')]")
			WebElement productname;
			
			@FindBy(xpath = "//p[contains(text(),'Category: Women > Tops')]")
			WebElement category;
			
			@FindBy(xpath = "//span[contains(text(),'Rs. 500')]")
			WebElement price;
			
			@FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[2]")
			WebElement availability;
			
			@FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[3]")
			WebElement condition;
			
			@FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[4]")
			WebElement brand;
			
			public String getProductDetailPageTitle() {
				return driver.getTitle();
			}
			
			public String getProductName() {
				return productname.getText();
				
			}
			public String getCategory() {
				return category.getText();
				
			}
			public String getPrice() {
				return price.getText();
				
			}
			public String getAvailability() {
				return availability.getText();
				
			}
			public String getCondition() {
				return condition.getText();
				
			}
			public String getBrand() {
				return brand.getText();
				
			}
}

