package TestNG_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataprovidersDemo {

	DataFormatter formatter = new DataFormatter();
	
	
//	static WebDriver driver;
//	
//	
//	@BeforeMethod
//	public static void setUp() {
//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver1/chromedriver.exe");
//
//		driver = new ChromeDriver();
//		System.out.println("Opening website....");
//		driver.get("");
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		System.out.println("Maximizing window....");
//		driver.manage().window().maximize();
//	}
//	
	
//................................................................................................................................	
	
	@Test(dataProvider = "dataP")   //give the name of DataProvider which @Test is listening to. 
	public void moodleLogin(String username, String password) {
		
		System.out.println("username: "+username+" | password: "+password);
		
		
		
	}
	
	
//....................................................................................................................................
	
	@DataProvider(name="dataP")
	public Object[][] getTestData() throws IOException {
		
		//String projectPath = System.getProperty("user.dir");
		
		//Object[][] data = {{"1704050","yourname"},{"1703056","1703056"}};
		FileInputStream fis =  new FileInputStream("C:\\Users\\Aman\\eclipse-workspace\\SeleniumSampleFramework\\src\\test\\java\\TestNG_Practice\\moodleLoginID.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);    //High level representation of XSSF Workbook
		
		XSSFSheet sheet =  wb.getSheetAt(0);
		//XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i=0; i<rowCount-1; i++) {       //use proper row count or program won't run
			row = sheet.getRow(i+1);
			for(int j=0; j<colCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		
		
		return data;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
//	@AfterMethod
//	public static void tearDown() {
//		driver.close();
//		driver.quit();
//	}
//	
//	
	
}
