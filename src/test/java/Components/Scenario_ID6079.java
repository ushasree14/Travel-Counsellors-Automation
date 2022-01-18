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

public class Scenario_ID6079 extends BaseClass {
	
	
	public Scenario_ID6079(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.Europe.click();
		Thread.sleep(2000);
		TC_obj.Today.click();
		Thread.sleep(2000);
		//TC_obj.fiveNights.click();
		TC_obj.OnePerson.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		logger.info(
				"Scenario: What happens if we don't select - Trip End date");
		TC_obj.Continue.click();
		/*
		 * WebElement errormsg =
		 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.
		 * xpath("//p[contains(text(),'The End date field is required.')]"))));
		 * System.out.println(errormsg.getText());
		 */
		takeScreenshot("Scenario_ID6079_ContinueButton");
		Thread.sleep(5000);
WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/div/form/div[1]/div/div"));
		
		logger.info(TC_obj.fiveNights.getAttribute("span"));
		logger.info(error.getAttribute("toastMessage"));
		logger.info(error.getAttribute("span"));
		
	}

}

