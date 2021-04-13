package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import Pages.ritMoodleLoginPage;



public class ritMoodleLoginStep{
	
	public static WebDriver driver;
	ExtentTest test = null;
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ritMoodleLoginStep(ExtentTest test1){
		test = test1;
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");
		driver = new ChromeDriver();

	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	


	public void openMoodle() {

		driver.get("http://210.212.171.173/moodle/login/index.php");
		driver.manage().window().maximize();
		System.out.println("Moodle opened");
		test.pass("Navigated to http://210.212.171.173/moodle/login/index.php");
		
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public void login() {

		driver.findElement(ritMoodleLoginPage.findUsername()).sendKeys("1704050");
		test.pass("Entered Username");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(ritMoodleLoginPage.findPassword()).sendKeys("yourname");
		test.pass("Entered password");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.pass("logged in");
		driver.findElement(ritMoodleLoginPage.findLoginLinkText()).click();
		System.out.println("Login Successfull");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void logout() {

		driver.findElement(ritMoodleLoginPage.findLogoutLinkText()).click();
		test.pass("Logged out");
		
		
		
		System.out.println("Logout Successfull");
		driver.findElement(By.xpath("//input[@id='username']")).clear();
				
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void closeMoodle() {
		
		driver.close();
		driver.quit();
		System.out.println("Moodle closed");
	}
	
}
