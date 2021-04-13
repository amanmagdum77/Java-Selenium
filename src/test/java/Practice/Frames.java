package Practice;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	static WebDriver driver;
	static JavascriptExecutor js;


	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		js = (JavascriptExecutor) driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximizing window....");


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Opening website....");
		driver.get("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");

		int sizeFrame = driver.findElements(By.tagName("frame")).size();

		System.out.println("Total frames "+ sizeFrame);
		
		List<WebElement> frames = new ArrayList<WebElement>();
		frames = driver.findElements(By.tagName("frame"));
		
		for(int i=0; i<frames.size(); i++) {
			System.out.println("Frames src: "+frames.get(i).getAttribute("src"));
		}

		try {
			driver.findElement(By.name("name")).sendKeys("Aman Magdum");
		

		} catch (Exception e) {
			System.out.println("Cannot locate element | website contains frames");
		}


		driver.switchTo().frame(1);

		try {
			driver.findElement(By.name("name")).sendKeys("Aman Magdum");
			System.out.println("Entered name 'Aman Magdum' in Frame2");

		} catch (Exception e) {
			System.out.println("Cannot locate element | website contains frames");
		}


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		driver.switchTo().defaultContent();

		driver.switchTo().frame(0);

		System.out.println("Moved to  frame 1");
		//js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//a[contains(text(),'Background')]")).click();

		//js.executeScript("window.scrollBy(0,500)");
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		//driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		System.out.println("Moved to Frame 3");
		driver.findElement(By.xpath("//option[@value=\"#structure\"]")).click();


		js.executeScript("window.scrollBy(0,1000)");




		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");


	}

}
