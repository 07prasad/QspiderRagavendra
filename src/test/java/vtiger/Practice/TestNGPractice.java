package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
   
	@Test
	public void CreateCustomer()
	{
		System.out.println("this is tc 1 - customer is created");//passed
	}
	@Test(dependsOnMethods="CreateCustomerTest")
	public void ModifyCustomer()
	{
		System.out.println("this is tc 2 - customer is modified");//passed
	}
	@Test(dependsOnMethods= {"CreateCustomer","ModifyCustomerTest"})
	public void DeleteCustomerTest()
	{
		Assert.fail();//failed
		System.out.println("This is tc 3 - Customer is deleted");
		
	}
}














