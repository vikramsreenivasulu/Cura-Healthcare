package CuraAction;

import static org.testng.Assert.assertTrue;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import CuraLocators.FrontLocator;
import Utility.BaseClass;

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
			BaseClass.Sleep();
			// frontlocator.frontpage.CuraHelathCare.click();

			// ***************** Hover **********************
			Actions HH = new Actions(BaseClass.driver);
			HH.moveToElement(frontlocator.frontpage.HomeHover).build().perform();

			// ***************** Hover **********************
			Actions LH = new Actions(BaseClass.driver);
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

		public LogInPage() {
			hongkongappointment = new HongKongAppointment();
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

				BaseClass.selectDropdownForSelect(frontlocator.login.makeappointmenthongkong.Facility, AppointNames);
				BaseClass.Sleep();
				frontlocator.login.makeappointmenthongkong.Readmission.click();
				BaseClass.Sleep();
				frontlocator.login.makeappointmenthongkong.Medicare.click();
				BaseClass.Sleep();
				String date = BaseClass.getDate(2);
				frontlocator.login.makeappointmenthongkong.Date.sendKeys(date);
				BaseClass.Sleep();
				frontlocator.login.makeappointmenthongkong.Comment.click();
				BaseClass.Sleep();
				frontlocator.login.makeappointmenthongkong.Comment.sendKeys(comment);
				BaseClass.Sleep();
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
					Assert.assertEquals(Visitdate, "15/03/2026");

					// Comment
					String Comment = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyCommit.getText();
					System.out.println("Verify Comment:" + Comment);
					Assert.assertEquals(Comment,
							"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");

				}//VerifyHongKongAppointmentDetails

				
			}// VerifyHongKongAppointment

			
		}// HongKongAppointment
		
	}// LogInPage
	
}//CuraFrontMethods


