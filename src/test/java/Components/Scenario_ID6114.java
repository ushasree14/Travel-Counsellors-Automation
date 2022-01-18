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

public class Scenario_ID6114 extends BaseClass {

	public Scenario_ID6114(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB, String T2DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", cookies);
		logger.info("Cookies accepted");
		TC_obj.SingleTrip.click();
		TC_obj.Europe.click();

		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement Tomorrow = wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();

		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		fiveNights.click();

		TC_obj.Couple.click();

		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));

		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T2DOB));
		TC_obj.T2DOB.sendKeys(T2DOB);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		logger.info("ID6114 -Validation - Children cannot be part of a couple");
		TC_obj.Continue.click();
		logger.info("Clicked on continue button");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Invalid_Couple_TDOB_Error_message));

		Assert.assertEquals("Children cannot be part of a couple", TC_obj.Invalid_Couple_TDOB_Error_message.getText());
		logger.info("Expected Error message is - Children cannot be part of a couple");
		logger.info("Actual Error message is:-" + TC_obj.Invalid_Couple_TDOB_Error_message.getText());
	}

}
