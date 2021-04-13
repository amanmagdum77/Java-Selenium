package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Frames2 {

	static WebDriver driver;
	static JavascriptExecutor js;


	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		js = (JavascriptExecutor) driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximizing window....");


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Opening website....");
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		int sizeFrame = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println("Total frames "+ sizeFrame);
	
		driver.switchTo().frame("frame1");
		WebElement textf = driver.findElement(By.xpath("//input[@type='text']"));
		textf.sendKeys("Naruto Uzumaki");
		System.out.println(textf.getAttribute("type"));
	
		
		driver.switchTo().frame(driver.findElement(By.id("frame3")));
		WebElement cb =driver.findElement(By.xpath("//input[@id='a']"));
		cb.click();
		System.out.println(cb.isSelected());
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		Select drop = new Select(driver.findElement(By.id("animals")));
		WebElement  d =  driver.findElement(By.id("animals"));
		drop.selectByIndex(3);
		System.out.println(d.getAttribute("value"));
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
	}
}
