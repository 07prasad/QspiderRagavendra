package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverUtilPractice {

	
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implycitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void explicitlywait(WebDriver driver)
	{
		
	}
}
