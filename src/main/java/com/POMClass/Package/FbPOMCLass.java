package com.POMClass.Package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Package.BaseClass;
import com.Util.Package.Utility;

public class FbPOMCLass extends BaseClass{
	
	public FbPOMCLass() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement uName;

	@FindBy(xpath="//input[@id='pass']")
	private WebElement pass;

	
	public void enterUserName(String str) {
		Utility.setText(uName, str);
	}
	
	public void enterPassword(String str) {
		Utility.setText(pass, str);
	}

}
