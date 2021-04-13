package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLcertificates {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		DesiredCapabilities dc = new DesiredCapabilities();
		//dc.acceptInsecureCerts();
		//       OR
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);  // merge chromeOptions with our DesiredCapabilities
		
		driver = new ChromeDriver(); // creates new ChromeDriver using default server configuration
		System.out.println("Opening website....");
		driver.get("https://expired.badssl.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
	
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
		
		
	}
	
}
