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

public class Scenario_ID1798 extends BaseClass {

	public Scenario_ID1798(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		driver.get(baseURL);

		logger.info("URL is opened");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

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
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		  TC_obj.T1DOB.sendKeys(T1DOB);
		  TC_obj.T1DOB.sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		TC_obj.WSCover.click();
		TC_obj.CruiseCover.click();
		Thread.sleep(3000);
		TC_obj.GolfCover.click();
		Thread.sleep(3000);
		TC_obj.WSCover.click();
		Thread.sleep(3000);
		logger.info("Scenario: A user can add policy addons to his order in getquote Page");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}


}
