package com.swiggy.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.swiggy.reports.ExtentReportManager;

public class MySuiteListener implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Suite started...");
		
		ExtentReportManager.initReport("target/extentReport.html");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Suite ended...");
		ExtentReportManager.closeReport();
	}
	
	

}
