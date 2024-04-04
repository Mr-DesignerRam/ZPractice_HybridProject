package com.Util.Package;

import com.BaseClass.Package.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtility extends BaseClass {
	
	public static ExtentReports extentReports;
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentTest logger;
	
	public static void initReport() {
		extentReports= new ExtentReports();
		extentSparkReporter=  new ExtentSparkReporter(projectPath+"//extentReports//Google.Html");
		extentReports.attachReporter(extentSparkReporter);
	}
	public static void generateReport() {
		extentReports.flush();
	}

	public static ExtentTest createReport(String name) {
		
return extentReports.createTest(name); // keyboard
		
	}
}
