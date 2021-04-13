package TestScript;
import org.openqa.selenium.WebDriver;
import Step.GoogleSearchStep;

public class GoogleSearchTest {

	public static WebDriver driver = null; 
	
	
	public static void main(String[] args) {
	
		GoogleSearchStep gt = new GoogleSearchStep();
		
		gt.googleSearch();		
		
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

}
