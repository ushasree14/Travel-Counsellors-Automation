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

public class Scenario_ID3972 extends BaseClass {
	
	public Scenario_ID3972(WebDriver driver) {
		this.driver = driver;
	}

	public void GetQuoteTest(String T1DOB, String T2DOB, String T3DOB, String T4DOB, String T5DOB, String T6DOB, String T7DOB, String T8DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.AnnualTrip.click();
		logger.info("Clicked Annual Trip");
		TC_obj.WWInc.click();
		TC_obj.Today.click();
		TC_obj.Group.click();
		Thread.sleep(5000);
		TC_obj.Groupeight.click();
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		TC_obj.T2DOB.sendKeys(T2DOB);
		Thread.sleep(2000);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		TC_obj.T3DOB.sendKeys(T3DOB);
		TC_obj.T3DOB.sendKeys(Keys.TAB);
		TC_obj.T4DOB.sendKeys(T4DOB);
		TC_obj.T4DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		TC_obj.T5DOB.sendKeys(T5DOB);
		TC_obj.T5DOB.sendKeys(Keys.TAB);
		TC_obj.T6DOB.sendKeys(T6DOB);
		TC_obj.T6DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		TC_obj.T7DOB.sendKeys(T7DOB);
		TC_obj.T7DOB.sendKeys(Keys.TAB);
		TC_obj.T8DOB.sendKeys(T8DOB);
		TC_obj.T8DOB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		logger.info(
				"Verify user able to create Travel policy with Group, AMT:Accept Cookies,WWInc., Group(8),Travel Only, Ultimate, Business Cover");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}
	
	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.Ultimate.click();
		logger.info("Clicked on Premier Product");
		Thread.sleep(3000);
		TC_obj.BusinessCover.click();
		logger.info("Clicked on Business Cover");
		Thread.sleep(3000);
		TC_obj.clickedContinue.click();
		logger.info("Clicked on continue and will navigate to Traveler Details Page");

	}
	
	
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1,String FN_Traveler2,
			String LN_Traveler2, String FN_Traveler3, String LN_Traveler3, String FN_Traveler4, String LN_Traveler4,
			String FN_Traveler5, String LN_Traveler5, String FN_Traveler6, String LN_Traveler6, String FN_Traveler7,
			String LN_Traveler7, String FN_Traveler8, String LN_Traveler8,  String Address_Line1, String city,
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
		
		TC_obj.Traveller_Title3_Dropdown.click();
		TC_obj.Title3_option.click();
		TC_obj.FN_Traveler3.sendKeys(FN_Traveler3);
		TC_obj.LN_Traveler3.sendKeys(LN_Traveler3);
		
		TC_obj.Traveller_Title4_Dropdown.click();
		TC_obj.Title4_option.click();
		TC_obj.FN_Traveler4.sendKeys(FN_Traveler4);
		TC_obj.LN_Traveler4.sendKeys(LN_Traveler4);
		Thread.sleep(3000);
		
		TC_obj.Traveller_Title5_Dropdown.click();
		TC_obj.Title5_option.click();
		TC_obj.FN_Traveler5.sendKeys(FN_Traveler5);
		TC_obj.LN_Traveler5.sendKeys(LN_Traveler5);
		
		TC_obj.Traveller_Title6_Dropdown.click();
		TC_obj.Title6_option.click();
		TC_obj.FN_Traveler6.sendKeys(FN_Traveler6);
		TC_obj.LN_Traveler6.sendKeys(LN_Traveler6);
		Thread.sleep(3000);
		
		TC_obj.Traveller_Title7_Dropdown.click();
		TC_obj.Title7_option.click();
		TC_obj.FN_Traveler7.sendKeys(FN_Traveler7);
		TC_obj.LN_Traveler7.sendKeys(LN_Traveler7);
		
		TC_obj.Traveller_Title8_Dropdown.click();
		TC_obj.Title8_option.click();
		TC_obj.FN_Traveler8.sendKeys(FN_Traveler8);
		TC_obj.LN_Traveler8.sendKeys(LN_Traveler8);
		Thread.sleep(2000);
		
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
	}
	
	
	
	public void Payment_Details(String cardnumber, String securityCVV) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TC_WebElements TC_obj = new TC_WebElements(driver);
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
	
	@Test(priority = 9)
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
