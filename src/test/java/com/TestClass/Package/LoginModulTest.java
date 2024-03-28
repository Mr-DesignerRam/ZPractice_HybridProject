package com.TestClass.Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.Package.BaseClass;
import com.POMClass.Package.LoginPomClass;
import com.Util.Package.Utility;

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
	public void getTitle() {
		String Title = driver.getTitle();
		System.out.println(Title);
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(Title, "OrangeHRM");

	}

	@Test
	public void LoginTest() {

		LoginPomClass loginpomclass = new LoginPomClass();
		String username = loginpomclass.getUName();
		String password = loginpomclass.getPassword();

		Utility.implicitWait(5);

		loginpomclass.setUserName(username);
		loginpomclass.setPassword(password);
		loginpomclass.clickLogin();

	}
}
