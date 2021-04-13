package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPage;

public class GoogleSearchStep {
	
	public static WebDriver driver = null; 
	public GoogleSearchPage gt = new GoogleSearchPage();
	
	public void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "//drivers//chromedriver1//chromedriver.exe");
		driver = new ChromeDriver();
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		
	
		driver.get("https://www.google.com/");
		

		
		driver.findElement(GoogleSearchPage.textboxSearch()).sendKeys("Naruto");
	
		driver.findElement(GoogleSearchPage.textboxSearch()).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//a[contains(@href,'https://en.wikipedia.org/wiki/Naruto')]")).click();
		

		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
		
		
		
	}

	
	
	
	
	
	

}
