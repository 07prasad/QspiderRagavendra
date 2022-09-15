package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
    
	
	//Declaration
	@FindBy(name="lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement SearchBoxEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDropdown;
	
	@FindBy(xpath="//input[@name='button']")
	private WebElement saveBtn;
	
	//Initilization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getContactNameEdt()
	{
		return ContactNameEdt;
	}
	public WebElement getorglookupimg()
	{
		return getorglookupimg();
	}
	public WebElement getSearchBoxEdt()
	{
		return SearchBoxEdt;
	}
	public WebElement getSearchBtn()
	{
		return SearchBtn;
	}
	public WebElement getleadsourceDrodown()
	{
		return leadsourceDropdown;
	}
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	//Business Library
	/**
	 * This method will create a contact using mandatory fields and save 
	 * @param lastname
	 */
     public void createNewContact(String lastname)
     {
    	 ContactNameEdt.sendKeys(lastname);
    	 saveBtn.click();
     }
     /**
      * This method will create a contact with contact name and lead source down
      * @param lastname
      * @param leadsourcetype
      */
     public void createNewContact(String lastname, String leadsourceType)
     {
    	 ContactNameEdt.sendKeys(lastname);
    	 handleDropDown(leadsourceType, leadsourceDropdown);
    	 saveBtn.click();
     }
     /**
      * This method will create a contact with lastname and organization name
      * @param lastname
      * @param orgname
      * @param driver
      */
      public void createNewContact(String lastname, String orgname, WebDriver driver)
      {
    	  ContactNameEdt.sendKeys(lastname);
    	  OrgNameEdt.click();
    	  switchToWindow(driver,"Accounts");
    	  SearchBoxEdt.sendKeys(orgname);
    	  SearchBtn.click();
    	  driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();//dynamic xpath
    	  switchToWindow(driver,"Contacts");
    	  saveBtn.click();
      }


}









































