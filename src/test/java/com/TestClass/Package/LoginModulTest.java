package com.TestClass.Package;

import java.io.IOException;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.Package.BaseClass;
import com.Listener.MyListener;
import com.POMClass.Package.LoginPomClass;
import com.Util.Package.Utility;

@Listeners(MyListener.class)
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

	@Test(groups = {"Login"})
	public void LoginTest() throws IOException {
		
		Utility.LogInCOde();
	
	}
}
