package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {

		System.out.println("************** Test Started : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("************** Test is Successful : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("************** Test Failure : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("************** Test Skipped : " + result.getName());
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("************** Test Completed : " + context.getName());
	}
	
	public void onStart(ISuite suite) {
		System.out.println("Here starts Suite");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Here ends everything");
	}

}
