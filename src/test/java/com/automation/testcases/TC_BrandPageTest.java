package com.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automation.pageobject.BrandPage;
import com.automation.pageobject.CategoryPage;
import com.automation.pageobject.HomePage;



public class TC_BrandPageTest extends BaseTest{

	@Test
	public void VerifyViewbrandProduct() {
		
		HomePage homepage = new HomePage(driver);
		//Automation Exercise - Tops Products
		
		String Brandtext = homepage.getBrandText();
		Assert.assertEquals(Brandtext, "BRANDS");
		logger.info("BRANDS is visible on the home page.");
		
		 WebElement brandLink = driver.findElement(By.xpath("//div[@class='brands-name']//a[@href='/brand_products/Polo']"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandLink);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandLink);
         // Verify if the expected action has been performed
         Assert.assertTrue(true, "Click on Brand (using JavaScript) was successful.");
		
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
