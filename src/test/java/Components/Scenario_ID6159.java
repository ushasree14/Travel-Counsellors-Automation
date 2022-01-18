package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID6159 extends BaseClass {
	
	
	public Scenario_ID6159(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String StartDate, String EndDate, String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
			
			logger.info("Accepted cookies");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.Auz.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		TC_obj.Tomorrow.click();
		TC_obj.fiveNights.click();
		Thread.sleep(2000);
		
		TC_obj.OnePerson.click();
		
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		
		logger.info(
				"Scenario: Verify the price if we refresh page in Cover page - ST");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}
	
	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
	 wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
	 Thread.sleep(4000);	
	 TC_obj.illness_question.click();
		TC_obj.symptoms_question.click();
		TC_obj.conditions_question.click();
		logger.info("Answered Traveler Journey Questions");
		TC_obj.ClickQuotePage.click();
		logger.info("Clicked on continue and will navigate to Quote Page");
		Thread.sleep(4000);

	}
	
	@Test
	public void QuotePageTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		Actions action=new Actions(driver);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.Premier.click();
		logger.info("Clicked on Premier Product");
		Thread.sleep(3000);
		logger.info("Navigated to cover page:-"+ driver.getCurrentUrl());
		logger.info("Before Selecting Business cover, the Price is:- "+TC_obj.Price_on_cover_page.getText());
		TC_obj.BusinessCover.click();
		logger.info("Clicked on Business Cover");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Price_on_cover_page));
		logger.info("Before refresh the page, Price is:- "+TC_obj.Price_on_cover_page.getText());
		driver.navigate().refresh();
		logger.info("Page refreshed");
		
/*
		//wait.until(ExpectedConditions.visibilityOf(TC_obj.Price_on_cover_page));
		//logger.info("After refresh the page, Price is:- "+TC_obj.Price_on_cover_page.getText());
		
		try{
			TC_obj.BusinessCover.click();
			
	      }
	      catch(StaleElementReferenceException e){
//	    	  wait.until(ExpectedConditions.visibilityOf(TC_obj.BusinessCover));
	    	  TC_obj.BusinessCover.click();
	    	  logger.info("Removed Business Cover option");
	    	  logger.info("After refresh the page and Removed the Business cover option, Price is:- "+TC_obj.Price_on_cover_page.getText());
	      }

	*/
	
	
	}

}
