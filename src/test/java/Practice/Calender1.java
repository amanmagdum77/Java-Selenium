package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender1 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("http://demo.guru99.com/test/");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
		   //Find the date time picker control
		WebElement dateTime = driver.findElement(By.xpath("//input[@name='bdaytime']"));
	
		  //Fill date as mm/dd/yyyy as 09/25/2013
		dateTime.sendKeys("26031999");

		 //Press tab to shift focus to time field
		dateTime.sendKeys(Keys.TAB);

        //Fill time as 02:45 PM
		dateTime.sendKeys("0645AM");
		
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
	}

}
