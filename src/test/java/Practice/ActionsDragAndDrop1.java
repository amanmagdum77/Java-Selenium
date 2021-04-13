package Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop1 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximizing window....");
		System.out.println("Opening website....");
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");	
		
		//Element which needs to drag.    		
    	WebElement From =driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
    	System.out.println("Element to be dragged selected");
    	
    	//Element on which need to drop.		
        WebElement To =driver.findElement(By.xpath("//*[@id='mydropzone']"));					
        System.out.println("Location where element to be dragged selected");		
        
        //Using Action class for drag and drop.	
        System.out.println("Dragging and dropping");
        Actions act=new Actions(driver);					

        /////////////////////////////////////////////////////////////////////////////////////////////////
        
        //Dragged and dropped.		
        //act.dragAndDrop(From, To).build().perform();
        //act.dragAndDropBy(From,(int) 300.14, 64).release().build().perform();
        //act.clickAndHold(From).moveToElement(To).release().build().perform();
        
        act.clickAndHold(From).moveToElement(To).release().build().perform();
        
        System.out.println("Dragged and dropped.");
        
        Thread.sleep(1000);
        driver.close();
        driver.quit();
        System.out.println("Test case executed successfully");
		

	}

}
