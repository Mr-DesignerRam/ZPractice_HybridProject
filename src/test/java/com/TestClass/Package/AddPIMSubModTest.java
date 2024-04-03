package com.TestClass.Package;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Test;

import com.POMClass.Package.AddPIMSubModulePOM;

import com.Util.Package.Utility;

public class AddPIMSubModTest {

	@Test(dependsOnGroups = { "addClick" })
	public void PIMSubModTest() throws IOException, EncryptedDocumentException, AWTException {

		AddPIMSubModulePOM addPIM = new AddPIMSubModulePOM();
	//	addPIM.first_Name();

		Utility.implicitWait(15);
		Utility.takeScreenshot("AllData");

	}

}
