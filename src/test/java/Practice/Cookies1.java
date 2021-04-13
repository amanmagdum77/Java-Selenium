package Practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Cookies1 {

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


		// create file named Cookies to store Login Information		
		File file = new File("Cookies.data");		
		try {

			// Delete old file if exists
			file.delete();		
			file.createNewFile();			
			FileWriter fileWrite = new FileWriter(file);							
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
			// loop for getting the cookie information 		
			for(Cookie ck : driver.manage().getCookies())							
			{			
				Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
				Bwrite.newLine();             
			}			
			Bwrite.close();			
			fileWrite.close();	
			// loop for getting the cookie information 	



		} catch (Exception ex) {
			ex.printStackTrace();	
		}
		
		
		Thread.sleep(1000);
		driver.close();
		driver.quit();


	}


}
