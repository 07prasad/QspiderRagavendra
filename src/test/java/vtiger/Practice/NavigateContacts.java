package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateContacts {

	public static void main(String[] args) {
	
		//launch the browser
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("http://localhost:8888/index.php?action=index&module=Home");
				
				//Login to application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//navigate to contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//click on create contacts look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//text box accepting the data
				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("tata");
				
				//text box accepting the data
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("prasad");
				
				//navigate to organizations link
				driver.findElement(By.xpath("//a[text()='Contacts']/ancestor::td/descendant::a[text()='Organizations']")).click();
				
				//click on create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Enter the mandatory fields
				driver.findElement(By.name("accountname")).sendKeys("Qspiders");
				
				//save
				driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
				
				//print
				System.out.println("organization name created");
				System.out.println("contacts name created");
				driver.close();
				
				
				
				
	}

}
