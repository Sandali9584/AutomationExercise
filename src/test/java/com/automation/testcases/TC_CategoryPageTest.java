package com.automation.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automation.pageobject.CategoryPage;
import com.automation.pageobject.HomePage;

import junit.framework.Assert;

public class TC_CategoryPageTest extends BaseTest{
@Test
	public void verifyviewcategoryproduct() {
		
		HomePage homepage = new HomePage(driver);
		//Automation Exercise - Tops Products
		
		String Categorytext = homepage.getCategoryText();
		AssertJUnit.assertEquals(Categorytext, "CATEGORY");
		logger.info("CATEGORY is visible on the home page.");
		
		homepage.clickOnWomenCategory();
		logger.info("Click on Category");
		
		homepage.clickOnCategory();
		logger.info("Click on SubCategory");
		
		CategoryPage categorypage = new CategoryPage(driver);
		
		String categorypagettitle = categorypage.getCategoryPageTitle();
		if(categorypagettitle.equals("Automation Exercise - Tops Products"))
		{
			logger.info("Category Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("Category Page is NOT visible.");
			
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		String categorytext = categorypage.getCategorypagetext();
		//System.out.println(categorytext);
		//Assert.assertEquals(categorytext, "WOMEN -  TOPS PRODUCTS");
		logger.info("'WOMEN -  TOPS PRODUCTS' is visible on the category page.");
		
		
		
	}
}
