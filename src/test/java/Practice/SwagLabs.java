package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		visitSwagLabsLoginPage();
		login();
		teardown();

	}

	private static void teardown() {
		
		driver.close();
		driver.quit();
		System.out.println("Test excecuted successfully");
		
	}

	private static void login() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[starts-with(@id,'passw')]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/form/input[3]")).click();
		System.out.println("Logged in");
		
	}

	
	private static void visitSwagLabsLoginPage() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening Swag Labs login page....");
		driver.get("https://www.saucedemo.com/");
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		
	}


}
