package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class LocatorsYahoo {

	static WebDriver driver;
	static Select dropBirthMonth;
	static WebElement checkBox;
	static JavascriptExecutor js ;

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		yahooVisitPage();
		LoginPageCredentials();
		yahooSignUp();
		yahooNavigating();
	//	yahooSignIn();
		yahooClose();

	}





	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	private static void yahooVisitPage() {
		// TODO Auto-generated method stub

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		// visit yahoo website
		System.out.println("Opening Yahoo login page....");
		driver.get("https://login.yahoo.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

	}
	
	public static void LoginPageCredentials() {
		
		WebElement checkBox1;
		
		// Enter email address 
		driver.findElement(By.id("login-username")).sendKeys("amanmagdum77@gmail.com");

		// Stay signed in checkbox
		checkBox= driver.findElement(By.name("persistent"));
		if(checkBox.isSelected()) {

		}else {
			checkBox.click();
		}

		
		System.out.println("No Account found, Trying to create new account");
		// Create account Button 
		//driver.findElement(By.xpath("//a[@href='https://login.yahoo.com/account/create?src=noSrc&specId=yidReg&done=https%3A%2F%2Fwww.yahoo.com']")).click();
		driver.findElement(By.id("createacc")).click();

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static void yahooSignUp() {
		// TODO Auto-generated method stub

		// Fill SignUp form
		System.out.println("Proceding to fill form");

		driver.findElement(By.partialLinkText("I want to use my current")).click();;
		driver.findElement(By.id("usernamereg-firstName")).clear();
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Aman");
		driver.findElement(By.id("usernamereg-lastName")).clear();
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Magdum");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("jackwildom0@gmail.com");
		driver.findElement(By.name("password")).sendKeys("FCLiverpool@123");

		dropBirthMonth = new Select(driver.findElement(By.id("usernamereg-month")));
		dropBirthMonth.selectByVisibleText("July");

		driver.findElement(By.name("dd")).clear();
		driver.findElement(By.name("dd")).sendKeys("27");
		driver.findElement(By.name("yyyy")).clear();
		driver.findElement(By.name("yyyy")).sendKeys("1999");
		driver.findElement(By.name("freeformGender")).clear();
		driver.findElement(By.name("freeformGender")).sendKeys("Male");


		try {
			driver.findElement(By.name("signup")).click();
		} catch (Exception e) {

			System.out.println("Form did not fill");
			yahooSignUp();
		}

		
		System.out.println("Form Filled");


	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static void yahooNavigating() {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Help")).click();
		System.out.println("Clicked on Help");
		driver.findElement(By.xpath("//a[@href='https://login.yahoo.com/?.lang=en-IN&src=help&.done=https%3A%2F%2Fin.help.yahoo.com%2Fkb%2Faccount&pspid=986299015&activity=ybar-signin']")).click();
	

	}


	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static void yahooSignIn() {
	
		js = (JavascriptExecutor) driver;

		
		//driver.findElement(By.name("username")).sendKeys("amanmagdum77@gmail.com");
		//driver.findElement(By.id("login-username")).sendKeys("amanmagdum77@gmail.com");
		//System.out.println("Entered email");
		
		//checkBox= driver.findElement(By.name("persistent"));
		//checkBox.click();
		
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("Window scrolled down");
		
		driver.findElement(By.id("tpa-google-button")).click();
//		driver.findElement(By.name("tpaProvider")).click();
//		driver.findElement(By.xpath("(//*[@class='OVnw0d'])[0]"));

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static void yahooClose() {
		// TODO Auto-generated method stub
		driver.close();
		driver.quit();
		System.out.println("Closing Yahoo login page....");
	}



}
