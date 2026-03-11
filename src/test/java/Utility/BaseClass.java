package Utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	//URL
	public static String url = "https://katalon-demo-cura.herokuapp.com/";
	public static WebDriver driver;

	//START
	public static void startdriver() {

		driver = new ChromeDriver(getChromeOptions());

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	//OPTIONS
	//OPTIONS
	public static ChromeOptions getChromeOptions() {

	    ChromeOptions options = new ChromeOptions();

	    //AUTOMATION
	    options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
	    options.setExperimentalOption("useAutomationExtension", false);

	    //POPUPS
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-infobars");

	    //PASSWORD MANAGER
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false); //IMPORTANT
	    prefs.put("autofill.profile_enabled", false);
	    prefs.put("autofill.credit_card_enabled", false);

	    options.setExperimentalOption("prefs", prefs);

	    return options;
	}

	
	//DropDown
	public static void selectDropdown(WebElement dropdown, String value) throws InterruptedException {
	    dropdown.click();
	    Sleep();
	    Sleep();
	    WebElement element = driver.findElement(By.xpath("//select[@id='combo_facility']/option[text()='"+ value +"']"));
	    element.click();
	}
	
	
	//WAIT
	public static void Sleep() throws InterruptedException {
		Thread.sleep(2000);
	}

}