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

public class Scenario_ID3989 extends BaseClass {

	public Scenario_ID3989(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.RejectCookies);
		logger.info("Cookies Rejected");

		TC_obj.AnnualTrip.click();
		logger.info("Clicked AMT Trip");
		TC_obj.WWExc.click();
		logger.info("Clicked WWExc Trip");
		Thread.sleep(2000);
		
		TC_obj.Today.click();
	

		Thread.sleep(2000);
		TC_obj.OnePerson.click();
		logger.info("One Person(Individual) Selected");
		Thread.sleep(4000);
		TC_obj.T1DOB.sendKeys(T1DOB);
		logger.info("Traveller DOB "+T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);

		TC_obj.CruiseCover.click();
		logger.info("Cruise Cover Selected");
		logger.info("Scenario: Verify user able to create T&M policy with Individual, AMT");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

	
		WebDriverWait wait = new WebDriverWait(driver, 80);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
		TC_obj.illness_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.symptoms_question));
		TC_obj.symptoms_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.conditions_question));
		TC_obj.conditions_question.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.conditions_questionYes));
		TC_obj.conditions_questionYes.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.waived_conditions));
		TC_obj.waived_conditions.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.gdpr));
		TC_obj.gdpr.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.treatment));
		TC_obj.treatment.click();
		TC_obj.diagnosis.click();

		Thread.sleep(3000);
		logger.info("Answered Pre Existing Medical Questions");
		TC_obj.ClickQuotePageforMedical.click();
		logger.info("Clicked on continue to fill Traveller details");

	}

	@Test(priority = 3)
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String Address_Line1, String city,
			String County, String PostCode) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Traveller_Title1_Dropdown));
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
		TC_obj.Travel_Details_Continue_Button.click();
		logger.info("Answered Traveler details Journey Questions");
	}

	@Test(priority = 4)
	public void Medical_Conditions(String med_conditionT1) throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
	
		WebDriverWait wait = new WebDriverWait(driver, 90);
		logger.info("started medical screening journey");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.Medical_screening_Start_Button);
		//js.executeScript("arguments[0].click()",TC_obj.Medical_screening_Start_Button );
		//wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Start_Button)).click();
		
		TC_obj.Medical_screening_Start_Button.click();
		logger.info(" medical screening start button clicked");
        
		
	
		WebElement iframe = wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Iframe));
		iframe.click();
		driver.switchTo().frame(TC_obj.Medical_screening_Iframe);
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT1);
		Thread.sleep(2000);
		TC_obj.Medical_screening_Search_Button.click();
		TC_obj.Select_Medical_Condition.click();
		TC_obj.Medical_Condition_Continue_Button.click();
		TC_obj.Medical_Condition_Finish_Button.click();
		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void QuotePageTest() throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Premier));
		TC_obj.Premier.click();
		TC_obj.Flight_Cancellation.click();
		Thread.sleep(2000);
		TC_obj.Special_Sports_table_B.click();
		Thread.sleep(2000);
		TC_obj.Special_Sports_table_D.click();
		
		logger.info("Clicked on Premier Product,Special Sports Table B, Special Sports (table D),Flight Cancellation");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.clickedContinue));
		TC_obj.clickedContinue.click();
		logger.info("Clicked on continue and will navigate to Terms and conditions");
	}

	@Test(priority = 6)
	public void Travel_details_fields_2(String Phonenumber, String Email) {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.mobile));
		TC_obj.mobile.sendKeys(Phonenumber);
		TC_obj.email.sendKeys(Email);
		TC_obj.termsandconditions.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Travel_Details_Continue_Button));
		TC_obj.Travel_Details_Continue_Button.click();
	}

	@Test(priority = 7)
	public void Payment_Details(String cardnumber, String securityCVV) {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait Payment_page_iframe = new WebDriverWait(driver, 70);
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

		driver.switchTo().defaultContent();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 70);
		WebElement payment_message_title = wait
				.until(ExpectedConditions.visibilityOf(TC_obj.Payment_Success_Page_Title_1));
		Assert.assertEquals(TC_obj.Payment_Success_Page_Title_1.getText(), "Thank you");

		Assert.assertEquals(TC_obj.Payment_Success_Page_Title_2.getText(),
				"Your Travel Insurance is all set up. Enjoy your trip!");
		System.out.println(TC_obj.Payment_Success_Travel_Insurance_Policy_Number.getText());
	}

}
