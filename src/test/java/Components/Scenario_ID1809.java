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

public class Scenario_ID1809 extends BaseClass {
	
	
	public Scenario_ID1809(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void GetQuoteTest(String StartDate, String EndDate, String T1DOB, String T2DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.UK));
		TC_obj.UK.click();
		logger.info("Selected UK");
		Thread.sleep(2000);
		
		WebElement SelectStartDate = wait
				.until(ExpectedConditions.visibilityOf(TC_obj.SelectStartDate));
		SelectStartDate.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.StartDate));
		TC_obj.StartDate.clear();
		TC_obj.StartDate.sendKeys(StartDate);
		TC_obj.StartDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectEndDate));
		TC_obj.SelectEndDate.click();
		TC_obj.EndDate.clear();
		TC_obj.EndDate.sendKeys(EndDate);
		TC_obj.EndDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Couple));
		TC_obj.Couple.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		TC_obj.T2DOB.sendKeys(T2DOB);
		Thread.sleep(2000);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		logger.info(
				"Scenario: As a customer I want to see the GDPR statement");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}
	
	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {


		TC_WebElements TC_obj = new TC_WebElements(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
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

		/* driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); */

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
	
	
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1,String FN_Traveler2,
			String LN_Traveler2, String Address_Line1, String city,
			String County, String PostCode, String Phonenumber, String Email) throws InterruptedException {
		
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TC_obj.Traveller_Title1_Dropdown.click();
		TC_obj.Title1_option.click();
		TC_obj.FN_Traveler1.sendKeys(FN_Traveler1);
		TC_obj.LN_Traveler1.sendKeys(LN_Traveler1);
		
		
		TC_obj.Traveller_Title2_Dropdown.click();
		TC_obj.Title2_option.click();
		TC_obj.FN_Traveler2.sendKeys(FN_Traveler2);
		TC_obj.LN_Traveler2.sendKeys(LN_Traveler2);
		Thread.sleep(3000);
	
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
		logger.info("Clicked on continue and will navigate to Payment Details Page");
	}
	
	
	
	@Test(priority = 7)
	public void Payment_Details(String cardnumber, String securityCVV) {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
		WebDriverWait Payment_page_iframe = new WebDriverWait(driver, 40);
		Payment_page_iframe.until(ExpectedConditions.visibilityOf(TC_obj.Payment_page_iframe)).click();
		driver.switchTo().frame(TC_obj.Payment_page_iframe);
		TC_obj.Card_Number_Field.sendKeys(cardnumber);
		TC_obj.Security_Number_CVV_Field.sendKeys(securityCVV);
		TC_obj.Card_Expiry_Month_dropdown.sendKeys("10");
		TC_obj.Card_Expiry_Year_dropdown.sendKeys("23");
		TC_obj.PayNow_Button.click();
		driver.switchTo().defaultContent();
		TC_obj.Payment_Success_Page_Title_1.getText();
		TC_obj.Payment_Success_Page_Title_2.getText();
		System.out.println(TC_obj.Payment_Success_Travel_Insurance_Policy_Number.getText());

	}

	@Test(priority = 8)
	public void Verify_Payment_Page_Successful_Message() {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement payment_message_title = wait
				.until(ExpectedConditions.visibilityOf(TC_obj.Payment_Success_Page_Title_1));
		Assert.assertEquals(TC_obj.Payment_Success_Page_Title_1.getText(), "Thank you");

		Assert.assertEquals(TC_obj.Payment_Success_Page_Title_2.getText(),
				"Your Travel Insurance is all set up. Enjoy your trip!");
		System.out.println(TC_obj.Payment_Success_Travel_Insurance_Policy_Number.getText());
	}
}
