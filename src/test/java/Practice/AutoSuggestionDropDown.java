package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropDown {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/a/img")).click();
		driver.findElement(By.xpath("//span[text()=\"From\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys("Mu");
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
		
		
	}

}
