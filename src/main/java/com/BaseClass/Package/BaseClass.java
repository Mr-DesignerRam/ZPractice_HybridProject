package com.BaseClass.Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Util.Package.Utility;

public class BaseClass {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties prop;
	
	public static void launchWebsite(String browser) throws IOException {
		
		 fis= new FileInputStream(projectPath+"\\src\\test\\resources\\data.properties");
		 prop = new Properties();
		prop.load(fis);
		
		switch (browser) {

		case "chrome":
			driver = new ChromeDriver();
			driver.get(prop.getProperty("Url"));
			break;

		case "firefox":
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("Url"));
			break;

		case "edge":
			driver = new EdgeDriver();
			driver.get(prop.getProperty("Url"));
			break;
			
			default:
				System.out.println("No browser selected..");
		}

//		driver.get("https://www.facebook.com/");
//		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		Utility.implicitWait(10);
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

}
