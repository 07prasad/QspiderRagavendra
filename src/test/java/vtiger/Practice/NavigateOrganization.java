package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateOrganization {

	public static void main(String[] args) {
		
		//launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
		driver.get("http://localhost:8888");
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qspiders");
		
		//select industry dropdown
		driver.findElement(By.xpath("//select[@name='industry']")).click();
		
		//select electronics option
		driver.findElement(By.xpath("//option[@value='Electronics']")).click();
		
		//select Type dropdown
		driver.findElement(By.xpath("//select[@name='accounttype']")).click();
		
		//select electronics option
		driver.findElement(By.xpath("//option[@value='Investor']")).click();
		
		//save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		//print
		System.out.println("organization name created");
		driver.close();
		
		
				
				

	}

}
