package captureScreenshot;

import java.io.File;

import library.Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FacebookScreenshot {
	
	@Test
	public void captureScreenshot() throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Learn Automation");
		
		Utility.captureScreenshot(driver, "Wayne");
		
		
		driver.quit();
		
	}

}
