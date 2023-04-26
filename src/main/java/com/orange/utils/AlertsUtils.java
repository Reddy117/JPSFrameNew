package com.orange.utils;

import org.openqa.selenium.Alert;

public class AlertsUtils extends BaseClass{

	public static Alert a;
	
	static {
		a=driver.switchTo().alert();
	}
	public static void accepAlert() {
		
		a.accept();
	}
	
	public static void dismissAlert() {
		
		a.dismiss();
	}
	
}
