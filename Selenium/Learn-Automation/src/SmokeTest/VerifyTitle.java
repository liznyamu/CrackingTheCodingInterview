package SmokeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class VerifyTitle {
	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@Test
	public void verifyBlogTitle(){
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.learn-automation.com");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Selenium"));
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus() == ITestResult.FAILURE){
			//10:36
		}
		
	}

}
