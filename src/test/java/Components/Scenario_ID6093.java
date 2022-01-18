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

public class Scenario_ID6093 extends BaseClass {

	public Scenario_ID6093(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String EndDate, String T1DOB) throws InterruptedException, IOException {
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

//		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
//	WebElement SelectStartDate = wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectStartDate));

		wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectEndDate));
		TC_obj.SelectEndDate.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.EndDate));
		TC_obj.EndDate.clear();
		TC_obj.EndDate.sendKeys(EndDate);
		TC_obj.EndDate.sendKeys(Keys.TAB);
		TC_obj.EndDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);

		logger.info("Invalid End Date entered");

		wait.until(ExpectedConditions.visibilityOf(TC_obj.OnePerson));
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		// 10/09/1991
		TC_obj.T1DOB.clear();
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		logger.info("ID6093 - Verify When user entered invalid End date");
		TC_obj.Continue.click();
		logger.info("Clicked on continue button");
		takeScreenshot("Negative_Scenario_ID6093_Invalid_EndDate");

		wait.until(ExpectedConditions.visibilityOf(TC_obj.Invalid_EndDate_Error_message));

		Assert.assertEquals("The end date must be after the start date",
				TC_obj.Invalid_EndDate_Error_message.getText());

		logger.info("Error message is:-" + TC_obj.Invalid_EndDate_Error_message.getText());
	}

}
