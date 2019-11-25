package com.atmecs.assesment.qaautomation.helper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;

public class HeatClinicValidate {

	PageAction page;
	LogReports log;
	Readproperties read;
	public WebDriver driver;

	public void HeatClinicHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void performAction(WebDriver driver, String expectedData, String validationMessage) throws Exception {
		page = new PageAction(driver);
		log = new LogReports();
		read = new Readproperties();
		String actualproduct;
		actualproduct = page.getText(read.readPropertiesFile(validationMessage, ConstantPaths.heatclinic));
		Assert.assertEquals(actualproduct, expectedData);
		log.info("Successfully validated " + expectedData);
		//System.out.println(actualproduct);
		//System.out.println(expectedData);
	}

}
