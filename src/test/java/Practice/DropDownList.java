package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {

	static WebDriver driver;

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://accounts.random.org/create");
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();

		WebElement moveto = driver.findElement(By.xpath("//*[@id=\"register-terms-group\"]/label"));

		Actions actions = new Actions(driver);
		actions.moveToElement(moveto);
		actions.perform();

		


		Select s2 = new Select(driver.findElement(By.id("register-time-zone"))); 
		s2.selectByValue("Africa/Accra");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Select s3 = new Select(driver.findElement(By.id("register-language")));  
		
		s3.selectByVisibleText("French");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");


	}

}
