package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CopyOfTestNGClass
{
	   WebDriver driver;
	  
	   //System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
   
   @BeforeTest
   public void launchapp()
   {
	   System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
	   driver =new FirefoxDriver();
	   System.out.println("Before test");
	  // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      // Launch website
      System.out.println("Launch website");
      driver.navigate().to("http://www.calculator.net");
      driver.manage().window().maximize();
   }
   @Test
   public void calculatepercent()
   {
	   System.out.println("Starting @test");
	   //System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
	   //driver =new FirefoxDriver();
	   System.out.println("Click on Math Calculators");
	   // Click on Math Calculators
      driver.findElement(By.xpath(".//*[@id='hcalc']/table/tbody/tr/td[2]/div[3]/a")).click();
      
      // Click on Percent Calculators
      System.out.println("Click on Percent Calculators");
      driver.findElement(By.xpath(".//*[@id='content']/ul[1]/li[3]/a")).click();     
      // Enter value 10 in the first number of the percent Calculator
      System.out.println("Capture 10");
      //driver.findElement(By.id("cpar1")).sendKeys("10");
      
      // Enter value 50 in the second number of the percent Calculator
      System.out.println("Capture 50");
      //driver.findElement(By.id("cpar2")).sendKeys("50");
      
      // Click Calculate Button
      System.out.println("Click Calculate Button");
      //driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();
      
      // Get the Result Text based on its xpath
      System.out.println("Get result");
      //String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/span/font/b")).getText();
      
      // Print a Log In message to the screen
      // System.out.println("The Result is " + result);
      
      // if(result.equals("5"))
      //{
      //   System.out.println(" The Result is Pass");
     // }
      //else
      //{
       //  System.out.println(" The Result is Fail");
      //}
   }
   @AfterTest
   public void terminatetest()
   {
      driver.close();
   }
}