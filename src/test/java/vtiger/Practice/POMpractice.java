package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.Loginpage;

public class POMpractice {
	
	public static void main(String args[]) {
		
		//Launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		//Login to App
		Loginpage lp=new Loginpage(driver);
		
		WebElement username=lp.getUserNameEdt();
		username.sendKeys("admin");
		
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click();
		
		lp.loginToApp("admin", "admin");//--->test script optimised due to business library
		
	}

}

















