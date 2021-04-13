package Practice;

import java.util.concurrent.TimeUnit;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutordemo2 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("java.net.preferIPv4Stack" , "true");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://www.twoplugs.com/");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		System.out.println("Maximizing window....\n");
		driver.manage().window().maximize();
		
		
		// Scrolling
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,1200)", "");     // working
		
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");                  //working
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);         //working
		
		//js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//a[contains(@href,'/about')])[2]")));  // working
		
		Thread.sleep(2000);
		
		WebElement loginBtn = driver.findElement(By.xpath("//a[contains(@href,'/login')]"));
		WebElement signUpBtn = driver.findElement(By.xpath("(//a[contains(@href,'/signup')])[3]"));
		
		js.executeScript("arguments[0].style.border='5px solid red'", signUpBtn);              //working
		js.executeScript("arguments[0].style.border='3px solid red'", loginBtn);	           //working
		Thread.sleep(3000);
		
		
		
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
	}
}
