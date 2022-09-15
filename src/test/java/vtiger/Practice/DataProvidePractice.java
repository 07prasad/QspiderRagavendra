package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidePractice
{
	@Test(dataProvider="getData")
	public void addProductToCartTest(String name, String model, int price, String feature, int qty)
	{
		System.out.println(name+"_"+model+"_"+price+"_"+feature+"_"+qty+"_");
	}
	@DataProvider
	public Object[][] getData()
	{
		                       //row //columns
		Object[][] d=new Object[4][5];
		
		d[0][0]="samsung";
		d[0][1]="A80";
		d[0][2]=3000;
		d[0][3]="camera";
		d[0][4]=12;
		
		d[1][0]="vivo";
		d[1][1]="A8";
		d[1][2]="300";
		d[1][3]="camera";
		d[1][4]=10;
		
		d[2][0]="Oppo";
		d[2][1]="v1";
		d[2][2]="30000";
		d[2][3]="security";
		d[2][4]="12";
		
		d[3][0]="iphone";
		d[3][1]="13pro";
		d[3][2]="30009";
		d[3][3]="secure";
		d[3][4]=15;
		
		return d;
	}

}
