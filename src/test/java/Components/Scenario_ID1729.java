package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1729 extends BaseClass {

	public Scenario_ID1729(WebDriver driver) {
		this.driver = driver;
	}
	
	public void GetQuoteTest() throws InterruptedException, IOException {
		
		driver.get(baseURL);

		logger.info("URL is opened");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		logger.info("Scenario: As a customer I would like to see the Travel Counsellors FAQs");
		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.acceptCookies.click();
		logger.info("Accepted cookies");

	}

	
	public void DocumentsTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.CookiePolicy.click();
		Thread.sleep(5000);

	}

}
