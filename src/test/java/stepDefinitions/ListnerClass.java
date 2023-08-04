package stepDefinitions;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

public abstract class ListnerClass extends CommonSteps implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TC Passed"+result.getName());
		System.out.println("passssssss");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test case fail"+result.getName());
		System.out.println("Failed TC");
		try {
			TakeScreenshot(driver, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Test Case skip"+result.getName());
		
	}

	
	

}
