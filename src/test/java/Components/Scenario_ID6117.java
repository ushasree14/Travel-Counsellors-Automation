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

public class Scenario_ID6117 extends BaseClass {
	
	public Scenario_ID6117(WebDriver driver) {
		this.driver = driver;
		
	}


	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB, String T2DOB, String T3DOB, String T4D0B, String T5D0B) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
			logger.info("Accepted cookies");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.WWExc.click();
		Thread.sleep(2000);
	
		WebDriverWait Tomorrow1 = new WebDriverWait(driver, 40);
		WebElement Tomorrow = Tomorrow1.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();

		
		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		fiveNights.click();
		Thread.sleep(2000);

		TC_obj.SPF.click();
		logger.info("Clicked on single parent family");
		  WebElement Groupfive =
		  wait.until(ExpectedConditions.visibilityOf(TC_obj.Groupfive));
		  Groupfive.click();

		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 1 DOB is "+T1DOB);
		TC_obj.T2DOB.sendKeys(T2DOB);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 2 DOB is "+T2DOB);
		TC_obj.T3DOB.sendKeys(T3DOB);
		TC_obj.T3DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 3 DOB is "+T3DOB);
		TC_obj.T4DOB.sendKeys(T4D0B);
		TC_obj.T4DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 4 DOB is "+T4D0B);
		TC_obj.T5DOB.sendKeys(T5D0B);
		TC_obj.T5DOB.sendKeys(Keys.TAB);
		logger.info("Traveller 5 DOB is "+T5D0B);
		
		Thread.sleep(5000);
		
		logger.info("Scenario: Validation: SPF - There cannot be more than 1 adult in a single parent family");
		TC_obj.Continue.click();
		

		wait.until(ExpectedConditions.visibilityOf(TC_obj.Invalid_SPF_TDOB_Error_message));
		
		Assert.assertEquals("There cannot be more than 1 adult in a single parent family", TC_obj.Invalid_SPF_TDOB_Error_message.getText());
		logger.info("Expected Error message is - There cannot be more than 1 adult in a single parent family");
		logger.info("Actual Error message is:-"+ TC_obj.Invalid_SPF_TDOB_Error_message.getText());
	}


}
