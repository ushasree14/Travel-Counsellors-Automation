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

public class Scenario_ID3986 extends BaseClass {
	
	public Scenario_ID3986(WebDriver driver) {
		this.driver = driver;
		
	}


	@Test(priority = 1)

	public void GetQuoteTest(String StartDate, String EndDate, String T1DOB, String T2DOB, String T3DOB, String T4D0B, String T5D0B) throws InterruptedException, IOException {
TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.WWExc.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectStartDate));
		TC_obj.SelectStartDate.click();

		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.StartDate))).click();
		TC_obj.StartDate.clear();
		TC_obj.StartDate.sendKeys(StartDate);
		TC_obj.StartDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectEndDate));
		TC_obj.SelectEndDate.click();
		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.EndDate))).click();
		TC_obj.EndDate.clear();
		TC_obj.EndDate.sendKeys(EndDate);
		TC_obj.EndDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SPF));
		TC_obj.SPF.click();

		  WebElement Groupfive =
		  wait.until(ExpectedConditions.visibilityOf(TC_obj.Groupfive));
		  Groupfive.click();
		  wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T2DOB));
		TC_obj.T2DOB.sendKeys(T2DOB);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T3DOB));
		TC_obj.T3DOB.sendKeys(T3DOB);
		TC_obj.T3DOB.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T4DOB));
		TC_obj.T4DOB.sendKeys(T4D0B);
		TC_obj.T4DOB.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T5DOB));
		TC_obj.T5DOB.sendKeys(T5D0B);
		TC_obj.T5DOB.sendKeys(Keys.TAB);
		
		Thread.sleep(5000);
		
		TC_obj.GolfCover.click();

		logger.info("Scenario: Verify user able to create Travel policy with SPF, ST");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}


	@Test
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

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

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.Classic.click();
		logger.info("Clicked on Premier Product");
		Thread.sleep(3000);
		TC_obj.Special_Sports_table_C.click();
		logger.info("Clicked on Special_Sports_table_C Cover");
		Thread.sleep(3000);
		TC_obj.clickedContinue.click();
		logger.info("Clicked on continue and will navigate to Traveler Details Page");

	}

	@Test(priority = 3)
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String FN_Traveler2,
			String LN_Traveler2, String FN_Traveler3, String LN_Traveler3, String FN_Traveler4, String LN_Traveler4, String FN_Traveler5, String LN_Traveler5, String Address_Line1, String city,
			String County, String PostCode, String Phonenumber, String Email) throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Traveller_Title1_Dropdown));
		TC_obj.Traveller_Title1_Dropdown.click();
		TC_obj.Title1_option.click();

		TC_obj.FN_Traveler1.sendKeys(FN_Traveler1);
		TC_obj.LN_Traveler1.sendKeys(LN_Traveler1);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Traveller_Title2_Dropdown));
		TC_obj.Traveller_Title2_Dropdown.click();
		TC_obj.Title2_option.click();

		TC_obj.FN_Traveler2.sendKeys(FN_Traveler2);
		TC_obj.LN_Traveler2.sendKeys(LN_Traveler2);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Traveller_Title3_Dropdown));
		TC_obj.Traveller_Title3_Dropdown.click();
		TC_obj.Title3_option.click();

		TC_obj.FN_Traveler3.sendKeys(FN_Traveler3);
		TC_obj.LN_Traveler3.sendKeys(LN_Traveler3);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Traveller_Title4_Dropdown));
		TC_obj.Traveller_Title4_Dropdown.click();
		TC_obj.Title4_option.click();

		TC_obj.FN_Traveler4.sendKeys(FN_Traveler4);
		TC_obj.LN_Traveler4.sendKeys(LN_Traveler4);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Traveller_Title5_Dropdown));
		TC_obj.Traveller_Title5_Dropdown.click();
		TC_obj.Title5_option.click();

		TC_obj.FN_Traveler5.sendKeys(FN_Traveler5);
		TC_obj.LN_Traveler5.sendKeys(LN_Traveler5);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Enter_address_manually_Link));
		TC_obj.Enter_address_manually_Link.click();
		TC_obj.Address_Line_1_Field.sendKeys(Address_Line1);
		TC_obj.City_Town_Field.sendKeys(city);
		TC_obj.County_Field.sendKeys(County);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Country_Dropdown));
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
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement iframe = wait.until(ExpectedConditions.visibilityOf(TC_obj.Payment_page_iframe));
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
