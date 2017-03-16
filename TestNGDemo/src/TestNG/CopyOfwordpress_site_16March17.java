// Notes for myself
// Page object model - 
// http://toolsqa.com/selenium-webdriver/page-object-model/
//http://toolsqa.com/selenium-webdriver/page-object-model/
//https://seleniumbycharan.wordpress.com/2015/06/01/page-object-model-selenium/

package TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class CopyOfwordpress_site_16March17
{
	   WebDriver driver;
	  
	   //System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
   
   @BeforeTest
   public void launchapp()
   {	   
	   System.out.println("Pre-test Settings");
	   System.setProperty("webdriver.chrome.driver", "/Users/wayne/Documents/myprojects/Selenium/Chrome/chromedriver");
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--start-maximized");
	   driver = new ChromeDriver(options);
	   
	   System.out.println("Starting @Before test");
	  // Puts an Implicit wait, Will wait for 60 seconds before throwing exception
     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     
      // Launch website
      System.out.println("Launch website");
      driver.navigate().to("http://www.stuffandthings.co.za/tw/wp-admin");
    
      System.out.println("Maximise the browser");
      driver.manage().window().maximize();
 
      Utility.captureScreenshot(driver, "After launch");
 
      System.out.println("End of @BeforeTest");
   }
@Test
   public void WP_01_Login()
  {
	//temporary code
	boolean result;
	//result = ("the whole string".indexOf("the")) >=0;
	//System.out.println("result = " + result);
	//System.out.println("indexof=: " + ("the whole string".indexOf("the")));
	 //titleFound = (listedPosts.indexOf(title)) >= 0;
	//System.exit(0);
	
	   System.out.println("Starting @test WP_01_Login");
	   Utility.captureScreenshot(driver, "Before capture login details");
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   WebElement element;
	   Utility.captureScreenshot(driver, "Wait until login screen becomes visible");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
	   driver.findElement(By.id("user_login")).sendKeys("Wayne");
	   driver.findElement(By.id("user_pass")).sendKeys("kuhle101@");
	   Utility.captureScreenshot(driver, "After capture login details");
	   System.out.println("Click on 'Login'");
	   driver.findElement(By.id("wp-submit")).click();
	   Utility.captureScreenshot(driver, "After login");
	   
	   System.out.println("Wait until 'User Name' becomes visible");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wp-admin-bar-my-account")));   
	   System.out.println("'User Name' has become visible");	
	   Utility.captureScreenshot(driver, "User Name has become visible"); 
	   
	   // Check that we are on the dashboard
	   System.out.println("Check that we are on the dashboard");	
	   String dashboard = driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/h1")).getText();
	   AssertJUnit.assertEquals(dashboard, "Dashboard");

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
	   Utility.captureScreenshot(driver, "After click on logout");
	   
	   // Confirm successful logout
	   System.out.println("Confirm successful logout");	
	   String logout_Message = driver.findElement(By.xpath(".//*[@id='login']/p[1]")).getText();
	   AssertJUnit.assertEquals(logout_Message, "You are now logged out.");
   }
   //@Ignore
   @Test
   public void WP_02_Add_Post()
   {
	   System.out.println("Starting @test WP_01_Login");
	   Utility.captureScreenshot(driver, "Before capture login details");
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   WebElement element;
	   Utility.captureScreenshot(driver, "Wait until login screen becomes visible");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
	   driver.findElement(By.id("user_login")).sendKeys("Wayne");
	   driver.findElement(By.id("user_pass")).sendKeys("kuhle101@");
	   Utility.captureScreenshot(driver, "After capture login details");
	   System.out.println("Click on 'Login'");
	   driver.findElement(By.id("wp-submit")).click();
	   Utility.captureScreenshot(driver, "After login");
	   
	   System.out.println("Wait until 'User Name' becomes visible");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wp-admin-bar-my-account")));   
	   System.out.println("'User Name' has become visible");	
	   Utility.captureScreenshot(driver, "User Name has become visible"); 
	   
	   // Hover over 'Post'
	   //WebElement ele = driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]"));
	   //Actions action = new Actions(driver);
	   //System.out.println("Hover 'Posts'");
	   //action.moveToElement(ele).build().perform();   
	   //element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")));
	   //System.out.println("List item has become visible");
	   //Utility.captureScreenshot(driver, "List item is visible"); 
	   
	   // Click on Posts
	   System.out.println("Click on 'Posts'");
	   driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
	   System.out.println("Wait until submenu becomes visible'");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")));
	   
	   System.out.println("Click on 'Add New'");
	   driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
	   Utility.captureScreenshot(driver, "After click on Add New Post");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='wpbody-content']/div[3]/h1")));
	   
	   // Confirm on screen to Add New Post
	   String logout_Message = driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/h1")).getText();
	   Assert.assertEquals(logout_Message, "Add New Post");
	   
	   //Populate the blog title	   
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   Date date = new Date();
	   System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
	   
	   //Publish post
	   driver.findElement(By.id("title")).sendKeys("This is the title - " + dateFormat.format(date));
	   String title = "This is the title - " + dateFormat.format(date);
	   driver.findElement(By.id("publish")).click();
	   
	   // Extract post number
	   String urlname = driver.getCurrentUrl();
	   System.out.println("URL = " + urlname);
	   int n = urlname.indexOf("=");
	   System.out.println("Index of equals = " + n);
	   int m = urlname.indexOf("&");
	   System.out.println("Index of & = " + m);
	   String p =  urlname.substring(n+1,m);
	   System.out.println("Our post number is " +p);
	   
	   // Now go confirm that new article in list for all posts
	   System.out.println("Click on All Posts");
	   driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[2]/a")).click();
	   Utility.captureScreenshot(driver, "After click on All Posts");
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='wpbody-content']/div[3]/h1")));
	   
	   
	   
	  // Experimental code to print elements in list
	  // List<WebElement> items = driver.findElements(By.id("the-list"));
	   //List<WebElement> postLine;
	   //int counter = -1;
	  //boolean titleFound;
	  //System.out.println("Item size =:" + items.size() );
	   ///if ( items.size() > 0 ) {
	     //for ( WebElement we: items ) {
	    	// System.out.println("Counter i:" + counter);
	    	 //counter = counter + 1;

	      //System.out.println("Post data is" + we.getText() );
	      //String listedPosts = we.getText() ;
	      //System.out.println("title = " + title);
	      //System.out.println("Index is: " + (listedPosts.indexOf(title)));
	      //titleFound = (listedPosts.indexOf(title)) >= 0;
	      //System.out.println("titleFound is: " + titleFound);
	          
	     }
	   
   
  
   @AfterTest
   public void terminatetest()
   {	
	   Utility.captureScreenshot(driver, "AfterTest");
	   System.out.println("In @aftertest");
     // driver.close();
   }
}