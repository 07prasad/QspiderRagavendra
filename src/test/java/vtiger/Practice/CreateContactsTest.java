package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactsTest {

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
		
		//click on dropdown button
		driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
		
		//select on option
		driver.findElement(By.xpath("//option[@value='Mr.']")).click();
		
		//text box accepting the data
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("tata");
		
		//text box accepting the data
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("prasad");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//print
		System.out.println("contacts name created");
		
		driver.close();
		
	}

}
