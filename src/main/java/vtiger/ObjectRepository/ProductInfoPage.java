package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
   //Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement proHeaderText;
	
	
	//initialization
	public void productinfopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getProHeaderText() {
		return proHeaderText;
	}
	
    //business library
	
	public String getproHeadrText()
	{
		String pro=proHeaderText.getText();
		return null;
		
	}
	
	
}
