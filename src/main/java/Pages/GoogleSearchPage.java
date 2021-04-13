package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	private static WebElement element = null;
	
	public static By textboxSearch() {
		return By.name("q");
	}
	
	public static By buttonSearch() {
		
		return By.name("btnK");
	}
	
}
 