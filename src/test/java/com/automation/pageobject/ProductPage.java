package com.automation.pageobject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//create object of webdriver
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ProductPage(WebDriver rdriver) {
		driver= rdriver;
		
		PageFactory.initElements(rdriver, this);
		this.actions = new Actions(driver);
		
	}
	
	//identify webelements
	
	@FindBy(xpath = "//div[@class='features_items']")
	public List<WebElement> productList;
	
	@FindBy(xpath = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement viewproduct;
	
	@FindBy(xpath = "//input[@id='search_product']")
	WebElement searchproduct;
	
	@FindBy(xpath = "//button[@id='submit_search']")
	WebElement submitsearch;
	
	@FindBy(xpath="//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/p[1]")
	WebElement searchResultProduct ;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	WebElement addtocart;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]")
	WebElement first;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")
	WebElement firstproduct;
	
	public String getProductPageTitle() {
		return driver.getTitle();
	}
	
	public List<WebElement> getProductList() {
        return productList;
    }
	
	public void clickOnViewproduct() {
		viewproduct.click();
	}
	
	public void enterSearchKeyword(String searchkeyword) {
		searchproduct.sendKeys(searchkeyword);
	}
	
	public void clickOnSearchBtn() {
		submitsearch.click();
	}
	
	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
	}
	
	public void clickOnAddtocart() {
		addtocart.click();
		
	}
	public void mouseoverfirstproduct() {
		 actions.moveToElement(first).build().perform();
	        
	}
	
	public WebElement getViewProductButton() {
        return viewproduct;
    }
	
	public WebElement getSearchResult() {
        return searchResultProduct;
    }
}
