package com.TestClass.Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseClass.Package.BaseClass;
import com.POMClass.Package.FbPOMCLass;
import com.Util.Package.fbDataInfo;

public class FBTest extends BaseClass{

	@BeforeClass
	public void setup() {
		BaseClass.launchWebsite();
		
	}
	
	
	@DataProvider(name="FbData")
	public Object[][] getallExcelData() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = fbDataInfo.getExcelPath("FBLogin.xlsx");
		Sheet sh = fbDataInfo.getSheet(fis, "Sheet1");
		return fbDataInfo.readEntireExcel(sh);
	}
	
	@Test(dataProvider = "FbData")
	public void setAllData(Map<String, Object> data) {
		FbPOMCLass obj= new FbPOMCLass();
		obj.enterUserName(data.get("UserName").toString());
		obj.enterPassword(data.get("Password").toString());
	}
}
