package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.Homepage;
import vtiger.ObjectRepository.Loginpage;

public class BaseClass 
{
   public DatabaseUtility dUtil=new DatabaseUtility();
   public JavaUtility jUtil=new JavaUtility();
   public ExcelFileUtility eUtil=new ExcelFileUtility();
   public PropertyFileUtility pUtil=new PropertyFileUtility();
   public WebDriverUtility wUtil=new WebDriverUtility();
   
   
   public WebDriver driver=null;
   public static WebDriver sdriver=null;
   @BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
   public void bsConnectDB() throws SQLException
   {
	   //dUtil.connectToDB();
	   Reporter.log("Database connection successfully", true);
   }
  //@Parameters("BROWSER")
 // @BeforeTest
  @BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
   public void bcConfig(/*String BROWSER*/) throws IOException
   {
	   String BROWSER=pUtil.readDataFromPropertyFile("browser");
	   String URL=pUtil.readDataFromPropertyFile("url");
	   
	   if(BROWSER.equalsIgnoreCase("CHROME"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   Reporter.log("chrome browser launched successfully", true);
	   }
	   else if(BROWSER.equalsIgnoreCase("FIREFOX"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		   Reporter.log("firefox browser launched successfully");
	   }
	   else
	   {
		   System.out.println("Invalid browser successfully");
	   }
	   sdriver=driver;
	   wUtil.maximizewindow(driver);
	   wUtil.waitForElementsToLoadInDoM(driver);
	   driver.get(URL);
	   }
	   
	   @BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	   public void bmConfig() throws IOException
	   {
	   String USERNAME=pUtil.readDataFromPropertyFile("username");
	   String PASSWORD=pUtil.readDataFromPropertyFile("password");
	   Loginpage lp=new Loginpage(driver);
	   lp.loginToApp(USERNAME, PASSWORD);
	   Reporter.log("Login successfull", true);
	   }
	   
	   @AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	   public void amConfig()
	   {
		   Homepage hp=new Homepage(driver);
		   hp.signOutApp(driver);
		   Reporter.log("signout successfull", true);
	   }
	  // @AfterTest
	   @AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	   public void acConfig()
	   {
		   driver.close();
		   Reporter.log("close the browser successfully", true);
	   }
	   @AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	   public void asConfig()
	   {
		   //dUtil.cliseDb();
		   Reporter.log("close the database connection", true);
	   }
	   
	  }














