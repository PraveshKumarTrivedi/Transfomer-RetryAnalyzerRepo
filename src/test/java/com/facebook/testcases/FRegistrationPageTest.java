/**
 * 
 */
package com.facebook.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.base.FBase;
import com.facebook.pages.FRegistrationPage;
import com.facebook.util.TestUtil;

/**
 * @author pkumar
 *
 */
public class FRegistrationPageTest extends FBase {
	
	FRegistrationPage fregispage;
	TestUtil testsutil;
	String sheetName = "Sheet3";
	
	public FRegistrationPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		bmet();
		fregispage = new FRegistrationPage();
	}
	
	@DataProvider
	public Object[][] getNewAccountData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	// Retry Analyzer Use
	/*
	@Test(retryAnalyzer=Analyzer.RetryAnlyzer.class)
	public void retryAnalyzerUse()
	{
		Assert.assertEquals(false, true);
	}*/
	
	
	@Test(priority=1, dataProvider="getNewAccountData")
	public void verifyCreateAnAccountTest(String Firstname, String Surname, String Email, String Password,String DOB, String Gender) throws InterruptedException
	{
		fregispage.verifyCreateAnAccount(Firstname, Surname, Email, Password, DOB, Gender);
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
