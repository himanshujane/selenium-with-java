package genericLib;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class commonLib {
	public WebDriver driver;
	public ExtentReports ereports;
	public ExtentTest startTest;
//Annotation***************************************************

	@BeforeSuite
	public void inReport() {
		System.out.println("Before Suite - Report To be implemented");
		ereports = new ExtentReports("C:\\Users\\h.jain\\eclipse-workspace\\poc\\Reports\\Report_"+ getdatetimestamp() + ".html"); 
	}

	@BeforeMethod
	public void launchApp() {
		System.out.println("Before Method ");
		System.setProperty("webdriver.chrome.driver", "..//poc//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterMethod
	public void teardown() {
		System.out.println("Shutdown");
		ereports.endTest(startTest);
		ereports.flush();
		driver.quit();
	}

//Annotation close***************************************************

//Keywords********************************************************
	public static void sendkeys(WebElement we, String val) {
		we.clear();
		we.sendKeys(val);
	}

	public static void enter(WebElement we) {
		we.sendKeys(Keys.ENTER);
		;
	}

	public static void click(WebElement we) {
		we.click();
	}
//Keywords Close ***************************************************

//common methods *************************************************

	// data and time
	public String getdatetimestamp() {

		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String unique = sf.format(date);
		return unique;
	}

// utility 

public static String getprop(String key) throws Exception {
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\config.properties");
	Properties prop = new Properties();
	prop.load(fis);
	return prop.getProperty(key);
}

//common methods close ***********************************************

}
