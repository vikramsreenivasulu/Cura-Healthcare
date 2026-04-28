package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report{
	
	public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentReports extentReports;
	
	public static ExtentTest extentTest;
	public static void startReport() {

		extentSparkReporter = new ExtentSparkReporter(
				"C:\\Users\\vikram.sreenivasulu\\eclipse-workspace\\Cura_Healthcare\\Reports\\htmlReport.html");
		
		extentSparkReporter.config().setDocumentTitle("Cura_HealthCare Automation Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("Cura_HealthCare");
		extentSparkReporter.config().setEncoding("utf-8");
		
		
		extentReports= new ExtentReports();
		extentReports.setSystemInfo("Name", "Vikram");
		extentReports.setSystemInfo("Team", "Automation Team");
		extentReports.setSystemInfo("System", "CPLBNGLPT103");
		extentReports.attachReporter(extentSparkReporter);

	}
	
	public static void createTest(String testName) {
		 extentTest = extentReports.createTest(testName);

	}
	
	public static void pass(String testName) {
		extentTest.pass(testName);

	}
	
	public static void fail(String testName) {
		extentTest.fail(testName);

	}
	
	public static void flush() {
		extentReports.flush();

	}
	
	public static void logInfo(String info) {
		extentTest.info(info);

		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String fileName = info + "_" + timeStamp;
		String screenshotPath = caputreScreenshot(fileName);

		extentTest.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	
	public static String caputreScreenshot(String fileName) {
	    TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
	    File srcFile = ts.getScreenshotAs(OutputType.FILE);

	    String projectRoot = System.getProperty("user.dir");
	    
	    // Save screenshot relative to Reports folder
	    String relativePath = ".." + File.separator + "Screenshots" + File.separator + fileName + ".png";
	    String absolutePath = projectRoot + File.separator + "Screenshots" + File.separator + fileName + ".png";

	    File dest = new File(absolutePath);
	    dest.getParentFile().mkdirs();

	    try {
	        FileUtils.copyFile(srcFile, dest);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return relativePath; // Return relative path for HTML
	}
	
}





//public static void logInfo(String info) {
//extentTest.info(info);
//
//String screenshotPath = caputreScreenshot(info);
//extentTest.pass("Screenshot",
//        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//}
//
//public static String caputreScreenshot(String fileName) {
//
//TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
//File srcFile = ts.getScreenshotAs(OutputType.FILE);
//
//String projectRoot = System.getProperty("user.dir");
//String filePath = projectRoot + File.separator + "Screenshots" + File.separator + fileName + ".png";
//
//File dest = new File(filePath);
//dest.getParentFile().mkdirs();
//
//try {
//	FileUtils.copyFile(srcFile, dest);
//} catch (IOException e) {
//	e.printStackTrace();
//}
//
//return filePath;
//
//}