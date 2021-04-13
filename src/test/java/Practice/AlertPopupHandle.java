package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		System.out.println("Maximizing window....");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

		///////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText(); 
		System.out.println("Alert text = "+alertText);
		
		if (alertText.equals("Please enter a valid user name")) {
			System.out.println("Correct alert message");
		}else {
			System.out.println("Incorrect alert message");
		}
		alert.accept();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("amanmagdum77@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert text = "+alert1.getText());
		alert1.accept();
		
		
		Thread.sleep(2000);
		
		//////////////////////////////////////////////////////////////////////////////////////////
		driver.close();
		
		System.out.println("Test case executed successfully ");
		
		
		

	}

}
