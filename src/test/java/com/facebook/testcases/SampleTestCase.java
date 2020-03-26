package com.facebook.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.FBase;

public class SampleTestCase extends FBase {
	
	@BeforeMethod
	public void setUp()
	{
		bmet();
	}
	
	@Test
	public void createAnAccount() throws InterruptedException
	{
		driver.findElement(By.id("u_0_m")).sendKeys("xbncbxn");
		driver.findElement(By.id("u_0_o")).sendKeys("djfad");
		driver.findElement(By.id("u_0_r")).sendKeys("jgdgjsfa");
		driver.findElement(By.id("u_0_w")).sendKeys("zxbcdas12");
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		
		Select select = new Select(day);
		Thread.sleep(1000);
		select.selectByVisibleText("12");
		
		Select select1 = new Select(month);
		Thread.sleep(1000);
		select1.selectByVisibleText("Jun");
		
		Select select2 = new Select(year);
		Thread.sleep(1000);
		select2.selectByVisibleText("1981");
		
		driver.findElement(By.xpath("//label[contains(text(),'Custom')]")).click();
	}

}
