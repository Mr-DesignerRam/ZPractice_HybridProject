package com.TestClass.Package;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.Package.BaseClass;
import com.POMClass.Package.LoginPomClass;
import com.POMClass.Package.PIMModulePOM;
import com.Util.Package.Utility;

public class PIMModuleTest extends BaseClass {
	@BeforeClass
	public void setup() {
		//BaseClass.launchWebsite();
	}

	@AfterClass
	public void teardown() {
//	driver.close();
	}

@Test(groups = {"addClick"},dependsOnGroups = {"Login"})
	public void PIMModuleTest1() throws IOException {
	

		PIMModulePOM PIMmodulepom =new  PIMModulePOM();
		PIMmodulepom.clickPIMModule();

		PIMmodulepom.clickAdd();
}

}