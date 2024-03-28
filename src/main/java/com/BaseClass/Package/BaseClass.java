package com.BaseClass.Package;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Util.Package.Utility;

public class BaseClass {

	public static WebDriver driver;
	 public static String projectPath= System.getProperty("user.dir");
	
	public static void launchWebsite() {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Utility.implicitWait(10);
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
}
