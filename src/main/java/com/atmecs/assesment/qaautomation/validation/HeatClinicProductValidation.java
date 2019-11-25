package com.atmecs.assesment.qaautomation.validation;

import org.openqa.selenium.WebDriver;
import com.atmecs.assesment.qaautomation.helper.HeatClinicValidate;
import com.atmecs.assesment.qaautomation.utils.JDBConnection;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;

public class HeatClinicProductValidation {
    HeatClinicValidate helper;
	LogReports log;
	PageAction page;
	WebDriver driver;
	Readproperties read = new Readproperties();
	JDBConnection database;

	public void homePageValidate(WebDriver driver) throws Exception {
         page=new PageAction(driver);
         helper=new HeatClinicValidate();
         log=new LogReports();
         database=new JDBConnection();
		//String expectedhomepagecontent = values[0];
		String expectedhomepagecontent=database.db("assesment", "heatclinic", "data", 1);
		log.info("validating homepage");
		helper.performAction(driver, expectedhomepagecontent, "homepage.validate.txt");

	}

	public void hotSaucesValidation() throws Exception {

		//String expectedhotsaucescontent = values[1];
		String expectedhotsaucescontent =database.db("assesment", "heatclinic", "data", 2);
		log.info("validating hotsaucespage");
		helper.performAction(driver, expectedhotsaucescontent, "hotsaucepage.product.txt");
	}

	public void merchantiseAndClearanceValidation() throws Exception {

		//String expectedmerchantiseandclearancepage = values[2];
		String expectedmerchantiseandclearancepage=database.db("assesment", "heatclinic", "data", 3);
		log.info("validatinh merchantisepage");
		helper.performAction(driver, expectedmerchantiseandclearancepage, "merchantisepage.heading.txt");

	}

	public void newtohotsauseValidation() throws Exception {

		//String expectednewtohotsausepage = values[3];
		String expectednewtohotsausepage=database.db("assesment", "heatclinic", "data",4);
		log.info("validating newtohotsausepage");
		helper.performAction(driver, expectednewtohotsausepage, "newtohotsause.content.txt");

	}

	public void merchantiseMensPageValidation() throws Exception {

		//String expectedmerchantisemenspage = values[4];
		String expectedmerchantisemenspage=database.db("assesment", "heatclinic", "data", 5);
		log.info("validating merchantisemenspage");
		helper.performAction(driver, expectedmerchantisemenspage, "merchantisepage.mens.txt");
	}

	public void itemNameValidation() throws Exception {

		//String expecteditemname = values[6];
		String expecteditemname=database.db("assesment","heatclinic", "data", 7);
		log.info("validating itemname");
		helper.performAction(driver, expecteditemname, "cartpage.itemname.txt");
	}

	public void shirtSizeNameColourValidation() throws Exception {

		//String expectedshirtdetails = values[7];
		String expectedshirtdetails=database.db("assesment", "hetclinic", "data", 8);
		log.info("validating shirtsize,name,colour");
		helper.performAction(driver, expectedshirtdetails, "cartpage.shirtdetails.txt");

	}

	public void priceValidation() throws Exception {

		//String expectedprice = values[8];
		String expectedprice=database.db("assesment", "hetclinic", "data", 9);
		log.info("validating productprice");
		helper.performAction(driver, expectedprice, "cartpage.price.txt");
	}

}