package com.Util.Package;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.BaseClass.Package.BaseClass;

public class Utility extends BaseClass {

	
	
	public static void setText(WebElement ele, String str) {
		ele.sendKeys(str);

	}

	public static void userClick(WebElement ele) {
		ele.click();
	}

	public static void implicitWait(int num) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));

	}

	public static void takeScreenshot(String Name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		String date = d.toString().replace(":", "_");
		
		String dest = Utility.projectPath+"\\ScreenShot\\"+Name + date+".png";
		File destinaFile = new File(dest);
		FileUtils.copyFile(src, destinaFile);
		
		
	}

}
