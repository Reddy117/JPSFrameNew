package com.orange.tests;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.pages.LoginPage;
import com.orange.utils.BaseClass;

public class TS2_AdminTests extends BaseClass {

	@Test(dataProvider="getTC1_ProvideAdminRightsData")
	public void TC1_ProvideAdminRights(HashMap<String,String> map) throws InterruptedException {
		if(!map.get("Runmode").equalsIgnoreCase("yes"))
			throw new SkipException("The run of the test case set to no, So skipping");
		
		new LoginPage().enterUserName().enterPassword().clickloginButton().clickAdmin()
		.clickAdmAddButton().enterAdminemployeeNameText(map.get("UserName")).selectEmployeeName()
		.enteradminUserName(map.get("UserName")).enteradminpassword(map.get("Password"))
		.enteradminconfPassword(map.get("Password")).selectUserRoleDrop(map.get("UserRole"))
		.selectStatusDrop(map.get("Status")).clickadminSaveButton();
	}
	
	@DataProvider
	public Object[][] getTC1_ProvideAdminRightsData(){
		return getData("Sheet2", "TC1_ProvideAdminRights");
	}
	
	
}
 