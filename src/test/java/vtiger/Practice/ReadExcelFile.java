package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		//load the file into file input stream
		FileInputStream fis=new FileInputStream(".\\Tests.xlsx");
		
		//create workbook using workbook factory
		Workbook wb=WorkbookFactory.create(fis);
		
		//navigate to sheet
		    Sheet sh = wb.getSheet("Organization");
		
		//navigate to row
		   Row row = sh.getRow(1);
		
		//navigate to cell
		     Cell c = row.getCell(2);
		String val=c.getStringCellValue();
				
		//print		
	    System.out.println(val);
		
	}
}
