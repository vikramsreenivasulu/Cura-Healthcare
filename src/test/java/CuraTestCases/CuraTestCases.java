package CuraTestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import CuraAction.CuraFrontMethods;
import Utility.BaseClass_CuraHealthcare;
import Utility.Report;
import Utility.Verify;

public class CuraTestCases {

	public CuraFrontMethods curafrontmethods;

	@BeforeSuite
	public void BeforeSuite() {
		BaseClass_CuraHealthcare.startdriver();
		Verify.restAssertion();
		Report.startReport();
		curafrontmethods = new CuraFrontMethods();
	}

	@Test()
	public void ATTest() throws InterruptedException {

		// Report started here//
		Report.createTest("HealthCare TestCase");

		// Node started here//
		Report.createNode("HealthCare Login");
		Report.logInfo("Test started");
		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.curafrontmethod.VerifyTitle();
		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.curafrontmethod.CuraHelathCare();
		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.loginpage.loginpage();
		Report.pass("Login_Successfull");
		Report.createNode("HongKong Appointment");
		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.loginpage.hongkongappointment.MakeAppointmentHongKongDetails("Hongkong CURA Healthcare Center",
				"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");

		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment
				.VerifyHealthCareCenter("Hongkong CURA Healthcare Center");
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment.ReadMission("Yes");
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment.HealthcareProgram("MMedicare");
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment.Visitdate();
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment.Commet(
				"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");
		Report.logInfo("Verify_HongKong_Appointment_Details");
		Report.pass("Verify HongKong Details Successfull");

		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.loginpage.homepage.ClickHomePage();
		Report.createNode("Seoul Appointment");
		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.loginpage.seoulappointment.MakeSeoulAppointmentDetails("Seoul CURA Healthcare Center",
				"Seoul is a top global destination for medical tourism, offering advanced, cost-effective healthcare, including specialized, high-tech, and wellness services");
		BaseClass_CuraHealthcare.Sleep();
		curafrontmethods.loginpage.seoulappointment.verifyseoulappointment
				.VerifyHealthCareCenter("Seoul CURA Healthcare Center");
		curafrontmethods.loginpage.seoulappointment.verifyseoulappointment.ReadMission("Yes");
		curafrontmethods.loginpage.seoulappointment.verifyseoulappointment.HealthcareProgram("MMedicaid");
		curafrontmethods.loginpage.seoulappointment.verifyseoulappointment.Visitdate();
		curafrontmethods.loginpage.seoulappointment.verifyseoulappointment.Commet(
				"Seoul is a top global destination for medical tourism, offering advanced, cost-effective healthcare, including specialized, high-tech, and wellness services");
		Report.logInfo("Verify_Seoul_Appointment_Details");
		Report.pass("Verify HongKong Details Successfull");

		Report.pass("All Test Cases Pass");
		Verify.assertAll();
	}

	@AfterMethod()
	public void AfterSuite(ITestResult result) {
		Report.getResult(result);
		BaseClass_CuraHealthcare.StopDriver();
		Report.flush();
	}

}// CuraFrontTestCases
