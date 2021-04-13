package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Step.ritMoodleLoginStep;

public class BaseClass {
	
	public static WebDriver driver = null;

	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	
	@BeforeSuite
	public void setUp() {
		
		//start reporters
		htmlReporter = new ExtentHtmlReporter("extentReportBaseClass.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 
		
		 
	}
	
	@Test
	public void Test1() {
		//creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("RIT Moodle Test1","This is a test to check RIT Moodle website working");
		test1.log(Status.INFO, "Starting test case");
		
		ritMoodleLoginStep gt = new ritMoodleLoginStep(test1);
		
		gt.openMoodle();
		gt.login();	
		gt.logout();
		gt.closeMoodle();
		
		test1.log(Status.INFO, "Test case completed successfully");
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

	
	
}
