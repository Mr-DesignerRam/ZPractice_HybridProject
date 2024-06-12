package com.TestClass.Package;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BaseClass.Package.BaseClass;
import com.Listener.MyListener;
import com.POMClass.Package.AddPIMSubModulePOM;
import com.POMClass.Package.PIMModulePOM;
import com.Util.Package.ExtentReportUtility;
import com.Util.Package.ObjectsClass;
import com.Util.Package.Utility;
import com.aventstack.extentreports.Status;

@Listeners(MyListener.class)
public class UserAllData extends BaseClass {

	
	@AfterMethod
	public void attachScreenShot(ITestResult result) {
		
		ExtentReportUtility.logger.addScreenCaptureFromPath(projectPath+"\\ScreenShot\\"+result.getName()+".png", result.getName());
		
		if(result.getStatus()==result.FAILURE) {
			ExtentReportUtility.logger.log(Status.FAIL,"Test case is Failed "+result.getName());
			ExtentReportUtility.logger.log(Status.FAIL,"Test case is Failed "+result.getThrowable());
		}
	}

	
	
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
		Utility.implicitWait(8);

		obj.setFirstName(data.get("firstName").toString());
		ExtentReportUtility.logger.log(Status.INFO, "First Name is: "+data.get("firstName").toString());
		
		obj.setMiddleName(data.get("middleName").toString());
		ExtentReportUtility.logger.log(Status.INFO, "Middle Name is: "+data.get("middleName").toString());
		
		obj.setLastName(data.get("lastName").toString());
		ExtentReportUtility.logger.log(Status.INFO, "Last Name is: "+data.get("lastName").toString());
		
		obj.setEmpId(data.get("EmpId").toString());
		ExtentReportUtility.logger.log(Status.INFO, "empId is: "+data.get("EmpId").toString());
		
		obj.createLoginClick();
	
		obj.valueOfUserName(data.get("userName").toString());
		ExtentReportUtility.logger.log(Status.INFO, "userName is: "+data.get("userName").toString());
		
		obj.valueOfPassword(data.get("password").toString());
		ExtentReportUtility.logger.log(Status.INFO, "Password is: "+data.get("password").toString());
		
		obj.valueConfirmPassword(data.get("confirmPassword").toString());
		ExtentReportUtility.logger.log(Status.INFO, "Password is: "+data.get("confirmPassword").toString());
//		obj.saveButtonClick();
		
		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(5)).build().perform();
		
		PIMModulePOM PIMmodulepom =new  PIMModulePOM();
		PIMmodulepom.clickPIMModule();

		PIMmodulepom.clickAdd();
		System.out.println();
		
//		System.out.println(data);
	}

}
