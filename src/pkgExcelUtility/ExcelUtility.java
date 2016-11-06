package pkgExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {

	private Sheet sheet;
	public Workbook workbook;
	private ExcelUtility(){}
	private static ExcelUtility excel=new ExcelUtility();
	public static ExcelUtility excelInstance(){
		return excel;
	}
		
	public  void setExcelFile(String fileName,String sheetName) throws IOException {
		
		    //String excel_filePath="D:/JAVA_PROJECT/QAProject/src/pkgTestData";
		    String filePath=System.getProperty("user.dir")+"\\src\\pkgTestData";
			
			File file=new File(filePath+"\\"+fileName);
			FileInputStream fileinputstream= new FileInputStream(file);
			@SuppressWarnings("resource")
			Workbook workbook=new XSSFWorkbook(fileinputstream);
			Sheet sheet=workbook.getSheet(sheetName);
			this.sheet=sheet;
			this.workbook=workbook;
			
	}
	
	public Sheet getExcelFile(){
		return sheet;
	}
	
	public void closeExcle(String fileName) throws IOException{
		
		String filePath=System.getProperty("user.dir")+"\\src\\pkgTestData";
		File file=new File(filePath+"\\"+fileName);
		FileInputStream fileinputstream= new FileInputStream(file);
		fileinputstream.close();
	}
	
	public ArrayList<String> loginCredential(String TC_Name){
		
		Sheet sheet=ExcelUtility.excelInstance().getExcelFile();
		int totalRows=sheet.getLastRowNum()-sheet.getFirstRowNum();
		ArrayList<String> arraylist=new ArrayList<String>();
		double numericValue;
		for(int i=1;i<=totalRows;i++){
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				if(row.getCell(j).getStringCellValue().equals(TC_Name)){
					System.out.println("Running Test case of Login Module: "+row.getCell(j).getStringCellValue());
					int celltype=row.getCell(j+2).getCellType();					
					switch(celltype){
					case 0: arraylist.add(row.getCell(j+1).getStringCellValue());
							numericValue=row.getCell(j+2).getNumericCellValue();
							String value=Double.toString(numericValue);
							arraylist.add(value);
							break;
					case 1: arraylist.add(row.getCell(j+1).getStringCellValue());
							arraylist.add(row.getCell(j+2).getStringCellValue());
							break;
					}				
					
				}else 
					//System.out.println(row.getCell(j).getStringCellValue());
				break;
			}
		}
		
		return arraylist;
	}
	
	public ArrayList<Double> Gen2Setup(){
		Sheet sheet=ExcelUtility.excelInstance().getExcelFile();
		int totalRows=sheet.getLastRowNum()-sheet.getFirstRowNum();
		ArrayList<Double> arraylist=new ArrayList<Double>();
		
		for(int i=1;i<=totalRows;i++){
			Row row=sheet.getRow(i);
			arraylist.add(row.getCell(0).getNumericCellValue());
		}
		return arraylist;
		
		
	}
	
	public void writeToExcel(int rowno, int colno,String fileName) throws IOException{
		
		String filePath=System.getProperty("user.dir")+"\\src\\pkgTestData";
		File file=new File(filePath+"\\"+fileName);
		Row row=this.sheet.getRow(rowno);
		row.createCell(colno).setCellValue("Pass");
		//System.out.println("row no"+rowno +" --> "+row.toString());
		
		FileOutputStream fileoutputstream=new FileOutputStream(file); 
	    workbook.write(fileoutputstream);
	}
	
}
