package TestScript;

import Step.ritMoodleLoginStep;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class RitMoodleLoginTest {

	public static WebDriver driver = null;

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test1 = null;

	//	public static void main(String[] args) {

	@BeforeSuite
	public void SetUp() {
		htmlReporter = new ExtentHtmlReporter("extentReportMoodle1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 
	}

	@Test
	public void Test() {
		test1 = extent.createTest("RIT Moodle Test1","This is a test to check RIT Moodle website working");
		test1.log(Status.INFO, "Starting test case....");

		ritMoodleLoginStep gt = new ritMoodleLoginStep(test1); // test1 is passed to the constructor

		gt.openMoodle();
		gt.login();	
		gt.logout();
		gt.closeMoodle();


		test1.log(Status.INFO, "Test case completed. ");
	}

	@AfterSuite
	public void teardown() {
		extent.flush();
	}





}
//}
