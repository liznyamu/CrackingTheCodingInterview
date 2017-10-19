package SmokeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import library.Utility;

public class HandleRadioButton {

	public static void main(String[] args){
		Utility.setFirefoxCapabilities();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://seleniumpractise.blogspot.co.ke/2016/08/how-to-automate-radio-button-in.html");
		
		List <WebElement> radio = driver.findElements(By.xpath(".//input[@name='lang' and @type='radio']"));
		
		for(int i = 0; i<radio.size(); i++){
			WebElement local_radio = radio.get(i);
			
			String value = local_radio.getAttribute("value");
			
			System.out.println("Values from radio buttons are ========>>>>>>>>" + value);
			
		}
		
		driver.quit();
		
	}
}
