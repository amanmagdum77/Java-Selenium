package Pages;

import org.openqa.selenium.By;

public class ritMoodleLoginPage {
	

	
	public static By findUsername() {
		return By.xpath("//input[@id='username']");
	}
	
	public static By findPassword() {
		return By.xpath("//input[@id='password']");
	}
	
	public static By findLoginLinkText() {
		return By.id("loginbtn");
	}
	
	public static By findLogoutLinkText() {
		return By.linkText("Log out");
	}
	
}
