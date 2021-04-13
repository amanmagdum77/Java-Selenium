package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRightClick {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
	
		WebElement rightClickMe = driver.findElement(By.xpath("//p//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions action = new Actions(driver); 
		action.contextClick(rightClickMe).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-cut']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		action.contextClick(rightClickMe).build().perform();
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-paste']")).click();
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
		
	
	
	
	
	
	
	}
}
