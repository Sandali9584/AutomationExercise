package com.automation.testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageobject.ContactUsPage;
import com.automation.pageobject.HomePage;



public class TC_ContactUsPageTest extends BaseTest {

	@Test
	public void VerifyContactUsPage() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		
		homepage.clickOnContactUs();
		logger.info("Click on Contact Us Link");
		
		ContactUsPage contactuspg = new ContactUsPage(driver);
		
		String getintouchtext = contactuspg.getgetintouchlabeltext();
		
		Assert.assertEquals(getintouchtext, "GET IN TOUCH");
		logger.info("'GET IN TOUCH' label is visible on the Contact Us page.");
		
		contactuspg.entername("John");
		logger.info("Entered name");
		
		contactuspg.enteremail("johnsmith@gmail.com");
		logger.info("Entered email");
		
		contactuspg.entersubject("inquery");
		logger.info("Entered Subject");
		
		contactuspg.entermessage("Hello world");
		logger.info("Entered Message");
		
		// Explicit wait for file input to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='upload_file']")));
		logger.info("File upload input is visible");
		
		contactuspg.chooseFile();
		logger.info("Uploaded File");
		
		WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        // Wait until submit button is clickable and then click it
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
		
		// Wait for alert to be present
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Accept the alert (click OK)
		
        String SuccessMessage = contactuspg.getSuccessMessage();

        // Assert that success message is displayed
        Assert.assertEquals(SuccessMessage,"Success! Your details have been submitted successfully.", "Success message is not displayed");

		
		
	}
}
