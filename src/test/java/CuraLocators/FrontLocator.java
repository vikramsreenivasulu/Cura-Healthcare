package CuraLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class FrontLocator {
	
	public FrontPage frontpage;
	public Login login;

	public FrontLocator() {
		
		frontpage = new FrontPage();
		login = new Login();
		
	}
	
	public class FrontPage{
		
		public FrontPage() {
			PageFactory.initElements(BaseClass.driver, this);
		}
		
		@FindBy(xpath="//i[@class='fa fa-bars']")
		public WebElement CuraHelathCare;
		
		@FindBy(xpath="//header[@id='top']//h1[text()='CURA Healthcare Service']")
		public WebElement VerifyTitle;
		
		@FindBy(xpath="//a[normalize-space(text())='Home']")
		public WebElement HomeHover;
		
		@FindBy(xpath="//a[normalize-space(text())='Login']")
		public WebElement LoginHover;
	}//FrontPage
	
	public class Login{
		public MakeAppointmentHongKong makeappointmenthongkong;
		
		public Login() {
			PageFactory.initElements(BaseClass.driver, this);
			makeappointmenthongkong = new MakeAppointmentHongKong();
		}
		
		@FindBy(xpath="(//input[@type='text'])[1]")
		public WebElement DemoUserName;
		
		@FindBy(xpath="(//input[@type='text'])[2]")
		public WebElement DemoUserPassword;
		
		@FindBy(id = "txt-username")
		public WebElement UserName;
		
		@FindBy(id="txt-password")
		public WebElement Password;
		
		@FindBy(id="btn-login")
		public WebElement ClickLogin;
		
		public class MakeAppointmentHongKong{
			
			public VerifyHongKong verifyhongkong;
			public  MakeAppointmentHongKong() {
				PageFactory.initElements(BaseClass.driver, this);
				verifyhongkong = new VerifyHongKong();
			}
			
			@FindBy(id="combo_facility")
			public WebElement Facility;
			
			@FindBy(id="chk_hospotal_readmission")
			public WebElement Readmission;
			
			@FindBy(id="radio_program_medicare")
			public WebElement Medicare;
			
			@FindBy(id="txt_comment")
			public WebElement Comment;
			
			@FindBy(id="txt_visit_date")
			public WebElement Date;
			
			@FindBy(id="btn-book-appointment")
			public WebElement BookAppointment;
			
			public class VerifyHongKong{
				
				public VerifyHongKong() {
					PageFactory.initElements(BaseClass.driver, this);
				}
				
				@FindBy(id="facility")
				public WebElement VerifyFacility ;
				
				@FindBy(id="hospital_readmission")
				public WebElement VerifyReadmission ;
				
				@FindBy(id="program")
				public WebElement VerifyMedicare ;
				
				@FindBy(id="visit_date")
				public WebElement VerifyDate ;
				
				@FindBy(id="comment")
				public WebElement VerifyCommit ;
				
				
				
			}//VerifyHongKong
			
		}//MakeAppointmentHongKong
		
		public class MakeAppointmentSeoul{
			
			public MakeAppointmentSeoul() {
				PageFactory.initElements(BaseClass.driver, this);
			}
			
			
		}
		
	}//Login
	
	
	
}//FrontLocator


















