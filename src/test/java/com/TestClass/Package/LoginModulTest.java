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
import com.Util.Package.ExtentReportUtility;
import com.Util.Package.Utility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

@Listeners(MyListener.class)
public class LoginModulTest extends BaseClass {

	@BeforeClass
	public void setup() {
		BaseClass.launchWebsite();
	}

	@AfterClass
	public void teardown() {
//	driver.close();

	}
	
//	@BeforeTest
//	public void beforeTest() {
//		ExtentReportUtility.initExtentReports();
//	}
//	
//	@AfterTest
//	public void afterTest() {
//		ExtentReportUtility.generateReport();
//	}
	

	@Test
	public void getTitle() {
		ExtentReportUtility.logger = ExtentReportUtility.createReport("getTitle");
		String Title = driver.getTitle();
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(Title, "OrangeHRM");
		
		ExtentReportUtility.logger.log(Status.INFO, Title);
		

	}

	@Test(groups = {"Login"})
	public void LoginTest() throws IOException {
		ExtentReportUtility.logger = ExtentReportUtility.createReport("LoginTest");
		Utility.LogInCOde();
		
		ExtentReportUtility.logger.log(Status.INFO, "User Login With: Admin");
		ExtentReportUtility.logger.log(Status.FAIL, "Wrong Crediential");
	
	}
}
