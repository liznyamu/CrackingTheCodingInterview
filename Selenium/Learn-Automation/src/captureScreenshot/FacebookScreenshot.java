package captureScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import library.Utility;

public class FacebookScreenshot {
	WebDriver driver;
	
	@Test
	public void captureScreenshot() throws Exception{
		
		Utility.setFirefoxCapabilities();
		
		driver = new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		
		
		driver.get("http://www.facebook.com");		
	
		driver.findElement(By.xpath(".//*[@id='email5552']")).sendKeys("Learn Automation");		
					
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			Utility.captureScreenshot(driver, result.getName());
		}
		
		driver.quit();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
