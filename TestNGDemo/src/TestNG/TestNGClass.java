package TestNG;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import library.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass
{
	   WebDriver driver;
	  
	   //System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
   
   @BeforeTest
   public void launchapp()
   {
	   System.out.println("Starting Pos A");
	   System.setProperty("webdriver.gecko.driver", "/Users/wayne/Documents/myprojects/Selenium/GeckoDriver/geckodriver");
	   System.out.println("Starting Pos B");
	   driver =new FirefoxDriver();
	   System.out.println("Starting @Before test");
	  // Puts an Implicit wait, Will wait for 60 seconds before throwing exception
     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      // Launch website
      System.out.println("Launch website");
      driver.navigate().to("http://localhost:3000");
      //driver.navigate().to("localhost:3000");
      System.out.println("Maximise the browser");
      driver.manage().window().maximize();
      Utility.captureScreenshot(driver, "After launch");
      System.out.println("End of @BeforeTest");
   }
   @Test
   public void GF_01Login()
   {
	   System.out.println("Starting @test GF_01_Login");
	      System.out.println("Click on 'Login'");
	      Utility.captureScreenshot(driver, "Click on 'Login'");
	      driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a")).click();
	      driver.findElement(By.id("user_email")).sendKeys("wayne@edubizconnect.co.za");
	      driver.findElement(By.id("user_password")).sendKeys("emailpals");
	      Utility.captureScreenshot(driver, "Fields captured");
	      driver.findElement(By.xpath(".//*[@id='new_user']/div[3]/input")).click();
	      //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      
	      System.out.println("Wait until homescreen becomes visible");
	      WebDriverWait wait = new WebDriverWait(driver, 10);
	      WebElement element; 
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='banner-logo']/h2[2]")));
      
	      Utility.captureScreenshot(driver, "Successfully logged in");
	      System.out.println("Successfully logged in");
	      System.out.println("End of @test GF_Login");
   }
   @Test
   public void GF_02Happy_Path1()
   {
	   System.out.println("Starting @test GF_02_Happy_Path1");
	      System.out.println("Click on 'Adopt'");
	           
	      driver.findElement(By.xpath(".//*[@id='menu']/li[2]/a")).click();
	      
	     // System.out.println("Click on Firebarrel");
	      //driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[1]/div[1]/img")).click();
	      
	     // Wait until Spekboom image becomes visible
	      System.out.println("Wait until Spekboom image becomes visible");
	      WebDriverWait wait = new WebDriverWait(driver, 10);
	      WebElement element; 
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div/div/div/div/div/div[1]/div[2]/img")));
	      
	      Utility.captureScreenshot(driver, "Spekboom image has become visible");
	      
	      // Get list containing "Add To Cart" buttons for each plant
	      List<WebElement> addToCartButtons = driver.findElements(By.xpath(".//*[@id='adopt_form']/div[2]/input"));
	      System.out.println("Total selected 'Add To Cart'buttons are: " + addToCartButtons.size());
	      Iterator<WebElement> iter = addToCartButtons.iterator();
	      boolean visible = false;
	      int i = 0;
	      while (iter.hasNext()) {
	       	  i = i + 1;
	    	  System.out.println("addToCartButton no: " + i);
	    	  WebElement item = iter.next();
	    	  System.out.println("Check if button is visible");
	    	  visible = item.isDisplayed();
	    	  System.out.println("Visible = " + visible);
	 	  
	    	  if (visible) {
	    		  Utility.captureScreenshot(driver, "addToCartButton has become visible");
	    		  System.out.println("Click on Visible 'Add to Cart'");
	    		  item.click();
	    		  break;
	    	  }
	      }
	      
	      //System.exit(0);
	      	      
		     // Wait until "View Cart" present
	      System.out.println("Wait until 'View Cart' becomes visible");
	      //WebDriverWait wait = new WebDriverWait(driver, 10);
	      //WebElement element; 
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='product_added_container']/a[1]")));
	      
	      Utility.captureScreenshot(driver, "'View Cart' has become visible");
	      
	      // Get list containing "View Cart" buttons for each plant
	      List<WebElement> viewCartButtons = driver.findElements(By.xpath(".//*[@id='product_added_container']/a[1]"));
	      System.out.println("Total selected 'Add To Cart'buttons are: " + addToCartButtons.size());
	      Iterator<WebElement> iter2 = viewCartButtons.iterator();
	      boolean present = false;
	      i = 0;
	      while (iter2.hasNext()) {
	       	  i = i + 1;
	    	  System.out.println("viewCartButtons no: " + i);
	    	  WebElement item2 = iter2.next();
	    	  System.out.println("Check if 'View Cart' button is present");
	    	  present = item2.isDisplayed();
	    	  System.out.println("Visible = " + present);
	 	  
	    	  if (visible) {
	    		  System.out.println("Click on Visible 'View Cart'");
	    		  item2.click();
	    		  break;
	    	  }
	      }
	      
	      //System.exit(0);
	     	      	      	      
	      Utility.captureScreenshot(driver, "Wait for 'Proceed to Checkout' has become visible");
	      //element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div/div/div/div/div/div[4]/a[2]")));
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div/div/div/div/div[2]/a[2]")));
	
	      Utility.captureScreenshot(driver, "'Proceed to Checkout' has become visible");
	      //System.out.println("Click on 'View cart'");
	      //driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[4]/a[2]")).click();
	      
	      System.out.println("Click on 'Proceed To CheckOut'");
	      //driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[4]/a[2]")).click();
	      driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/a[2]")).click();
	      
	      //element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div/div/div/div/div[2]/a[2]")));
	     //element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='card_960347225333']/form/div[5]/div[2]/iframe")));
	     
	      // Wait until 
	      // Get correct element
	      // Test it
	      //element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div/div/div/div/h2")));
	      System.out.println("Set timeout 120 secs");
	      driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("display_as_donor")));
	      Utility.captureScreenshot(driver, "'Secure Checkout' before wait for credit card data");
	      
	      //Find total number of Iframes
	      Integer size = driver.findElements(By.tagName("iframe")).size();
	      System.out.println("Total number of Iframes is:" + size);
	      
	      // Assume 1 iFrame only
	      System.out.println("Switch to iFrame");
	      driver.switchTo().frame(0);
	      
	      // The elements inside the iFrame may not yet have appeared
	      // Sometimes it is a few seconds before they appear
	      // So we need some way of ensuring that they are visible before proceeding
	      
	      //driver.findElement(By.xpath(“//*[contains(@id,’username’)]”)).sendKeys(“username”);
	     // driver.findElement(By.xpath(//*[contains(@id,’username’)])).sendKeys(“username”);
	      //element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(“//*[contains(@id,’username’)]”)));
	     //driver.findElement(By.xpath("//*[contains(@title,'foobar')]"));
	      System.out.println("Set timeout 120 secs");
	      driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	      System.out.println("Wait for card number to appear");
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("card.number")));
	      Utility.captureScreenshot(driver, "'Secure Checkout' has become visible");	
	      System.out.println("Send card number");
	     //driver.findElement(By.xpath("//*[contains(@id,’/form/div[2]/div[2]/iframe’)]")).sendKeys("5454545454545454");      
	      driver.findElement(By.name("card.number")).sendKeys("5454545454545454");
		     
	      // element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(“//*[contains(@id,’username’)]”));

	      
	      // Check if we can use index to find the IFrame
	      
	/*      for(i=0; i<size; i++){
	    		driver.switchTo().frame(i);
	    		//int total=driver.findElements(By.xpath("html/body/a/img")).size();
	    		System.out.println("Frame index = " + i);
	    		System.out.println("Finding elements in frame - cardnumber");
	    		List<WebElement> cardNumber = driver.findElements(By.xpath("//*[contains(@id,'/form/div[2]/div[2]/iframe')]"));
	    		List<WebElement> cardNumber = driver.findElements(By.xpath(“//*[contains(@id,’username                  ’)]”));
	    		System.out.println("Finding elements in frame - cardnumber");
	    		System.out.println("Size of cardNumber is: " + cardNumber.size());
	    		
	    		//driver.findElement(By.xpath("//a[contains(text(),'117')]"));
	    				//List<WebElement> addToCartButtons = driver.findElements(By.xpath(".//*[@id='adopt_form']/div[2]/input"));
	    		     
	    				driver.switchTo().defaultContent();
	      }
	      
	      */
	      
	      //driver.findElement(By.xpath(".//*[@id='card_960347225333']/form/div[2]/div[2]/iframe")).sendKeys("5454545454545454");
	      //Utility.captureScreenshot(driver, "After populate of credit card");
	      
	      System.out.println(" We are done");
	      
	      //Close the Browser.
	      driver.close();
   }
   @AfterTest
   public void terminatetest()
   {	
	   Utility.captureScreenshot(driver, "AfterTest");
	   System.out.println("In @aftertest");
      driver.close();
   }
}