package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1709 extends BaseClass  {

	public Scenario_ID1709(WebDriver driver) {
		this.driver = driver;
	}


	public void GetQuoteTest() throws InterruptedException, IOException {
TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
	
}
	

	public void DocumentsTest() throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TC_obj.footerFAQ.click();
		
		//doc.faqHeading();
		
		WebDriverWait wait = new WebDriverWait(driver, 70);
		WebElement Livechat = wait
				.until(ExpectedConditions.visibilityOf(TC_obj.Livechat));
	  Assert.assertEquals(TC_obj.Livechat.getText(),
	  "Live Chat");
	}
}
