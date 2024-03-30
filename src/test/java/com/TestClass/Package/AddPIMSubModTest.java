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

	
	@BeforeClass
	public void setup() {
		BaseClass.launchWebsite();
	}

	@AfterClass
	public void teardown() {
//	driver.close();
	}

	@Test
	public void PIMSubModTest() throws IOException {
		
		// Ha code Multiple time use krav lagel tya sathi kai krav
		
		
//		SoftAssert assert1 = new SoftAssert();
		LoginPomClass loginpomclass = new LoginPomClass();

		loginpomclass.setUserName( loginpomclass.getUName());
		loginpomclass.setPassword(loginpomclass.getPassword());

		PIMModulePOM PIMmodulepom = loginpomclass.clickLogin();
		PIMmodulepom.clickPIMModule();

		AddPIMSubModulePOM addPIM = PIMmodulepom.clickAdd();
		addPIM.first_Name();
		
		Utility.takeScreenshot("AllData");
		
		
	}
	
}
