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
		BaseClass.Sleep();
		curafrontmethods.loginpage.hongkongappointment.MakeAppointmentHongKongDetails("Hongkong CURA Healthcare Center",
				"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");
		BaseClass.Sleep();
		curafrontmethods.loginpage.hongkongappointment.verifyHongKongAppointment.VerifyHongKongAppointmentDetails();

	}

}// CuraFrontTestCases
