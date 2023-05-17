package com.Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static DataFormatter format;
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 10;
	public static String projectPath = System.getProperty("user.dir");
	
	public TestUtils(String excelPath, String SheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(SheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public int getRowCount() {
		int rowCount=0;
		try {
			
			rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("No. of count: "+rowCount);
		
		}catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();		
		}
		return rowCount;
		
	}
	public int getColCount() {
		int colCount=0;
		try {
			
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("No. of count: "+colCount);
		
		}catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();		
		}
		return colCount;
	}
	public String getCellData(int rowNum, int colNum) {
		String cellData =null;
		Cell cell=sheet.getRow(rowNum).getCell(colNum);
		
		try {
			if(cell.getCellType()==CellType.NUMERIC) {
				int Data=0;
				Data= (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				cellData = Data +"";
				
			}else {
				cellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			}
		
		}catch (NumberFormatException e){
			e.printStackTrace();
			
		}
		return cellData;
	}
}
