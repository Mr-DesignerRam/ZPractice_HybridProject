//package com.TestClass.Package;
//
//import org.testng.Assert;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.Listener.GoogleListener;
//import com.Util.Package.ReportUtility;
//import com.aventstack.extentreports.Status;
//
//@Listeners(GoogleListener.class)
//public class GoogleTest {
//
//	@Test
//	public void Test1() {
//		
//	ReportUtility.logger	= ReportUtility.createReport("Test1");
//		System.out.println("Test1 Method Executed");
//		ReportUtility.logger.log(Status.INFO, "Test1 Method Executed");
//	}
//	
//	@Test
//	public void Test2() {
//		ReportUtility.logger	= ReportUtility.createReport("Test2");
////		System.out.println("Test1 Method Executed");
//		
//		ReportUtility.logger.log(Status.INFO, "Test2 Method Executed");
//	}
//	@Test
//	public void Test3() {
//		ReportUtility.logger	= ReportUtility.createReport("Test3");
////		System.out.println("Test1 Method Executed");
//		
//		ReportUtility.logger.log(Status.INFO, "Test3 Method Executed");
//	}
//	@Test
//	public void Test4() {
//		ReportUtility.logger	= ReportUtility.createReport("Test4");
//		ReportUtility.logger.log(Status.INFO, "Test4 Method Executed");
//		ReportUtility.logger.log(Status.FAIL, "Test is Failed");
//		Assert.fail();
//	}
//	
//}
