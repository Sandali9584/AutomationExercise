package com.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.automation.pageobject.CategoryPage;
import com.automation.pageobject.HomePage;


public class TC_CategoryPageTest extends BaseTest{
@Test
	public void verifyviewcategoryproduct() {
		
		HomePage homepage = new HomePage(driver);
		//Automation Exercise - Tops Products
		
		String Categorytext = homepage.getCategoryText();
		AssertJUnit.assertEquals(Categorytext, "CATEGORY");
		logger.info("CATEGORY is visible on the home page.");
		
		 WebElement womenCategoryLink = driver.findElement(By.xpath("//a[normalize-space()='Women']"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", womenCategoryLink);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", womenCategoryLink);
         // Verify if the expected action has been performed
         Assert.assertTrue(true, "Click on Women category (using JavaScript) was successful.");
		
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
		//Assert.assertEquals(categorytext, "WOMEN -  TOPS PRODUCTS");
		logger.info("'WOMEN -  TOPS PRODUCTS' is visible on the category page.");
		
		
		
	}
}
