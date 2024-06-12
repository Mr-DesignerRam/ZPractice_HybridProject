package com.ParallelTest.Package;

import org.testng.annotations.Factory;

import com.TestClass.Package.LoginModulTest;

public class FactoryDemo {
	
	
	@Factory
	public Object[] factory() {
		return new Object[]{ new ParallelClass1(10),new ParallelClass1(20)
				};
	}
//	
//	@Factory
//	public Object[] passBrowserValue() {
//		return new Object[] {new LoginModulTest("chrome")};
//	}

}
