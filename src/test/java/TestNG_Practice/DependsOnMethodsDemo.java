package TestNG_Practice;

import org.testng.annotations.Test;

public class DependsOnMethodsDemo {

	@Test
	public static void Login() {
		System.out.println("Logging in...........");
		//int i = 9/0;   // uncomment this
	}
	
	@Test(dependsOnMethods = "Login")
	public static void HomePage() {
		System.out.println("Opening Home Page...........");
	}
	
	@Test(dependsOnMethods = "Login")
	public static void Search() {
		System.out.println("Searching something.........");
	}
	
	@Test(dependsOnMethods = "Login")
	public static void ClickOnFirstSearchResults() {
		System.out.println("Clicking............");
	}
	
}
