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

public class Scenario_ID6120 extends BaseClass {

	public Scenario_ID6120(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
		logger.info("Accepted cookies");

		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Auz));
		TC_obj.Auz.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		TC_obj.Tomorrow.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		TC_obj.fiveNights.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.OnePerson));
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		logger.info("Traveller DOB is " + T1DOB);

		logger.info(
				"Scenario: Check what happens if we click Yes to 2nd question in Pre existing medical condition page");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 80);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
		TC_obj.illness_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.symptoms_question_yes));
		TC_obj.symptoms_question_yes.click();
		WebElement symptoms_question_yes_error_message = wait
				.until(ExpectedConditions.visibilityOf(TC_obj.symptoms_question_yes_error_message));

		logger.info("if user clicked Yes to 2nd question in Pre existing medical condition page-- Error Message is:-- "
				+ symptoms_question_yes_error_message.getText());

	}

}
