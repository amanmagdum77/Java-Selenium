package Practice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calendar3 {
	static WebDriver driver;
	static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {

		String expectedDate="26-September-2021";
		String expDate=expectedDate.split("-")[0];
		String expMonth=expectedDate.split("-")[1];
		String expYear=expectedDate.split("-")[2];

		String expMonthYear = expectedDate.split("-")[1]+" "+expectedDate.split("-")[2];
		System.out.println(expMonthYear);

		//System.out.println(expDate+"/"+expMonth+"/"+expYear);



		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();

		System.out.println("Opening website....");
		driver.get("https://jqueryui.com/datepicker/#date%E2%88%92range");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();

		js =((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,300)", ""); 


		WebElement frame1 = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(frame1);

		WebElement sDate = driver.findElement(By.id("datepicker"));
		sDate.click();

	

//		WebElement departCalMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
//		WebElement departCalYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
//		System.out.println(departCalMonth.getText());
//		System.out.println(departCalYear.getText());

		
		
		WebElement monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		String monthYearText =monthYear.getText();


		//.....................................................................................................................
		
		if(!monthYearText.equals(expMonthYear))
		{
			while (true) {
				WebElement next = driver.findElement(By.xpath("//div//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				next.click();
				monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
				monthYearText =monthYear.getText();
				System.out.println(monthYearText);
				
				if(monthYearText.equals(expMonthYear)) {
					break;
				}

			}
		}
		
		//........................................................................................................................

		List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
		System.out.println(expDate);
		
		for (WebElement date : dates) {
			
			System.out.println(date.getText());
			if(date.getText().equals(expDate)) {
				date.click();
				break;
			}
		}
		
		
		
		Thread.sleep(4000);




		driver.close();
		driver.quit();
		System.out.println("Test case executed successfully");
	}
}
