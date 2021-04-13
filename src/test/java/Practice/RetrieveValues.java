package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RetrieveValues {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C355887219806%7Ce%7Cfacebook%20signup%7C&placement=&creative=355887219806&keyword=facebook%20signup&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387563%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-321689134300%26loc_physical_ms%3D1007788%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMIovyWq7P27gIVxrmWCh1nZQvhEAAYASAAEgKhpfD_BwE");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();

		driver.findElement(By.name("firstname")).sendKeys("Aman");
		driver.findElement(By.name("lastname")).sendKeys("Magdum");
		driver.findElement(By.name("reg_email__")).sendKeys("amanmagdum77@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("amanmagdum77@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("FCLiverpool@123");

		Select date = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		date.selectByValue("27");
		Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		month.selectByValue("7");
		Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year.selectByValue("1999");

		
		
		WebElement fnameAttributes = driver.findElement(By.name("firstname"));	
		System.out.println("");
		System.out.println("type : "+fnameAttributes.getAttribute("type"));
		System.out.println("name : "+fnameAttributes.getAttribute("name"));
		System.out.println("id : "+fnameAttributes.getAttribute("id"));
		System.out.println("aria-label : "+fnameAttributes.getAttribute("aria-label"));
		System.out.println("class : "+fnameAttributes.getAttribute("class"));

		WebElement monthAttributes = driver.findElement(By.xpath("//select[@id='month']"));
		System.out.println("");
		System.out.println("aria-label : "+monthAttributes.getAttribute("aria-label"));
		System.out.println("name : "+monthAttributes.getAttribute("name"));
		System.out.println("id : "+monthAttributes.getAttribute("id"));
		System.out.println("title : "+monthAttributes.getAttribute("title"));
		System.out.println("class : "+monthAttributes.getAttribute("class"));

		
		System.out.println("");
		System.out.println("Radio button found = "+driver.findElements(By.xpath("//input[@type='radio']")).size());
		driver.findElements(By.xpath("//input[@type='radio']")).get(1).click();
		
		WebElement radioAttributes = driver.findElement(By.xpath("//input[@type='radio']"));
		
		System.out.println("type : "+radioAttributes.getAttribute("type"));
		System.out.println("name : "+radioAttributes.getAttribute("name"));
		System.out.println("id : "+radioAttributes.getAttribute("id"));
		System.out.println("value : "+radioAttributes.getAttribute("value"));
		System.out.println("class : "+radioAttributes.getAttribute("class"));
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		System.out.println("");
		System.out.println("test case executed successfully");

	}

}
