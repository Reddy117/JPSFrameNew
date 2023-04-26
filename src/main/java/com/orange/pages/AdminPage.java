package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.utils.BaseClass;

public class AdminPage extends BaseClass{

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addButton;
	
	@FindBy(xpath="//label[text()='Employee Name']/following::input[1]")
	WebElement employeeNameText;
	
	@FindBy(xpath="//label[text()='Username']/following::input[1]")
	WebElement uernametext;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement passwordtext;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement confpasswordtext;
	
	@FindBy(xpath="//label[text()='Status']/following::div[1]")
	WebElement statusdrop;
	
	@FindBy(xpath="//label[text()='User Role']/following::div[1]")
	WebElement userroledrop;
	
	@FindBy(xpath="//div[@role='listbox']")
	WebElement listItemBox;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	public AdminPage clickAdmAddButton() {
		addButton.click();
		return this;
	}
	
	public AdminPage enterAdminemployeeNameText(String empName) {
		employeeNameText.sendKeys(empName);
		return this;
	}
	
	public AdminPage enteradminUserName(String userName) {
		uernametext.sendKeys(userName);
		return this;
	}
	
	public AdminPage enteradminpassword(String password) {
		passwordtext.sendKeys(password);
		return this;
	}
	
	public AdminPage enteradminconfPassword(String password) {
		confpasswordtext.sendKeys(password);
		return this;
	}
	
	public AdminPage selectStatusDrop(String status) {
		statusdrop.click();
		selectDropdown(listItemBox,status,"span");
		return this;
	}
	
	public AdminPage selectUserRoleDrop(String role) {
		userroledrop.click();
		selectDropdown(listItemBox,role,"span");
		return this;
	}
	
	public AdminPage selectEmployeeName() throws InterruptedException {
		Thread.sleep(2000);
		listItemBox.click();
		return this;
	}
	
	public void clickadminSaveButton() {
		saveButton.click();
	}
	
}
