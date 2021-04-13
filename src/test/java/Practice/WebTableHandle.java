package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("java.net.preferIPv4Stack" , "true");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....\n");
		driver.manage().window().maximize();
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		
		String BeforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String AfterXpath = "]/td[1]";
		
		System.out.println("Column 1 data");
		for(int i=2; i<=7; i++) {
			String actualXpath = BeforeXpath + i + AfterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			if (element.getText().equals("Island Trading")) {
				System.out.println("Company name: "+ element.getText()+" is found at position: "+i);
			}
			
			
		}
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String BeforeXpath1 = "//*[@id=\"customers\"]/tbody/tr[3]/td[";
		String AfterXpath1 = "]";
		
		System.out.println("Row 3 data");
		for(int i=1; i<=3; i++) {
			String actualXpath1 = BeforeXpath1 + i + AfterXpath1;
			WebElement element1 = driver.findElement(By.xpath(actualXpath1));
			System.out.println(element1.getText());
			if (element1.getText().equals("Mexico")) {
				System.out.println("Country name: "+ element1.getText()+" is found at position: "+ i);
			}	
		}
		
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		List <WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("\nTotal rows: "+ rowCount);
	
		String AfterXpathCountry = "]/td[3]";
		System.out.println("Column 3 data");
		for(int i=2; i<=rowCount; i++) {
			String actualXpath = BeforeXpath + i + AfterXpathCountry;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		
		driver.close();
		driver.quit();
		System.out.println("\nTest case executed successfuly");
		
		
	}
}
