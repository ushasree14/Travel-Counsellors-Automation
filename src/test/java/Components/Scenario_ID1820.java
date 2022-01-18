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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1820 extends BaseClass {
	
	public Scenario_ID1820(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB, String StartDate, String EndDate) throws InterruptedException, IOException {
TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Auz));
TC_obj.Auz.click();
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectStartDate));
		TC_obj.SelectStartDate.click();

		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.StartDate))).click();
		TC_obj.StartDate.clear();
		TC_obj.StartDate.sendKeys(StartDate);
		TC_obj.StartDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectEndDate));
		TC_obj.SelectEndDate.click();
		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.EndDate))).click();
		TC_obj.EndDate.clear();
		TC_obj.EndDate.sendKeys(EndDate);
		TC_obj.EndDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.OnePerson))).click();
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.T1DOB))).click();
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);


		logger.info("Scenario: A user can select a start date subject to restrictions");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

}
