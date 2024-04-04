package com.TestClass.Package;

import java.io.IOException;

import org.testng.annotations.AfterClass;
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
	@BeforeClass
	public void setup() {
		// BaseClass.launchWebsite();
	}

	@AfterClass
	public void teardown() {
//	driver.close();
	}

	@BeforeTest
	public void beforeTest() {
		ExtentReportUtility.initExtentReports();
	}

	@AfterTest
	public void afterTest() {
		ExtentReportUtility.generateReport();
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