package Practice;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsHandle {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
		System.out.println("Opening google.com....");
		driver.get("https://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String parentHandlenName = driver.getWindowHandle();
		System.out.println("Parent Window id is "+parentHandlenName);
		
		driver.findElement(By.xpath("//a[contains(@href,\"//www.google.com\")]")).click();
		
		Set<String> allHandlesNames = driver.getWindowHandles();
		int count = allHandlesNames.size();
		System.out.println("Total window count = "+count);
		
		for(String childHs:allHandlesNames) {
			System.out.println(childHs);
		}
		
		for(String childHandle : allHandlesNames ) {
			if(!childHandle.equalsIgnoreCase(parentHandlenName)) {
				driver.switchTo().window(childHandle);
				driver.findElement(By.name("q")).sendKeys("Itachi Uchiha");
				driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				driver.close();
			}
		}
		
		driver.switchTo().window(parentHandlenName);
		System.out.println("Parent window Title name = "+driver.getTitle());
		Thread.sleep(1500); 		
		driver.findElement(By.xpath("//a[contains(@href,\"//www.google.com\")]")).click();
		driver.findElement(By.xpath("//a[contains(@href,\"//www.facebook.com\")]")).click();
		//driver.findElement(By.xpath("//a[contains(@href,\"//www.yahoo.com\")]")).click();
		driver.findElement(By.xpath("//a[contains(@href,\"//www.google.com\")]")).click();
		driver.findElement(By.xpath("//a[contains(@href,\"//www.facebook.com\")]")).click();
		//driver.findElement(By.xpath("//a[contains(@href,\"//www.yahoo.com\")]")).click();
		
		Thread.sleep(2000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for(int i=0;i<tabs.size();i++) {
			System.out.println(tabs.get(i));
			System.out.println("Current window title = "+driver.getTitle());
		}
		
		System.out.println("Switching to Tab index 1");
		driver.switchTo().window(tabs.get(1));
		System.out.println("Current window title = "+driver.getTitle());
		Thread.sleep(2000);
		
		System.out.println("Closing all tabs");

		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
	}

}
