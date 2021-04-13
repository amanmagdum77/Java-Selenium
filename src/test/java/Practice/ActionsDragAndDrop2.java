package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop2 {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement sE = driver.findElement(By.id("draggable"));
		WebElement dE = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		Thread.sleep(1000);
		
		action.
		clickAndHold(sE)
		.moveToElement(dE)
		.release()
		.build()
		.perform();
		
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		

		
		
	}
}
