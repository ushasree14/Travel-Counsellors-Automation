package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.Screenshot;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String chrome = readconfig.getChromePath();
	public String firefox = readconfig.getFirefoxPath();

	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeTest
	public void setup(String br) throws WebDriverException, IOException {
		logger = Logger.getLogger("Travel counsellor");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			/*
			 * // DesiredCapabilities capabilities = DesiredCapabilities.chrome(); //
			 * ChromeOptions options = new ChromeOptions(); //
			 * options.addArguments("--incognito"); //
			 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
			 */
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			//options.addArguments("--headless");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
	//	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		System.out.println("Travel Counsellors Get quote page Title :-"+driver.getTitle());

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

//	 Full_Page_Screenshot
		public static void takeScreenshot(String fileName) throws WebDriverException, IOException {
		
		//take screenshot and store it as a file format:
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshots in desired location using copyfile method:
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".jpg"));
		//FileUtils.copyFile(file, new File("D:\\TravelCounsellors\\Screenshots\\" + fileName + ".jpg"));
		
		
		//System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\Travel_Counsellor_TestData_New.xls";
		}
		
		/*
		 * public void failed() { File srcFile
		 * =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try {
		 * FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") +
		 * "\\Screenshots\\" + fileName + ".jpg")); } Catch(IOException e){
		 * e.printStackTrace(); }
		 * 
		 * }
		 */
			
		

}
