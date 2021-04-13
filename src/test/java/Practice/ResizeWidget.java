package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeWidget {static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

	driver = new ChromeDriver();
	System.out.println("Opening website....");
	driver.get("https://jqueryui.com/resizable/");
	System.out.println("Maximizing window....");
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));

	WebElement r = driver.findElement(By.xpath("//div[@id=\"resizable\"]/div[3]"));
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_UP,Keys.ARROW_UP).build().perform();
	Thread.sleep(2000);
	
	//action.moveToElement(driver.findElement(By.xpath("//a[contains(@href,'http://api.jqueryui.com/resizable/')]")));
	action.clickAndHold(r).dragAndDropBy(r, 230, 130).release().build().perform();
	Thread.sleep(2000);
	driver.close();
	driver.quit();
	System.out.println("Test case executed successfully");


}
}
