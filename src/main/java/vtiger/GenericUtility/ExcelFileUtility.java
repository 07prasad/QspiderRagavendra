package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	 
   public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
   {
		
	   
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row r=sh.getRow(row);
		Cell c=r.getCell(cell);
		String val=c.getStringCellValue();
		wb.close();
		return val;
		
	}


    public int getRowCount(String sheet) throws EncryptedDocumentException, IOException 
    {
    	
    	FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
    	Workbook wb=WorkbookFactory.create(fis);
    	Sheet sh=wb.getSheet(sheet);
    	int lastRow=sh.getLastRowNum();
    	return lastRow;
    }
      public void writeDataIntoExcel(String sheet, int row, int cell, String value) throws EncryptedDocumentException, IOException 
      {
    	  
    	  FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
    	  Workbook wb=WorkbookFactory.create(fis);
    	  Sheet sh=wb.getSheet(sheet);
    	  Row r=sh.getRow(row);
    	  Cell c=r.getCell(cell);
    	  c.setCellValue(value);
    	  
    	  FileOutputStream fos=new FileOutputStream(ConstantsUtility.ExcelFilePath);
    	  wb.write(fos);
    	  wb.close();
      }
      public   Object[][] readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException 
      {
    	  FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
    	  Workbook wb=WorkbookFactory.create(fis);
    	  Sheet sh=wb.getSheet(sheetname);
    	  int lastRow=sh.getLastRowNum();
    	  int lastCell=sh.getRow(0).getLastCellNum();
    	  
    	  Object[][] data=new Object[lastRow][lastCell];
    	  
    	  for(int i=0; i<lastRow; i++)
    	  {
    		  for(int j=0; j<lastCell; j++)
    		  data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
    	  }
      
      return data;

}
}
    
    
    
    
    
    
    
    
    
    
    
    
    