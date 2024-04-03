package com.Util.Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fbDataInfo {
	
	public static String projectPath=System.getProperty("user.dir");
	
	public static FileInputStream getExcelPath(String FileName) throws FileNotFoundException {
		
		FileInputStream fis = new FileInputStream(projectPath+"\\src\\test\\resources\\"+FileName);
		return fis;
	}
	
	public static Sheet getSheet(FileInputStream fis,String sheetName) throws EncryptedDocumentException, IOException {
		
		return WorkbookFactory.create(fis).getSheet(sheetName);
		
	}
	
	public static Object[][] readEntireExcel(Sheet sh) {
		
		
		int lastRow = sh.getLastRowNum();
		
		Object readallData[][] = new Object[lastRow][1];
		
		for(int row=0;row<lastRow;row++) {
			
			Map<String ,Object> data = new HashMap<>();
			
			int lastCell = sh.getRow(row).getLastCellNum();
			for(int col=0;col<lastCell;col++) {
				
				String firstRow = sh.getRow(0).getCell(col).getStringCellValue();
				
				if(sh.getRow(row+1).getCell(col).getCellType().toString().equalsIgnoreCase("string")) {
		
				data.put(firstRow,sh.getRow(row+1).getCell(col).getStringCellValue());
				}
					else {
			data.put(firstRow, sh.getRow(row+1).getCell(col).getNumericCellValue());
				}
				
			} readallData[row][0] =data;
			
		
		} return readallData;
		
		}
		
		
	}

	

