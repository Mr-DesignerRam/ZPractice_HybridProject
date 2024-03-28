package com.POMClass.Package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPomClass {

	// //
	@FindBy(xpath = "p[text()='Username : Admin']")
	private WebElement getUserName;

	////
	@FindBy(xpath = "p[text()='Password : admin123']")
	private WebElement getPassword;

	//
	@FindBy(xpath = "input[@placeholder='Username']")
	private WebElement setUserName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement setPassword;
	
	@FindBy(xpath="//button[@type='submit'")
	private WebElement clickLogin;
}
