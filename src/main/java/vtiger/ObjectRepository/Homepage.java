package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class Homepage extends WebDriverUtility{
	
	//Declaration
	 @FindBy(linkText="Organizations")
	 private WebElement OrganizationsLnk;
	 
	 @FindBy(linkText="Contacts")
	 private WebElement ContactsLnk;

	 @FindBy(linkText="Opportunities")
	 private WebElement OpportunitiesLnk;

	 @FindBy(linkText="products")
	 private WebElement ProductsLnk;

	 @FindBy(linkText="Leads")
	 private WebElement LeadsLnk;
	 
	 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	 private WebElement adminstratorImg;
	 
	// @FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")})
	 @FindBy(linkText="Sign Out")
	 private WebElement signOutLnk;
	 
	 //Initialization
	 public Homepage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	//Utilization
		
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
     //business library
	/**
	 * This method will perfom signout operation
	 * @param driver
	 */

	public void signOutApp(WebDriver driver) 
	{
		mouseHoverOn(driver, adminstratorImg);
		signOutLnk.click();
	}
    /**
     * This method click on organization
     */
	 public void clickonorgLink()
	 {
		 OrganizationsLnk.click();
     }
	 /**
	  * This method clickoncontacts
	  */
	 public void clickoncontacts()
	 {
		 ContactsLnk.click();
	 }
}
	 









