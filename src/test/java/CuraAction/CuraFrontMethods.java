package CuraAction;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import CuraLocators.FrontLocator;
import Utility.BaseClass_CuraHealthcare;

public class CuraFrontMethods {

	public CuraFrontMethod curafrontmethod;
	public LogInPage loginpage;

	public CuraFrontMethods() {

		curafrontmethod = new CuraFrontMethod();
		loginpage = new LogInPage();
	}

	public FrontLocator frontlocator = new FrontLocator();

	public class CuraFrontMethod {

		public void CuraHelathCare() throws InterruptedException {
			frontlocator.frontpage.CuraHelathCare.click();
			BaseClass_CuraHealthcare.Sleep();
			// frontlocator.frontpage.CuraHelathCare.click();

			// ***************** Hover **********************
			Actions HH = new Actions(BaseClass_CuraHealthcare.driver);
			HH.moveToElement(frontlocator.frontpage.HomeHover).build().perform();

			// ***************** Hover **********************
			Actions LH = new Actions(BaseClass_CuraHealthcare.driver);
			LH.moveToElement(frontlocator.frontpage.LoginHover).build().perform();

			frontlocator.frontpage.LoginHover.click();

		}

		public void VerifyTitle() {

			boolean displayed = frontlocator.frontpage.VerifyTitle.isDisplayed();
			// System.out.println("display value:"+displayed);
			assertTrue(displayed, "is not display");

			String text = frontlocator.frontpage.VerifyTitle.getText();
			System.out.println("text is :" + text);

		}
	}// CuraFrontMethod

	public class LogInPage {

		public HongKongAppointment hongkongappointment;
		public SeoulAppointment seoulappointment;

		public HomePage homepage;
		public LogInPage() {
			hongkongappointment = new HongKongAppointment();
			seoulappointment = new SeoulAppointment();
			homepage = new HomePage();
		}

		public void loginpage() {

			String attribute = frontlocator.login.DemoUserName.getAttribute("value");
			System.out.println("UserName" + attribute);

			String attribute2 = frontlocator.login.DemoUserPassword.getAttribute("value");
			System.out.println("Password" + attribute2);

			frontlocator.login.UserName.sendKeys(attribute);
			frontlocator.login.Password.sendKeys(attribute2);
			frontlocator.login.ClickLogin.click();
		}// loginpage

		public class HongKongAppointment {

			public VerifyHongKongAppointment verifyHongKongAppointment;

			public HongKongAppointment() {

				verifyHongKongAppointment = new VerifyHongKongAppointment();
			}

			public void MakeAppointmentHongKongDetails(String AppointNames, String comment) throws InterruptedException {

				BaseClass_CuraHealthcare.selectDropdownForSelect(frontlocator.login.makeappointmenthongkong.Facility, AppointNames);
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmenthongkong.Readmission.click();
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmenthongkong.Medicare.click();
				BaseClass_CuraHealthcare.Sleep();
				String date = BaseClass_CuraHealthcare.getDate(2);
				frontlocator.login.makeappointmenthongkong.Date.sendKeys(date);
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmenthongkong.Comment.click();
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmenthongkong.Comment.sendKeys(comment);
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmenthongkong.BookAppointment.click();

			}// MakeAppointmentHongKong

			public class VerifyHongKongAppointment {

				public void VerifyHongKongAppointmentDetails() {
					// facility
					String Facility = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyFacility
							.getText();
					System.out.println("Verify Facility:" + Facility);
					Assert.assertEquals(Facility, "Hongkong CURA Healthcare Center");

					// ReadMission
					String ReadMission = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyReadmission
							.getText();
					System.out.println("Verify ReadMission:" + ReadMission);
					Assert.assertEquals(ReadMission, "Yes");

					// HealthcareProgram
					String HealthcareProgram = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyMedicare
							.getText();
					System.out.println("Verify HealthcareProgram:" + HealthcareProgram);
					Assert.assertEquals(HealthcareProgram, "Medicare");

					// Visitdate
					String Visitdate = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyDate.getText();
					System.out.println("Verify Visitdate:" + Visitdate);
					Assert.assertEquals(Visitdate, Visitdate);

					// Comment
					String Comment = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyCommit.getText();
					System.out.println("Verify Comment:" + Comment);
					Assert.assertEquals(Comment,
							"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");

				}//VerifyHongKongAppointmentDetails

				
			}// VerifyHongKongAppointment

			
		}// HongKongAppointment
		
		public class  HomePage{
			
			public void ClickHomePage() {
				frontlocator.login.homepage.ClickHomePageButton.click();
			}
		}
		
		public class SeoulAppointment{
			
			public VerifySeoulAppointment verifyseoulappointment;
			
			public SeoulAppointment() {
				verifyseoulappointment = new VerifySeoulAppointment();
			}
			
			public  void MakeSeoulAppointmentDetails(String AppointName, String comment) throws InterruptedException {
				BaseClass_CuraHealthcare.selectDropdownForSelect(frontlocator.login.makeappointmentseoul.Facility, AppointName);
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmentseoul.Readmission.click();
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmentseoul.Medicaid.click();
				BaseClass_CuraHealthcare.Sleep();
				String date = BaseClass_CuraHealthcare.getDate(2);
				frontlocator.login.makeappointmentseoul.Date.sendKeys(date);
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmentseoul.Comment.click();
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmentseoul.Comment.sendKeys(comment);
				BaseClass_CuraHealthcare.Sleep();
				frontlocator.login.makeappointmentseoul.BookAppointment.click();
				
			}//MakeSeoulAppointmentDetails
			
			public class VerifySeoulAppointment{
				
				public void VerifySeoulAppointmentDetails() {
					
					String Facility = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyFacility.getText();
					System.out.println("Verify Facility:" + Facility);
					Assert.assertEquals(Facility, "Seoul CURA Healthcare Center");
					
					// ReadMission
					String ReadMission = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyReadmission
							.getText();
					System.out.println("Verify ReadMission:" + ReadMission);
					Assert.assertEquals(ReadMission, "Yes");

					// HealthcareProgram
					String HealthcareProgram = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyMedicaid
							.getText();
					System.out.println("Verify HealthcareProgram:" + HealthcareProgram);
					Assert.assertEquals(HealthcareProgram, "Medicaid");

					// Visitdate
					String Visitdate = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyDate.getText();
					System.out.println("Verify Visitdate:" + Visitdate);
					Assert.assertEquals(Visitdate, Visitdate);

					// Comment
					String Comment = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyCommit.getText();
					System.out.println("Verify Comment:" + Comment);
					Assert.assertEquals(Comment,
							"Seoul is a top global destination for medical tourism, offering advanced, cost-effective healthcare, including specialized, high-tech, and wellness services");

					
				}//VerifySeoulAppointmentDetails
				
			}//VerifySeoulAppointment
			
		}//SeoulAppointment
		
	}// LogInPage
	
}//CuraFrontMethods


