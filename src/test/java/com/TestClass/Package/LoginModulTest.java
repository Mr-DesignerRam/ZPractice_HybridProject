package com.TestClass.Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseClass.Package.BaseClass;

public class LoginModulTest extends BaseClass {

	@BeforeClass
	public void setup() {
		BaseClass.launchWebsite();
	}
	
	
	
	@AfterClass
	public void teardown() {
//	driver.close();
		
	}
	
	@Test
	public void test1() {
		System.out.println("Hello");
	}
}
