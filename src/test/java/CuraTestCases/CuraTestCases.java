package CuraTestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import CuraAction.CuraFrontMethods;
import Utility.BaseClass;
import Utility.Report;

public class CuraTestCases {

	public CuraFrontMethods curafrontmethods;

	@BeforeSuite
	public void BeforeSuite() {
		BaseClass.startdriver();
		 Report.startReport();
		curafrontmethods = new CuraFrontMethods();
	}

	@Test()
	public void ATTest() throws InterruptedException {

		
		Report.createTest("HealthCare TestCase");
		Report.logInfo("Test started");
		BaseClass.Sleep();
		curafrontmethods.curafrontmethod.VerifyTitle();
		BaseClass.Sleep();
		curafrontmethods.curafrontmethod.CuraHelathCare();
		BaseClass.Sleep();
		curafrontmethods.loginpage.loginpage();
		Report.pass("Login_Successfull");
//		 Report.pass("Test passed");
		BaseClass.Sleep();
		curafrontmethods.loginpage.hongkongappointment.MakeAppointmentHongKongDetails("Hongkong CURA Healthcare Center",
				"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");
		
		BaseClass.Sleep();
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment.VerifyHongKongAppointmentDetails();
		Report.logInfo("Verify_HongKong_Appointment_Details");
		Report.pass("Verify HongKong Details Successfull");
	//s	Report.fail("If it is fail the issue is date");
		BaseClass.Sleep();
		curafrontmethods.loginpage.homepage.ClickHomePage();
		BaseClass.Sleep();
		curafrontmethods.loginpage.seoulappointment.MakeSeoulAppointmentDetails("Seoul CURA Healthcare Center",
				"Seoul is a top global destination for medical tourism, offering advanced, cost-effective healthcare, including specialized, high-tech, and wellness services");
		BaseClass.Sleep();
		curafrontmethods.loginpage.seoulappointment.verifyseoulappointment.VerifySeoulAppointmentDetails();
		Report.logInfo("Verify_Seoul_Appointment_Details");
		Report.pass("Verify HongKong Details Successfull");
	//	Report.fail("If it is fail the issue is date");
		
		Report.pass("All Test Cases Pass");
	}
	
	@AfterSuite()
	public void AfterSuite() {
		BaseClass.StopDriver();
		Report.flush();
	}

}// CuraFrontTestCases
