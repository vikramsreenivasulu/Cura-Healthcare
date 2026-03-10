package CuraAction;

import static org.testng.Assert.assertTrue;

import CuraLocators.FrontLocator;
import Utility.BaseClass;

public class CuraFrontMethods {

	public CuraFrontMethod curafrontmethod;
	
	public CuraFrontMethods() {
		
		curafrontmethod = new CuraFrontMethod();
	}
	
	public FrontLocator frontlocator = new FrontLocator();
	public class CuraFrontMethod{
		
		public void CuraHelathCare() throws InterruptedException {
			frontlocator.frontpage.CuraHelathCare.click();
			BaseClass.Sleep();
			frontlocator.frontpage.CuraHelathCare.click();
		}
		
		public void VerifyTitle() {
			
			boolean displayed = frontlocator.frontpage.VerifyTitle.isDisplayed();
			//System.out.println("display value:"+displayed);
			assertTrue(displayed, "is not display");
			
			String text = frontlocator.frontpage.VerifyTitle.getText();
			System.out.println("text is :"+text);
			
		}
	}//CuraFrontMethod
	
	
	
}//CuraFrontMethods
