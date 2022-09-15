package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import vtiger.ObjectRepository.Loginpage;

public class CreateContactWithMandatoryFieldTest extends BaseClass {
	@Test(groups="SmokeSuite")
	public  void  createContactWithMandatoryFieldTest() throws EncryptedDocumentException, IOException{
		   
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
		
		
	    
	    //Vlaidate
	    ContactsInfoPage cip=new ContactsInfoPage(driver);
	    String contactHeader=cip.getContactHeader();
	    Assert.assertTrue(contactHeader.contains(lastname));
	}}
	 /*   if(contactHeader.contains(LASTNAME))
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("fail");
	    }*/
	    
	    






























