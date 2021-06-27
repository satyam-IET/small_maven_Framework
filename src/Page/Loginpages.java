package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Logintest;

public class Loginpages {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
// ==================================WebElements===================================
	
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(name="user_pwd")
	WebElement UserPassword;
	
	@FindBy(className="rememberMe")
	WebElement RememberMe;
	
	@FindBy(name="btn_login")
	WebElement LoginName;
	
	@FindBy(id="msg_box")
	WebElement Error;
	
// ===============================Constructor ====================================	
public Loginpages() {
	
	driver = Logintest.driver;
	reports = Logintest.reports;
	test = Logintest.test;
	PageFactory.initElements(driver, this);
}
	
//================ Methods ========================================
	
public void Login(String usrnm , String Pass) {
		
		test = reports.startTest("Login Test Case");
		
		// To click on Login Button
		
		LoginLink.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on the login button");

	    //to enter email / to enter any name in webpage
		
	    UserName.sendKeys(usrnm);
		
		test.log(LogStatus.PASS, "Successfully Entered Username");

		// Enter Password
		
		UserPassword.sendKeys(Pass);
		
		test.log(LogStatus.PASS, "Successfully Entered Username");

	    //Click on Remember me check box
		
		RememberMe.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on remember me checkbox");

		
		//WebElement LoginName = driver.findElement(By.name("btn_login"));
		LoginName.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on login button");
		
		// Check Error Message
		
		String Actmsg = Error.getText();
		
		String expectmsg = "The email or password you have entered is invalid.";
		
		Assert.assertTrue(Error.isDisplayed());
		Assert.assertEquals(Actmsg, expectmsg);


}}
