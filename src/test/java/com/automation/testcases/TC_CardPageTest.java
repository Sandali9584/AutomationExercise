package com.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.HomePage;
import com.automation.pageobject.ProductPage;

import junit.framework.Assert;

public class TC_CardPageTest extends BaseTest{

	@Test
	public void verifyaddproductincart() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnproducts();
		logger.info("Click on product button");
		
		ProductPage productpage = new ProductPage(driver);
		
		String productpagettitle = productpage.getProductPageTitle();
		if(productpagettitle.equals("Automation Exercise - All Products"))
		{
			logger.info("All Product Page is visible Successfully");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("All Product Page is NOT visible.");
			
			//captureScreenShot(driver,"VerifyHomePageTitle");
			Assert.assertTrue(false);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		productpage.mouseoverfirstproduct();
		Thread.sleep(2000);
		//productpage.clickOnAddtocart();
		
	}
	
	
}
