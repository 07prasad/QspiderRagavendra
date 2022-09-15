package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage 
{
  //Declaration
	@FindBy(linkText="//img[@title='Create Product...']")
	private WebElement createprodutlookupimg;
 
	//Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getCreateprodutlookupimg() {
		return createprodutlookupimg;
	}

	public void getClickOnProductsPage() {
		createprodutlookupimg.click();
	}
}
	
    
	






