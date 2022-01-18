package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.BaseClass;

public class TC_WebElements extends BaseClass {

	public TC_WebElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// GetQuote Page Webelements
	
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Accept')]")
	@CacheLookup
	public WebElement acceptCookies;
	

	@FindBy(xpath = "//button[contains(text(),'Reject')]")
	@CacheLookup
	public WebElement RejectCookies;
	
	@FindBy(xpath = "//*[@id='Answer_1' and @name='AnswerNum']")
	@CacheLookup
	public WebElement recovered;
	

	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/aside/div/div/div/div[2]/div[2]/a[1]")
	@CacheLookup
	public WebElement PolicyDocumentation;
	
	@FindBy(xpath = "//a[contains(text(),'Terms of Business (PDF, 40.1KB)')]")
	@CacheLookup
	public WebElement TermsOfBusiness;
	
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/main/div/div/div/ul/li/a")
	public List<WebElement> Policy_Documentation_All_links;

	@FindBy(xpath = "/html/body/footer/div/div/div/div/div/p[1]")
	@CacheLookup
	public WebElement Footer1;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[1]/div/div/div[2]/div[1]/label")
	@CacheLookup
	public WebElement SingleTrip;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[1]/div/div/div[2]/div[2]/label")
	@CacheLookup
	public WebElement AnnualTrip;
	@FindBy(xpath = "//span[contains(text(),'Europe')]")
	@CacheLookup
	public WebElement Europe;
	
	@FindBy(xpath = "//span[contains(text(),'Australia and New Zealand')]")
	@CacheLookup
	public WebElement Auz;
	
	@FindBy(xpath = "//span[contains(text(),'UK')]")
	@CacheLookup
	public WebElement UK;
	
	
	@FindBy(xpath = "//span[contains(text(),'Worldwide Excluding USA Canada Caribbean & Mexico')]")
	@CacheLookup
	public WebElement WWExc;
	
	@FindBy(xpath = "//span[contains(text(),'Worldwide including USA Canada Caribbean & Mexico')]")
	@CacheLookup
	public WebElement WWInc;
	
	

	@FindBy(xpath = "//span[contains(text(),'Today')]")
	@CacheLookup
	public WebElement Today;
	
	@FindBy(xpath = "//span[contains(text(),'Tomorrow')]")
	@CacheLookup
	public WebElement Tomorrow;

	@FindBy(xpath = "//span[contains(text(),'5 nights')]")
	@CacheLookup
	public WebElement fiveNights;
	
	@FindBy(xpath = "//span[contains(text(),'7 nights')]")
	@CacheLookup
	public WebElement SevenNights;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[4]/div/div/div[2]/div[3]/label")
	@CacheLookup
	public WebElement SelectStartDate;
	
	
	
	@FindBy(xpath = "//*[@id='pika-title-bj']/div[2]/select/option[2]")
	@CacheLookup
	public WebElement SelectCalYear;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[5]/div/div/div/div[2]/div[3]/label/span[2]")
	@CacheLookup
	public WebElement SelectEndDate;
	
	@FindBy(xpath = "//input[@id='manual_starts_at']")
	@CacheLookup
	public WebElement StartDate;
	
	@FindBy(xpath = "//input[@id='manual_ends_at']")
	@CacheLookup
	public WebElement EndDate;
	
	
	
	

	@FindBy(xpath = "//span[contains(text(),'One person')]")
	@CacheLookup
	public WebElement OnePerson;
	
	@FindBy(xpath = "//span[contains(text(),'A couple')]")
	@CacheLookup
	public WebElement Couple;
	
	@FindBy(xpath = "//span[contains(text(),'A single parent family')]")
	@CacheLookup
	public WebElement SPF;
	
	@FindBy(xpath = "//span[contains(text(),'A family')]")
	@CacheLookup
	public WebElement Family;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[3]")
	@CacheLookup
	public WebElement FamilyFour;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[4]")
	@CacheLookup
	public WebElement FamilyFive;
	
