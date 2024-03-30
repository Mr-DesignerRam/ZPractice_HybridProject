package com.Util.Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.BaseClass.Package.BaseClass;

public class ExcelReaderClass extends BaseClass {
	
	
	public static FileInputStream fis;

	public static FileInputStream readExcel(String fileName) throws FileNotFoundException {

		return fis = new FileInputStream(projectPath + "\\src\\test\\resources\\" + fileName);

	}

	public static Sheet getSheet(FileInputStream fis, String sheetname) throws EncryptedDocumentException, IOException {
		return WorkbookFactory.create(fis).getSheet(sheetname);
	}

	public static Object singleDataRead(Sheet sh, int row, int cell) {
		if (sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("String")) {

			return  sh.getRow(row).getCell(cell).getStringCellValue();
		} else {
			return sh.getRow(row).getCell(cell).getNumericCellValue();

		}

	}

	public static Object getSpecificRow(Sheet sh, int row) {

		int colCount = sh.getRow(row).getLastCellNum();

		for (int col = 0; col < colCount; col++) {
			if (sh.getRow(row).getCell(col).getCellType().toString().equalsIgnoreCase("String")) {
				return sh.getRow(row).getCell(col).getStringCellValue();
			} else {
				return sh.getRow(row).getCell(col).getNumericCellValue();
			}
			

		}
		return 0;
		
		
	}
	
	public static Map<String, Object> readAllData(Sheet sh) {
		
		Map<String , Object> data= new HashMap<>();

		for(int i=1;i<sh.getLastRowNum();i++) {
			
		int lastCol	= sh.getRow(i).getLastCellNum();
		
		for(int col=0;col<lastCol;col++) {
			
		if(sh.getRow(i).getCell(col).getCellType().toString().equalsIgnoreCase("String")) {
		
		data.put(sh.getRow(0).getCell(col).getStringCellValue(), sh.getRow(i).getCell(col).getStringCellValue());
		
		}
		else {
			 data.put(sh.getRow(0).getCell(col).getStringCellValue(), sh.getRow(i).getCell(col).getNumericCellValue());
		}
		
		}
		}
		return data;
			
	}	

	
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		ExcelReaderClass.readExcel("Login.xlsx");
//		Sheet sh = ExcelReaderClass.getSheet(fis, "Sheet1");
//	
//		System.out.println( ExcelReaderClass.singleDataRead(sh, 0,0));
//		
//	}
}
