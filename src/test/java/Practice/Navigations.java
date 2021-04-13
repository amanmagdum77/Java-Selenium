package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
		System.out.println("Opening google.com....");
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		System.out.println("Opening instagram.com....");
		driver.navigate().to("https://www.instagram.com/");
		Thread.sleep(2000);
		
		System.out.println("Navigating back to google.com....");
		driver.navigate().back();
		Thread.sleep(1000);
		System.out.println("Navigating forward to instagram.com....");
		driver.navigate().forward();
		Thread.sleep(1000);
		System.out.println("Navigating back to google.com....");
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.findElement(By.name("q")).sendKeys("Naruto");
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
	}

}
