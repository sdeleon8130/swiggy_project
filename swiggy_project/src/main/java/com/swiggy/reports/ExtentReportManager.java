package com.swiggy.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportManager {
	
	static ExtentReports report;
	static ExtentTest test;
	
	public static void initReport(String pathOfReport) {
		
		report = new ExtentReports(pathOfReport);
	}
	
	public static void closeReport() {
		
		report.flush();
	}
	
	public static void startTest(String nameOfTest) {
		
		test = report.startTest(nameOfTest);
	}
	
	public static void endTest() {
		
		report.endTest(test);
	}
	
	public static void logSuccess(String message) {
		
		test.log(LogStatus.PASS, message);
	}

	public static void logFailure(String message) {
		
		test.log(LogStatus.FAIL, message);
	}
	
	public static void logInfo(String message) {
		
		test.log(LogStatus.INFO, message);
	}
	
public static void logSkip(String message) {
		
		test.log(LogStatus.SKIP, message);
	}
	
	public static void logWarn(String message) {
		
		test.log(LogStatus.WARNING, message);
	}
}