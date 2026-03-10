package CuraLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class FrontLocator {
	
	public FrontPage frontpage;

	public FrontLocator() {
		
		frontpage = new FrontPage();
		
	}
	
	public class FrontPage{
		
		public FrontPage() {
			PageFactory.initElements(BaseClass.driver, this);
		}
		
		@FindBy(xpath="//i[@class='fa fa-bars']")
		public WebElement CuraHelathCare;
		
		@FindBy(xpath="//header[@id='top']//h1[text()='CURA Healthcare Service']")
		public WebElement VerifyTitle;
		
	}//FrontPage
	
	
	
	
	
	
	
}//FrontLocator
