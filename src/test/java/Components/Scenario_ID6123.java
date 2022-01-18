package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID6123 extends BaseClass {

	public Scenario_ID6123(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String StartDate, String EndDate, String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 70);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
		// TC_obj.acceptCookies.click();
		logger.info("Accepted cookies");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SingleTrip));
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Europe));
		TC_obj.Europe.click();
		Thread.sleep(2000);
		
		WebElement SelectStartDate = wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectStartDate));
		SelectStartDate.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Today));
		TC_obj.Today.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SevenNights));
		TC_obj.SevenNights.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.OnePerson));
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);

		logger.info("Scenario: Check what happens if we don't add any text in traveler page and click on continue");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Continue));
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);

		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
		
		TC_obj.illness_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.symptoms_question));
		TC_obj.symptoms_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.conditions_question));
		TC_obj.conditions_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.ClickQuotePage));
		logger.info("Answered Traveler Journey Questions");
		TC_obj.ClickQuotePage.click();
		logger.info("Clicked on continue and will navigate to Quote Page");
		

	}

	@Test
	public void QuotePageTest() throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Premier));
		TC_obj.Premier.click();
		logger.info("Clicked on Premier Product");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Flight_Cancellation));
		TC_obj.Flight_Cancellation.click();
		logger.info("Clicked on Flight_Cancellation");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.clickedContinue));
		TC_obj.clickedContinue.click();
		logger.info("Clicked on continue and will navigate to Traveler Details Page");

	}

	public void Travel_details_fields_1() throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 80);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Travel_Details_Continue_Button));
		TC_obj.Travel_Details_Continue_Button.click();
		logger.info("Without enter any details then Clicked on Traveller Details Continue Button");
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Travel_Details_Fields_Error_Messages_List));
		logger.info("List of error messages list on Travellers Details Page :-\n "
				+ TC_obj.Travel_Details_Fields_Error_Messages_List.getText());

	}

}
