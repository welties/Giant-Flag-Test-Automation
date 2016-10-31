package captureScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CopyOfFacebookScreenshot {
	
	@Test
	public void captureScreenshot() throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Learn Automation");
		
		//Typecasting
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/facebook.png"));
		
		System.out.println("Screenshot");
		
		driver.quit();
		
	}

}
