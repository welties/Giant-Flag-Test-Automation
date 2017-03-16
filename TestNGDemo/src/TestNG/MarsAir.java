package TestNG;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class MarsAir {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  public static void main(String args[]) {
	  
	  JUnitCore junit = new JUnitCore();
	  junit.addListener(new TextListener(System.out));
	  Result result = junit.run(MarsAir.class); // Replace "SampleTest" with the name of your class
	  if (result.getFailureCount() > 0) {
	    System.out.println("Test failed.");
	    System.exit(1);
	  } else {
	    System.out.println("Test finished successfully.");
	    //System.exit(0);
	  }
	}

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "/Users/wayne/Documents/myprojects/Selenium/Chrome/chromedriver");
    //driver = new FirefoxDriver();
	  ChromeOptions options = new ChromeOptions();
	   options.addArguments("--start-maximized");
	   driver = new ChromeDriver(options);
    baseUrl = "http://ronwea.marsair.tw/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  /**
 * @throws Exception
 */
@Test
  public void testMarsAir() throws Exception {
    driver.get(baseUrl + "/");
    for(int i = 1 ; i < 7 ; i++)
    {
    	for (int j = 1 ; j < 7 ; j++)
    	{
    	new Select(driver.findElement(By.id("departing"))).selectByIndex(i);
    	new Select(driver.findElement(By.id("returning"))).selectByIndex(j);
        driver.findElement(By.id("promotional_code")).sendKeys("FF3-DUE-126");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("MarsAir")).click();
        
    	}
    	
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}