package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID3992 extends BaseClass {

	public Scenario_ID3992(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String StartDate, String EndDate, String T1DOB, String T2DOB, String T3DOB, String T4D0B, String T5D0B) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
		logger.info("Cookies Accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.WWExc.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		TC_obj.Tomorrow.click();
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		TC_obj.fiveNights.click();
		Thread.sleep(2000);

		TC_obj.SPF.click();

		  WebElement Groupfive =
		  wait.until(ExpectedConditions.visibilityOf(TC_obj.Groupfive));
		  Groupfive.click();

		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		TC_obj.T2DOB.sendKeys(T2DOB);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		TC_obj.T3DOB.sendKeys(T3DOB);
		TC_obj.T3DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		TC_obj.T4DOB.sendKeys(T4D0B);
		TC_obj.T4DOB.sendKeys(Keys.TAB);
		TC_obj.T5DOB.sendKeys(T5D0B);
		TC_obj.T5DOB.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		
		TC_obj.GolfCover.click();

		logger.info("Scenario: Verify user able to create T&M policy with SPF, ST");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		TC_obj.illness_question.click();
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
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String FN_Traveler2,
			String LN_Traveler2, String FN_Traveler3, String LN_Traveler3, String FN_Traveler4, String LN_Traveler4, String FN_Traveler5, String LN_Traveler5, String Address_Line1, String city,
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

		TC_obj.Traveller_Title3_Dropdown.click();
		TC_obj.Title3_option.click();

		TC_obj.FN_Traveler3.sendKeys(FN_Traveler3);
		TC_obj.LN_Traveler3.sendKeys(LN_Traveler3);
		
		TC_obj.Traveller_Title4_Dropdown.click();
		TC_obj.Title4_option.click();

		TC_obj.FN_Traveler4.sendKeys(FN_Traveler4);
		TC_obj.LN_Traveler4.sendKeys(LN_Traveler4);
		
		TC_obj.Traveller_Title5_Dropdown.click();
		TC_obj.Title5_option.click();

		TC_obj.FN_Traveler5.sendKeys(FN_Traveler5);
		TC_obj.LN_Traveler5.sendKeys(LN_Traveler5);

		TC_obj.Enter_address_manually_Link.click();
		TC_obj.Address_Line_1_Field.sendKeys(Address_Line1);
		TC_obj.City_Town_Field.sendKeys(city);
		TC_obj.County_Field.sendKeys(County);

		Select Country = new Select(TC_obj.Country_Dropdown);
		Country.selectByValue("united-kingdom-gbr");
		Thread.sleep(2000);
		TC_obj.Postcode_Field.sendKeys(PostCode);
		/*
		 * TC_obj.mobile.sendKeys(Phonenumber); Thread.sleep(3000);
		 * TC_obj.email.sendKeys(Email); TC_obj.termsandconditions.click();
		 */
		Thread.sleep(2000);
		TC_obj.Travel_Details_Continue_Button.click();
		logger.info("Traveler details completed");
	}

	@Test(priority = 4)
	public void Medical_Conditions(String med_conditionT1,String med_conditionT2) throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		logger.info("Entered Medical conditions");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.disable_medical_conditions_travellers_3);
		TC_obj.disable_medical_conditions_travellers_3.click();
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.disable_medical_conditions_travellers_4);
		TC_obj.disable_medical_conditions_travellers_4.click();
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.disable_medical_conditions_travellers_5);
		TC_obj.disable_medical_conditions_travellers_5.click();
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Start_Button)).click();
		logger.info("clicked on medical screening start button");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Iframe)).click();
		driver.switchTo().frame(TC_obj.Medical_screening_Iframe);
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT1);
		logger.info("Entered Whooping cough condition");
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Search_Button));
		TC_obj.Medical_screening_Search_Button.click();
		logger.info("Clicked on search button");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Select_Medical_Condition));
		TC_obj.Select_Medical_Condition.click();
		logger.info("Select_Medical_Condition");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.recovered)).click();
		logger.info("recovered");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.MedicalScreeningContinue))).click();
		//wait.until(ExpectedConditions.visibilityOf(TC_obj.MedicalScreeningContinue)).click();
	
		logger.info("MedicalScreeningContinue");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Finish));
		TC_obj.Finish.click();
		logger.info("Finish");
		Thread.sleep(5000);
		
		//TC_obj.TCcontinue.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Search_Box));
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT2);
		Thread.sleep(5000);
		
		TC_obj.Medical_screening_Search_Button.click();
		TC_obj.Select_Medical_Condition.click();
		Thread.sleep(5000);
		
		TC_obj.Medical_Condition_Continue_Button.click();
		logger.info("Medical_Condition_Continue_Button");
		
		TC_obj.Medical_Condition_Finish_Button.click();
		logger.info("Medical_Condition_Finish_Button");
		Thread.sleep(5000);
		
		
		driver.switchTo().defaultContent();
		
		logger.info("Completed Medical Screening Journey Questions");

	}

	@Test(priority = 5)
	public void QuotePageTest() throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Ultimate));
		TC_obj.Ultimate.click();
		TC_obj.Wedding_Cover.click();
		TC_obj.Flight_Cancellation.click();
		Thread.sleep(2000);
		
		logger.info("Clicked on Ultimate Product,Wedding_Cover. Flight Cancellation");
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
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Payment_page_iframe));
		driver.switchTo().frame(TC_obj.Payment_page_iframe);
		TC_obj.Card_Number_Field.sendKeys(cardnumber);
		TC_obj.Security_Number_CVV_Field.sendKeys(securityCVV);
		TC_obj.Card_Expiry_Month_dropdown.sendKeys("10");
		TC_obj.Card_Expiry_Year_dropdown.sendKeys("23");
		TC_obj.PayNow_Button.click();
		driver.switchTo().defaultContent();
//		wait.until(ExpectedConditions.visibilityOf(TC_obj.Payment_Success_Page_Title_1));
//		TC_obj.Payment_Success_Page_Title_1.getText();
//		TC_obj.Payment_Success_Page_Title_2.getText();
//		System.out.println(TC_obj.Payment_Success_Travel_Insurance_Policy_Number.getText());

	}

	@Test(priority = 8)
	public void Verify_Payment_Page_Successful_Message() {
		TC_WebElements TC_obj = new TC_WebElements(driver);

		
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Payment_Success_Page_Title_1));
		logger.info("Payment completed");
		Assert.assertEquals(TC_obj.Payment_Success_Page_Title_1.getText(), "Thank you");

		Assert.assertEquals(TC_obj.Payment_Success_Page_Title_2.getText(),
				"Your Travel Insurance is all set up. Enjoy your trip!");
		logger.info(TC_obj.Payment_Success_Page_Title_1.getText());
		logger.info(TC_obj.Payment_Success_Page_Title_2.getText());
		logger.info(TC_obj.Payment_Success_Travel_Insurance_Policy_Number.getText());
	}

}
