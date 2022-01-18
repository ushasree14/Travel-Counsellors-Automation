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
import org.testng.annotations.Test;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1858 extends BaseClass {
	
	public Scenario_ID1858(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB, String T2DOB, String T3DOB, String T4DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		/*
		 * WebDriverWait cookies = new WebDriverWait(driver, 20); try {
		 * System.out.println("clicked on Accept cookies");
		 * cookies.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "/html/body/div[2]/div/div/button[1]"))).click(); } catch (TimeoutException
		 * e) { System.out.println(e.toString()); }
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
			//TC_obj.acceptCookies.click();
			logger.info("Accepted cookies");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		TC_obj.Europe.click();

		WebDriverWait Tomorrow1 = new WebDriverWait(driver, 40);
		WebElement Tomorrow = Tomorrow1.until(ExpectedConditions.visibilityOf(TC_obj.Tomorrow));
		Tomorrow.click();

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement fiveNights = wait.until(ExpectedConditions.visibilityOf(TC_obj.fiveNights));
		fiveNights.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Family));
		TC_obj.Family.click();
		TC_obj.FamilyFour.click();
		

		/*
		 * WebElement Groupthree =
		 * wait.until(ExpectedConditions.visibilityOf(TC_obj.Groupthree));
		 * Groupthree.click();
		 */
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
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T4DOB));
		TC_obj.T4DOB.sendKeys(T4DOB);
		TC_obj.T4DOB.sendKeys(Keys.TAB);

		logger.info("Scenario: As a customer I want to see the GDPR statement");
		TC_obj.Continue.click();
		logger.info("An administrator should be able to configure 3DS2 Secure Authentication V2 Configuration");

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
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String FN_Traveler2,
			String LN_Traveler2, String FN_Traveler3, String LN_Traveler3, String FN_Traveler4, String LN_Traveler4, String Address_Line1, String city,
			String County, String PostCode) throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
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
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Enter_address_manually_Link));
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

}
