package TestNG_Practice;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertDemo {

	static WebDriver driver;
	
	@BeforeMethod
	public static void SetUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("http://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public static void getTitle() {
	
		String title = driver.getTitle();
		System.out.println(title);
		
		assertEquals(title, "Google","title not matched.............");     
		// 1.Actual string  2.expected string 3. if not equal print message
		System.out.println("Assertion passed");
		
	}
	
	
	@Test
	public static void logoDisplayed() {
		boolean b = driver.findElement(By.xpath("//*[@class='lnXdpd']")).isDisplayed();
		assertTrue(b,"Logo not displayed");
	}
	
	
	@AfterMethod
	public static void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfuly");
	}
	
	
}
