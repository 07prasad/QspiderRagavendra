package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
         Driver d=new Driver();
         Connection con=null;
         
         //try {
         //step1:register the driver
         DriverManager.registerDriver(d);
         
         //step2:get the connection
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
         
         //step3:issue create statement
         Statement state=con.createStatement();
         
         //step4:execute the query
         String query="insert into customerinfo values('Alok',12,'mumbai');";
		 int result = state.executeUpdate(query);
         if(result==1) {
        	 System.out.println("the data is inserted");
         }
         else {
        	 System.out.println("the data is not inserted");
         }
         }
//	     catch(Exception e){
//        }
//           finally {
//         //step5:close the database
//           con.close();
//           System.out.println("database closed");
//           }   
	}
	




