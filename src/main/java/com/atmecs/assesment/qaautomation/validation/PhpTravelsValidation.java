package com.atmecs.assesment.qaautomation.validation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.assesment.qaautomation.helper.PhpTravelsValidate;
import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;

public class PhpTravelsValidation {

	WebDriver driver;
	LogReports log = new LogReports();
	PageAction page;
	Readproperties read;
	PhpTravelsValidate validate;

	public PhpTravelsValidation(WebDriver driver) {
		this.driver = driver;
		page = new PageAction(driver);
		validate = new PhpTravelsValidate();
		read = new Readproperties();

	}

	public void userNameValidate() throws Exception {
		log.info("validating username");
		String expectedUserName = page.getdata_fromExcel("phptravels", "Inputs", "usernamevalidate");
		validate.performAction(driver, expectedUserName, "homepage.username.txt");

	}

	public void bookingTabValidate() throws Exception {
		log.info("validating booking tab");
		String expectedBookingText = page.getdata_fromExcel("phptravels", "Inputs", "bookingtabvalidate");
		validate.performAction(driver, expectedBookingText, "homepage.booking.tab");
	}

public void dateValidate() throws IOException {
		
	log.info("validating date");
		String actualDate = page.getText(read.readPropertiesFile("homepage.date.txt", ConstantPaths.phptravels));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemDate = (dtf.format(now));
		Assert.assertEquals(actualDate, systemDate);
		log.info("sucessfully validated date");
	}
	public void timeValidate() throws IOException {

		log.info("validating time");
		String actualTime = page.getText(read.readPropertiesFile("homepage.time.txt", ConstantPaths.phptravels));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String systemTime = (dtf.format(now));
		Assert.assertEquals(actualTime, systemTime);
		System.out.println("date and time validated");
		log.info("successfully validated time");

	}
	
}
