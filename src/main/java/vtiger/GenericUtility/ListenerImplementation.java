package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
   ExtentReports report;
   ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		test=report.createTest(methodname);//test is created which will initialize the individual test
		
		//Reporter.log(methodname+"=> test script execution started", true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		//Reporter.log(methodname+"=> is passed", true);
		test.log(Status.PASS, methodname+"---> passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		
		//this will capture the exception occured
		//String msg=result.getThrowable().toString();
		//this will capture the current test method name
		String methodName=result.getMethod().getMethodName();
		
		//This will appenf method name with date for screenshot
		String screenShotName=methodName+"-"+jUtil.getSystemDateInFormat();
		
		//This will log in report and console
		test.log(Status.FAIL,methodName+"---> Failed");
		test.log(Status.FAIL,result.getThrowable());
		
	    //Reporter.log((methodname+"=> is failed because =>"+msg,true);
		//This will capture the screen shot and provide the screen shot name and save it in folder
		try {
			//wUtil.takeScreenShot(BaseClass.sdriver,screenShotName);
			String path=wUtil.takesScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);//navigate to screenshot path and attach it is to the report
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//String msg=result.getThrowable().toString();
		
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"---> skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		//Reporter.log(methodName+"=> is skipped because=>"+msg,true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//start of suite execution 
		/*configure extent reports*/                            //Inside ExtentReports - Report-06 sep 2022 10-38-41.html
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-5-Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		report=new ExtentReports();
	    report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser","Chrome");
		
	    report.setSystemInfo("Base-platform","windows");
		
	    report.setSystemInfo("Base-URL","http://localhost:8888");
	    report.setSystemInfo("Reporter Name","prasad");
				
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//End of suite execution
		report.flush();//consolidate all the test script execution and dump the status into report
	}

}










