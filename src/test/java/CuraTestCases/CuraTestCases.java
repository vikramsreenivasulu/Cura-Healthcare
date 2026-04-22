package CuraTestCases;

import org.testng.ITestResult;
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
		BaseClass.Sleep();
		curafrontmethods.curafrontmethod.VerifyTitle();
		BaseClass.Sleep();
		curafrontmethods.curafrontmethod.CuraHelathCare();
		BaseClass.Sleep();
		curafrontmethods.loginpage.loginpage();
		Report.pass("Login_Successfull");
		BaseClass.Sleep();
		curafrontmethods.loginpage.hongkongappointment.MakeAppointmentHongKongDetails("Hongkong CURA Healthcare Center",
				"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");
		BaseClass.Sleep();
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment.VerifyHongKongAppointmentDetails();
		Report.logInfo("Verify_HongKong_Appointment_Details");
		BaseClass.Sleep();
		curafrontmethods.loginpage.homepage.ClickHomePage();
		BaseClass.Sleep();
		curafrontmethods.loginpage.seoulappointment.MakeSeoulAppointmentDetails("Seoul CURA Healthcare Center",
				"Seoul is a top global destination for medical tourism, offering advanced, cost-effective healthcare, including specialized, high-tech, and wellness services");
		BaseClass.Sleep();
		curafrontmethods.loginpage.seoulappointment.verifyseoulappointment.VerifySeoulAppointmentDetails();
		Report.logInfo("Verify_Seoul_Appointment_Details");
	}
	
	@AfterSuite()
	public void AfterSuite(ITestResult result) {
		BaseClass.StopDriver();
		Report.flush();
	}

}// CuraFrontTestCases
