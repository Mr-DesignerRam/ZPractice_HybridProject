package com.Util.Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ObjectsClass {

	public static String projectPath = System.getProperty("user.dir");

	public static FileInputStream getExcelPath(String fileName) throws FileNotFoundException {

		FileInputStream fis = new FileInputStream(projectPath + "\\src\\test\\resources\\" + fileName);
		return fis;
	}

	public static Sheet getSheet(FileInputStream fis) throws EncryptedDocumentException, IOException {
		return WorkbookFactory.create(fis).getSheet("Sheet1");

	}

	public static Object[][] entireExcelInfo(Sheet sh) {

		int lastRow = sh.getLastRowNum();
		
Object excelAllData[][]=new Object[lastRow][1]; 
		
		for (int i = 0; i < lastRow; i++) {
			Map<String, Object> data = new HashMap<>();

			int cellCount = sh.getRow(i).getLastCellNum();
			for (int col = 0; col < cellCount; col++) {

				String firstRow = sh.getRow(0).getCell(col).getStringCellValue();
				if (sh.getRow(i+1).getCell(col).getCellType().toString().equalsIgnoreCase("String")) {

					data.put(firstRow, sh.getRow(i+1).getCell(col).getStringCellValue());
				} else {

					data.put(firstRow, sh.getRow(i+1).getCell(col).getNumericCellValue());

				}
			}
			excelAllData[i][0]=data;
		}
		return excelAllData;

	}

}
