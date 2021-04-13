import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class RitMoodleLoginTestNG {

	WebDriver driver = null;

	
	@BeforeTest
	public void setUpTest(){
		
	
	
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://210.212.171.173/moodle/login/index.php");
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Test
	public void Test() {
		driver.manage().window().maximize();
		
		
		////////////////////////////////////////////// User login ///////////////////////////////////////////////////////////////////////////		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("1703056");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1703056");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("loginbtn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	  
		//driver.findElement(By.xpath("//a[contains(@href,'//210.212.171.173/moodle/login/logout.php?sesskey=4vmx5LG0cu')]")).click();
		driver.findElement(By.linkText("Log out")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		///////////////////////////////////////////// New user login /////////////////////////////////////////////////////////////		
		
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		
		WebElement textBoxUserName = driver.findElement(By.id("username"));
		textBoxUserName.sendKeys("1704050");
		
		WebElement textBoxPassword = driver.findElement(By.id("password"));
		textBoxPassword.sendKeys("yourname");
		
		driver.findElement(By.id("loginbtn")).click();
	
		
	
	}
			
//		Using single line
//		driver.findElement(By.id("username")).sendKeys("1704050");
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@AfterTest
	public void closeBrowser() {		
		driver.close();
		System.out.println("Test completed successfully");
//		driver.quit();
		
	}

}
