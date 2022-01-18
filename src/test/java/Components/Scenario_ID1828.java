package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1828 extends BaseClass {
	

	public Scenario_ID1828(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Europe));
		TC_obj.Europe.click();
		logger.info("Europe");
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Today));
		TC_obj.Today.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		TC_obj.fiveNights.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.OnePerson));
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		logger.info("T1DOB");
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		logger.info("T1DOB Tab");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.WSCover));
		TC_obj.WSCover.click();
		Thread.sleep(3000);
		logger.info(
				"Scenario: A user can leave the pre-existing medical questionnaire flow with their details recorded");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.illness_question.click();
		TC_obj.symptoms_question.click();
	}
}
