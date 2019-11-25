package com.atmecs.assesment.qaautomation.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static WebDriver driver;
	static ExtentReports extent;

	public static void reportLog(String testname, String Failuremsg) {
		extent = new ExtentReports();

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(ConstantPaths.EXTENT_REPORTFILE);

		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest(testname);
		logger.log(Status.INFO, testname);
		logger.log(Status.PASS, testname);

	}

	@AfterSuite
	public void closeExtent() {
		extent.flush();
	}
}
