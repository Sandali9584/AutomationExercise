package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

			//create object of webdriver
			WebDriver driver;
			
			public LoginPage(WebDriver rdriver) {
				driver= rdriver;
				
				PageFactory.initElements(rdriver, this);
			}
			
			//identify webelements
			
			@FindBy(xpath = "//input[@name='name' and @data-qa='signup-name']")
			WebElement signupname;
			
			@FindBy(xpath = "//input[@name='email' and @data-qa='signup-email']")
			WebElement signupemail;
			
			@FindBy(xpath = "//button[@type='submit' and @data-qa='signup-button']")
			WebElement signupbutton;
			
			@FindBy(xpath =  "//input[@name='email' and @data-qa='login-email']")
			WebElement loginemail;
			
			@FindBy(xpath = "//input[@name='password' and @data-qa='login-password']")
			WebElement loginpassword;
			
			@FindBy(xpath = "//button[@type='submit' and @data-qa='login-button']")
			WebElement loginbutton;
			
			@FindBy(xpath = "//h2[text()='New User Signup!']")
			WebElement signuplabel;
			
			@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
			WebElement loginAlert;
			
			@FindBy(xpath = "//p[text()='Email Address already exist!']")
			WebElement signupAlert;
			
			public String getLoginPageTitle()
			{
				return(driver.getTitle());
			}
			
			public String getlabeltext() {
				return signuplabel.getText();
				
			}
			
			public void entersignupEmail(String email) {
				signupemail.sendKeys(email);
			}
			
			public void entersignupName(String name) {
				signupname.sendKeys(name);
			}
			
			public void enterLoginEmail(String email) {
				loginemail.sendKeys(email);
			}
			
			public void enterLoginPassword(String password) {
				loginpassword.sendKeys(password);
			}
			
			public void clickOnSignUp() {
				signupbutton.click();
			}
			
			public void clickOnLogin() {
				loginbutton.click();
			}
			
			public String alertloginMsg() {
				return loginAlert.getText();
			}
			
			public String alertsignupMsg() {
				return signupAlert.getText();
			}
}
			
