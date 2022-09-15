package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.Homepage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreatecontactTest extends BaseClass {

	
	
@Test(groups="RegressionSuite")
	public 	void createContactTest() throws IOException {
		
		
	String lastname=eUtil.readDataFromExcel("Contacts", 1, 2);
		
		
		
		//step 5: navigate to contacts
		Homepage hp=new Homepage(driver);
		  hp.clickoncontacts();
		  
		
		//step 6: click on create contact
		  ContactsPage cp=new ContactsPage(driver);
		  cp.createnewcontact();
		
		//step 7: create contact with mandatory information
		  CreateNewContactPage cc=new CreateNewContactPage(driver);
		  cc.createNewContact(lastname);
		
			
		//step 8:validate
		  
		  ContactsInfoPage ci=new ContactsInfoPage(driver);
	       String contactHeader=ci.getContactHeader();
		 Assert.assertEquals(contactHeader.contains(lastname), true);
	     //  Assert.fail();
	}
	
}











