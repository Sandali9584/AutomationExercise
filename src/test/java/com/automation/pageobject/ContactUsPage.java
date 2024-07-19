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
		
		@FindBy(xpath = "//input[@name='upload_file']")
		WebElement fileupload;
		
		@FindBy(xpath = "//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[3]/form[1]/div[6]/input[1]")
		WebElement submitbutton;
		
		@FindBy(xpath = "//div[@class='status alert alert-success']")
		WebElement successMessage;
		
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
			submitbutton.click();
		}
		
		public void chooseFile() {
			fileupload.sendKeys("C:\\Users\\USER\\Downloads\\ManulTesting_Questions & Answers-150.pdf");;
		}
		
		public String getSuccessMessage() {
			return successMessage.getText(); 
		}
}
