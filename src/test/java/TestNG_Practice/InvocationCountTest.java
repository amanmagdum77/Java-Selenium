package TestNG_Practice;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class InvocationCountTest {

	
	//invocationCount = run/repeat test for that no. of count
	//invocationTimeOut = terminate test run in __ milliseconds
	//expectedExceptions = ignore the exception if found
	
	@Test(invocationCount = 10000,invocationTimeOut = 20,expectedExceptions = ThreadTimeoutException.class)
	public static void sum() {
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println("Sum = "+c);
	}
	
}
