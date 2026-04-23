package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
		extentSparkReporter.config().setTheme(Theme.STANDARD);
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
		
	}
	
}