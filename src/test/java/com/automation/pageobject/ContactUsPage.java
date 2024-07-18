package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	//create object of webdriver
		WebDriver driver;
		
		public ContactUsPage(WebDriver rdriver) {
			driver= rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelements
		@FindBy(xpath = "//h2[text()='Get In Touch']")
		WebElement getintouch;
		
		@FindBy(xpath = "//input[@name='name']")
		WebElement name;
		
		@FindBy(xpath = "//input[@name='email']")
		WebElement email;
		
		@FindBy(xpath = "//input[@name='subject']")
		WebElement subject;
		
		@FindBy(xpath = "//textarea[@id='message']")
		WebElement textarea;
		
		//input[@name='upload_file']
		@FindBy(xpath = "//input[@type='submit' and @name='submit']")
		WebElement submitbtn;
		
		public String getgetintouchlabeltext() {
			return getintouch.getText();	
		}
		
		public void entername(String Name) {
			 name.sendKeys(Name);
		}
		
		public void enteremail(String Email) {
			 email.sendKeys(Email);
		}
		
		public void entersubject(String Subject) {
			subject.sendKeys(Subject);
		}
		
		public void entermessage(String Msg) {
			textarea.sendKeys(Msg);
		}
		
		public void clickOnSubmit() {
			submitbtn.click();
		}
}
