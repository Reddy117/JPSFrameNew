package com.orange.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Faker;
import com.orange.constants.FrameworkConstants;

public class BaseClass {
	public static WebDriver driver;
	private static Faker fk;
	public String firstName;
	public String lstName;
	private static String xlPath = System.getProperty("user.dir") + "/src/test/resources/TestData/OrangeData1.xlsx";

	@BeforeSuite
	public void getuserDetails() throws InterruptedException {
		firstName = getFirstName();
		lstName = getlastName();
		String userName = firstName + " " + lstName;
		writeData("Sheet2", "TC1_CreateEmployee", "FirstName", firstName);
		writeData("Sheet2", "TC1_CreateEmployee", "LastName", lstName);
		writeData("Sheet2", "TC1_CreateEmployee", "UserName", userName);

		writeData("Sheet2", "TC1_ProvideAdminRights", "FirstName", firstName);
		writeData("Sheet2", "TC1_ProvideAdminRights", "LastName", lstName);
		writeData("Sheet2", "TC1_ProvideAdminRights", "UserName", userName);
		Thread.sleep(5000);
		System.out.println("Executing");
	}

	@BeforeMethod
	public void openApp() {
		ChromeOptions oc = new ChromeOptions();
		oc.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(oc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(getPropertyValue("url"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	public static String getFirstName() {
		fk = new Faker();
		return fk.name().firstName();
	}

	public static String getlastName() {
		fk = new Faker();
		return fk.name().lastName();
	}

	public void selectDropdown(WebElement ele, String value, String tagname) {
		List<WebElement> items = ele.findElements(By.tagName(tagname));

		for (WebElement item : items) {
			if (item.getText().equals(value)) {
				item.click();
				break;
			}
		}
	}

	public static Object[][] getData(String sheetName, String tcName) {
		Map<String, String> map = null;
		Object[][] data = null;
		try {
			FileInputStream f = new FileInputStream(FrameworkConstants.XLPATH);
			XSSFWorkbook w = new XSSFWorkbook(f);
			XSSFSheet s = w.getSheet(sheetName);
			int rowcount = s.getLastRowNum();
			int colCount = s.getRow(0).getLastCellNum();
			int row = 0;
			data = new Object[1][1];
			for (int i = 1; i <= rowcount; i++) {
				map = new HashMap();
				if (s.getRow(i).getCell(0).toString().equals(tcName)) {
					row = i;
					for (int j = 0; j < colCount; j++) {
						String key = s.getRow(0).getCell(j).toString();
						String value = s.getRow(row).getCell(j).toString();
						map.put(key, value);
					}
					data[0][0] = map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void writeData(String sheetName, String tcName, String colName, String data) {
		try {
			FileInputStream f = new FileInputStream(FrameworkConstants.XLPATH);
			XSSFWorkbook workbook = new XSSFWorkbook(f);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(0).getLastCellNum();

			int row = 0;
			int col = 0;
			for (int i = 1; i <= rowcount; i++) {
				if (sheet.getRow(i).getCell(0).toString().equals(tcName)) {
					row = i;
					for (int j = 0; j < colcount; j++) {
						if (sheet.getRow(0).getCell(j).toString().equals(colName)) {
							col = j;
							break;
						}
					}
				}

			}
			sheet.getRow(row).getCell(col).setCellValue(data);
			FileOutputStream out = new FileOutputStream(FrameworkConstants.XLPATH);
			workbook.write(out);
			f.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String property) {
		Properties p = null;
		FileInputStream fs;
		try {
			fs = new FileInputStream(FrameworkConstants.CONFIGFILEPATH);
			p = new Properties();
			p.load(fs);
			// return p.getProperty(property);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(property);

	}

}
