package com.TestClass.Package;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.Package.BaseClass;
import com.POMClass.Package.AddPIMSubModulePOM;
import com.POMClass.Package.LoginPomClass;
import com.POMClass.Package.PIMModulePOM;
import com.Util.Package.Utility;

public class AddPIMSubModTest {


	@Test(dependsOnGroups = {"addClick"})
	public void PIMSubModTest() throws IOException {
	
		AddPIMSubModulePOM addPIM = new AddPIMSubModulePOM();
		addPIM.first_Name();
		
		Utility.implicitWait(15);
		Utility.takeScreenshot("AllData");
		
		
	}
	
}
