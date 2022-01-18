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

public class Scenario_ID6106 extends BaseClass {

	public Scenario_ID6106(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)

	public void GetQuoteTest(String T1DOB,String T2DOB, String T3DOB, String T4D0B, String T5D0B) throws InterruptedException, IOException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TC_obj.acceptCookies);
		logger.info("Cookies Accepted");

		TC_obj.AnnualTrip.click();
		logger.info("Clicked AMT Trip");
		TC_obj.Europe.click();
		logger.info("Clicked Europe Trip");
		Thread.sleep(2000);
		TC_obj.Tomorrow.click();
		
		
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
		Thread.sleep(2000);
		TC_obj.T5DOB.sendKeys(T5D0B);
		TC_obj.T5DOB.sendKeys(Keys.TAB);
		
		
		TC_obj.GolfCover.click();
		logger.info("Golf Cover Selected");
		logger.info("Scenario: Verify user able to create T&M policy with SPF, AMT - U/W declined");
		TC_obj.Continue.click();
		logger.info("Clicked on continue and redirected to Pre existing Medical Questions");

	}

	@Test(priority = 2)
	public void PreExistingMedicalQuesTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
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
	public void Travel_details_fields_1(String FN_Traveler1, String LN_Traveler1,String FN_Traveler2, String LN_Traveler2,String FN_Traveler3, String LN_Traveler3, String FN_Traveler4, String LN_Traveler4, String FN_Traveler5, String LN_Traveler5, String Address_Line1, String city,
			String County, String PostCode) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		TC_WebElements TC_obj = new TC_WebElements(driver);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Traveller_Title1_Dropdown));
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
		TC_obj.Travel_Details_Continue_Button.click();
		logger.info("Answered Traveler Journey Questions");
	}

	@Test(priority = 4)
	public void Medical_Conditions(String med_conditionT1,String med_conditionT2) throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 90);
		Actions action=new Actions(driver);
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.disable_medical_conditions_travellers_3);
		TC_obj.disable_medical_conditions_travellers_3.click();
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.disable_medical_conditions_travellers_4);
		TC_obj.disable_medical_conditions_travellers_4.click();
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.disable_medical_conditions_travellers_5);
		TC_obj.disable_medical_conditions_travellers_5.click();
		
		logger.info("started medical screening journey");
		
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.Medical_screening_Start_Button);
		
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Start_Button));
		action.moveToElement(TC_obj.Medical_screening_Start_Button);
		TC_obj.Medical_screening_Start_Button.click();
		logger.info(" medical screening start button clicked");
		
		
//		Traveler 1 medical conditions
	//	js.executeScript("window.scrollTo(document.body.scrollHeight,100)");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Iframe));
		driver.switchTo().frame(TC_obj.Medical_screening_Iframe);
	
		action.moveToElement(TC_obj.Medical_screening_Search_Box);
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT1);
		logger.info("Traveller 1 Medical condition "+med_conditionT1);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Search_Button));
		action.moveToElement(TC_obj.Medical_screening_Search_Button);
		TC_obj.Medical_screening_Search_Button.click();
//		Smoker's cough option
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Select_Medical_Condition));
		action.moveToElement(TC_obj.Select_Medical_Condition);
		TC_obj.Select_Medical_Condition.click();
 
//		How many medicines are prescribed for your breathing condition (count each inhaler as one medicine)?
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_condition_option_4));
		action.moveToElement(TC_obj.Medical_condition_option_4);
		TC_obj.Medical_condition_option_4.click();//Six or more
		action.moveToElement(TC_obj.Medical_Condition_Continue_Button);
		TC_obj.Medical_Condition_Continue_Button.click();

//		How many hospital admissions have you had for your breathing condition in the last year?
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_condition_option_3));
		action.moveToElement(TC_obj.Medical_condition_option_3);
		TC_obj.Medical_condition_option_3.click();//Two or more
		action.moveToElement(TC_obj.Medical_Condition_Continue_Button);
		TC_obj.Medical_Condition_Continue_Button.click();
		
//		How short of breath do you get when you are walking on the flat?
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_condition_option_5));
		action.moveToElement(TC_obj.Medical_condition_option_5);
		TC_obj.Medical_condition_option_5.click();//I am unable to walk because of an unrelated medical problem
		action.moveToElement(TC_obj.Medical_Condition_Continue_Button);
		TC_obj.Medical_Condition_Continue_Button.click();
		
//		Have you ever been prescribed oxygen other than when you are in hospital?
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_condition_option_1));
		action.moveToElement(TC_obj.Medical_condition_option_1);
		TC_obj.Medical_condition_option_1.click();// Yes - within the last 12 months
		action.moveToElement(TC_obj.Medical_Condition_Continue_Button);
		TC_obj.Medical_Condition_Continue_Button.click();
		
//		Have you ever been a smoker?
		wait.until(ExpectedConditions.visibilityOf(TC_obj.SeizureNo));
		action.moveToElement(TC_obj.SeizureNo);
		TC_obj.SeizureNo.click();//Yes - still smoking
		action.moveToElement(TC_obj.Medical_Condition_Continue_Button);
		TC_obj.Medical_Condition_Continue_Button.click();
		
//		In the last year have you had a chest infection or an episode of pneumonia?
//		wait.until(ExpectedConditions.visibilityOf(TC_obj.SeizureNo));
		Thread.sleep(2000);
		action.moveToElement(TC_obj.Medical_condition_No_option);
		TC_obj.Medical_condition_No_option.click();//No

					
		wait.until(ExpectedConditions.elementToBeClickable(TC_obj.Medical_Condition_Continue_Button));
		action.moveToElement(TC_obj.Medical_Condition_Continue_Button);
		TC_obj.Medical_Condition_Continue_Button.click();
	
		Thread.sleep(2000);
		TC_obj.Medical_Condition_Continue_Button.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_Condition_Finish_Button));
		action.moveToElement(TC_obj.Medical_Condition_Finish_Button);
		TC_obj.Medical_Condition_Finish_Button.click();
		driver.switchTo().defaultContent();
		
//		Traveler 2 medical conditions
		
		js.executeScript("window.scrollTo(document.body.scrollHeight,100)");
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Iframe));
		driver.switchTo().frame(TC_obj.Medical_screening_Iframe);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Search_Box));
		js.executeScript("arguments[0].scrollIntoView();", TC_obj.Medical_screening_Search_Box);
		TC_obj.Medical_screening_Search_Box.sendKeys(med_conditionT2);
		logger.info("Traveller 2 Medical condition "+med_conditionT2);
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_screening_Search_Button));
		TC_obj.Medical_screening_Search_Button.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Select_Medical_Condition));
		TC_obj.Select_Medical_Condition.click();
		
		TC_obj.Medical_Condition_Continue_Button.click();
		wait.until(ExpectedConditions.visibilityOf(TC_obj.Medical_Condition_Finish_Button));
		TC_obj.Medical_Condition_Finish_Button.click();
		logger.info("Answered medical screening Questions");
			
		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.visibilityOf(TC_obj.Unable_to_offer_cover));
		action.moveToElement(TC_obj.Unable_to_offer_cover);
		logger.info(TC_obj.Unable_to_offer_cover.getText());
		Assert.assertEquals(TC_obj.Underwriter_Declined.getText(), "Underwriter Declined");
		
		logger.info(TC_obj.Underwriter_Declined.getText());
		
	}


}
