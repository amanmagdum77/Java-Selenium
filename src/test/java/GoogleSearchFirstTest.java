
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class GoogleSearchFirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		googleSearch();
		
		
		
		
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void googleSearch() {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Visit google.com
		driver.get("https://www.google.com/");
		
		// Enter text in search box
		driver.findElement(By.name("q")).sendKeys("Naruto");
		
		
		// Hit enter on keyboard
		WebElement my_element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		my_element.click();
		driver.close();
		driver.quit();
	
		System.out.println("Test completed successfully");
		
		
		
	}

}
