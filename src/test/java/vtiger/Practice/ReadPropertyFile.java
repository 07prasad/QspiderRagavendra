package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       //load the file to file input stream
		FileInputStream fis=new FileInputStream("./chromedriver.exe");
		
		//create object of properties from java
		Properties prop=new Properties();
		
		//load the file to properties object
		prop.load(fis);
		
		//read data through the key
		String bs=prop.getProperty("browser");
		System.out.println(bs);
		
		String us=prop.getProperty("url");
		System.out.println(us);
		
		}

}
