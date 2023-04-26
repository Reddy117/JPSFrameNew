package com.orange.tests;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.pages.LoginPage;
import com.orange.utils.BaseClass;

public class TS1_CreateEmployee extends BaseClass {

	@Test(dataProvider = "getTC1_CreateEmployeeData")
	public void TC1_CreateEmployee(HashMap<String, String> map) {
		if(!map.get("Runmode").equalsIgnoreCase("yes"))
			throw new SkipException("The run of the test case set to no, So skipping");
			
		
		new LoginPage().enterUserName().enterPassword().clickloginButton()
				.clickPIM().clickAddButton()
				.enterFirstName(map.get("FirstName")).enterLastName(map.get("LastName")).clickCreateCreds()
				.enterUserName(map.get("UserName")).enterPassword(map.get("Password"))
				.enterConfPassword(map.get("Password")).clickSaveButton();
	}

	@DataProvider
	public Object[][] getTC1_CreateEmployeeData() {
		return getData("Sheet2", "TC1_CreateEmployee");
	}

	// @Test
	public void TC3_editEmployee() {

	}

}
