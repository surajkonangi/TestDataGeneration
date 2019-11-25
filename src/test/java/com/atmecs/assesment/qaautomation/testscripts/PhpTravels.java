package com.atmecs.assesment.qaautomation.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;
import com.atmecs.assesment.qaautomation.utils.TestBase;
import com.atmecs.assesment.qaautomation.utils.WaitMethods;
import com.atmecs.assesment.qaautomation.validation.PhpTravelsValidation;

public class PhpTravels extends TestBase {

	PageAction page;
	WaitMethods wait;
	LogReports log;
	String url;
	PhpTravelsValidation validate;

	@BeforeClass
	public void beforeTest() throws IOException {
		read = new Readproperties();
		url = read.readPropertiesFile("Url3", ConstantPaths.CONFIG_FILE);
		driver.get(url);
	}

	@Test
	public void invoiceVerification() throws Exception {
		page = new PageAction(driver);
		read = new Readproperties();
		log = new LogReports();
		validate = new PhpTravelsValidation(driver);

		log.info("STEP#1: entering username");
		String username = page.getdata_fromExcel("phptravels", "Inputs", "username");
		page.sendKeys(read.readPropertiesFile("loginpage.username.box", ConstantPaths.phptravels), username);
		log.info("STEP#2: entering password");
		String password = page.getdata_fromExcel("phptravels", "Inputs", "password");
		page.sendKeys(read.readPropertiesFile("loginpage.password.box", ConstantPaths.phptravels), password);
		log.info("STEP#3: click on login button");
		page.click(read.readPropertiesFile("loginpage.login.btn", ConstantPaths.phptravels));
		log.info("STEP#4: username validation");
		validate.userNameValidate();
		log.info("STEP#5: bookingtab validation");
		validate.bookingTabValidate();
		validate.dateValidate();
		validate.timeValidate();

	}
}
