package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;



	public class BaseClass {
		
		public static WebDriver driver;
		
//		Browser Launch
		
		public static WebDriver launchBrowser(String browserName) {
			
			switch(browserName) {
			
			case"chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			case"edge":
		    WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			default:
				System.err.println("Invalid Browser");
			}
			return driver;
	
}

//		url launch
		
		public static void launchUrl(String url) {
			driver.get(url);
			
			driver.manage().window().maximize();
		}
		
		//wait
		public static void implicityWait(long time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		
		
	//  get title
	   public static  String getTitle() {
		   String title = driver.getTitle();
		   return title;
	   }
	   
	//   Get CurrentUrl
	   
	   public static String getCurrenturl() {
		   String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	   }
	   
	   //Quit
	   
	   public static void quit() {
		   driver.quit();
	   }
	   

	   
	   //sendkeys
	   
	   public static String sendkeys(WebElement e,String user) {
		 e.sendKeys(user);
		return user;
		  }
	   
	  //click
		 public static void buttonClick(WebElement e) { 
		  e.click();
		   }
		   
	  //getAttribute 
		 
		public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;	  
	 }
	//get Text 
		 
			public static String getText(WebElement e) {
				String text=e.getText();
				return text;		
		
			}
		    
  //find element
		   
		   public static WebElement findElement(String locatorName, String locatorValue) {
		   WebElement Value=null;
		    if(locatorName.equals("id")) {
			   Value=driver.findElement(By.id(locatorValue));
		   } else if(locatorName.equals("name")) {
			   Value=driver.findElement(By.name(locatorValue));
		   }else if(locatorName.equals("Xpath")) {
			   Value=driver.findElement(By.xpath(locatorValue));
		   }
		   return Value;
		   
		   }
		   
	//dynamic Wait
		   void implicitywait(long time) {
		   driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		   }
		   
  //static Wait
	    public static void Threadsleep(long milis)throws InterruptedException{
			   Thread.sleep(milis);
	    }
	    
  //Actions
 //movetoelement
 	
               public static void moveToElement(WebElement e) {
				   Actions a=new Actions(driver);
				   a.moveToElement(e).perform();
			   }
			   
  //drag and drop
			   public static void drogAndDrop(WebElement src,WebElement des) {
				   Actions a=new Actions(driver);
				   a.dragAndDrop(src,des).perform();
			   }
				   
  //click and Hold
				   
				   public static void clickAndHold(WebElement src,WebElement des) {
					   Actions a=new Actions(driver);
					   a.clickAndHold(src).release(des).perform();
				   }
					   
  //rightclick
					   public static void rightClick(WebElement e) {
						   Actions a=new Actions(driver);
						   a.contextClick(e).perform();
					   }
						
						   
 // doubleClick
						   
						   public static void doubleClick(WebElement e) {
							   Actions a=new Actions(driver);
							   a.doubleClick(e).perform();
						   }
	   
	   //clear
						   
						   public static void clear(WebElement e) {
							  	   e.clear();
						   }
						   
						   
						   
	//copy text
						   public static void copytext(WebElement e)throws AWTException {
							   Robot b=new Robot();
							   b.keyPress(KeyEvent.VK_CONTROL);
							   b.keyRelease(KeyEvent.VK_CONTROL);
						   }
							   
    //Paste text
							   public static void pastetext(WebElement e)throws AWTException {
								   Robot b=new Robot();
								   b.keyPress(KeyEvent.VK_CONTROL);
								   b.keyRelease(KeyEvent.VK_CONTROL);}
							   
	 //select by index
							   public static void selectByIndex(WebElement e,int index) {
								   Select b=new Select(e);
								   b.selectByIndex(index);
							   }
							   
	 //selectbyvalue
							   public static void selectByValue(WebElement e,String index) {
								   Select b=new Select(e);
								   b.selectByValue(index);
							   }
							   
    //select By text
							   public static void selectByVisibleText(WebElement e,String Value) {
								   Select b=new Select(e);
								   b.selectByVisibleText(Value);
							   }
							   
	//first Selected option
							   public static void firstSelectedOption(WebElement e) {
								   Select b=new Select(e);
								   b.getFirstSelectedOption();
							   }
							   
  //deselect by index
							   public static void deselectbyindex(WebElement e1,int index) {
								   Select b=new Select(e1);
								   b.deselectByIndex(index);
							   }
							   
  //deselect by Value
							   public static void deselectByValue(WebElement e,String index) {
								   Select b=new Select(e);
								   b.selectByValue(index);
		                     
		                       
//deselect by text
//							
//								   
//							   
//							   
// // deselectAll
//							   public static void deselectAll(WebElement e) {
//								   Select b1=new Select(e);
//								   b.deselectAll();
//							   }
//								   
							   }
}
