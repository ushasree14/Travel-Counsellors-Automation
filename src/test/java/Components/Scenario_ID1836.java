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

public class Scenario_ID1836 extends BaseClass {

	
	public Scenario_ID1836(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		/*
		 * WebDriverWait cookies = new WebDriverWait(driver, 20); try {
		 * System.out.println("clicked on Reject cookies");
		 * cookies.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "/html/body/div[2]/div/div/button[2]"))).click(); } catch (TimeoutException
		 * e) { System.out.println(e.toString()); }
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", TC_obj.RejectCookies);
	
		TC_obj.RejectCookies.click();
		logger.info("Rejected cookies");
		TC_obj.AnnualTrip.click();
		logger.info("Clicked Annual Trip");
		TC_obj.WWExc.click();
		
		WebDriverWait Tomorrow1 = new WebDriverWait(driver, 20);
		WebElement Tomorrow = Tomorrow1
				.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.OnePerson));
		TC_obj.OnePerson.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		  TC_obj.T1DOB.sendKeys(T1DOB);
		  TC_obj.T1DOB.sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		  logger.info("Scenario: A customer receives a Travel & Medical Certificate by email when purchasing");
		TC_obj.Continue.click();
			logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}


	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.illness_question));
		TC_obj.illness_question.click();
		TC_obj.symptoms_question.click();
		TC_obj.conditions_question.click();
		TC_obj.conditions_questionYes.click();
		TC_obj.waived_conditions.click();
		TC_obj.gdpr.click();
		TC_obj.treatment.click();
		TC_obj.diagnosis.click();

		Thread.sleep(3000);
		logger.info("Answered Traveler Journey Questions");
		TC_obj.ClickQuotePageforMedical.click();
		logger.info("Clicked on continue and will navigate to Quote Page");

	}

	@Test(priority = 3)
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1,  String Address_Line1, String city,
			String County, String PostCode) throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
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

	}

	@Test(priority = 4)
	public void Medical_Conditions(String med_conditionT1 ) throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		/*
		 * TC_obj.T3MedicalDecline.click(); Thread.sleep(3000);
		 */
		WebDriverWait wait = new WebDriverWait(driver, 90); 
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("arguments[0].scrollIntoView();", TC_obj.Medical_screening_Start_Button);
		 Thread.sleep(5000);
		// wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Start_Button));
		 TC_obj.Medical_screening_Start_Button.click(); 
		System.out.println("start button clicked");
	   
		 js.executeScript("window.scrollBy(0,-1000)");
	     Thread.sleep(3000);
	     wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Iframe));
		driver.switchTo().frame(TC_obj.Medical_screening_Iframe);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Search_Box));
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT1);
		Thread.sleep(2000);
		TC_obj.Medical_screening_Search_Button.click();
		TC_obj.Select_Medical_Condition.click();
		Thread.sleep(5000);
		TC_obj.SeizureNo.click();
		Thread.sleep(5000);
		TC_obj.consciousnessNo.click();
		Thread.sleep(2000);
		TC_obj.lastSixMonths.click();
		Thread.sleep(2000);
		TC_obj.lastTwelveMonths.click();
		Thread.sleep(2000);
		TC_obj.DifferentMedicines.click();
		TC_obj.FirstSeizure.click();
		TC_obj.Result.click();
		Thread.sleep(2000);
		TC_obj.MedicalScreeningContinue.click();
		Thread.sleep(2000);
		TC_obj.Finish.click();
		Thread.sleep(3000);
		/*
		 * //TC_obj.TCcontinue.click();
		 * TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT2);
		 * Thread.sleep(2000); TC_obj.Medical_screening_Search_Button.click();
		 * TC_obj.Select_Medical_Condition.click(); Thread.sleep(2000);
		 * TC_obj.Medical_Condition_Continue_Button.click();
		 * TC_obj.Medical_Condition_Finish_Button.click(); Thread.sleep(3000);
		 * TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT4);
		 * Thread.sleep(2000); TC_obj.Medical_screening_Search_Button.click();
		 * Thread.sleep(2000); TC_obj.Select_Medical_Condition.click();
		 * TC_obj.Medical_Condition_Continue_Button.click();
		 * TC_obj.Medical_Condition_Finish_Button.click();
		 */
		driver.switchTo().defaultContent();

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
	}

	@Test(priority = 7)
	public void Payment_Details(String cardnumber, String securityCVV) {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Payment_page_iframe));
		driver.switchTo().frame(TC_obj.Payment_page_iframe);
		 
		TC_obj.Card_Number_Field.sendKeys(cardnumber);
		TC_obj.Security_Number_CVV_Field.sendKeys(securityCVV);
		TC_obj.Card_Expiry_Month_dropdown.sendKeys("10");
		TC_obj.Card_Expiry_Year_dropdown.sendKeys("23");
		TC_obj.PayNow_Button.click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Payment_Success_Page_Title_1));
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
