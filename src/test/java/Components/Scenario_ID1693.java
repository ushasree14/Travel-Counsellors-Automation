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
import org.testng.Assert;
import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1693 extends BaseClass {

	public Scenario_ID1693(WebDriver driver) {
		this.driver = driver;
	}

	// As a customer I want to use Live Chat to communicate with sale agents

	public void GetQuoteTest() throws InterruptedException, IOException {
TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");

	}

	public void LiveChatTest() throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TC_obj.Livechat.click();
		System.out.println("clicked on livechat");
		driver.switchTo().frame(TC_obj.liveChatiframe);
		System.out.println("liveChatiframe switched");
		TC_obj.LiveChatname.sendKeys("test");
		TC_obj.LiveChatemail.sendKeys("ushasree.kommanamanchi@rockinsurance.com");
		TC_obj.StartLiveChat.click();
		System.out.println("clicked on start live chat");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		/*
		 * wait.until(ExpectedConditions.visibilityOf(TC_obj.agentMsg));
		 * Assert.assertEquals(TC_obj.agentMsg.getText(),
		 * "One moment while we check for an available agent.");
		 * System.out.println(TC_obj.agentMsg.getText());
		 * 
		 * TC_obj.testMsg.sendKeys("This is Automation test Sample");
		 * TC_obj.testMsg.sendKeys(Keys.ENTER); Thread.sleep(2000);
		 * TC_obj.agentMsg.click();
		 */
		
		WebElement TodayLiveText= driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/div[1]/div[1]"));
		TodayLiveText.getText();
		
		  wait.until(ExpectedConditions.visibilityOf(TodayLiveText));
		if(TodayLiveText.getText().contains("Today")) {
		    System.out.println("Today text is matched");
		    System.out.println(TodayLiveText.getText());
		} else {
		    System.out.println("Today text is not matched");
		    
		}

		
	}

}
