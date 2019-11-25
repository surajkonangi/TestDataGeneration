package com.atmecs.assesment.qaautomation.testscripts;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.assesment.qaautomation.dataproviders.DataProvides;
import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.JDBConnection;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;
import com.atmecs.assesment.qaautomation.utils.TestBase;
import com.atmecs.assesment.qaautomation.utils.WaitMethods;
import com.atmecs.assesment.qaautomation.validation.HeatClinicProductValidation;

public class HeatClinic extends TestBase {
	PageAction page;
	Readproperties read;
	WaitMethods wait;
	String url;
	LogReports log;
	HeatClinicProductValidation validate;
	JDBConnection database;

	@BeforeClass
	public void beforeTest() throws IOException {
		read = new Readproperties();
		url = read.readPropertiesFile("Url2", ConstantPaths.CONFIG_FILE);
		driver.get(url);
	}

	@Test
	public void addItemToCart() throws Exception {
		read = new Readproperties();
		page = new PageAction(driver);
		wait = new WaitMethods();
		log = new LogReports();
		validate = new HeatClinicProductValidation();
		database = new JDBConnection();

		log.info("STEP#1: validate title of homepage");
		//validate.homePageValidate(driver);
		log.info("STEP#2: navigating to hotsause tab");
		page.click(read.readPropertiesFile("homepage.hotsause.btn", ConstantPaths.heatclinic));
		log.info("STEP#3: validate header of hotsausepage");
		//validate.hotSaucesValidation();
		log.info("STEP#4: navigate to merchandise tab");
		page.click(read.readPropertiesFile("homepage.merchandise.btn", ConstantPaths.heatclinic));
		log.info("STEP#5: validate header of merchandisepage");
		//validate.merchantiseAndClearanceValidation();
		log.info("STEP#6: navigate to clearance tab");
		page.click(read.readPropertiesFile("homepage.clearance.btn", ConstantPaths.heatclinic));
		log.info("STEP#7: validate header of clearancepage");
		//validate.merchantiseAndClearanceValidation();
		log.info("STEP#8: navigate to newtohotsause tab");
		page.click(read.readPropertiesFile("homepage.newtohotsause.btn", ConstantPaths.heatclinic));
		log.info("STEP#9: validate content of newtohotsausepage ");
		//validate.newtohotsauseValidation();
		log.info("STEP#10: mouseover on the merchandise tab");
		page.mouseOn(read.readPropertiesFile("homepage.merchandise.btn", ConstantPaths.heatclinic));
		log.info("STEP#11: navigate to mens page in merchandise dropdown");
		page.click(read.readPropertiesFile("merchandisepage.mens.btn", ConstantPaths.heatclinic));
		log.info("STEP#12: validate header of menspage");
		//validate.merchantiseAndClearanceValidation();
		log.info("STEP#13: select shirt");
		page.click(read.readPropertiesFile("merchandisepage.shirtselect.btn", ConstantPaths.heatclinic));
		log.info("STEP#14: select colour of the shirt");
		page.click(read.readPropertiesFile("merchandisepage.shirtcolour.box", ConstantPaths.heatclinic));
		log.info("STEP#15: select size of the shirt");
		page.click(read.readPropertiesFile("merchandisepage.shirtsize.box", ConstantPaths.heatclinic));
		log.info("STEP#16: enter personalised name");
		String personalizedname=page.getdata_fromExcel("HeatClinic", "Inputdata", "Name on shirt");
		page.sendKeys(read.readPropertiesFile("merchantisepage.personilisedname.box", ConstantPaths.heatclinic),personalizedname);
		log.info("STEP#17: click on buynow button");
		page.click(read.readPropertiesFile("merchantisepage.buynow.btn", ConstantPaths.heatclinic));
		log.info("STEP#18: navigate to viewcart button");
		page.click(read.readPropertiesFile("merchantisepage.viewcart.btn", ConstantPaths.heatclinic));
		log.info("STEP#19: validate item name");
		validate.itemNameValidation();
		log.info("STEP#20: validate size,name.colour of the shirt");
		validate.shirtSizeNameColourValidation();
		log.info("STEP#21: validate price of the shirt");
		validate.priceValidation();
		log.info("STEP#22: clear the value in the quantity box");
		page.clear(read.readPropertiesFile("cartpage.quantity.box", ConstantPaths.heatclinic));
		log.info("STEP#23: enter the reduired value in the quantity box ");
		page.sendKeys(read.readPropertiesFile("cartpage.quantity.box", ConstantPaths.heatclinic),
				database.db("assesment", "heatclinic", "data", 10));
		log.info("STEP#24: click on the update button");
		page.click(read.readPropertiesFile("cartpage.update.btn", ConstantPaths.heatclinic));

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
