package com.atmecs.assesment.qaautomation.helper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;

public class PhpTravelsValidate {

	PageAction page;
	LogReports log;
	Readproperties read;
	public WebDriver driver;

	public void phpTravelsHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void performAction(WebDriver driver, String expectedData, String locator) throws Exception {
		page = new PageAction(driver);
		log = new LogReports();
		read = new Readproperties();
		String actualproduct;
		actualproduct = page.getText(read.readPropertiesFile(locator, ConstantPaths.phptravels));
		Assert.assertEquals(actualproduct, expectedData);
		log.info("Successfully validated " + expectedData);
	}
}
