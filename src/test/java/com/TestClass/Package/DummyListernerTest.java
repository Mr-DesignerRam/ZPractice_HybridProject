//package com.TestClass.Package;
//
//
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.Listener.DummyListener;
//
//
//@Listeners(DummyListener.class)
//public class DummyListernerTest {
//	
//	@Test(groups = {"Regression"})
//	public void Test1() {
//		System.out.println("Test1 Method Executed");
//
//	}
//	@Test
//	public void Test2() {
//		System.out.println("Test2 Method Executed");
//	}
//
//	@Test(groups = {"Regression"})
//	public void Test3() {
//		System.out.println("Test3 Method Executed");
//	}
//	
//	@Test
//	public void Test4() {
//		System.out.println("Test4 Method Executed");
//		
//	}
//	
//	
//	@Test(groups = {"Regression"})
//	public void Test5() {
//		System.out.println("Test5 Method Executed");
//		
//	}
//	@Test(dependsOnGroups = "Regression")
//	public void Test6() {
//		System.out.println("Test6 Method Executed");
//		
//	}
//	
//	
//	@Test(groups = {"Regression"})
//	public void Test7() {
//		System.out.println("Test7 Method Executed");
//	
//	}
//	
//
//}
