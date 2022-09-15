package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
  {
	
	public void maximizewindow(WebDriver driver) 
	{
		
		driver.manage().window().maximize();
	}
	 public void waitForElementsToLoadInDoM(WebDriver driver) 
	 {
		 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 
	 public void waitForElementToLoad(WebDriver driver, WebElement element) 
	 {
		 
		 WebDriverWait wait=new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	   public void waitForElementToBeClickable(WebDriver driver, WebElement element) 
	   {
		   
		   WebDriverWait wait=new WebDriverWait(driver, 20);
		   wait.until(ExpectedConditions.elementToBeClickable(element));
	   }
	   
       public void customwaitAndClickOnElement(WebElement element) throws InterruptedException
       {
    	 
    	 int count=0;
    	 while(count<10) {
    		
    	   try {
    		   element.click();
    		   break;
    	   }
    	    catch (Exception e) {
    	    	
    	    	//handle the exception
    	    	Thread.sleep(1000);
    	    	count++;
    	    }
    	 }
     }
	public void handleDropDown(WebElement element, int index) {
    	  
    	  Select s=new Select(element);
    	  s.selectByIndex(index);
      }
       public void handleDropDown(WebElement element, String visibletext) {
    	   
    	   Select s=new Select(element);
    	   s.selectByVisibleText(visibletext);
       }

     public void handleDropDown(String value, WebElement element) {
    	 
    	 Select s=new Select(element);
    	 s.selectByValue(value);
     }

      public void doubleClickOn(WebDriver driver) {
    	   
    	  Actions act=new Actions(driver);
    	  act.doubleClick().perform();      
     }
      
      public void doubleClickOn(WebDriver driver, WebElement element) {
    	  
    	  Actions act=new Actions(driver);
    	  act.doubleClick(element).perform();
      }
        
      public void mouseHoverOn(WebDriver driver, WebElement element) {
    	  
    	  Actions act=new Actions(driver);
    	  act.moveToElement(element).perform();
      }

      public void mouseHoverOn(WebDriver driver, int x, int y) {
    	  
    	  Actions act=new Actions(driver);
    	  act.moveByOffset(x, y).perform();
      }

      public void rightClickOn(WebDriver driver) {
    	  
    	  Actions act=new Actions(driver);
    	  act.contextClick().perform();
      }

      public void rightClickOn(WebDriver driver, WebElement element) {
    	  
    	  Actions act=new Actions(driver);
    	  act.contextClick(element).perform();
      }

      public void dragAndDropOn(WebDriver driver, WebElement srcElement, WebElement targetElement) {
    	  
    	  Actions act=new Actions(driver);
    	  act.dragAndDrop(srcElement, targetElement).perform();
      }
       
      public void acceptAlert(WebDriver driver) {
    	  
    	  driver.switchTo().alert().accept();
      }

      public void dismissAlert(WebDriver driver) {
    	  
    	  driver.switchTo().alert().dismiss();
      }

      public String getTextInAlert(WebDriver driver) {
    	  
    	  String alertText=driver.switchTo().alert().getText();
    	  return alertText;
      }

      public void switchToWindow(WebDriver driver, String partialTitle) {
    	  
    	  //step1:get all window handles
    	    Set<String> widowIds=driver.getWindowHandles();
    	  
    	  //step2:iterator through all the windowIds
    	    Iterator<String> it=widowIds.iterator();
    	    
    	  //step3:navigate inside the windows
    	    while(it.hasNext())//loop untill windowids exist
    	    {
    	    	//capture all the windows
    	    	  String winId=it.next();
    	    	  
    	    	//switch to the window and capture the title
    	    	  String currentTitle=driver.switchTo().window(winId).getTitle();
    	    	  if(currentTitle.contains(partialTitle))
    	    	  {
    	    		  break;
    	    	  }
    	    }
      }
         
        public void switchTiFrame(WebDriver driver, int index) {
        	
        	driver.switchTo().frame(index);
        }
      
        public void switchToFrame(WebDriver driver, String idOrName) {
        	
        	driver.switchTo().frame(idOrName);
        }
      
        public void switchToFrame(WebDriver driver, WebElement element) {
        	
        	driver.switchTo().frame(element);
        }
      
        public  String takesScreenShot(WebDriver driver, String screenshotName) throws IOException 
         {	
            TakesScreenshot ts=(TakesScreenshot)driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            String path=".\\ScreenShots\\"+screenshotName+".png";
            File dst=new File(path);
            FileUtils.copyFile(src, dst);
            
            return dst.getAbsolutePath();    //used for reporting in listeners        
         }
      
        public void scrollAction(WebDriver driver)
        {
        	JavascriptExecutor js=(JavascriptExecutor) driver;
        	js.executeAsyncScript("window.scrollBy(0,500)", "");
        }
       
        public void scrollAction(WebDriver driver, WebElement element)
        {
        	JavascriptExecutor js=(JavascriptExecutor) driver;
        	//js.executescript("argument[0].scrollintoview()", element);
            int y=element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")", element);
        }
  }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
      
      
