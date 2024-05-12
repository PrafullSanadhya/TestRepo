package Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class xlsheetDataProvider {
	
	@DataProvider(name ="xldata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		
		String excelSheetName = m.getName();
		File f = new File(System.getProperty("C:\\Users\\sanad\\New WorkSpace\\PageObjectModel\\testdata.xlsx"));
        FileInputStream fs = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fs);
        Sheet sheetName = wb.getSheet(excelSheetName);
        
        int totalRows = sheetName.getLastRowNum(); 
        Row rowcells = sheetName.getRow(0);
        int totalCol = rowcells.getLastCellNum();
        
        DataFormatter format = new DataFormatter();
        
        String data[][] = new String[totalRows][totalCol];
        for ( int i=1; i<=totalRows; i++) {
        	for ( int j=0; j<totalCol; j++) {
        		data[i-1][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
         		 
        	}
        }
        return data; 
	}
	

}
