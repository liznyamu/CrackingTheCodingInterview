package library;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Utility {

	/**
	 * Capture screen shots
	 * @param driver
	 */
	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception occurred while taking screenshot" + e.getMessage());
		}

	}
	
	/**
	 * Set Gecko Driver
	 */
	public static void setFirefoxCapabilities(){
		
		System.setProperty("webdriver.gecko.driver", "/home/erza/Application_Server/selenium/geckoDriver/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);	
	}
	
	

}
