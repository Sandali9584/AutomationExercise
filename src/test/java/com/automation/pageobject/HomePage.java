package com.automation.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		//create object of webdriver
		WebDriver driver;
		
		public HomePage(WebDriver rdriver) {
			driver= rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelements
		@FindBy(xpath = " //img[@alt='Website for automation practice']")
		WebElement logo;
		
		@FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
		WebElement signup;
		
		@FindBy(xpath = "//li[10]//a[1]")
		WebElement userName;
		
		@FindBy(xpath = "//a[normalize-space()='Delete Account']")
		WebElement deleteaccount;
		
		@FindBy(xpath = "//a[normalize-space()='Logout']")
		WebElement logout;
		
		@FindBy(xpath = "//a[normalize-space()='Contact us']")
		WebElement contactus;
		
		@FindBy(xpath = "//a[normalize-space()='Test Cases']")
		WebElement testcase;
		
		@FindBy(xpath = "//a[text()=' Products']")
		WebElement products;
		
		@FindBy(xpath = "//h2[contains(text(),'Subscription')]")
		WebElement Subscriptiontext;
		
		@FindBy(xpath = "//input[@id='susbscribe_email']")
		WebElement susbscribeemail;
		
		@FindBy(xpath = "//button[@id='subscribe']")
		WebElement subscribebtn;
		
		@FindBy(xpath = "//footer[@id='footer']")
		WebElement footer;
		
		@FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
		WebElement successalert;
		
		@FindBy(xpath = "//h2[contains(text(),'Category')]")
		WebElement categorytext;
		
		@FindBy(xpath = "//a[normalize-space()='Women']")
		WebElement womenlink;
		
		@FindBy(xpath = "//a[normalize-space()='Tops']")
		WebElement toplink;
		
		@FindBy(xpath = "//h2[contains(text(),'Brands')]")
		WebElement brandtext;
		
		@FindBy(xpath = "//div[@class='brands-name']//a[@href='/brand_products/Polo']")
		WebElement pololink;
		
		public boolean logoDisplay() {
			return logo.isDisplayed();
		}
		
		public String getPageTitle()
		{
			return(driver.getTitle());
		}
		
		public void clickOnSignup() {
			signup.click();
		}
		
		public String getUserName() {
			String uname = userName.getText();
			return uname;
		}
		
		public void clickOnDeleteAccount() {
			deleteaccount.click();
		}
		
		public void clickOnLogout() {
			logout.click();
		}
		
		public void clickOnContactUs() {
			contactus.click();
		}
		
		public void clickOnTestCase() {
			testcase.click();
		}
		
		public void clickOnproducts() {
			products.click();
		}
		
		public String getsubscriptiontext() {
			return Subscriptiontext.getText();
		}
		
		public void entersubscriptionemail(String email) {
			susbscribeemail.sendKeys(email);
		}
		
		public void clickOnSubscriptionButton() {
			subscribebtn.click();
		}
		
		public String getsuccessalert() {
			return successalert.getText();
		}
		
		public String getCategoryText() {
			return categorytext.getText();
		}
		
		public void clickOnWomenCategory() {
			womenlink.click();
		}
		public void clickOnCategory() {
			toplink.click();
}
		public String getBrandText() {
			return brandtext.getText();
		}
		
		public void clickOnPoloBrand() {
			pololink.click();
		}
}
