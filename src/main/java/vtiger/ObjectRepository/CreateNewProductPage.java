package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	//Declaration
	@FindBy(name="//input[@name='productname']")
	private WebElement productname;
	
	@FindBy(name="//input[@name='discontinued']")
	private WebElement checkbox;
	
	@FindBy(name="//input[@name='sales_start_date']")
	private WebElement date;
	
	@FindBy(xpath="//option[@value='Software']")
	private WebElement dropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utiliztion
	public WebElement getProductname() {
		return productname;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getDate() {
		return date;
	}
	public WebElement getDropdown() {
		return dropdown;
	}
	
	//Business Library
	
	public void createNewProductPage(String proname, String dateof, String productcategorydropdown)
	{
		productname.sendKeys(proname);
		checkbox.click();
		date.sendKeys(dateof);
	   // handledropdown(productcategorydropdown, dropdown);
	}
	
	
	
	
	

}
