package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckBox {

	static WebDriver driver;
	static JavascriptExecutor js ;

	public static void main(String[] args) throws InterruptedException {

		openWebsite();
		checkbox();
		teardown();
	}

	private static void checkbox() throws InterruptedException {
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@name=\"eula\"]"));
		WebElement logIn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/div/p/a"));
		
//		js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,2000)");
//		System.out.println("Window scrolled down");
		Actions actions = new Actions(driver);
		actions.moveToElement(logIn);
		actions.perform();
		System.out.println(checkBox.isSelected());
		
		checkBox.click();
		System.out.println(checkBox.isSelected());
		
		checkBox.click();
		System.out.println(checkBox.isSelected());
		
		
	}

	private static void openWebsite() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening Developer Salesforce signup page....");
		driver.get("https://developer.salesforce.com/signup");
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();

	}


	private static void teardown() {

		driver.close();
		driver.quit();
		System.out.println("Test excecuted successfully");

	}


}
