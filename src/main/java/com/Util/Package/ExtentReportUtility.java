package com.Util.Package;

import com.BaseClass.Package.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility extends BaseClass{
	
	public static ExtentReports extentReports;
	// Location we reports are stored.
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentTest logger;
	
	public static void initExtentReports() {
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(projectPath+"\\extentReports\\OrangeHRMTest.html");
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public static  void generateReport() {
		extentReports.flush();
	}
	
	public static ExtentTest createReport(String testName) {
		return extentReports.createTest(testName);
//		  logger = extentReports.createTest(testName);
	}
	

}
