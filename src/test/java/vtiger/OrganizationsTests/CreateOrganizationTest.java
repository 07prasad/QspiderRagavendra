package vtiger.OrganizationsTests;
import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
//import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.Homepage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups="RegressionSuite")
	public void createOrganizationTest() throws EncryptedDocumentException, IOException 
	{
		String orgname=eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//navigate to Organization link
		Homepage hp=new Homepage(driver);
		hp.clickonorgLink();
		Reporter.log("organisation link clicked");
		
		//Navigate to create org img 
		OrganizationsPage org=new OrganizationsPage(driver);
		org.clickOnCreateNewOrgImg();
		Reporter.log("organisation image clicked");

		//Create Organization with mandatory fields
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createNewOrg(orgname);
		Reporter.log("organisation is created");

		//Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrgHeader();
		System.out.println(OrgHeader);
	Assert.assertEquals(OrgHeader.contains(orgname), true);
	//	Assert.assertTrue(OrgHeader.contains(ORGNAME));
	
	
	
	    
	}

	}
