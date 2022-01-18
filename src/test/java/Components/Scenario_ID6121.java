package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID6121 extends BaseClass {

	public Scenario_ID6121(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
		//TC_obj.acceptCookies.click();
		logger.info("Accepted cookies");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SingleTrip));
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Europe));
		TC_obj.Europe.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		TC_obj.Tomorrow.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		TC_obj.fiveNights.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.OnePerson));
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		logger.info("Traveller DOB is " + T1DOB);

		logger.info(
				"Scenario: Check what happens if we click No to GDPR 1st question in Pre existing medical condition page");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Continue));
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
		TC_obj.illness_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.symptoms_question_yes));
		TC_obj.symptoms_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.conditions_questionYes));
		TC_obj.conditions_questionYes.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.waived_conditions));
		TC_obj.waived_conditions.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.gdpr_No));
		TC_obj.gdpr_No.click();
		
		
		
		WebElement Gdpr_question_no_error_message = wait
				.until(ExpectedConditions.visibilityOf(TC_obj.gdpr_No_error_message));

		logger.info("if user clicked GDPR No to 1st question in Pre existing medical condition page-- Actual Error Message is:-- "
				+ Gdpr_question_no_error_message.getText());

	}

}
