package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthenticationPopUp {

	static WebDriver driver;
	
	public static String username = "admin";
	public static String password = "admin";
	
	
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
		System.out.println("Opening website....");
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//https://admin:admin@the-internet.herokuapp.com/basic_auth
		//		username:pass@	(put your username and password in the same format following : and @ before the url)    		
		
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
	
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		Thread.sleep(4000);
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
	}
}
