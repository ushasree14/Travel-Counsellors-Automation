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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID6128 extends BaseClass {
	
	
	public Scenario_ID6128(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String StartDate, String EndDate, String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
			//TC_obj.acceptCookies.click();
			logger.info("Accepted cookies");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.Auz.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		TC_obj.Tomorrow.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		TC_obj.fiveNights.click();
		Thread.sleep(2000);
		TC_obj.OnePerson.click();
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		
		logger.info(
				"Scenario: Check what happens if we refresh page in payment page after entering card details");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}
	
	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
	 wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
	 Thread.sleep(4000);	
	 TC_obj.illness_question.click();
		TC_obj.symptoms_question.click();
		TC_obj.conditions_question.click();
		logger.info("Answered Traveler Journey Questions");
		TC_obj.ClickQuotePage.click();
		logger.info("Clicked on continue and will navigate to Quote Page");
		Thread.sleep(4000);

	}
	
	@Test
	public void QuotePageTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.Premier.click();
		logger.info("Clicked on Premier Product");
		Thread.sleep(3000);
		TC_obj.Flight_Cancellation.click();
		logger.info("Clicked on Business Cover");
		Thread.sleep(3000);
		TC_obj.clickedContinue.click();
		logger.info("Clicked on continue and will navigate to Traveler Details Page");

	}
	
	
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String Address_Line1, String city,
			String County, String PostCode, String Phonenumber, String Email) throws InterruptedException {
		
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TC_obj.Traveller_Title1_Dropdown.click();
		TC_obj.Title1_option.click();
		TC_obj.FN_Traveler1.sendKeys(FN_Traveler1);
		TC_obj.LN_Traveler1.sendKeys(LN_Traveler1);
		
	
	
		TC_obj.Enter_address_manually_Link.click();
		TC_obj.Address_Line_1_Field.sendKeys(Address_Line1);
		TC_obj.City_Town_Field.sendKeys(city);
		TC_obj.County_Field.sendKeys(County);

		Select Country = new Select(TC_obj.Country_Dropdown);
		Country.selectByValue("united-kingdom-gbr");
		Thread.sleep(2000);
		TC_obj.Postcode_Field.sendKeys(PostCode);
		TC_obj.mobile.sendKeys(Phonenumber);
		Thread.sleep(3000);
		TC_obj.email.sendKeys(Email);
		TC_obj.termsandconditions.click();
		Thread.sleep(2000);
		TC_obj.Travel_Details_Continue_Button.click();
		logger.info("Traveler Details completed");
		
	}
	
	
	
	public void Payment_Details(String cardnumber, String securityCVV) throws InterruptedException {
		
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Payment_page_iframe));
		driver.switchTo().frame(TC_obj.Payment_page_iframe);
		logger.info("Switched to payment iframe");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Card_Number_Field));
		TC_obj.Card_Number_Field.sendKeys(cardnumber);
		TC_obj.Security_Number_CVV_Field.sendKeys(securityCVV);
		TC_obj.Card_Expiry_Month_dropdown.sendKeys("10");
		TC_obj.Card_Expiry_Year_dropdown.sendKeys("23");
		driver.navigate().refresh();
		logger.info("After refresh the current page URL is:- "+ driver.getCurrentUrl());
		driver.switchTo().defaultContent();
	}
	
	

}
