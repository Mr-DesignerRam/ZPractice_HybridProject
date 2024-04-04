package com.TestClass.Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BaseClass.Package.BaseClass;
import com.Listener.MyListener;
import com.POMClass.Package.AddPIMSubModulePOM;
import com.POMClass.Package.PIMModulePOM;
import com.Util.Package.ExtentReportUtility;
import com.Util.Package.ObjectsClass;
import com.aventstack.extentreports.Status;

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
		
	ExtentReportUtility.logger=  ExtentReportUtility.createReport("setData");
		
		AddPIMSubModulePOM obj = new AddPIMSubModulePOM();
		obj.clearText();

		obj.setFirstName(data.get("firstName").toString());
		ExtentReportUtility.logger.log(Status.INFO, "First Name is: "+data.get("firstName").toString());
		obj.setMiddleName(data.get("middleName").toString());
		ExtentReportUtility.logger.log(Status.INFO, "Middle Name is: "+data.get("middleName").toString());
		obj.setLastName(data.get("lastName").toString());
		ExtentReportUtility.logger.log(Status.INFO, "Last Name is: "+data.get("lastName").toString());
		obj.setEmpId(data.get("EmpId").toString());
		ExtentReportUtility.logger.log(Status.INFO, "empId is: "+data.get("EmpId").toString());
		obj.saveButtonClick();
		
		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(5)).build().perform();
		
		PIMModulePOM PIMmodulepom =new  PIMModulePOM();
		PIMmodulepom.clickPIMModule();

		PIMmodulepom.clickAdd();
		Assert.fail();
//		System.out.println(data);
	}

}
