package Components;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1849 extends BaseClass {

	public Scenario_ID1849(WebDriver driver) {
		this.driver = driver;
	}

	public void GetQuoteTest(String T1DOB, String StartDate, String EndDate) throws InterruptedException, IOException {
TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		TC_obj.PolicyDocumentation.click();
	}
		
		public void Verify_PolicyDocumentation_Page_Links() throws Exception {
			TC_WebElements TC_obj = new TC_WebElements(driver);
			Thread.sleep(5000);
			

			Set<String> MainWindows = driver.getWindowHandles();
			for (String Window : MainWindows) {
				driver.switchTo().window(Window);
			}
			System.out.println(driver.getCurrentUrl());
			List<WebElement> Policy_doc_links = TC_obj.Policy_Documentation_All_links;
			Thread.sleep(3000);
			int links_count = Policy_doc_links.size();
			System.out.println("In Policy documentation page Total Links count " + links_count);

			for (WebElement link : Policy_doc_links) {

				link.click();
			}
			Set<String> focused_window = driver.getWindowHandles();
			Thread.sleep(1000);
			for (String win : focused_window) {
				driver.switchTo().window(win);
				Thread.sleep(1000);
				System.out.println(driver.getTitle());
				System.out.println("URL is " + driver.getCurrentUrl());
			}
		}
	
}