package com.automation.testcases;

import org.testng.annotations.Test;

import com.automation.pageobject.HomePage;
import com.automation.pageobject.TestCasesPage;

import freemarker.log.Logger;
import junit.framework.Assert;

public class TC_TestCasePageTest extends BaseTest {
	
@Test
	public void verifytestcasepagenavigate() {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnTestCase();
		logger.info("Click on test cases button");
		
		TestCasesPage tcpage = new TestCasesPage(driver);
		
		String testcasepagettitle = tcpage.getpagetitle();
		if(testcasepagettitle.equals("Automation Practice Website for UI Testing - Test Cases"))
		{
			logger.info("Testcase Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Testcase Page is NOT visible.");
			
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
	}
}
