package com.automation.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.pageobject.HomePage;

public class TC_HomePageTest extends BaseTest {
	
@Test 
public void VerifySubscriptioninhomepage() {
		
	HomePage homepg = new HomePage(driver);
	String title = homepg.getPageTitle();
	if(title.equals("Automation Exercise"))
	{
		logger.info("Homepage is visible successfully.");
		AssertJUnit.assertTrue(true);
	}

	else
	{
		logger.info("Homepage is NOT visible.");
		//captureScreenShot(driver,"VerifyHomePageTitle");
		AssertJUnit.assertTrue(false);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	logger.info("Scroll home page bottom.");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	String subscriptiontext = homepg.getsubscriptiontext();
	
	AssertJUnit.assertEquals(subscriptiontext, "SUBSCRIPTION");
	logger.info("SUBSCRIPTION is visible on the home page.");
	
	homepg.entersubscriptionemail("johnsmith@gmail.com");
	logger.info("enter subscription email");
	
	homepg.clickOnSubscriptionButton();
	logger.info("Click on subscription button");
	
	String successmsgtext = homepg.getsuccessalert();
	AssertJUnit.assertEquals(successmsgtext, "You have been successfully subscribed!");
	logger.info("'You have been successfully subscribed!' is visible on the home page.");
	}
}
