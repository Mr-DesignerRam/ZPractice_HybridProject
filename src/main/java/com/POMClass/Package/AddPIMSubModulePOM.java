package com.POMClass.Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Package.BaseClass;
import com.Util.Package.ExcelReaderClass;
import com.Util.Package.Utility;

public class AddPIMSubModulePOM extends BaseClass {

	public AddPIMSubModulePOM() {
		PageFactory.initElements(driver, this);
	}

	// First Name
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;

	// MiddleName
	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleName;

	// lastName
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;

	// emp id
	@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	private WebElement emp_Id;

	// save
	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement saveButton;

	// cancel
	@FindBy(xpath = "//button[text()=' Cancel ']")
	private WebElement cancelButton;

	// Not Working below code

//		public void clearempId() {
//			emp_Id.click();
//			Utility.implicitWait(5);
//			emp_Id.clear();
//		}

	public void first_Name() throws EncryptedDocumentException, IOException {

		// Ha code Multiple time use krav lagat ahe tya sathi kai krav

		FileInputStream fis = ExcelReaderClass.readExcel("Login.xlsx");
		Sheet sh = ExcelReaderClass.getSheet(fis, "Sheet1");
		String data = (String) ExcelReaderClass.singleDataRead(sh, 1, 0);
		String data1 = (String) ExcelReaderClass.singleDataRead(sh, 1, 1);
		String data2 = (String) ExcelReaderClass.singleDataRead(sh, 1, 2);

//		Object data3 =  ExcelReaderClass.singleDataRead(sh, 1, 3);

		Utility.setText(firstName, data);
		Utility.setText(middleName, data1);
		Utility.setText(lastName, data2);

		Utility.implicitWait(5);

		AddPIMSubModulePOM apm = new AddPIMSubModulePOM();
//		apm.clearempId();

		Utility.implicitWait(3);
//		Utility.setText(emp_Id, data3.toString());

	}

}
