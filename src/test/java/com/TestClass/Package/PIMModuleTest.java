package com.TestClass.Package;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.Package.BaseClass;
import com.Listener.MyListener;
import com.POMClass.Package.LoginPomClass;
import com.POMClass.Package.PIMModulePOM;
import com.Util.Package.ExtentReportUtility;
import com.Util.Package.Utility;
import com.aventstack.extentreports.Status;

@Listeners(MyListener.class)
public class PIMModuleTest extends BaseClass {


	@AfterMethod
	public void attachScreenShot(ITestResult result) {
		
		ExtentReportUtility.logger.addScreenCaptureFromPath(projectPath+"\\ScreenShot\\"+result.getName()+".png", result.getName());
		
		if(result.getStatus()==result.FAILURE) {
			ExtentReportUtility.logger.log(Status.FAIL,"Test case is Failed "+result.getName());
			ExtentReportUtility.logger.log(Status.FAIL,"Test case is Failed "+result.getThrowable());
		}
	}


	@Test(groups = { "addClick" }, dependsOnGroups = { "Login" })
	public void PIMModuleTest1() throws IOException {
		
	ExtentReportUtility.logger	= ExtentReportUtility.createReport("PIMModuleTest1");

		PIMModulePOM PIMmodulepom = new PIMModulePOM();
		PIMmodulepom.clickPIMModule();
		ExtentReportUtility.logger.log(Status.INFO, "Click on PIM Button");
		PIMmodulepom.clickAdd();
		ExtentReportUtility.logger.log(Status.INFO, "Click on Add Button");
	}

}