package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Driver driver;
	Connection con=null;
	private ResultSet result;
	private Object actData;
	private boolean flag;
	
	
	public void connectToDB() throws SQLException
	{
		driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(ConstantsUtility.DBUrl, ConstantsUtility.DBUsername, ConstantsUtility.DBPassword);
	}
	
	public void cliseDb() throws SQLException
	{
		con.close();
	}
	
    public String executeQueryAndGetTheData(String query, int collIndex,String expData) throws SQLException
    {
    	con.createStatement().executeQuery(query);
	    while(result.next())
    	{
    		result.getString(collIndex);
    		if(actData.equals(expData))
    		{
    			flag=true;//flag rising
    			break;
    		}
    	}
    
           if(flag)
           {
        	   System.out.println(expData);
        	   return expData;
           }
           else
           {
        	   System.out.println("data not presented");
        	   return " ";
           }
    }
} 
        




















