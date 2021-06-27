package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest  test;
	SoftAssert soft = new SoftAssert();
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	@BeforeMethod
	public void Setup() throws IOException {
		
        driver = new ChromeDriver();
		
		driver.get("https://simplilearn.com/");
		 
		//To maximize the browser 
		
		driver.manage().window().maximize();
		
		//To wait for 5 sec in every page
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		reports = new  ExtentReports("ExtentReports.html");
		
        FileInputStream fis = new FileInputStream("satyam1.xlsx");
		
		wbook = new XSSFWorkbook(fis);
		
		sheet = wbook.getSheetAt(0); 
	} 
	
	@AfterMethod
	public void teardown() {
		reports.endTest(test);
		reports.flush();
		
		driver.quit();
		
	}
	

}
