package TestNG;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.JavascriptExecutor;
import library.Utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class CopyOfwordpress_site_20170313
{
	   WebDriver driver;
	  
	   //System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
   
   @BeforeTest
   public void launchapp()
   {
	   System.out.println("Starting Pos A");
	   //System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
	   //System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/chrome/geckodriver");
	   System.setProperty("webdriver.chrome.driver", "/Users/wayne/Documents/myprojects/Selenium/Chrome/chromedriver");
	   System.out.println("Starting Pos B");
	   //driver =new FirefoxDriver();
	   //WebDriver driver = new ChromeDriver();
	   
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--start-maximized");
	   driver = new ChromeDriver(options);
	   
	   System.out.println("Starting @Before test");
	  // Puts an Implicit wait, Will wait for 60 seconds before throwing exception
     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      // Launch website
      System.out.println("Launch website");


   // Store the current window handle
     // String winHandleBefore = driver.getWindowHandle();

      driver.navigate().to("http://www.stuffandthings.co.za/tw/wp-admin");

      // Switch to new window opened
      //System.out.println("Switch focus to new window");
      //for(String winHandle : driver.getWindowHandles()){
      //    driver.switchTo().window(winHandle);
      //}
      
      //System.out.println("Pos C");
      //JavascriptExecutor js = (JavascriptExecutor) driver;
     // System.out.println("Pos D");
      //js.executeScript("alert('Test');");
     // System.out.println("Pos E");

      //driver.switchTo().alert().accept();
      
      //((JavascriptExecutor)this.webDriver).executeScript("alert('Test')"); 
      //this.webDriver.switchTo().alert().accept();
    
      System.out.println("Maximise the browser");
      driver.manage().window().maximize();
 
      Utility.captureScreenshot(driver, "After launch");
      //System.exit(0);
 
      System.out.println("End of @BeforeTest");
   }
 
   @Test
   public void GF_01_Login()
   {
	   System.out.println("Starting @test GF_01_Login");
	   Utility.captureScreenshot(driver, "Before capture login details");
	   System.out.println("position F");
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   System.out.println("position G");
	   WebElement element;
	   Utility.captureScreenshot(driver, "Wait until login screen becomes visible");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
	   driver.findElement(By.id("user_login")).sendKeys("Wayne");
	   driver.findElement(By.id("user_pass")).sendKeys("kuhle101@");
	   Utility.captureScreenshot(driver, "After capture login details");
	   System.out.println("Click on 'Login'");
	   driver.findElement(By.id("wp-submit")).click();
	   Utility.captureScreenshot(driver, "After login");
	   //driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
	   //selenium.click("//a[contains(text(),'Posts')]/following::a[contains(text(),'Add New')][1]");
	   
	   System.out.println("Wait until 'User Name' becomes visible");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wp-admin-bar-my-account")));   
	   //driver.findElement(By.xpath(".//*[@id='wp-admin-bar-my-account']/a")).click();  
	   System.out.println("'User Name' has become visible");	
	   Utility.captureScreenshot(driver, "User Name has become visible"); 
	   
	   // Check that we are on the dashboard
	   System.out.println("Check that we are on the dashboard");	
	   String dashboard = driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/h1")).getText();
	   Assert.assertEquals(dashboard, "Dashboard");

	   // Hover over user name
	   WebElement ele = driver.findElement(By.id("wp-admin-bar-my-account"));
	   Actions action = new Actions(driver);
	   System.out.println("Hover over user name");
	   action.moveToElement(ele).build().perform();   
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wp-admin-bar-logout")));
	   System.out.println("List item has become visible");
	   Utility.captureScreenshot(driver, "List item is visible"); 
	   
	   WebElement dropDespesa = driver.findElement(By.id("wp-admin-bar-logout"));
	   System.out.println("Click on 'Logout'");	   
	   dropDespesa.findElement(By.id("wp-admin-bar-logout")).click();
	   
	   //driver.findElement(By.id("wp-admin-bar-logout")).click();
	   //driver.findElement(By.xpath(".//*[@id='wp-admin-bar-logout']/a")).click();
	   Utility.captureScreenshot(driver, "After click on logout");
	   //driver.findElement(By.xpath(".//*[@id='wp-admin-bar-logout']/a")).click();
	   //System.exit(0);
	   
	   // Confirm successful logout
	   System.out.println("Confirm successful logout");	
	   String logout_Message = driver.findElement(By.xpath(".//*[@id='login']/p[1]")).getText();
	   Assert.assertEquals(logout_Message, "You are now logged out.");
	   
	   //System.out.println("Click on 'Posts'");
	   //driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
	   //Utility.captureScreenshot(driver, "After click on posts");
	   
	   //System.out.println("Click on 'Add New'");
	   //driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
	   //Utility.captureScreenshot(driver, "After click on Add New Post");
	   
	   //element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title-prompt-text")));
	   //driver.findElement(By.id("title-prompt-text")).sendKeys("This is the title");
	  //	 driver.findElement(By.xpath(".//*[@id='title-prompt-text']")).sendKeys("This is the title");

	   //System.exit(0);
   }
  
   @AfterTest
   public void terminatetest()
   {	
	   Utility.captureScreenshot(driver, "AfterTest");
	   System.out.println("In @aftertest");
      driver.close();
   }
}