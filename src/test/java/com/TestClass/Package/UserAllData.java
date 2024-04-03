package com.TestClass.Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BaseClass.Package.BaseClass;
import com.Listener.MyListener;
import com.POMClass.Package.AddPIMSubModulePOM;
import com.POMClass.Package.PIMModulePOM;
import com.Util.Package.ObjectsClass;

@Listeners(MyListener.class)
public class UserAllData extends BaseClass {

	@DataProvider(name = "userData")
	public Object[][] allDataRead() throws EncryptedDocumentException, IOException {
		FileInputStream fis = ObjectsClass.getExcelPath("Login.xlsx");
		Sheet sh = ObjectsClass.getSheet(fis);
		return ObjectsClass.entireExcelInfo(sh);
	}

	@Test(dataProvider = "userData", dependsOnGroups = { "addClick"})
	public void setData(Map<String, Object> data) {

		AddPIMSubModulePOM obj = new AddPIMSubModulePOM();
		obj.clearText();

		obj.setFirstName(data.get("firstName").toString());
		obj.setMiddleName(data.get("middleName").toString());
		obj.setLastName(data.get("lastName").toString());
		obj.setEmpId(data.get("EmpId").toString());
		obj.saveButtonClick();
		
		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(10)).build().perform();
		
		PIMModulePOM PIMmodulepom =new  PIMModulePOM();
		PIMmodulepom.clickPIMModule();

		PIMmodulepom.clickAdd();
//		System.out.println(data);
	}

}
