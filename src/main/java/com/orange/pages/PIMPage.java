package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.utils.BaseClass;

public class PIMPage extends BaseClass{

	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addbutton;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstNameText;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastNameText;
	
	@FindBy(xpath="//p[text()='Create Login Details']/following::span[1]")
	WebElement createdredsbutton;
	
	@FindBy(xpath="//label[text()='Username']/following::input[1]")
	WebElement usernametext;
	
	@FindBy(xpath="//label[text()='Password']/following::input[1]")
	WebElement passwordText;
	
	@FindBy(xpath="//label[text()='Confirm Password']/following::input[1]")
	WebElement confPasswordtext;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement savebutton;
	
	public PIMPage clickAddButton() {
		addbutton.click();
		return this;
	}
	
	public PIMPage enterFirstName(String fName) {
		firstNameText.sendKeys(fName);
		return this;
	}
	
	public PIMPage enterLastName(String lastName) {
		lastNameText.sendKeys(lastName);
		return this;
	}
	
	public PIMPage clickCreateCreds() {
		createdredsbutton.click();
		return this;
	}
	
	public PIMPage enterUserName(String userName) {
		usernametext.sendKeys(userName);
		return this;
	}
	
	public PIMPage enterPassword(String password) {
		passwordText.sendKeys(password);
		return this;
	}
	
	public PIMPage enterConfPassword(String password) {
		confPasswordtext.sendKeys(password);
		return this;
	}
	
	public PIMPage clickSaveButton() {
		savebutton.click();
		return this;
	}
	
}
