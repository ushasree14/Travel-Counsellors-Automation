package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1897 extends BaseClass {

	public Scenario_ID1897(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest() throws InterruptedException, IOException {
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Scenario: As a customer I would like to see the Travel Counsellors FAQs");
		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.RejectCookies.click();
		logger.info("Rejected cookies");

	}
}
