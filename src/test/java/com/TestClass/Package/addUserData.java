package com.TestClass.Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Util.Package.ExcelReaderClass;

public class addUserData {

	@DataProvider(name = "users")
	public static Object[][] getAllUser() throws EncryptedDocumentException, IOException {

		FileInputStream fis = ExcelReaderClass.readExcel("Login.xlsx");
		Sheet sh = ExcelReaderClass.getSheet(fis, "Sheet1");
		return ExcelReaderClass.readEntireData(sh);
	}
	
	

	@Test(dataProvider = "users")
	public void addUserTest(Map<String, Object> data) {
		
		
		// System.out.println(data.get("firstName") + "" + data.get("middleName") + ""

//+				""+data.get("lastName")+""+data.get("EmpId")
	//	);
		// System.out.println(data);

	}

}