	@FindBy(xpath = "//span[contains(text(),'A group')]")
	@CacheLookup
	public WebElement Group;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[3]")
	@CacheLookup
	public WebElement Groupthree;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[4]")
	@CacheLookup
	public WebElement Groupfour;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[5]")
	@CacheLookup
	public WebElement Groupfive;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[6]")
	@CacheLookup
	public WebElement Groupsix;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[7]")
	@CacheLookup
	public WebElement Groupseven;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[8]")
	@CacheLookup
	public WebElement Groupeight;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[9]")
	@CacheLookup
	public WebElement Groupnine;
	
	@FindBy(xpath = "//*[@id='number_of_travellers']/option[10]")
	@CacheLookup
	public WebElement Groupten;
	
	@FindBy(xpath = "//input[@id='traveller_dob_1']")
	@CacheLookup
	public WebElement T1DOB;
	
	@FindBy(xpath = "//input[@id='traveller_dob_2']")
	@CacheLookup
	public WebElement T2DOB;
	
	@FindBy(xpath = "//input[@id='traveller_dob_3']")
	@CacheLookup
	public WebElement T3DOB;
	
	@FindBy(xpath = "//input[@id='traveller_dob_4']")
	@CacheLookup
	public WebElement T4DOB;
	
	@FindBy(xpath = "//input[@id='traveller_dob_5']")
	@CacheLookup
	public WebElement T5DOB;
	
	@FindBy(xpath = "//input[@id='traveller_dob_6']")
	@CacheLookup
	public WebElement T6DOB;
	
