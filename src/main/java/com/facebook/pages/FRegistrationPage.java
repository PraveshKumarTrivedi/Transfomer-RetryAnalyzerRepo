/**
 * 
 */
package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.FBase;
import com.facebook.util.TestUtil;

/**
 * @author pkumar
 *
 */
public class FRegistrationPage extends FBase{
	
	@FindBy(how=How.ID, using="u_0_m")
	WebElement fnTx;
	
	@FindBy(how=How.ID, using="u_0_o")
	WebElement lnTx;
	
	@FindBy(how=How.ID, using="u_0_r")
	WebElement emailTx;
	
	@FindBy(how=How.ID,using="u_0_w")
	WebElement newPasswordTx;
	
	@FindBy(how=How.ID,using="u_0_u")
	WebElement reenterPass;
	
	@FindBy(how=How.ID, using="day")
	WebElement day;
	
	@FindBy(how = How.ID, using="month")
	WebElement month;
	
	@FindBy(how = How.ID, using="year")
	WebElement year;
	
	@FindBy(how = How.XPATH, using="//input[@data-type='radio']")
	WebElement redioBtns;
	
	@FindBy(how = How.XPATH, using="//input[@name='sex' and contains(text(),'Female')]")
	WebElement redioFemale;
	
	@FindBy(how = How.XPATH, using="//input[@name='sex' and contains(text(),'Male')]")
	WebElement redioMale;
	
	@FindBy(how = How.XPATH, using="//input[@name='sex' and contains(text(),'Custom')]")
	WebElement redioCustom;
	
	@FindBy(how = How.XPATH, using="//button[@name='websubmit' and contains(text(),'Sign Up')]")
	WebElement clickONSignUp;
	
	public FRegistrationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void verifyCreateAnAccount(String fn, String sn, String email, String newPwd,String dob, String sex) throws InterruptedException
	{
		fnTx.sendKeys(fn);
		lnTx.sendKeys(sn);
		emailTx.sendKeys(email);
		newPasswordTx.sendKeys(newPwd);
		//dob = "10-May-2019";
		String dobArr[] = dob.split("-");
		TestUtil.selectValueFromDropDown(day,dobArr[0]);
		TestUtil.selectValueFromDropDown(month,dobArr[1]);
		TestUtil.selectValueFromDropDown(year,dobArr[2]);
		Thread.sleep(5000);
		TestUtil.selectUserGender(sex);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
