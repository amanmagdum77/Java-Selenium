
package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class JavaScirptExecutordemo1 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.gecko.driver",projectPath + "/drivers/geckodriver/geckodriver.exe");

		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		System.out.println("Opening website....");
		driver.get("https://www.freecrm.com/");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		System.out.println("Maximizing window....\n");
		driver.manage().window().maximize();
		
	
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
//		js.executeScript("alert('Welcome to Selenium')");
//		Alert a1 = driver.switchTo().alert();
//		Thread.sleep(2000);
//		a1.accept();
//	
//		js.executeScript("prompt('Enter your name')");   //not working
//		Thread.sleep(2000);
//		Alert a2 = driver.switchTo().alert();
//		a2.sendKeys("Aman Magdum");                      // not sending keys
//		System.out.println(a2.getText());
//		Thread.sleep(2000);
//		a2.accept();
//		
//		js.executeScript("confirm('Are you sure?')");
//		Thread.sleep(2000);
//		Alert a3 = driver.switchTo().alert();
//		a3.accept();
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
		
//		WebElement element = driver.findElement(By.xpath("//a[contains(@href,'https://ui.cogmento.com')]"));
//		WebElement login = driver.findElement(By.xpath("//span[text()='Log In']"));
//		
//		flash(element, driver);		    //not working
//		clickLoginUsingJS(login,driver);   //working
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// refresh in selenium
		//driver.navigate().refresh();  // working    
		
		//refresh in Javascript
		//refreshUsingJavascript(driver);  // working
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		

//		System.out.println(driver.getTitle());   
//		System.out.println(getTitleUsingJS(driver));   // working
//		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		String pageText = getInnerText(driver);  // working
//		System.out.println(pageText);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		driver.close();
		driver.quit();
		System.out.println("\nTest case executed successfully");
		
		
	}
	private static String getInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	private static String getTitleUsingJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	private static void refreshUsingJavascript(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
		System.out.println("Refreshed using JS");
		
	}
	private static void clickLoginUsingJS(WebElement login, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", login);
		Thread.sleep(3000);
		driver.navigate().back();
		
	}
	public static void flash(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i=0;i<50;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
	}
	private static void changeColor(String color, WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("argument[0].style.backgroundColor = '"+color+"'", element);
		Thread.sleep(2000);
		
	}
	
	
	
	
	
	
}
