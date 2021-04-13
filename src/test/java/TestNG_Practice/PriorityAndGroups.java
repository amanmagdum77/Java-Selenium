package TestNG_Practice;

import org.testng.annotations.Test;

public class PriorityAndGroups {
	
	@Test(priority = 1, groups = "Login")
	public static void Login() {
		System.out.println("Logging in...........");
	
	}
	
	@Test(priority = 2,groups = "HomePage")
	public static void HomePage() {
		System.out.println("Opening Home Page...........");
	}
	
	
	@Test(priority = 4,groups = "Click")
	public static void ClickOnFirstSearchResults() {
		System.out.println("Clicking............");
	}
	
	
	@Test(priority = 3,groups = "Search")
	public static void Search() {
		System.out.println("Searching something.........");
	}
	
	
	@Test(priority = 5,groups = "Random Test")
	public static void randomTest1() {
		System.out.println("1. From same group");
	}
	
	@Test(priority = 6,groups = "Random Test")
	public static void randomTest2() {
		System.out.println("2. From same group");
	}
	
	@Test(priority = 7,groups = "Random Test")
	public static void randomTest3() {
		System.out.println("3. From same group");
	}
	
}
