/**
 * 
 */
package com.facebook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.FBase;
import com.facebook.pages.FHomePage;
import com.facebook.pages.FLoginPage;

/**
 * @author pkumar
 *
 */
public class FLoginPageTest extends FBase{
	
	 FLoginPage floginpage;
	 FHomePage homepage;
	public FLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		bmet();
		floginpage = new FLoginPage();
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest()
	{
		String title =floginpage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up", "Page Title is not matching");
	}
	
	@Test(priority=2)
	public void verifyValidUserTest()
	{
		homepage = floginpage.verifyValidUser(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	
	
	
	
	
	
	
	

}
