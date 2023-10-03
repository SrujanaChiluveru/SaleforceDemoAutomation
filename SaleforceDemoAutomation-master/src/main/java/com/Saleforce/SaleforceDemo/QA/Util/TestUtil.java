package com.Saleforce.SaleforceDemo.QA.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Saleforce.SaleforceDemo.QA.TestBase.TestBase;

public class TestUtil extends TestBase{
	 static FileInputStream fip;
	 static String testDataPath= prop.getProperty("testDataPath");
	 static Workbook book;
	 static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		Object[][] testdata;
		try {
			fip=new FileInputStream(testDataPath);
			book= WorkbookFactory.create(fip);
			sheet= book.getSheet(sheetName);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testdata= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				testdata[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return testdata;
	}

	public static void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static void takeScreenShot(String testMethodName) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file= ts.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		
		try {
			FileUtils.copyFile(file, new File("F:\\EclipseWorkSpace\\SaleforceDemo\\Screenshots"+testMethodName+date+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
