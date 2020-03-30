/**
 * 
 */
package com.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author pkumar
 *
 * here i have instantiated driver and properties browser 
 */
public class FBase {
	
	public static  Properties prop;
	public static  WebDriver driver;
	public FBase()
	{
	try{
			prop = new Properties();
			FileInputStream source = new FileInputStream("C:\\Users\\Vaio\\git\\Transfomer-RetryAnalyzerRepo\\Transfomer-RetryAnalyzerRepo\\src\\main\\java\\com\\facebook\\config\\config.properties");
			prop.load(source);
	   }
	catch(FileNotFoundException e)
	{
		    e.printStackTrace();
	}
	catch(IOException e)
	{
			e.printStackTrace();
	}
	}
	
	public void bmet()
	{
		String browserName = prop.getProperty("Browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
