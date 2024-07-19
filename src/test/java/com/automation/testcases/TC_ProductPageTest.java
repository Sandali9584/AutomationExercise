package com.automation.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.automation.pageobject.HomePage;
import com.automation.pageobject.ProductDetailPage;
import com.automation.pageobject.ProductPage;


public class TC_ProductPageTest extends BaseTest {

	@Test
	public void verifyallproductsandproductdetails() throws InterruptedException {

		HomePage homepage = new HomePage(driver);
		homepage.clickOnproducts();
		logger.info("Click on product button");

		ProductPage productpage = new ProductPage(driver);

		String productPageTitle = productpage.getProductPageTitle();
		Assert.assertEquals(productPageTitle, "Automation Exercise - All Products", "Product page title verification failed.");
		logger.info("Product page is visible successfully.");

		// Wait until the products container is present and visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement productsContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='single-products']")));
		logger.info("Products list is visible.");
		
		// Scroll down to the end of the products container using JavascriptExecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", productsContainer);

		// Explicit wait for the element to be clickable
		WebElement viewProductButton = wait.until(ExpectedConditions.elementToBeClickable(productpage.getViewProductButton()));

		// Click on the view product button
		viewProductButton.click();

		ProductDetailPage productdetailpg = new ProductDetailPage(driver);

		String productDetailPageTitle = productdetailpg.getProductDetailPageTitle();
		Assert.assertEquals(productDetailPageTitle, "Automation Exercise - Product Details", "Product details page title verification failed.");
		logger.info("Product details page is visible successfully.");

		Assert.assertEquals(productdetailpg.getProductName(), "Blue Top", "Product name verification failed.");
		Assert.assertEquals(productdetailpg.getCategory(), "Category: Women > Tops", "Category verification failed.");
		Assert.assertEquals(productdetailpg.getPrice(), "Rs. 500", "Price verification failed.");
		Assert.assertEquals(productdetailpg.getAvailability(), "Availability: In Stock", "Availability verification failed.");
		Assert.assertEquals(productdetailpg.getCondition(), "Condition: New", "Condition verification failed.");
		Assert.assertEquals(productdetailpg.getBrand(), "Brand: Polo", "Brand verification failed.");
		logger.info("All product details are visible successfully.");

	}
	@Test
	public void verifysearchproducts() throws IOException {

		String searchKey = "Dress";

		HomePage homepage = new HomePage(driver);
		homepage.clickOnproducts();
		logger.info("Click on product button");

		ProductPage productpage = new ProductPage(driver);

		String productPageTitle = productpage.getProductPageTitle();
		Assert.assertEquals(productPageTitle, "Automation Exercise - All Products", "Product page title verification failed.");
		logger.info("Product page is visible successfully.");

		productpage.enterSearchKeyword(searchKey);
		logger.info("Enter search keyword");

		productpage.clickOnSearchBtn();
		logger.info("Click on Search button");
		
		// Wait for 'SEARCHED PRODUCTS' header to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement searchedProductsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Searched Products')]")));
        logger.info("'SEARCHED PRODUCTS' header to be visible");
        
        // Scroll to the search results section using JavascriptExecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchedProductsHeader);

        // Verify all the products related to search are visible
        By searchResultsLocator = By.xpath("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/p[1]");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultsLocator));
        logger.info("all the search products are visible");
        
        List<WebElement> searchResults = driver.findElements(searchResultsLocator);
		
		//Verify that correct Product is displaying after search
        boolean productFound = false;
		for (int i = 0; i < searchResults.size(); i++) {
            WebElement result = searchResults.get(i);
            String product = result.getText();
            if (product.contains(searchKey)) {
                productFound = true;
                break;
            }
        }
		Assert.assertTrue(productFound, "Product containing search key '" + searchKey + "' not found.");
		logger.info("correct Product is displaying ");
	}

}
