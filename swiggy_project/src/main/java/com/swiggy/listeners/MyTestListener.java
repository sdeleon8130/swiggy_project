package com.swiggy.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.swiggy.reports.ExtentReportManager;


public class MyTestListener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Begin Test");
		
		
		ExtentReportManager.startTest(result.getMethod().getMethodName());
		ExtentReportManager.endTest();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Successful");
		
		ExtentReportManager.logSuccess("Test Passed: " + result.getMethod().getMethodName());
		ExtentReportManager.endTest();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Failed");
		
		//figure out failed reason
		String errorMessage = result.getThrowable().getMessage();
		
		ExtentReportManager.logFailure("Error Message : " + errorMessage);
		ExtentReportManager.endTest();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("Test Skipped: " + methodName);
		ExtentReportManager.logSkip("Test Skipped: " + result.getMethod().getMethodName());
		ExtentReportManager.endTest();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");
		ExtentReportManager.logWarn("Test Failed But Within Success Percentage: " + result.getMethod().getMethodName());
		ExtentReportManager.endTest();
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("Test Failed for Timeout: " + methodName);
		
		String errorMessage = result.getThrowable().getMessage();
		
		ExtentReportManager.logFailure("Error Message : " + errorMessage);
		
		ExtentReportManager.logFailure("Test Failed: " + result.getMethod().getMethodName());
		ExtentReportManager.endTest();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Finished");
	}

	
}
