package com.orange.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardUtils extends BaseClass {

	public static Actions a;

	static {
		a = new Actions(driver);
	}

	public static void dragAndDrop(WebElement src, WebElement target) {
		a.dragAndDrop(src, target).perform();
	}

	public static void mouseHover(WebElement ele) {
		a.moveToElement(ele).perform();
	}
	
	public static void doubleClick(WebElement ele) {
		a.doubleClick(ele).perform();
	}
	
	public static void keyBoardActions(String key) {
		switch(key) {
		case "Enter":
			a.sendKeys(Keys.ENTER).perform();
		case "control":
			a.sendKeys(Keys.CONTROL).perform();
		case "shift":
			a.sendKeys(Keys.SHIFT).perform();
		
		}
	}
		
		
}
