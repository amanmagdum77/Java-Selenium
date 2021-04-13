package TestNG_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	
	// testng0.xml
	// run testng0.xml | file not this file.
	
	static WebDriver driver;

	@Test
	@Parameters({"username","password"})
	public static void moodleLogin(String username,String password) {
//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");
//
//		driver = new ChromeDriver();
//		System.out.println("Maximizing window....");
//		driver.manage().window().maximize();
//
//		System.out.println("Opening website....");
//		driver.get("http://210.212.171.173/moodle/login/index.php");
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("username: "+username+"\npassword: "+password);
		
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
	}
	
	
}
