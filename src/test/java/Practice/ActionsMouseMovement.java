package Practice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMouseMovement {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();

		System.out.println("Opening website....");
		driver.get("http://mrbool.com/");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='navspace menucel ativo2 dm-2']//li//a[@class='menulink']")))
		.build()
		.perform();
		System.out.println("Mouse Movement done");
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Articles']")).click();
		System.out.println("Opening Articles");
		Thread.sleep(1500);
		
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");

	}

}
