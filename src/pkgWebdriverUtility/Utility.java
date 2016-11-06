package pkgWebdriverUtility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {

	public String excel_fileName="TestData.xlsx";
	public String excel_filePath="./Test_Data";
	
	private  XSSFSheet ExcelWSheet;
	private  XSSFWorkbook ExcelWBook;
	private  XSSFCell Cell;
	private  XSSFRow Row;
	private  FileInputStream ExcelFile;
	
	public  FileInputStream setExcelFile(String excel_filepath, String excel_fileName) throws Exception{
		
		try{
			FileInputStream ExcelFile= new FileInputStream(excel_filePath);
			
			ExcelWBook= new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(excel_fileName);
			this.ExcelFile=ExcelFile;
			
		}catch(Exception e){
			throw (e);
		}
		return ExcelFile;
	}
	
	public FileInputStream getExcelFile(){
		return ExcelFile;
	}
	
	public void getCellData() throws Exception{
	
		//FileInputStream ExcelFile= new FileInputStream(excel_filePath);
		ExcelWBook= new XSSFWorkbook(this.getExcelFile());
		ExcelWSheet = ExcelWBook.getSheet(excel_fileName);
		
		
		
	}
}
