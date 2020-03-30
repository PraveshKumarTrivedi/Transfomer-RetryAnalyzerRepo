/**
 * 
 */
package com.facebook.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	//Select Pronouncer 
	@FindBy(how = How.NAME, using="preferred_pronoun")
	WebElement pronouncer;
	
	@FindBy(how =  How.ID, using="u_0_11")
	WebElement genederOptional;
	
	@FindBy(how = How.ID, using="u_0_13")
	WebElement signUpbtn;
	
	public FRegistrationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectPronouncer(String pronouncer)
	{
		WebElement pronoun_drop = driver.findElement(By.xpath("//select[@class='_7-16 _5dba']"));
		Select select_pronoun = new Select(pronoun_drop);
		//select_pronoun.selectByValue("1");
		select_pronoun.selectByVisibleText(pronouncer);
		
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
		if(sex.equals("Custom"))
		{
			selectPronouncer("She: \"Wish her a happy birthday!\"");
		}
		genederOptional.sendKeys("Children");
		signUpbtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
