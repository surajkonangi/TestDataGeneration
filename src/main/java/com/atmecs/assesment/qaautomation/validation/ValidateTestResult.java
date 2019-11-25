package com.atmecs.assesment.qaautomation.validation;

import org.testng.Assert;

import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.Readproperties;
import com.atmecs.assesment.qaautomation.utils.TestBase;

public class ValidateTestResult extends TestBase {
	static LogReports log = new LogReports();
	Readproperties read = new Readproperties();

	public static  boolean validateData(String actual,String expected) {
		try {
			/*
			 * 
			 * print actual and expected value
			 * 
			*/
			Assert.assertEquals(actual, expected);
			
			return true;
		} catch (AssertionError assertionError) {
			
			return false;
		}
	}
}
