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
		
		public Login() {
			PageFactory.initElements(BaseClass.driver, this);
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
		
	}//Login
	
	
	
	
	
	
}//FrontLocator
