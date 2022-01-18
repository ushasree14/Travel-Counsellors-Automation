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

public class Scenario_ID1806 extends BaseClass {

	public Scenario_ID1806(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String StartDate, String EndDate, String T1DOB) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		TC_obj.SingleTrip.click();
		logger.info("Clicked Single Trip");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.WWExc));
		TC_obj.WWExc.click();
		Thread.sleep(5000);
		 wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectStartDate));
		  TC_obj.SelectStartDate.click();
		 
		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.StartDate))).click();
		TC_obj.StartDate.clear();
		Thread.sleep(5000);
		TC_obj.StartDate.sendKeys(StartDate);
		Thread.sleep(5000);
		TC_obj.StartDate.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SelectEndDate));
		TC_obj.SelectEndDate.click();
		wait.until(ExpectedConditions.elementToBeClickable((TC_obj.EndDate))).click();
		TC_obj.EndDate.clear();
		Thread.sleep(2000);
		TC_obj.EndDate.sendKeys(EndDate);
		TC_obj.EndDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.OnePerson));
		TC_obj.OnePerson.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.T1DOB));
		TC_obj.T1DOB.sendKeys(T1DOB);
		TC_obj.T1DOB.sendKeys(Keys.TAB);

		logger.info("Scenario: A user can see the Medical Screening system (Verisk)");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}


	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
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
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1, String Address_Line1, String city,
			String County, String PostCode) throws InterruptedException {

		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		logger.info("Clicked on continue and will navigate to Medical Screening Details Page");

	}

	@Test(priority = 4)
	public void Medical_Conditions(String med_conditionT1) throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Start_Button));

		TC_obj.Medical_screening_Start_Button.click();
		Thread.sleep(3000);
		driver.switchTo().frame(TC_obj.Medical_screening_Iframe);
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT1);
		Thread.sleep(2000);
		TC_obj.Medical_screening_Search_Button.click();
		TC_obj.Select_Medical_Condition.click();
		TC_obj.Medical_Condition_Continue_Button.click();
		TC_obj.Medical_Condition_Finish_Button.click();
		Thread.sleep(3000);
		// driver.switchTo().frame(TC_obj.Medical_screening_Iframe);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		logger.info("Completed Medical Screening Details Page");

	}

}
