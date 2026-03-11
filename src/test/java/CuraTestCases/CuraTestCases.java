package CuraTestCases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import CuraAction.CuraFrontMethods;
import Utility.BaseClass;

public class CuraTestCases {

	public CuraFrontMethods curafrontmethods;
	
	@BeforeSuite
	public void BeforeSuite() {
		BaseClass.startdriver();
		curafrontmethods = new CuraFrontMethods();
	}
	
	@Test()
	public void ATTest() throws InterruptedException {
		
		
		BaseClass.Sleep();
		curafrontmethods.curafrontmethod.VerifyTitle();
		BaseClass.Sleep();
		curafrontmethods.curafrontmethod.CuraHelathCare();
		BaseClass.Sleep();
		curafrontmethods.loginpage.loginpage();
	}
	
}//CuraFrontTestCases
