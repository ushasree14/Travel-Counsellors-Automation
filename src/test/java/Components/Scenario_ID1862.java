package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1862 extends BaseClass{
	
	public Scenario_ID1862(WebDriver driver) {
		this.driver = driver;
	}

	public void Verify_HTTPS() {

		String current_url = driver.getCurrentUrl();
		if (current_url.contains("https")) {
			logger.info("HTTPS header Verified successfully in this current screen URL:- " + current_url);
		} else {
			logger.info("HTTPS header not placed in this current URL");
		}

	}

	public void GetQuoteTest(String T1DOB)
			throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Europe));
		TC_obj.Europe.click();

		wait.until(ExpectedConditions.visibilityOf(TC_obj.Today));
		TC_obj.Today.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		TC_obj.fiveNights.click();
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		  TC_obj.T1DOB.sendKeys(T1DOB);
		  TC_obj.T1DOB.sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		logger.info("ID1862 - A user can clearly see the quote journey URL upon landing on the ROCK quote journey");
		TC_obj.Continue.click();
		logger.info("Clicked on continue button");
		

	}

	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		Verify_HTTPS();
		TC_obj.Ultimate.click();
		logger.info("Clicked on Premier Product");
		Thread.sleep(3000);
		TC_obj.BusinessCover.click();
		logger.info("Clicked on Business Cover");
		Thread.sleep(3000);
		TC_obj.clickedContinue.click();
		//logger.info("Clicked on continue and will navigate to Traveler Details Page");

	}

}


