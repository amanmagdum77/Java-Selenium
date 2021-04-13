package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllLinks {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://www.sugarcrm.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks1 =  driver.findElements(By.tagName("a"));
		Thread.sleep(2000);
		
		List<WebElement> allLinks =  driver.findElements(By.tagName("a"));
		System.out.println("Total tags are = "+ allLinks.size());
		System.out.println("");
		for(int i=0; i<allLinks.size(); i++) {
			System.out.println(allLinks.get(i).getAttribute("href"));
			System.out.println(allLinks.get(i).getText());
			Thread.sleep(50);
		}
		
		
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");

	}

}
