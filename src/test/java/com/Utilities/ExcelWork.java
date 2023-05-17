package com.Utilities;

import com.TestBase.TestBase;

public class ExcelWork  {
	//String projectPath = System.getProperty("user.dir");

	public Object[][] registrationTest(String excelPath, String sheetName){
		String registerPath = TestUtils.projectPath+"\\src\\TestData\\ExcelData.xlsx";
		TestUtils excelRegister = new TestUtils(registerPath,"Register");
		
		int rowCount = excelRegister.getRowCount();
		int colCount = excelRegister.getColCount();
		
		Object data [][] = new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String cellData = excelRegister.getCellData(i, j);
				//System.out.println(cellData+" ");
				 data[i-1][j]=cellData;
			}
		}
		return data;
		
	}
}
