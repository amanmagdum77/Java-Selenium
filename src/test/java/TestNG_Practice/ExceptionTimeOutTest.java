package TestNG_Practice;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {

	@Test(timeOut = 2000)  
	public static void infiniteLoop() {
		int i = 1;
		while(true) {
			System.out.println(i);
			i++;
		}
		
	}
	
}
