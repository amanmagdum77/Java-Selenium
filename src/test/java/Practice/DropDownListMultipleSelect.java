package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDownListMultipleSelect {
	static WebDriver driver;


	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();

		WebElement moveto = driver.findElement(By.xpath("//*[@id=\"printAll\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(moveto);
		actions.perform();

		Select s1 = new Select(driver.findElement(By.id("multi-select")));

//		WebElement firstSelect =  s1.getFirstSelectedOption();
//		firstSelect.getText();

		s1.selectByValue("California");
		s1.selectByIndex(3);
		s1.selectByVisibleText("Ohio");

		List<WebElement> allItems = s1.getAllSelectedOptions(); 
		System.out.println(allItems.size());
		//System.out.println(allItems);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s1.deselectAll();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s1.selectByValue("Texas");
		s1.selectByIndex(7);
		s1.selectByVisibleText("Florida");
		s1.selectByIndex(4);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		List<WebElement> allItems1 = s1.getAllSelectedOptions(); 
		System.out.println(allItems1.size());
		//System.out.println(allItems1);

		s1.deselectByIndex(7);
		s1.deselectByValue("Texas");
	

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allItems2 = s1.getAllSelectedOptions(); 
		System.out.println(allItems2.size());
		driver.close();
		driver.quit();
		System.out.println("Test executed successfully");
	}
}
