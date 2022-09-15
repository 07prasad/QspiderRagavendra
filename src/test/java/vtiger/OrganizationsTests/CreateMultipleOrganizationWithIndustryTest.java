package vtiger.OrganizationsTests;


import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vtiger.GenericUtility.BaseClass;

import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.Homepage;

import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

/**
 * @author prasad
 * @throws IOException 
 */
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)

public class CreateMultipleOrganizationWithIndustryTest extends BaseClass {
	
	
	 @Test(dataProvider="OrgData")
	 public  void CreateMultipleOrgTest(String Org,String industryType ) throws IOException
	 {
		 
	 //Read all the requird data
	
	 
	 
	 //Launch the browser
	
		 
	    //Login to app
		
		 //Navigate to Organization link
		 Homepage hp=new Homepage(driver);
		 hp.clickonorgLink();
		 
		 //Navigate to create org look up img
		 OrganizationsPage orga=new OrganizationsPage(driver);
		 orga.clickOnCreateNewOrgImg();
		 
		 //create new org with industry type
		 CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createNewOrg(Org+jUtil.getRandomNumber(), industryType);
		 
		 //Validate
		 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		 String orgHeader=oip.getOrgHeader();
	     Assert.assertEquals(orgHeader.contains(Org), true);
	 }
	 
	    @DataProvider(name="OrgData")
	    public Object[][] getData() throws EncryptedDocumentException, IOException
	    {
			return eUtil.readMultipleDataFromExcel("MultipleOrg");
	    	
	    }
	 }






















