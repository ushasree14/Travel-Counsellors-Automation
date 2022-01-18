package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1730 extends BaseClass {
	
	public Scenario_ID1730(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest() throws InterruptedException, IOException {
			
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			logger.info("Scenario: As a customer I want to see the ROCK/Travel Counsellor Privacy Policy");
			TC_WebElements TC_obj = new TC_WebElements(driver);
			TC_obj.RejectCookies.click();
			logger.info("Rejected cookies");

	}

	@Test(priority = 2)
	public void DocumentsTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.PrivacyPolicy.click();
		logger.info("Opened Privacy policy");
		Thread.sleep(3000);
		

	}

}
