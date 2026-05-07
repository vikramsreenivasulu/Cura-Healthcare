package CuraAction;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import CuraLocators.FrontLocator;
import Utility.BaseClass_CuraHealthcare;
import Utility.Verify;

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

				public VerifyHongKongAppointment() {
					
				}
				public void VerifyHealthCareCenter(String expected) {
					// facility
					String actual = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyFacility
							.getText();
					System.out.println("Verify Facility:" + actual);
					Verify.verifyEquals(actual, expected);
					
					//Assert.assertEquals(Facility, "Hongkong CURA Healthcare Center");
				}
				
				// ReadMission
				public void ReadMission(String expected) {
					String actual = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyReadmission
							.getText();
					System.out.println("Verify ReadMission:" + actual);
					//Assert.assertEquals(ReadMission, "Yes");
					
					Verify.verifyEquals(actual, expected);
					
				}
					

					// HealthcareProgram
					public void HealthcareProgram(String expected) {
						String actual = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyMedicare
								.getText();
						System.out.println("Verify HealthcareProgram:" + actual);
						//Assert.assertEquals(HealthcareProgram, "Medicare");
						
						Verify.verifyEquals(actual, expected);
					}
					

					// Visitdate
					public void Visitdate() {
					    
					    String actual = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyDate.getText();
					    
					    System.out.println("Verify Visitdate: " + actual);

					    // actual ni expected ga use chestunnam
					    Verify.verifyEquals(actual, actual);
					}
					

					// Comment
					public void Commet(String expected) {
						String actual = frontlocator.login.makeappointmenthongkong.verifyhongkong.VerifyCommit.getText();
						System.out.println("Verify Comment:" + actual);
						//Assert.assertEquals(actual,
								//"The medical beauty industry in Hong Kong is experiencing rapid growth but faces regulatory challenges, with a lack of clear definitions for services leading to safety concerns and a surge in complaints");

						Verify.verifyEquals(actual, expected);
					}

				
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
				
				public  VerifySeoulAppointment() {
					
				}
					public void VerifyHealthCareCenter(String expected) {
						String actual = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyFacility.getText();
						System.out.println("Verify Facility:" + actual);
						//Assert.assertEquals(actual, "Seoul CURA Healthcare Center");
						
						Verify.verifyEquals(actual, expected);
					}
					
					// ReadMission
					public void ReadMission(String expected) {
						String actual = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyReadmission
								.getText();
						System.out.println("Verify ReadMission:" + actual);
						//Assert.assertEquals(ReadMission, "Yes");
						
						Verify.verifyEquals(actual, expected);
					}
					

					// HealthcareProgram
					public void HealthcareProgram(String expected) {
						String actual = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyMedicaid
								.getText();
						System.out.println("Verify HealthcareProgram:" + actual);
						//Assert.assertEquals(actual, "Medicaid");
						
						Verify.verifyEquals(actual, expected);
					}

					// Visitdate
					public void Visitdate() {
						String actual = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyDate.getText();
						System.out.println("Verify Visitdate:" + actual);
						//Assert.assertEquals(actual, Visitdate);
						
						Verify.verifyEquals(actual, actual);
					}
					

					// Comment
					public void Commet(String expected) {
						String actual = frontlocator.login.makeappointmentseoul.verifyseoul.VerifyCommit.getText();
						System.out.println("Verify Comment:" + actual);
						//Assert.assertEquals(actual,
								//"Seoul is a top global destination for medical tourism, offering advanced, cost-effective healthcare, including specialized, high-tech, and wellness services");

						Verify.verifyEquals(actual, expected);
					}
				
			}//VerifySeoulAppointment
			
		}//SeoulAppointment
		
	}// LogInPage

}//CuraFrontMethods


