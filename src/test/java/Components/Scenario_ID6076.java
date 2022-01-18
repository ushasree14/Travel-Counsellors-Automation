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
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID6076 extends BaseClass {

	public Scenario_ID6076(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", cookies);
		logger.info("cookies accepted");

		TC_obj.Europe.click();

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement Tomorrow = wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();

//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
//		fiveNights.click();

		TC_obj.OnePerson.click();

		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));

		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		logger.info("Scenario 6076: What happens if we don't select - Which type of Cover do you need?");
		TC_obj.Continue.click();
		logger.info("Clicked on continue button");

		WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/div/form/div[1]/div/div"));
	
		logger.info(TC_obj.SingleTrip.getAttribute("span"));
		logger.info(error.getAttribute("toastMessage"));
		logger.info(error.getAttribute("span"));

		// Please select one of these options.

	}

}
