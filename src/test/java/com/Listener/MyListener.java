package com.Listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Util.Package.Utility;

public class MyListener  implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    try {
			Utility.takeScreenshot(result.getTestName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utility.takeScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