	@FindBy(xpath = "//input[@id='traveller_dob_7']")
	@CacheLookup
	public WebElement T7DOB;
	@FindBy(xpath = "//input[@id='traveller_dob_8']")
	@CacheLookup
	public WebElement T8DOB;
	@FindBy(xpath = "//input[@id='traveller_dob_9']")
	@CacheLookup
	public WebElement T9DOB;
	@FindBy(xpath = "//input[@id='traveller_dob_10']")
	@CacheLookup
	public WebElement T10DOB;


	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]/*[1]")
	@CacheLookup
	public WebElement Calendar;

	@FindBy(css = ".pika-select.pika-select-month")
	@CacheLookup
	public WebElement SelectMonth;

	@FindBy(xpath = "//option[contains(text(),'July')]")
	@CacheLookup
	public WebElement Month;

	@FindBy(css = ".pika-select.pika-select-year")
	@CacheLookup
	public WebElement SelectYear;

	@FindBy(xpath = "//option[contains(text(),'1990')]")
	@CacheLookup
	public WebElement Year;

	@FindBy(xpath = "//tbody/tr[2]/td[4]")
	@CacheLookup
	public WebElement SelectDate;

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/div[1]/form[1]/div[6]/ul[1]/li[1]/div[1]/div[2]/button[1]")
	@CacheLookup
	public WebElement WSCover;

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/div[1]/form[1]/div[6]/ul[1]/li[2]/div[1]/div[2]/button[1]")
	@CacheLookup
	public WebElement CruiseCover;

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/div[1]/form[1]/div[6]/ul[1]/li[3]/div[1]/div[2]/button[1]")
	@CacheLookup
	public WebElement GolfCover;

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/div[1]/form[1]/button[1]")
	@CacheLookup
	public WebElement Continue;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/fieldset/div/div/p")
	@CacheLookup
	public WebElement Invalid_TDOB_Error_message;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[5]/div/div/p")
	@CacheLookup
	public WebElement Invalid_EndDate_Error_message;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/fieldset/div/div/p")
	@CacheLookup
	public WebElement Invalid_Couple_TDOB_Error_message;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/fieldset/div/div/p")
	@CacheLookup
	public WebElement Invalid_AMT_Individual_TDOB_Error_message;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/fieldset/div/div/p")
	@CacheLookup
	public WebElement Invalid_ST_Family_TDOB_Error_message;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/fieldset/div/div/p")
	@CacheLookup
	public WebElement Invalid_SPF_TDOB_Error_message;
	
	
	
	// Medical Questions

	
	@FindBy(xpath = "//input[@name='party-has-terminal-illness-question' and @value='false']")
	@CacheLookup
	public WebElement illness_question;

	@FindBy(xpath = "//input[@name='party-has-unexplained-symptoms-question' and @value='false']")
	@CacheLookup
	public WebElement symptoms_question;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div/div/label[1]/input")
	@CacheLookup
	public WebElement illness_question_yes;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[2]/div/div[2]")
	@CacheLookup
	public WebElement illness_question_yes_error_message;
	

	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[2]/div/div[2]/label[1]/input")
	@CacheLookup
	public WebElement symptoms_question_yes;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[3]")
	@CacheLookup
	public WebElement symptoms_question_yes_error_message;

	
	
	@FindBy(xpath = "//input[@name='preexisting-medical-conditions-question' and @value='false']")
	@CacheLookup
	public WebElement conditions_question;

	@FindBy(xpath = "//input[@name='preexisting-medical-conditions-question' and @value='true']")
	@CacheLookup
	public WebElement conditions_questionYes;

	@FindBy(xpath = "//input[@name='party-has-waived-conditions-question' and @value='false']")
	@CacheLookup
	public WebElement waived_conditions;

	@FindBy(xpath = "//input[@name='gdpr-acceptance' and @value='true']")
	@CacheLookup
	public WebElement gdpr;
	@FindBy(xpath = "//input[@name='gdpr-acceptance' and @value='false']")
	@CacheLookup
	public WebElement gdpr_No;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[5]/div/div[3]/div[1]/div/div[2]/div")
	@CacheLookup
	public WebElement gdpr_No_error_message;
	
	
	
	
	@FindBy(xpath = "//input[@name='pre-existing-conditions-treatment-clarification-question' and @value='true']")
	@CacheLookup
	public WebElement treatment;

	@FindBy(xpath = "//input[@name='pre-existing-conditions-diagnosis-clarification-question' and @value='true']")
	@CacheLookup
	public WebElement diagnosis;

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/div[1]/form[1]/div[4]/button[1]")
	@CacheLookup
	public WebElement ClickQuotePage;

	@FindBy(xpath = "//a[contains(text(),'Policy Wording')]")
	@CacheLookup
	public WebElement PreExistingPolicyWording;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/form/div[7]/button")
	@CacheLookup
	public WebElement ClickQuotePageforMedical;

	// Traveller Details Webelements

	@FindBy(xpath = "//select[@id='traveller-title-1']")
	@CacheLookup
	public WebElement Traveller_Title1_Dropdown;
	
	@FindBy(xpath = "//option[@value='Miss']")
	@CacheLookup
	public WebElement Title1_option;
	
	@FindBy(xpath = "//select[@id='traveller-title-2']")
	@CacheLookup
	public WebElement Traveller_Title2_Dropdown;
	
	@FindBy(xpath = "//*[@id='traveller-title-2']/option[4]")
	@CacheLookup
	public WebElement Title2_option;
	
	@FindBy(xpath = "//select[@id='traveller-title-3']")
	@CacheLookup
	public WebElement Traveller_Title3_Dropdown;
	@FindBy(xpath = "//*[@id='traveller-title-3']/option[4]")
	@CacheLookup
	public WebElement Title3_option;
	
	@FindBy(xpath = "//*[@id='traveller-title-4']")
	@CacheLookup
	public WebElement Traveller_Title4_Dropdown;
	@FindBy(xpath = "//*[@id='traveller-title-4']/option[4]")
	@CacheLookup
	public WebElement Title4_option;
	
	
	
	@FindBy(xpath = "//select[@id='traveller-title-5']")
	@CacheLookup
	public WebElement Traveller_Title5_Dropdown;

	@FindBy(xpath = "//*[@id='traveller-title-5']/option[4]")
	@CacheLookup
	public WebElement Title5_option;
	
	@FindBy(xpath = "//select[@id='traveller-title-6']")
	@CacheLookup
	public WebElement Traveller_Title6_Dropdown;
	@FindBy(xpath = "//*[@id='traveller-title-6']/option[4]")
	@CacheLookup
	public WebElement Title6_option;
	
	@FindBy(xpath = "//select[@id='traveller-title-7']")
	@CacheLookup
	public WebElement Traveller_Title7_Dropdown;
	@FindBy(xpath = "//*[@id='traveller-title-7']/option[4]")
	@CacheLookup
	public WebElement Title7_option;
	
	@FindBy(xpath = "//select[@id='traveller-title-8']")
	@CacheLookup
	public WebElement Traveller_Title8_Dropdown;
	@FindBy(xpath = "//*[@id='traveller-title-8']/option[4]")
	@CacheLookup
	public WebElement Title8_option;
	
	@FindBy(xpath = "//select[@id='traveller-title-9']")
	@CacheLookup
	public WebElement Traveller_Title9_Dropdown;
	@FindBy(xpath = "//*[@id='traveller-title-9']/option[4]")
	@CacheLookup
	public WebElement Title9_option;
	
	@FindBy(xpath = "//select[@id='traveller-title-10']")
	@CacheLookup
	public WebElement Traveller_Title10_Dropdown;
	@FindBy(xpath = "//*[@id='traveller-title-10']/option[4]")
	@CacheLookup
	public WebElement Title10_option;
	
	

	@FindBy(xpath = "//input[@id='traveller-first-name-1']")
	@CacheLookup
	public WebElement FN_Traveler1;

	@FindBy(xpath = "//input[@id='traveller-last-name-1']")
	@CacheLookup
	public WebElement LN_Traveler1;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-2']")
	@CacheLookup
	public WebElement FN_Traveler2;

	@FindBy(xpath = "//input[@id='traveller-last-name-2']")
	@CacheLookup
	public WebElement LN_Traveler2;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-3']")
	@CacheLookup
	public WebElement FN_Traveler3;

	@FindBy(xpath = "//input[@id='traveller-last-name-3']")
	@CacheLookup
	public WebElement LN_Traveler3;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-4']")
	@CacheLookup
	public WebElement FN_Traveler4;

	@FindBy(xpath = "//input[@id='traveller-last-name-4']")
	@CacheLookup
	public WebElement LN_Traveler4;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-5']")
	@CacheLookup
	public WebElement FN_Traveler5;

	@FindBy(xpath = "//input[@id='traveller-last-name-5']")
	@CacheLookup
	public WebElement LN_Traveler5;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-6']")
	@CacheLookup
	public WebElement FN_Traveler6;

	@FindBy(xpath = "//input[@id='traveller-last-name-6']")
	@CacheLookup
	public WebElement LN_Traveler6;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-7']")
	@CacheLookup
	public WebElement FN_Traveler7;

	@FindBy(xpath = "//input[@id='traveller-last-name-7']")
	@CacheLookup
	public WebElement LN_Traveler7;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-8']")
	@CacheLookup
	public WebElement FN_Traveler8;

	@FindBy(xpath = "//input[@id='traveller-last-name-8']")
	@CacheLookup
	public WebElement LN_Traveler8;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-9']")
	@CacheLookup
	public WebElement FN_Traveler9;

	@FindBy(xpath = "//input[@id='traveller-last-name-9']")
	@CacheLookup
	public WebElement LN_Traveler9;
	
	@FindBy(xpath = "//input[@id='traveller-first-name-10']")
	@CacheLookup
	public WebElement FN_Traveler10;

	@FindBy(xpath = "//input[@id='traveller-last-name-10']")
	@CacheLookup
	public WebElement LN_Traveler10;

	@FindBy(xpath = "//input[@id='postcode-lookup']")
	@CacheLookup
	public WebElement postCode;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	@CacheLookup
	public WebElement SearchBar;

	@FindBy(xpath = "//select[@id='postcode-lookup-addresses']")
	@CacheLookup
	public WebElement postcodeaddress;
	
	@FindBy(xpath = "//button[normalize-space()='Enter address manually']")
	@CacheLookup
	public WebElement Enter_address_manually_Link;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/main[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
	@CacheLookup
	public WebElement Address_Line_1_Field;
	@FindBy(xpath = "//input[@id='address-city']")
	@CacheLookup
	public WebElement City_Town_Field;
	@FindBy(xpath = "//input[@id='address-county']")
	@CacheLookup
	public WebElement County_Field;
	@FindBy(xpath = "//select[@id='address-country']")
	@CacheLookup
	public WebElement Country_Dropdown;
	@FindBy(xpath = "//input[@id='address-postcode']")
	@CacheLookup
	public WebElement Postcode_Field;

	@FindBy(xpath = "//option[@value='14481300.00']")
	@CacheLookup
	public WebElement address;

	@FindBy(xpath = "//input[@id='policy-holder-telephone']")
	@CacheLookup
	public WebElement mobile;

	@FindBy(xpath = "//input[@id='policy-holder-email-address']")
	@CacheLookup
	public WebElement email;

	@FindBy(xpath = "//input[@id='address-county']")
	@CacheLookup
	public WebElement county;

	@FindBy(xpath = "//input[@id='terms-and-conditions-acceptance']")
	@CacheLookup
	public WebElement termsandconditions;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	@CacheLookup
	public WebElement Travel_Details_Continue_Button;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/main/form/div/div[5]/div/div")
	@CacheLookup
	public WebElement Travel_Details_Fields_Error_Messages_List;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/main/form/div/div[3]/div[2]/div/div[1]/div/div/p")
	@CacheLookup
	public WebElement Travel_Details_Mobile_Field_Error_Message;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/h1")
	@CacheLookup
	public WebElement Travel_Details_Page_Heading;
	
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/div[1]/div[1]/dl/div[2]/dd/button")
	@CacheLookup
	public WebElement T2MedicalDecline;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/div[1]/div[1]/dl/div[3]/dd/button")
	@CacheLookup
	public WebElement T3MedicalDecline;
	
	

	@FindBy(xpath = "//button[normalize-space()='Start']")
	public WebElement Medical_screening_Start_Button;

	@FindBy(xpath = "//iframe[@class='h-full w-full']")
	public WebElement Medical_screening_Iframe;

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ConditionText']")
	public WebElement Medical_screening_Search_Box;

	@FindBy(xpath = "//*[@id='search']")
	public WebElement Medical_screening_Search_Button;

	@FindBy(xpath = "//*[@id='101_BTN']")
	public WebElement Select_Medical_Condition;

	
	@FindBy(xpath = "//*[@id='Answer_1']")
	@CacheLookup
	public WebElement Medical_condition_option_1;
	@FindBy(xpath = "//*[@id='Answer_2']")
	@CacheLookup
	public WebElement SeizureNo;
	
	@FindBy(xpath = "//*[@id='Answer_2']")
	@CacheLookup
	public WebElement Medical_condition_No_option;
	
	@FindBy(xpath = "//*[@id='Answer_3']")
	@CacheLookup
	public WebElement Medical_condition_option_3;
	
	@FindBy(xpath = "//*[@id='Answer_4']")
	@CacheLookup
	public WebElement Medical_condition_option_4;
	@FindBy(xpath = "//*[@id='Answer_5']")
	@CacheLookup
	public WebElement Medical_condition_option_5;
	
	
	@FindBy(xpath = "//*[@id='Answer_1' and @tabindex='4']")
	@CacheLookup
	public WebElement consciousnessNo;

	@FindBy(xpath = "//*[@id='Answer_1' and @tabindex='5']")
	@CacheLookup
	public WebElement lastSixMonths;

	@FindBy(xpath = "//*[@id='Answer_1' and @tabindex='6']")
	@CacheLookup
	public WebElement lastTwelveMonths;

	@FindBy(xpath = "//*[@id='Answer_1' and @tabindex='7']")
	@CacheLookup
	public WebElement DifferentMedicines;

	@FindBy(xpath = "//*[@id='Answer_5' and @tabindex='12']")
	@CacheLookup
	public WebElement FirstSeizure;

	@FindBy(xpath = "//*[@id='Answer_6' and @tabindex='14']")
	@CacheLookup
	public WebElement Result;

	@FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/form/div/table/tbody/tr/td[2]/div/button")
	@CacheLookup
	public WebElement MedicalScreeningContinue;

	@FindBy(xpath = "//button[contains(text(),'Finish')]")
	@CacheLookup
	public WebElement Finish;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/main/form/div/div[5]/button")
	@CacheLookup
	public WebElement TCcontinue;
	
	@FindBy(xpath = "//*[@id='Continue']")
	public WebElement Medical_Condition_Continue_Button;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElement Medical_Condition_Continue;
	
	//*[@id="Continue"]
	@FindBy(xpath = "//*[@id='Finish']")
	public WebElement Medical_Condition_Finish_Button;
	
	@FindBy(xpath = "//*[@id='Answer_2']")
	public WebElement Migraine;
	//*[@id="Answer_2"]
	
	@FindBy(xpath = "//*[@id='Answer_2' and @tabindex='8']")
	public WebElement HeadacheDoctorVisit;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/div[1]/div[1]/dl/div[1]/dd/button")
	public WebElement disable_medical_conditions_travellers_1;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/div[1]/div[1]/dl/div[2]/dd/button")
	public WebElement disable_medical_conditions_travellers_2;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/div[1]/div[1]/dl/div[3]/dd/button")
	public WebElement disable_medical_conditions_travellers_3;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/div[1]/div[1]/dl/div[4]/dd/button")
	public WebElement disable_medical_conditions_travellers_4;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/div/div[1]/div[1]/dl/div[5]/dd/button")
	public WebElement disable_medical_conditions_travellers_5;
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/h1")
	public WebElement Unable_to_offer_cover;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/h1")
	public WebElement Underwriter_Declined;
	
	
	
	// QuotePage

	@FindBy(xpath = "//body/div[1]/main[1]/div[4]/div[1]/div[1]/div[1]/form[1]/button[1]")
	@CacheLookup
	public WebElement Classic;
	
	@FindBy(xpath = "/html/body/div[1]/main/div[4]/div/div[1]/div[1]/form/button")
	@CacheLookup
	public WebElement ClassicFamily;
	
	@FindBy(xpath = "/html/body/div[1]/main/div[4]/div/div[2]/div[1]/form/button")
	@CacheLookup
	public WebElement PremierFamily;
	
	@FindBy(xpath = "/html/body/div[1]/main/div[4]/div/div[3]/div[1]/form/button")
	@CacheLookup
	public WebElement UltimateFamily;

	@FindBy(xpath = "//body/div[1]/main[1]/div[4]/div[1]/div[2]/div[1]/form[1]/button[1]")
	@CacheLookup
	public WebElement Premier;

	@FindBy(xpath = "//body/div[1]/main[1]/div[4]/div[1]/div[3]/div[1]/form[1]/button[1]")
	@CacheLookup
	public WebElement Ultimate;

	@FindBy(xpath = "/html/body/div[1]/main/div[4]/div/div[1]/div[1]/form/button")
	@CacheLookup
	public WebElement TMClassic;

	@FindBy(xpath = "/html/body/div[1]/main/div[4]/div/div[2]/div[1]/form/button")
	@CacheLookup
	public WebElement TMPremier;

	@FindBy(xpath = "/html/body/div[1]/main/div[4]/div/div[3]/div[1]/form/button")
	@CacheLookup
	public WebElement TMUltimate;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/ul[1]/li[1]/div[1]/div[2]/button[1]")
	@CacheLookup
	public WebElement ExcessCover;

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/ul[1]/li[2]/div[1]/div[2]/button[1]")
	@CacheLookup
	public WebElement BusinessCover;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/aside/div/dl/div[1]")
	@CacheLookup
	public WebElement Price_on_cover_page;
	

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/main[1]/div[1]/form[1]/button[1]")
	@CacheLookup
	public WebElement clickedContinue;

	@FindBy(xpath = "/html/body/div[1]/main/div[4]/div/div[1]/div[2]/div/button")
	@CacheLookup
	public WebElement Quote_show_More_Less_buttons;
	
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[3]/div/div[2]/button")
	public WebElement Wedding_CoverFamily;
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[5]/div/div[2]/button")
	public WebElement TravelDisruptionCoverFamily;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[2]/div/div[2]/button")
	public WebElement Wedding_Cover;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[4]/div/div[2]/button")
	public WebElement Flight_Cancellation;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[4]/div/div[2]/button")
	public WebElement Flight_Cancellation_Remove;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[4]/div/div[2]/button")
	public WebElement Travel_Disruption_Cover;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[5]/div/div[2]/button")
	public WebElement Special_Sports_table_C;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[6]/div/div[2]/button")
	public WebElement Special_Sports_table_B;
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/main/ul/li[6]/div/div[2]/button")
	public WebElement Special_Sports_table_D;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	public WebElement Additional_Cover_page_Continue_button;

	// LiveChat

	@FindBy(xpath = "//iframe[@id='cloudlink-chat-overlay-iframe']")
	@CacheLookup
	public WebElement liveChatiframe;

	@FindBy(xpath = "//span[contains(text(),'Live Chat')]")
	@CacheLookup
	public WebElement Livechat;

	@FindBy(xpath = "//*[@id='Name']")
	@CacheLookup
	public WebElement LiveChatname;

	@FindBy(xpath = "//*[@id='Email']")
	@CacheLookup
	public WebElement LiveChatemail;

	@FindBy(xpath = "//*[@id='cccl_co_start_chat']/span")
	@CacheLookup
	public WebElement StartLiveChat;

	@FindBy(xpath = "//*[@id='text-area']")
	@CacheLookup
	public WebElement testMsg;
	
	@FindBy(xpath = "//span[contains(text(),'One moment while we check for an available agent.')]")
	@CacheLookup
	public WebElement agentMsg;

	@FindBy(partialLinkText = " Today ")
	@CacheLookup
	public WebElement LiveChatDate;
	

	// Documents

	@FindBy(xpath = "//body/footer[1]/div[1]/div[1]/nav[1]/a[1]")
	@CacheLookup
	public WebElement footerFAQ;

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/p")
	@CacheLookup
	public WebElement faqHeading;

	/*
	 * @FindBy(xpath = "//span[contains(text(),'Live Chat')]")
	 * 
	 * @CacheLookup public WebElement Livechat;
	 */

	@FindBy(xpath = "/html/body/footer/div/div/nav/a[3]")
	@CacheLookup
	public WebElement CookiePolicy;

	@FindBy(xpath = "/html/body/footer/div/div/nav/a[2]")
	@CacheLookup
	public WebElement PrivacyPolicy;

	// PaymentDetails Page Webelements

	@FindBy(xpath = "//iframe[@class='h-full w-full']")
	@CacheLookup
	public WebElement Payment_page_iframe;
	@FindBy(xpath = "//input[@id='UPPFormCardFormCard']")
	@CacheLookup
	public WebElement Card_Number_Field;
	@FindBy(xpath = "//input[@id='UPPFormCardFormCV2']")
	@CacheLookup
	public WebElement Security_Number_CVV_Field;
	@FindBy(xpath = "//select[@id='UPPFormCardFormExMonth']")
	@CacheLookup
	public WebElement Card_Expiry_Month_dropdown;
	@FindBy(xpath = "//select[@id='UPPFormCardFormExYear']")
	@CacheLookup
	public WebElement Card_Expiry_Year_dropdown;
	@FindBy(xpath = "//input[@id='UPPFormButtonPay']")
	@CacheLookup
	public WebElement PayNow_Button;

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/h1")
	@CacheLookup
	public WebElement Payment_Success_Page_Title_1;
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/p")
	@CacheLookup
	public WebElement Payment_Success_Page_Title_2;
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/main/div/h2")
	@CacheLookup
	public WebElement Payment_Success_Travel_Insurance_Policy_Number;

	@FindBy(xpath = "/html/body/div/div[3]/form/div[4]/div[5]/div/label")
	@CacheLookup
	public WebElement Invalid_card_number_error_message;
	@FindBy(xpath = "/html/body/div/div[3]/form/div[4]/div[6]/div/label")
	@CacheLookup
	public WebElement Invalid_CVV_number_error_message;
	
	
	
	@FindBy(xpath = "//*[@id='UPPFormButtonBack']")
	@CacheLookup
	public WebElement Payment_page_Cancel_button;
	
	
	
	


	
}
