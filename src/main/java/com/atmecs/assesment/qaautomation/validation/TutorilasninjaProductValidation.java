package com.atmecs.assesment.qaautomation.validation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.assesment.qaautomation.helper.TutorialsNinjaValidate;
import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.JDBConnection;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;

public class TutorilasninjaProductValidation {
	WebDriver driver;
	LogReports log = new LogReports();
	PageAction page;
	Readproperties read;
	TutorialsNinjaValidate validate;
	JDBConnection database;

	public TutorilasninjaProductValidation(WebDriver driver) {
		this.driver = driver;
		page = new PageAction(driver);
		validate = new TutorialsNinjaValidate();
		read =new Readproperties();
		database = new JDBConnection();

	}

	public void homePageValidate(String[] values) throws Exception {

		String expectedhomepagetitle = values[0];
		//String expectedhomepagetitle=database.db("assessment", "ninjastore", "data", 1);
		log.info("validating homepage");
		validate.performAction(driver, expectedhomepagetitle, "homepage.title.txt");
	}

	public void priceValidation(String[] values) throws Exception {

		String expectedproductprice = values[3];
		log.info("validating product price ");
		validate.performAction(driver, expectedproductprice, "productpage.price.txt");
	}

	public void exTaxValidation(String[] values) throws Exception {

		String ExpectedProductExTax = values[7];
		log.info("validating product extax ");
		validate.performAction(driver, ExpectedProductExTax, "productpage.extax.txt");
	}

	public void productDecriptionValidation(String[] values) throws Exception {
         String actualproductdescript;
		String expectedproductdescript = values[4];
		actualproductdescript=page.getText(read.readPropertiesFile("productpage.description.txt", ConstantPaths.tutorialsninja));
		Assert.assertTrue(actualproductdescript.contains(expectedproductdescript));
	}

	public void cartValidation(String[] values) throws Exception {

		String expectedcartdetails = values[5];
		log.info("validating cartdetails");
		validate.performAction(driver, expectedcartdetails, "productpage.viewkart.btn");
	}

	public void grandTotalValidation(String[] values) throws Exception {

		String ExpectedGrandTotal = values[8];
		log.info("validating grandtotal");
		validate.performAction(driver, ExpectedGrandTotal, "cartpage.grandtotal.txt");

	}

	public void productaVailability(String[] values) throws Exception {

		String ExpectedProductAvailability = values[9];
		log.info("validating productavailability");
		validate.performAction(driver, ExpectedProductAvailability, "productpage.availability.txt");
	}

}
