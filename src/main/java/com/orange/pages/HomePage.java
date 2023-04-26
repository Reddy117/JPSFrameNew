package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.utils.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//span[text()='PIM']")
	WebElement PIMTab;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement AdminTab;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public PIMPage clickPIM() {
		PIMTab.click();
		return new PIMPage();
	}
	
	public AdminPage clickAdmin() {
		AdminTab.click();
		return new AdminPage();
	}
}
