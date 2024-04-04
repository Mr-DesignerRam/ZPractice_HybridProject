package com.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Util.Package.ReportUtility;
import com.Util.Package.Utility;

public class GoogleListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		ReportUtility.initReport();
		System.out.println("onStart: Run Before All test execute");
	}

	@Override
	public void onFinish(ITestContext context) {
		ReportUtility.generateReport();
		System.out.println("onFinish: Run Before All test execute");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart: Run Before Every test execute");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess: Run After Every test Pass");
//		    Utility.takeScreenshot("abc");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure: Run After Every test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped: Run After Every test Skipped");
	}
}
