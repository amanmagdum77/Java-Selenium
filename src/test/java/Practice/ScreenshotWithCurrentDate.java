package Practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotWithCurrentDate {
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
		Date currentDate = new Date();
		System.out.println(currentDate);
		String ssFileName= currentDate.toString().replace(" ", "-").replace(":", "-"); 
		System.out.println(ssFileName);
		
		
		try {
			System.out.println("Opening google.com....");
			driver.get("https://www.google.com/");
			
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement naruto = driver.findElement(By.name("q"));
			naruto.sendKeys("Naruto Uzumaki");
			naruto.sendKeys(Keys.ENTER);
			driver.navigate().back();
			WebElement sasuke = driver.findElement(By.name("r"));
			sasuke.sendKeys("Sasuke Uchiha");
			
		} catch (Exception e) {
			File ss =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File loc =new File("/Users/Aman/eclipse-workspace/SeleniumSampleFramework/src/test/java/Practice/"+ssFileName+".png");
			FileUtils.copyFile(ss, loc);			
		}
		
		
		Thread.sleep(1000);
			
		driver.close();
		driver.quit();
		System.out.println("Test case executed");
	}
}









