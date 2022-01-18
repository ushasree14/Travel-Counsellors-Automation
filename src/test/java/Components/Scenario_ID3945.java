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

public class Scenario_ID3945 extends BaseClass {
	
	public Scenario_ID3945(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB, String T2DOB, String T3DOB, String T4DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.AnnualTrip.click();
		logger.info("Clicked Annual Trip");
		
		TC_obj.WWExc.click();
		
		WebDriverWait Tomorrow1 = new WebDriverWait(driver, 20);
		WebElement Tomorrow = Tomorrow1
				.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();
		
		TC_obj.Group.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Groupfour = wait
				.until(ExpectedConditions.visibilityOf(TC_obj.Groupfour));
		Groupfour.click();
		
		  TC_obj.T1DOB.sendKeys(T1DOB);
		  TC_obj.T1DOB.sendKeys(Keys.TAB);
		  TC_obj.T2DOB.sendKeys(T2DOB);
		  TC_obj.T2DOB.sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		  TC_obj.T3DOB.sendKeys(T3DOB);
		  TC_obj.T3DOB.sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		  TC_obj.T4DOB.sendKeys(T4DOB);
		  TC_obj.T4DOB.sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		  logger.info("Scenario: Verify user able to create T&M policy with Group, AMT: Rejected Cookies, WWExc. AMT, Group(4), T&M - T1,T2 & T4, Ultimate,Excess Cover");
		TC_obj.Continue.click();
			logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}


	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.illness_question.click();
		TC_obj.symptoms_question.click();
		TC_obj.conditions_question.click();
		TC_obj.conditions_questionYes.click();
		TC_obj.waived_conditions.click();
		TC_obj.gdpr.click();
		TC_obj.treatment.click();
		TC_obj.diagnosis.click();

		Thread.sleep(3000);
		TC_obj.ClickQuotePageforMedical.click();
		logger.info("Clicked on continue and will navigate to Quote Page");

	}

	@Test(priority = 3)
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String FN_Traveler2, String LN_Traveler2, String FN_Traveler3, String LN_Traveler3, String FN_Traveler4, String LN_Traveler4, String Address_Line1, String city,
			String County, String PostCode) throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
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
		
		TC_obj.Enter_address_manually_Link.click();
		TC_obj.Address_Line_1_Field.sendKeys(Address_Line1);
		TC_obj.City_Town_Field.sendKeys(city);
		TC_obj.County_Field.sendKeys(County);

		Select Country = new Select(TC_obj.Country_Dropdown);
		Country.selectByValue("united-kingdom-gbr");
		Thread.sleep(2000);
		TC_obj.Postcode_Field.sendKeys(PostCode);
		TC_obj.Travel_Details_Continue_Button.click();
		
		logger.info("Answered Traveler details");

	}

	@Test(priority = 4)
	public void Medical_Conditions(String med_conditionT1, String med_conditionT2,String med_conditionT3, String med_conditionT4 ) throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		logger.info("Entered Medical conditions");
		
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T3MedicalDecline)).click();
		logger.info("T3 Medical Declined");
		
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
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Select_Medical_Condition));
		TC_obj.Select_Medical_Condition.click();
		logger.info("Select_Medical_Condition");
		Thread.sleep(3000);
		
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
		Thread.sleep(3000);
		
		//TC_obj.TCcontinue.click();
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT2);
		Thread.sleep(2000);
		
		TC_obj.Medical_screening_Search_Button.click();
		TC_obj.Select_Medical_Condition.click();
		Thread.sleep(2000);
		
		TC_obj.Medical_Condition_Continue_Button.click();
		logger.info("Medical_Condition_Continue_Button");
		
		TC_obj.Medical_Condition_Finish_Button.click();
		logger.info("Medical_Condition_Finish_Button");
		Thread.sleep(3000);
		
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT4);
		logger.info("Medical_screening_Search_Box");
		Thread.sleep(2000);
		
		TC_obj.Medical_screening_Search_Button.click();
		logger.info("Medical_screening_Search_Button");
		Thread.sleep(2000);
		
		TC_obj.Select_Medical_Condition.click();
		logger.info("Select_Medical_Condition");
		
		TC_obj.Medical_Condition_Continue_Button.click();
		logger.info("Medical_Condition_Continue_Button");
		
		TC_obj.Medical_Condition_Finish_Button.click();
		logger.info("Medical_Condition_Finish_Button");
		driver.switchTo().defaultContent();
		
		logger.info("Completed Medical Screening Journey Questions");

	}

	@Test(priority = 5)
	public void QuotePageTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.Ultimate.click();
		TC_obj.ExcessCover.click();
		logger.info("Clicked on Classic Product");
		TC_obj.clickedContinue.click();
		logger.info("Clicked on continue and will navigate to Traveler Details Page");
	}

	@Test(priority = 6)
	public void Travel_details_fields_2(String Phonenumber, String Email) {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		TC_obj.mobile.sendKeys(Phonenumber);
		TC_obj.email.sendKeys(Email);
		TC_obj.termsandconditions.click();
		TC_obj.Travel_Details_Continue_Button.click();
		logger.info("Accepted Terms and conditions");
		logger.info("Started Payment Details");
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
