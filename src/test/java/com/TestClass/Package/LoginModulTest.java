package com.TestClass.Package;

import static org.testng.Assert.expectThrows;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
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
	
	
//	String browser;
//	public LoginModulTest(String browser) {
//		this.browser=browser;
//	}

	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) throws IOException {
		BaseClass.launchWebsite(browser);
	}

	@AfterClass
	public void teardown() {
//	driver.close();

	}

	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		ExtentReportUtility.logger.addScreenCaptureFromPath(projectPath + "\\ScreenShot\\" + result.getName() + ".png",
				result.getName());

		if (result.getStatus() == result.FAILURE) {
			ExtentReportUtility.logger.log(Status.FAIL, "Test Case is Failed : " + result.getName());
			ExtentReportUtility.logger.log(Status.FAIL, "Test case is Failed : " + result.getThrowable());
		}

	}

	@Test
	public void getTitle() {
		ExtentReportUtility.logger = ExtentReportUtility.createReport("getTitle");
		String Title = driver.getTitle();
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(Title, "OrangeHRM");
		ExtentReportUtility.logger.log(Status.INFO, Title);

	}

	@Test(groups = { "Login" })
	public void LoginTest() throws IOException {
		ExtentReportUtility.logger = ExtentReportUtility.createReport("LoginTest");
		Utility.LogInCOde();

		ExtentReportUtility.logger.log(Status.INFO, "User Login With: Admin");

	}
}
