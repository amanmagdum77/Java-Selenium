package TestNG_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DP {
	static DataFormatter formatter = new DataFormatter();
	public static void main(String[] args) throws IOException {
		FileInputStream fis =  new FileInputStream("C:\\Users\\Aman\\eclipse-workspace\\SeleniumSampleFramework\\src\\test\\java\\TestNG_Practice\\moodleLoginID.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet =  wb.getSheetAt(0);
		//XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i=0; i<rowCount-1; i++) {
			row = sheet.getRow(i+1);
			for(int j=0; j<colCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				System.out.println(formatter.formatCellValue(cell));
			}
		}

	}

}
// Simple class to get data from excel sheet.