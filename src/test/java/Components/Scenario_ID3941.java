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

public class Scenario_ID3941 extends BaseClass {

	public Scenario_ID3941(WebDriver driver) {
		this.driver = driver;
	}

	//started
	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB, String T2DOB, String T3DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.or(
		 * ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//button[@type='submit' and contains(text(),'Accept')]"))));
		 */
			
		/*
		 * WebDriverWait cookies = new WebDriverWait(driver, 20); try {
		 * System.out.println("clicked on Accept cookies");
		 * cookies.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//button[@type='submit' and contains(text(),'Accept')]"))).click(); }
		 * catch (TimeoutException e) { System.out.println(e.toString()); }
		 */
			
		/*
		 * TC_obj.acceptCookies.click(); logger.info("Accepted cookies");
		 * Thread.sleep(5000);
		 */
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.Europe.click();

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement Tomorrow = wait.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();

	
		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		fiveNights.click();

		TC_obj.Group.click();

		WebElement Groupthree = wait.until(ExpectedConditions.visibilityOf(TC_obj.Groupthree));
		Groupthree.click();

		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);
		TC_obj.T2DOB.sendKeys(T2DOB);
		TC_obj.T2DOB.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		TC_obj.T3DOB.sendKeys(T3DOB);
		TC_obj.T3DOB.sendKeys(Keys.TAB);

		logger.info("Scenario: Verify user able to create T&M policy with Group, ST : Accept Cookies, Auz, ST, Group(3),  T&M - T1 & T3, Classic,  Business Cover");
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
		logger.info("Answered Traveler Journey Questions");
		TC_obj.ClickQuotePageforMedical.click();
		logger.info("Clicked on continue and will navigate to Quote Page");

	}

	@Test(priority = 3)
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String FN_Traveler2,
			String LN_Traveler2, String FN_Traveler3, String LN_Traveler3, String Address_Line1, String city,
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
	public void Medical_Conditions(String med_conditionT1, String med_conditionT2, String med_conditionT3)
			throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T2MedicalDecline));
		TC_obj.T2MedicalDecline.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Start_Button));
		TC_obj.Medical_screening_Start_Button.click();
		Thread.sleep(3000);
		
	
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
		// driver.switchTo().frame(TC_obj.Medical_screening_Iframe);
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT3);
		Thread.sleep(2000);
		TC_obj.Medical_screening_Search_Button.click();
		TC_obj.Select_Medical_Condition.click();
		TC_obj.Medical_Condition_Continue_Button.click();
		TC_obj.Medical_Condition_Finish_Button.click();

		driver.switchTo().defaultContent();

	}

	@Test(priority = 5)
	public void QuotePageTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		TC_WebElements TC_obj = new TC_WebElements(driver);
		TC_obj.Classic.click();
		TC_obj.BusinessCover.click();
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
