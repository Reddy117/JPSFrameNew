package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.utils.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath="//input[@name='username']")
	WebElement usernametext;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordtext;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUserName() {
		usernametext.sendKeys(getPropertyValue("username"));
		return this;
	}
	
	public LoginPage enterPassword() {
		passwordtext.sendKeys(getPropertyValue("password"));
		return this;
	}
	
	public HomePage clickloginButton() {
		loginbutton.click();
		return new HomePage();
	}
	
}
