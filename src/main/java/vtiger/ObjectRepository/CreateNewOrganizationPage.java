package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNmaeEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getOrgNameEdt()
	{
		return getOrgNameEdt();
	}
	public WebElement getIndustryDropDown()
	{
		return industryDropDown;
	}
	public WebElement getTypeDropDown()
	{
		return typeDropDown;
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	//Business library
	/**
	 * This method will create organization with org name
	 * @param orgname
	 */
	
	public void createNewOrg(String orgName)
	{
		OrgNmaeEdt.sendKeys(orgName);
		saveBtn.click();
	}
     public void createNewOrg(String Orgname, String industryType)
     {
    	 OrgNmaeEdt.sendKeys(Orgname);
    	 handleDropDown(industryType,industryDropDown);
    	 saveBtn.click();
     }
     /**
      * This method will create organization with type and industry drop down
      * @param OrgName
      * @param industryType
      * @param type
      */
      public void createNewOrg(String OrgName, String industryType, String type)
      {
    	  OrgNmaeEdt.sendKeys(OrgName);
    	  handleDropDown(industryType, industryDropDown);
    	  handleDropDown(type, typeDropDown);
    	  saveBtn.click();
      }
}











