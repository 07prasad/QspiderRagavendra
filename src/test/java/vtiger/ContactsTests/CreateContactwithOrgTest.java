package vtiger.ContactsTests;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vtiger.GenericUtility.BaseClass;

import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.Homepage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateContactwithOrgTest extends BaseClass
{

	@Test(groups="SmokeSuite")
   public void CreateContactWithOrgTest() throws EncryptedDocumentException, IOException
   {
		
		//step 2: read all the necessary data
		  String ORGNAME=eUtil.readDataFromExcel("Contacts", 3, 2)+jUtil.getRandomNumber();
		  String LASTNAME=eUtil.readDataFromExcel("Contacts", 3, 3)+jUtil.getRandomNumber();
		  
		//Step 5: navigate to organizations link
		  Homepage hp=new Homepage(driver);
		  hp.clickonorgLink();
		  Reporter.log("Org Link Clicked", true);
		  
		  //Navigate to Create Org Img
		  OrganizationsPage org=new OrganizationsPage(driver);
		  org.clickOnCreateNewOrgImg();
		  Reporter.log("New Oeganization Img Created", true);
		  
		  
		 //STEP 6: create organization with mandatory fields and save 
		  CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		  cop.createNewOrg(ORGNAME);
		  Reporter.log("New Organization Page", true);
		  //validate
		  OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		  String orgHeader=oip.getOrgHeader();
		  System.out.println("orgHeader");
		  Assert.assertEquals(orgHeader.contains(ORGNAME),  true);
         //Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
		  
		//step 7: navigate to contacts link
	       hp.clickoncontacts();
	       Reporter.log("contacts link clicked", true);
	       
	    //navigate to create contacts img
	       ContactsPage cp=new ContactsPage(driver);
	       cp.createnewcontact();
	       Reporter.log("New contacts Img Created", true);
	       
	       //create contact with org detals
	       CreateNewContactPage cnp=new CreateNewContactPage(driver);
	       cnp.createNewContact(LASTNAME, ORGNAME, driver);
	       Reporter.log("New contact with organization Created", true);
	       
	       //Validate
	       ContactsInfoPage cip=new ContactsInfoPage(driver);
	       String contactHeader=cip.getContactHeader();
	       System.out.println(contactHeader);
	       Assert.assertEquals(contactHeader.contains(LASTNAME), true);
          //Assert.assertTrue(OrgHeader.contains(LASTNAME));
	   	
	      
   }
}
