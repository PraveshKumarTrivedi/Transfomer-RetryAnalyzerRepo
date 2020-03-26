/**
 * 
 */
package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.FBase;

/**
 * @author pkumar
 *
 */
public class FLoginPage extends FBase {

	@FindBy(how = How.ID, using="email")
	WebElement emailtxt;
	
	@FindBy(how = How.ID, using="pass")
	WebElement passtxt;
	
	@FindBy(how = How.XPATH, using="//input[@type='submit']")
	WebElement loginBtn;
	
	public FLoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public FHomePage verifyValidUser(String uname, String upass)
	{
		emailtxt.sendKeys(uname);
		passtxt.sendKeys(upass);
		loginBtn.click();
		return new FHomePage();
	}
	
	
	
}
