package com.automation.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.pageobject.HomePage;
import com.automation.pageobject.ProductDetailPage;
import com.automation.pageobject.ProductPage;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseTest {

	@Test
	public void verifyallproductsandproductdetails() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnproducts();
		logger.info("Click on product button");
		
		ProductPage productpage = new ProductPage(driver);
		
		String productpagettitle = productpage.getproductpagetitle();
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
		
		
		 List<WebElement> products = productpage.getProductList();

	        if (!products.isEmpty()) {
	            logger.info("Products list is visible.");
	           
	        } else {
	            logger.info("Products list is NOT visible.");
	        }
	        
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	        
	        productpage.clickOnViewproduct();
	        logger.info("Click on view product button");
	        
	        ProductDetailPage proddetailpg = new ProductDetailPage(driver);
	        
	        String pagetitle = proddetailpg.getProductDetailPageTitle();
	        if(pagetitle.equals("Automation Exercise - Product Details"))
			{
				logger.info("Product Details Page is visible Successfully");
				Assert.assertTrue(true);
			}

			else
			{
				logger.info("Product Details Page is NOT visible.");
				
				//captureScreenShot(driver,"VerifyHomePageTitle");
				Assert.assertTrue(false);
			}
	        
			String getproductname = proddetailpg.getProductname();
			
			Assert.assertEquals(getproductname, "Blue Top");
			logger.info("Product name is visible.");
			
			String getproductcategory = proddetailpg.getCategory();
			
			Assert.assertEquals(getproductcategory, "Category: Women > Tops");
			logger.info("Category is visible.");
			
			String getproductprice = proddetailpg.getPrice();
			
			Assert.assertEquals(getproductprice, "Rs. 500");
			logger.info("Price is visible.");
			
			String getavailability = proddetailpg.getAvailability();
			
			Assert.assertEquals(getavailability, "Availability: In Stock");
			logger.info("Availability is visible.");
			
			String getcondition = proddetailpg.getCondition();
			
			Assert.assertEquals(getcondition, "Condition: New");
			logger.info("Condition is visible.");
			
			String getbrand = proddetailpg.getBrand();
			
			Assert.assertEquals(getbrand, "Brand: Polo");
			logger.info("Brand is visible.");
		
	}
	@Test
	public void verifysearchproducts() throws IOException {
		
		String searchKey = "Dress";
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnproducts();
		logger.info("Click on product button");
		
		ProductPage productpage = new ProductPage(driver);
		
		String productpagettitle = productpage.getproductpagetitle();
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
		productpage.enterSearchKeyword(searchKey);
		logger.info("Enter search keyword");
		
		productpage.clickOnSearchBtn();
		logger.info("Click on Search button");
		
		String SearchResultProductname=productpage.getSearchResultProductName();


		//Verify that correct Product is displaying after search

		if(SearchResultProductname.contains(searchKey))
		{
			logger.info("Search Product testcase - Passed"); 
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Search Product testcase - Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);

		} 
		
	}
	
}
