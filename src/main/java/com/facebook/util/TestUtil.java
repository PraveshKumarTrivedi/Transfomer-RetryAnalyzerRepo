/**
 * 
 */
package com.facebook.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.facebook.base.FBase;

/**
 * @author pkumar
 *
 */
public class TestUtil extends FBase {
	
	
	public static String TESTDATA_SHEET_PATH ="C:\\Users\\Vaio\\git\\Transfomer-RetryAnalyzerRepo\\Transfomer-RetryAnalyzerRepo\\src\\main\\java\\com\\facebook\\testdata\\FacebookCreateAcountData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public void swithToFrame()
	{
		driver.switchTo().frame("String frameName");
	}
	
	public static void selectValueFromDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try{
			 book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public static void selectGender(String Gender)
	{
		List<WebElement> radio=  driver.findElements(By.xpath("//input[@type='radio' and @name='sex']"));
		for(int i=0; i<radio.size();i++)
		{
			WebElement local_radio = radio.get(i);
			String value = local_radio.getAttribute("value");
			System.out.println("Values of Radio buttons:::"+value);
			if(local_radio.equals(Gender))
			{
				local_radio.click();
			}
		}
	}
	
	public static void selectUserGender(String gender)
	{
		driver.findElement(By.xpath("//label[contains(text(),'"+gender+"')]")).click();
	}
	

}
