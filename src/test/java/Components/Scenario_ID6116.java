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

public class Scenario_ID6116 extends BaseClass {
	
	public Scenario_ID6116(WebDriver driver) {
		this.driver = driver;	}


	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB, String T2DOB, String T3DOB,String T4DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
		logger.info("Accepted cookies");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.Europe.click();

		WebDriverWait Tomorrow1 = new WebDriverWait(driver, 40);
		WebElement Tomorrow = Tomorrow1.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		fiveNights.click();

		TC_obj.Family.click();

		WebElement FamilyFour = wait.until(ExpectedConditions.visibilityOf(TC_obj.Groupthree));
		FamilyFour.click();

		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 1 DOB "+T1DOB);
		TC_obj.T2DOB.sendKeys(T2DOB);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 2 DOB "+T2DOB);
		Thread.sleep(5000);
		TC_obj.T3DOB.sendKeys(T3DOB);
		TC_obj.T3DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 3 DOB "+T3DOB);
		Thread.sleep(5000);
		TC_obj.T4DOB.sendKeys(T4DOB);
		TC_obj.T4DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 4 DOB "+T4DOB);
		logger.info("Scenario: Validation: Family - There cannot be more than 2 adults in a family");
		TC_obj.Continue.click();
		

		wait.until(ExpectedConditions.visibilityOf(TC_obj.Invalid_ST_Family_TDOB_Error_message));
		
		Assert.assertEquals("There cannot be more than 2 adults in a family", TC_obj.Invalid_ST_Family_TDOB_Error_message.getText());
		logger.info("Expected Error message is - There cannot be more than 2 adults in a family");
		logger.info("Actual Error message is:-"+ TC_obj.Invalid_ST_Family_TDOB_Error_message.getText());
		

	}

}
