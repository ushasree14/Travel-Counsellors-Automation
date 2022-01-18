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

public class Scenario_ID6122 extends BaseClass {

	public Scenario_ID6122(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 70);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
		//TC_obj.acceptCookies.click();
		logger.info("Accepted cookies");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.Europe.click();
		Thread.sleep(2000);
		
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
		logger.info("Scenario: Verify whether Show more and Show less buttons are working in Quote page");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Continue));
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);

		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
		
		TC_obj.illness_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.symptoms_question));
		TC_obj.symptoms_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.conditions_question));
		TC_obj.conditions_question.click();
	
		logger.info("Answered Traveler Journey Questions");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.ClickQuotePage));
		TC_obj.ClickQuotePage.click();
		logger.info("Clicked on continue and will navigate to Quote Page");
		

	}

	@Test
	public void QuotePageTest() throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Quote_show_More_Less_buttons));
		logger.info("Clicked on Show More button text - "+ TC_obj.Quote_show_More_Less_buttons.getText());
		TC_obj.Quote_show_More_Less_buttons.click();
		
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Quote_show_More_Less_buttons));
		logger.info("Clicked on Show Less button text- "+ TC_obj.Quote_show_More_Less_buttons.getText());
		js.executeScript("arguments[0].click();", TC_obj.Quote_show_More_Less_buttons);
		
		
		
	}

}
