package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	//create object of webdriver
	WebDriver driver;
	
	public SignUpPage(WebDriver rdriver) {
		driver= rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelements
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement signuppagetitle;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement title;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//select[@id='days']")
	WebElement days;
	
	@FindBy(xpath = "//select[@id='months']")
	WebElement months;
	
	@FindBy(xpath = "//select[@id='years']")
	WebElement years;
	
	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement newsletter;
	
	@FindBy(xpath = "//input[@id='optin']")
	WebElement optin;
	
	@FindBy(xpath = "//b[text()='Address Information']")
	WebElement addresstitle;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='company']")
	WebElement company;
	
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2;
	
	@FindBy(xpath = "//select[@id='country']")
	WebElement country;
	
	@FindBy(xpath = "//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement mobilenum;
	
	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement createaccbtn;
	
	public void selectTitle() {
		title.click();
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void selectYear(String yearvalue) {
		Select yeardropdown = new Select(years);
		yeardropdown.selectByValue(yearvalue);
	}
	
	public void selectMonth(String monthvalue) {
		Select monthdropdown = new Select(months);
		monthdropdown.selectByValue(monthvalue);
	}
	
	public void selectDay(String dayvalue) {
		Select daydropdown = new Select(days);
		daydropdown.selectByValue(dayvalue);
	}
	
	public void selectnewsletter() {
		 if (!newsletter.isSelected()) {
	            // If not selected, click on it to select
			 newsletter.click();
	            System.out.println("Checkbox selected.");
	        } else {
	            System.out.println("Checkbox already selected.");
	        }
	}
	
	public void selectoption() {
		 if (!optin.isSelected()) {
	            // If not selected, click on it to select
			 optin.click();
	            System.out.println("Checkbox selected.");
	        } else {
	            System.out.println("Checkbox already selected.");
	        }
	}
	
	public void enterFirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void enterLastname(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void enterCompany(String cmpny) {
		company.sendKeys(cmpny);
	}
	
	public void enterAddress1(String addresstext) {
		address1.sendKeys(addresstext);
	}
	
	public void enterAddress2(String addresstext2) {
		address2.sendKeys(addresstext2);
	}
	
	public void selectCountry(String countryvalue) {
		Select countrydropdown = new Select(country);
		countrydropdown.selectByValue(countryvalue);
	}
	
	public void enterState(String State) {
		state.sendKeys(State);	
	}
	
	public void enterCity(String City) {
		city.sendKeys(City);
	}
	
	public void enterZipcode(String Zipcode) {
		zipcode.sendKeys(Zipcode);
	}
	
	public void enterMobileNum(String Mobile) {
		mobilenum.sendKeys(Mobile);
	}
	
	public void clickCreateAccount() {
		createaccbtn.click();
	}
	
	public String getSignUpPageTitle() {
		return driver.getTitle();
	}
	
	public String getinformationlabeltext() {
		return signuppagetitle.getText();
		
	}
	public String getaddresslabeltext() {
		return addresstitle.getText();
		
	}
}
