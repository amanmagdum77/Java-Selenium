import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReportsGoogleSearch.html");
		
		//create extentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 
		
		//creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test 1","This is a test to validate google search functionality");
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		test1.log(Status.INFO, "Starting test case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Akatsuki");
		test1.pass("Entered text in testBox");
		
		
	//	driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		WebElement my_element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		my_element.click();

		
		
		
		
		
		driver.close();
		test1.pass("Browser closed");
		test1.info("Test completed");
		
		extent.flush();
		
	}

}
