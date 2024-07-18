package com.automation.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.automation.pageobject.AccountCreated;
import com.automation.pageobject.DeleteAccountPage;
import com.automation.pageobject.HomePage;
import com.automation.pageobject.LoginPage;
import com.automation.pageobject.SignUpPage;

import freemarker.log.Logger;
import junit.framework.Assert;

public class TC_LoginPageTest extends BaseTest{

	@Test(priority = 1)
	public void verifyRegistration() throws InterruptedException {
		
		HomePage homepg = new HomePage(driver);
		String title = homepg.getPageTitle();
		if(title.equals("Automation Exercise"))
		{
			logger.info("Homepage is visible successfully.");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Homepage is NOT visible.");
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
	
		homepg.clickOnSignup();
		logger.info(" Click on 'Signup / Login' button");
		
		LoginPage loginpg = new LoginPage(driver) ;
		String logintitle = loginpg.getLoginPageTitle();
		if(logintitle.equals("Automation Exercise - Signup / Login"))
		{
			logger.info("Login Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Login Page is NOT visible.");
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
		String signuptext = loginpg.getlabeltext();
		Assert.assertEquals(signuptext, "New User Signup!");
		logger.info("New User Signup!' is visible on the login page.");
		
		loginpg.entersignupName("John");
		logger.info("Enter name");
		loginpg.entersignupEmail("smithJohn123@gmail.com");
		logger.info("Enter email address");
		loginpg.clickOnSignUp();
		logger.info("Cick Sign up Button");
		
		SignUpPage signuppage = new SignUpPage(driver);
		String signuptitle = signuppage.getSignUpPageTitle();
		if(signuptitle.equals("Automation Exercise - Signup"))
		{
			logger.info("Signup Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Signup Page is NOT visible.");
			
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
		String information = signuppage.getinformationlabeltext();
		Assert.assertEquals(information, "ENTER ACCOUNT INFORMATION");
		logger.info("ENTER ACCOUNT INFORMATION!' is visible on the signup page.");
		
		signuppage.enterPassword("John123");
		logger.info("Enter password");
		
		signuppage.selectnewsletter();
		logger.info("Select checkbox 'Sign up for our newsletter!'");
		
		signuppage.selectoption();
		logger.info("Select checkbox 'Receive special offers from our partners!'");
		
		signuppage.enterFirstname("John");
		logger.info("Enter First Name");
		
		signuppage.enterLastname("Smith");
		logger.info("Enter Last name");
		
		signuppage.enterCompany("ABC");
		logger.info("Enter Company");
		
		signuppage.enterAddress1("Malabe");
		logger.info("Enter Address");
		
		signuppage.enterAddress2("Colombo");
		logger.info("Enter Address2");
		
		signuppage.selectCountry("Australia");
		logger.info("Select Country");
		
		signuppage.enterState("Sydney");
		logger.info("Enter State");
		
		signuppage.enterCity("Melbourne");
		logger.info("Enter City");
		
		signuppage.enterZipcode("80240");
		logger.info("Enter ZipCode");
		
		signuppage.enterMobileNum("5679554321");
		logger.info("Enter Mobile Number");
		
		signuppage.clickCreateAccount();
		logger.info("Click on Create Account Button");
		
		AccountCreated acccreatepg = new AccountCreated(driver);
		
		String createaccounttitle = acccreatepg.getAccountCreatedPageTitle();
		if(createaccounttitle.equals("Automation Exercise - Account Created"))
		{
			logger.info("Account_created Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Account_created Page is NOT visible.");
			
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
		String createtext = acccreatepg.getaccountcreatedlabeltext();
		Assert.assertEquals(createtext, "ACCOUNT CREATED!");
		logger.info("ACCOUNT CREATED!' is visible on the account create page.");
		
		acccreatepg.clickOnContinue();
		logger.info("Click 'Continue' button");
		
		/*
		 * String username = homepg.getUserName();
		 * if(username.equals("Logged in as john")) {
		 * logger.info("Verify Login - Passed"); Assert.assertTrue(true); }else {
		 * logger.info("Verify Login - Failed");
		 * //captureScreenShot(driver,"VerifyLogin"); Assert.assertTrue(false); }
		 */
		
		homepg.clickOnDeleteAccount();
		logger.info("Click ' Delete Account' button");
		
		DeleteAccountPage deleteaccpg = new DeleteAccountPage(driver);
		
		String deletetext = deleteaccpg.getaccountdeletedlabeltext();
		
		Assert.assertEquals(deletetext, "ACCOUNT DELETED!");
		logger.info("ACCOUNT DELETED!' is visible on the account delete page.");
		
		deleteaccpg.clickOnContinue();
		logger.info("Click 'Continue' button");
	}
	
	@Test(priority = 2)
	public void VerifyValidlogin() {
		HomePage homepg = new HomePage(driver);
		
		homepg.clickOnSignup();
		logger.info(" Click on 'Signup / Login' button");
		
		LoginPage loginpg = new LoginPage(driver) ;
		String logintitle = loginpg.getLoginPageTitle();
		if(logintitle.equals("Automation Exercise - Signup / Login"))
		{
			logger.info("Login Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Login Page is NOT visible.");
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
		String signuptext = loginpg.getlabeltext();
		Assert.assertEquals(signuptext, "New User Signup!");
		logger.info("New User Signup!' is visible on the login page.");
		
		loginpg.enterLoginEmail("johnsmith123@gmail.com");
		logger.info("Enter email");
		loginpg.enterLoginPassword("12345");
		logger.info("Enter password");
		loginpg.clickOnLogin();
		logger.info("Click ' Login' button");
		
		homepg.clickOnDeleteAccount();
		logger.info("Click ' Delete Account' button");
		
		DeleteAccountPage deleteaccpg = new DeleteAccountPage(driver);
		
		String deletetext = deleteaccpg.getaccountdeletedlabeltext();
		
		Assert.assertEquals(deletetext, "ACCOUNT DELETED!");
		logger.info("ACCOUNT DELETED!' is visible on the account delete page.");
		
		deleteaccpg.clickOnContinue();
		
	}
	
	@Test(priority = 3)
	public void VerifyInValidlogin() {
		HomePage homepg = new HomePage(driver);
	
		homepg.clickOnSignup();
		logger.info(" Click on 'Signup / Login' button");
		
		LoginPage loginpg = new LoginPage(driver) ;
		String logintitle = loginpg.getLoginPageTitle();
		if(logintitle.equals("Automation Exercise - Signup / Login"))
		{
			logger.info("Login Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Login Page is NOT visible.");
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
		String signuptext = loginpg.getlabeltext();
		Assert.assertEquals(signuptext, "New User Signup!");
		logger.info("New User Signup!' is visible on the login page.");
		
		loginpg.enterLoginEmail("johnsmith123@gmail.com");
		logger.info("Enter email");
		loginpg.enterLoginPassword("1234");
		logger.info("Enter password");
		loginpg.clickOnLogin();
		logger.info("Cick Login Button");
		
		String loginerr = loginpg.alertloginMsg();
		Assert.assertEquals(loginerr, "Your email or password is incorrect!");
		logger.info("Verify error 'Your email or password is incorrect!' is visible");
		
	}
	
	@Test(priority =  4)
	public void VerifyLogout() {
		HomePage homepg = new HomePage(driver);
		homepg.clickOnSignup();
		logger.info(" Click on 'Signup / Login' button");
		
		LoginPage loginpg = new LoginPage(driver) ;
		String logintitle = loginpg.getLoginPageTitle();
		if(logintitle.equals("Automation Exercise - Signup / Login"))
		{
			logger.info("Login Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Login Page is NOT visible.");
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
		String signuptext = loginpg.getlabeltext();
		Assert.assertEquals(signuptext, "New User Signup!");
		logger.info("New User Signup!' is visible on the login page.");
		
		loginpg.enterLoginEmail("johnsmith12@gmail.com");
		logger.info("Enter email");
		loginpg.enterLoginPassword("12345");
		logger.info("Enter password");
		loginpg.clickOnLogin();
		logger.info("Cick Login Button");
		
		homepg.clickOnLogout();
		logger.info("Cick Logout Button");
		
		if(logintitle.equals("Automation Exercise - Signup / Login"))
		{
			logger.info("Login Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Login Page is NOT visible.");
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
	}
	
	@Test( priority = 5)
	public void VerifyRegisterUserwithExistingEmail() {
		
		HomePage homepg = new HomePage(driver);
		homepg.clickOnSignup();
		logger.info(" Click on 'Signup / Login' button");
		
		LoginPage loginpg = new LoginPage(driver) ;
		String logintitle = loginpg.getLoginPageTitle();
		if(logintitle.equals("Automation Exercise - Signup / Login"))
		{
			logger.info("Login Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Login Page is NOT visible.");
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		
		String signuptext = loginpg.getlabeltext();
		Assert.assertEquals(signuptext, "New User Signup!");
		logger.info("New User Signup!' is visible on the login page.");
		
		loginpg.entersignupName("John");
		logger.info("Enter name");
		loginpg.entersignupEmail("johnsmith@gmail.com");
		logger.info("Enter email address");
		loginpg.clickOnSignUp();
		logger.info("Cick Sign up Button");
		
		String signuperr = loginpg.alertsignupMsg();
		Assert.assertEquals(signuperr, "Email Address already exist!");
		logger.info("Verify error 'Email Address already exist!' is visible");
	}
	
}
