package com.Util.Package;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.BaseClass.Package.BaseClass;
import com.POMClass.Package.LoginPomClass;

public class Utility extends BaseClass {

	public static Actions act;
	
	public static void setText(WebElement ele, String str) {
		ele.sendKeys(str);

	}

	public static void userClick(WebElement ele) {
		ele.click();
	}

	public static void implicitWait(int num) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));

	}

	public static void takeScreenshot(String testName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		String date = d.toString().replace(":", "_");
		
		String dest = Utility.projectPath+"\\ScreenShot\\"+testName+".png";
		File destinaFile = new File(dest);
		FileUtils.copyFile(src, destinaFile);
		
		
	}

	public static void LogInCOde() {
		
//		SoftAssert assert1 = new SoftAssert();
		LoginPomClass loginpomclass = new LoginPomClass();
		String username = loginpomclass.getUName();
		String password = loginpomclass.getPassword();

//		assert1.assertEquals(username, "Admin");
//		assert1.assertEquals(password, "admin123");
		loginpomclass.setUserName(prop.getProperty("username"));
		loginpomclass.setPassword(prop.getProperty("password"));
		
//		    loginpomclass.setUserName(username);
//			loginpomclass.setPassword(password);
		  loginpomclass.clickLogin();
//		  assert1.assertAll();
	}
	
	
	public static  void elementVisibleWait(WebElement ele,int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void actionClass() {
		 act = new Actions(driver);
	}
	
	
	
}
