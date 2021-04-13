package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Radio {

	static WebDriver driver;



	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening Mortgage Payoff Calculator....");
		driver.get("https://www.calculator.net/mortgage-payoff-calculator.html");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();


		WebElement calculate = driver.findElement(By.xpath("//*[@id=\"calinputtable\"]/tbody/tr[6]/td/input[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(calculate);
		actions.perform();


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		WebElement radioBtn1 =  driver.findElement(By.id("cpayoff1"));
		System.out.println(radioBtn1.isSelected() + "-R1 not selected");
		radioBtn1.click();
		System.out.println(radioBtn1.isSelected() + " -R1 selected");
		Thread.sleep(2000);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		WebElement radioBtn4 =  driver.findElement(By.id("cpayoff4"));
		System.out.println(radioBtn4.isSelected() + "-R4 not selected");
		radioBtn4.click();
		Thread.sleep(2000);

		System.out.println(radioBtn4.isSelected() + " -R4 selected");
		System.out.println(radioBtn1.isSelected() + "-R1 not selected");

		Thread.sleep(2000);
		WebElement radioBtn3 = driver.findElement(By.id("cpayoff3"));
		System.out.println(radioBtn3.isSelected()+"-R3 not selected");
		radioBtn3.click();
		System.out.println(radioBtn3.isSelected()+ " -R3 selected");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		System.out.println("Test excecuted successfully");

	}

}
