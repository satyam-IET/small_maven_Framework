package test;


import org.testng.annotations.Test;

import Page.Loginpages;

public class Logintest extends Base{
	
	
	/*@Test(priority=0 , description = "Verify User is able to click on login button")
	@Parameters({"username","password"})
	public void test1(String usrnm , String Pass) {
		
		Loginpages loginobj = new Loginpages();
		loginobj.Login(usrnm, Pass);
		
	} */
	
	// ============================Fetching data from excel sheet============================
	
	@Test(priority=1 , description = "Verify User is able to click on login button")
	
	public void test1() {
		
		String usrnm = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass = sheet.getRow(1).getCell(1).getStringCellValue();
		
		Loginpages loginobj = new Loginpages();
		loginobj.Login(usrnm, pass);
		
	}
	
}
