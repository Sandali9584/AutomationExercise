package com.automation.testcases;

import org.testng.annotations.Test;

import com.automation.pageobject.ContactUsPage;
import com.automation.pageobject.HomePage;

import freemarker.log.Logger;
import junit.framework.Assert;

public class TC_ContactUsPageTest extends BaseTest {

	@Test
	public void VerifyContactUsPage() {
		
		HomePage homepage = new HomePage(driver);
		
		homepage.clickOnContactUs();
		logger.info("Click on Contact Us Link");
		
		ContactUsPage contactuspg = new ContactUsPage(driver);
		
		String getintouchtext = contactuspg.getgetintouchlabeltext();
		
		Assert.assertEquals(getintouchtext, "GET IN TOUCH");
		logger.info("GET IN TOUCH' is visible on the account delete page.");
		
		contactuspg.entername("John");
		logger.info("Enter name");
		
		contactuspg.enteremail("johnsmith@gmail.com");
		logger.info("Enter email");
		
		contactuspg.entersubject("inquery");
		logger.info("Enter Subject");
		
		contactuspg.entermessage("Hello world");
		logger.info("Enter Message");
		
		contactuspg.clickOnSubmit();
		logger.info("Click on Submit");
	}
}
