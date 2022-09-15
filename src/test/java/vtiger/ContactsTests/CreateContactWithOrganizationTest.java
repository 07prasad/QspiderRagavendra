package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.Homepage;
import vtiger.ObjectRepository.Loginpage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups="RegressionSuite")
	public  void createContactWithOrganizationTest()  throws IOException {
		
		
		
	
		
		String ORGNAME=eUtil.readDataFromExcel("Contacts", 3, 2)+jUtil.getRandomNumber();
		String lastname=eUtil.readDataFromExcel("Contacts", 3, 3)+jUtil.getRandomNumber();
		
	
		//navigate to Organization link
		Homepage hp=new Homepage(driver);
		hp.clickonorgLink();
		
		//Navigate to create org img 
		OrganizationsPage org=new OrganizationsPage(driver);
		org.clickOnCreateNewOrgImg();
		//Create Organization with mandatory fields
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createNewOrg(ORGNAME);
		//Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrgHeader();
		System.out.println(OrgHeader);
	Assert.assertEquals(OrgHeader.contains(ORGNAME), true);
	//	Assert.assertTrue(OrgHeader.contains(ORGNAME));
	
		//Navigate to Contacts link
		hp.clickoncontacts();;
		//Navigate to cretae contacts img
		ContactsPage cp=new ContactsPage(driver);
		  cp.createnewcontact();
		
		//create contact with org details
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createNewContact(lastname, ORGNAME, driver);
		
		//Validate
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader=cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(lastname));
		
	}

}


































