package com.automation.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automation.pageobject.BrandPage;
import com.automation.pageobject.CategoryPage;
import com.automation.pageobject.HomePage;

import junit.framework.Assert;

public class TC_BrandPageTest extends BaseTest{

	@Test
	public void VerifyViewbrandProduct() {
		
		HomePage homepage = new HomePage(driver);
		//Automation Exercise - Tops Products
		
		String Brandtext = homepage.getBrandText();
		Assert.assertEquals(Brandtext, "BRANDS");
		logger.info("BRANDS is visible on the home page.");
		
		homepage.clickOnPoloBrand();
		logger.info("Click on Brand");
		
		BrandPage brandpage = new BrandPage(driver);
		
		String brandpagettitle = brandpage.getBrandPageTitle();
		if(brandpagettitle.equals("Automation Exercise - Polo Products"))
		{
			logger.info("Brand Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Brand Page is NOT visible.");
			
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
	}
}
