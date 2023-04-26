package com.orange.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.utils.BaseClass;

public class WaitUtilities extends BaseClass{
	
	public static WebDriverWait wait;
	static {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	public static void elementVisible(String xpath) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public static void elementClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
