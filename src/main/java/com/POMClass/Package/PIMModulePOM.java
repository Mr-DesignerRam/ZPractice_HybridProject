package com.POMClass.Package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Package.BaseClass;
import com.Util.Package.Utility;

public class PIMModulePOM extends BaseClass {

	
	public PIMModulePOM() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement PIMButton;
	
	public void clickPIMModule() {
		Utility.userClick(PIMButton);
	}
	
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addButton;
	
	
	public AddPIMSubModulePOM clickAdd() {
		 Utility.userClick(addButton);
		 return new AddPIMSubModulePOM();
		 
	}
}
