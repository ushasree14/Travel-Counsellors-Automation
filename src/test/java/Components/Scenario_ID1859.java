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
import org.testng.Assert;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1859 extends BaseClass {
	
	public Scenario_ID1859(WebDriver driver) {
		this.driver = driver;
	}
	
	public void GetQuoteTest() throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		TC_obj.PolicyDocumentation.click();
		Thread.sleep(3000);
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		TC_obj.TermsOfBusiness.click();
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
