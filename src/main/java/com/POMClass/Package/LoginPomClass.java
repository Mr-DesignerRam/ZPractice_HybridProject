package com.POMClass.Package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Package.BaseClass;
import com.Util.Package.Utility;

public class LoginPomClass extends BaseClass{
	
	public LoginPomClass() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Username : Admin']")
	private WebElement getUserName;

	@FindBy(xpath = "//p[text()='Password : admin123']")
	private WebElement getPassword;

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement setUserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement setPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonLogin;

	public String getUName() {
		String original = getUserName.getText();
		String UserName = original.substring(original.indexOf("A"));
		return UserName;
	}

	public String getPassword() {
		String Original = getPassword.getText();
		String password = Original.substring(Original.lastIndexOf("a"));
		return password;
	}

	public void setUserName(String username) {
		Utility.setText(setUserName, username);
//		setUserName.sendKeys(username);
	}

	public void setPassword(String password) {
		Utility.setText(setPassword, password);

//		setPassword.sendKeys(password);
	}

	public void clickLogin() {
		Utility.userClick(buttonLogin);

//		buttonLogin.click();
	}
}
