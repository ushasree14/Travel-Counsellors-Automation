package Components;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.TC_WebElements;
import Utilities.BaseClass;

public class Scenario_ID1856 extends BaseClass {

	public Scenario_ID1856(WebDriver driver) {
		this.driver = driver;
	}

	public void GetQuoteTest() throws InterruptedException, IOException {
TC_WebElements TC_obj = new TC_WebElements(driver);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Accept')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cookies);
		System.out.println("cookies accepted");
		
	}

	public void Footer() throws InterruptedException {
		TC_WebElements TC_obj = new TC_WebElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// doc.faqHeading();

		WebElement Footer = driver.findElement(By.xpath("/html/body/footer/div/div/div/div/div/p[1]"));
		Footer.getText();
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.visibilityOf(Footer));
		if (Footer.getText().contains(
				"Travel Counsellors Group (Travel Counsellors) acts as an intermediary for this policy. The policy is arranged and administered by ROCK Insurance Services Limited (ROCK) who are authorised and regulated by the Financial Conduct Authority (FCA No. 300317) and underwritten by SAInsurance Company ‘Euroins’ AD, who are authorised and regulated by the Bulgarian Financial Supervision Commission. You can find out more about how ROCK will process and share your data in their ")) {
			System.out.println("Today text is matched");
			System.out.println(Footer.getText());
		} else {
			System.out.println("Today text is not matched");

		}

	}
}
