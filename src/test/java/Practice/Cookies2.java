package Practice;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies2 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Opening website....");
		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Maximizing window....");
		driver.manage().window().maximize();
	
		Set <Cookie> cookies = driver.manage().getCookies();
	
		System.out.println("\nSize of cookies: "+ cookies.size());
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName()+" "+cookie.getValue());
		}
		
		
		Cookie cobj = new Cookie("MyCookie1", "Aman@123");
		driver.manage().addCookie(cobj);
		
		Cookie cobj2 = new Cookie("MyCookie2", "Sasuke Uchiha");
		Cookie cobj3 = new Cookie("MyCookie3", "Naruto Uzumaki");
		
		cobj = new Cookie("MyCookie1.1","Madara Uchiha");
		
		//////////////////////////////////////////////////////////////
		driver.manage().addCookie(cobj);
		driver.manage().addCookie(cobj2);
		driver.manage().addCookie(cobj3);
		cookies = driver.manage().getCookies();
		
		System.out.println("\nSize of cookies: "+ cookies.size());
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName()+" "+cookie.getValue());
		}
		
		driver.manage().deleteCookie(cobj2);
		driver.manage().deleteCookie(cobj3);
		cookies = driver.manage().getCookies();
		System.out.println("\nSize of cookies: "+ cookies.size());
		
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("\nSize of cookies: "+ cookies.size());
		
		
	
	driver.close();
	driver.quit();
	System.out.println("\nTest case executed successfully");
	}
	
}


