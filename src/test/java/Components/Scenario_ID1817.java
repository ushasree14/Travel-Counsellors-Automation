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

public class Scenario_ID1817 extends BaseClass {
	
	public Scenario_ID1817(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String T1DOB, String T2DOB, String T3DOB, String T4DOB, String T5DOB, String T6DOB, String T7DOB, String T8DOB, String T9DOB, String T10DOB) throws InterruptedException, IOException {
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
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Today));
		TC_obj.Today.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		TC_obj.fiveNights.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Group));
		TC_obj.Group.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Groupten));
		TC_obj.Groupten.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		TC_obj.T2DOB.sendKeys(T2DOB);
		Thread.sleep(2000);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T3DOB));
		TC_obj.T3DOB.sendKeys(T3DOB);
		TC_obj.T3DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T4DOB));
		TC_obj.T4DOB.sendKeys(T4DOB);
		TC_obj.T4DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T5DOB));
		TC_obj.T5DOB.sendKeys(T5DOB);
		TC_obj.T5DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T6DOB));
		TC_obj.T6DOB.sendKeys(T6DOB);
		TC_obj.T6DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T7DOB));
		TC_obj.T7DOB.sendKeys(T7DOB);
		TC_obj.T7DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T8DOB));
		TC_obj.T8DOB.sendKeys(T8DOB);
		TC_obj.T8DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T9DOB));
		TC_obj.T9DOB.sendKeys(T9DOB);
		TC_obj.T9DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T10DOB));
		TC_obj.T10DOB.sendKeys(T10DOB);
		TC_obj.T10DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		logger.info(
				"Scenario: A user can add a date of birth for relevant travellers");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

}
