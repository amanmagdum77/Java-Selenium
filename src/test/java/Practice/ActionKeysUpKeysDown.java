package Practice;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class ActionKeysUpKeysDown {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://demoqa.com/text-box");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement src = driver.findElement(By.id("currentAddress"));
		WebElement dst = driver.findElement(By.id("permanentAddress"));
		
		
		src.sendKeys("A powerful fox known as the Nine-Tails attacks Konoha, the hidden leaf village "
				+ "in the Land of Fire, one of the Five Great Shinobi Countries in the Ninja World."
				+ " In response, the leader of Konoha and the Fourth Hokage, Minato Namikaze (with"
				+ " his wife Kushina Uzumaki) seals the fox inside the body of his newborn son, Naruto Uzumaki, "
				+ "making Naruto a host of the beast; this costs Naruto's father his life, and the Third Hokage returns "
				+ "from retirement to become the leader of Konoha again. Naruto is often ridiculed by the "
				+ "Konoha villagers for being the host of the Nine-Tails. Because of a decree made by the Third "
				+ "Hokage forbidding anyone to mention these events, Naruto knows nothing about the Nine-Tails"
				+ " until 12 years later, when Mizuki, a renegade ninja, reveals the truth to Naruto. Naruto then"
				+ " defeats Mizuki in combat, earning the respect of his teacher Iruka Umino.");
		
	// select all and copy
		action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
	// switch to permanent address using TAB
		action.sendKeys(Keys.TAB).build().perform();
		
	// paste 
		action.keyDown(Keys.CONTROL).sendKeys("v");
		action.keyUp(Keys.CONTROL)
		.build().perform();
		
	 //Compare Text of current Address and Permanent Address
       assertEquals(src.getAttribute("value"),dst.getAttribute("value"));
        
		Thread.sleep(2000);
	
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
		
		
		
	}
	
}
