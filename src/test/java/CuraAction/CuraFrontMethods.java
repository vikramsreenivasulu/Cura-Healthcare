package CuraAction;

import static org.testng.Assert.assertTrue;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

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

			public void MakeAppointmentHongKongDetails(String AppointNames, String comment) {

				BaseClass.selectDropdownForSelect(frontlocator.login.makeappointmenthongkong.Facility, AppointNames);
				frontlocator.login.makeappointmenthongkong.Readmission.click();
				frontlocator.login.makeappointmenthongkong.Medicare.click();
				String date = BaseClass.getDate(2);
				frontlocator.login.makeappointmenthongkong.Date.sendKeys(date);
				frontlocator.login.makeappointmenthongkong.Comment.click();
				frontlocator.login.makeappointmenthongkong.Comment.sendKeys(comment);
				frontlocator.login.makeappointmenthongkong.BookAppointment.click();

			}// MakeAppointmentHongKong

			public class VerifyHongKongAppointment {

				public void VerifyHongKongAppointmentDetails() {

				}

			}//VerifyHongKongAppointment

		}//HongKongAppointment
	}//LogInPage
}

// LogInPage

//CuraFrontMethods
