package Components;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID6092 extends BaseClass {

	public Scenario_ID6092(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", cookies);
		logger.info("cookies accepted");
		TC_obj.SingleTrip.click();
		TC_obj.Europe.click();

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement Tomorrow = wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();

		
		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		fiveNights.click();

		TC_obj.OnePerson.click();

		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));

		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		logger.info("ID6092 - Verify When user entered invalid Traveller date of birth");
		TC_obj.Continue.click();
		logger.info("Clicked on continue button");

		wait.until(ExpectedConditions.visibilityOf(TC_obj.Invalid_TDOB_Error_message));
		
		Assert.assertEquals("The maximum age for this trip is 100", TC_obj.Invalid_TDOB_Error_message.getText());
		
		logger.info("Error message is:-"+ TC_obj.Invalid_TDOB_Error_message.getText());
	}

}
