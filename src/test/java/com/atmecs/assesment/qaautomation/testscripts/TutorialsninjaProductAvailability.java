package com.atmecs.assesment.qaautomation.testscripts;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.assesment.qaautomation.dataproviders.DataProvides;
import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.ExtentReport;
import com.atmecs.assesment.qaautomation.utils.JDBConnection;
import com.atmecs.assesment.qaautomation.utils.LogReports;
import com.atmecs.assesment.qaautomation.utils.PageAction;
import com.atmecs.assesment.qaautomation.utils.Readproperties;
import com.atmecs.assesment.qaautomation.utils.TestBase;
import com.atmecs.assesment.qaautomation.utils.WaitMethods;
import com.atmecs.assesment.qaautomation.validation.TutorilasninjaProductValidation;

public class TutorialsninjaProductAvailability extends TestBase {
	PageAction page;
	WaitMethods wait;
	LogReports log;
	String url;
	TutorilasninjaProductValidation validate;
	JDBConnection database;

	@BeforeClass
	public void beforeTest() throws IOException {
		read = new Readproperties();
		url = read.readPropertiesFile("Url1", ConstantPaths.CONFIG_FILE);
		driver.get(url);
	}

	@Test(dataProvider = "tutorialsninja", dataProviderClass = DataProvides.class)
	public void addItemsTocart(String[] values) throws Exception {
		page = new PageAction(driver);
		read = new Readproperties();
		log = new LogReports();
		validate = new TutorilasninjaProductValidation(driver);
		database = new JDBConnection();

		log.info("STEP#1: validate title of home page");
		validate.homePageValidate(values);
		log.info("STEP#2: enter name of the product");
		page.sendKeys(read.readPropertiesFile("homepage.search.box", ConstantPaths.tutorialsninja), values[1]);
		log.info("STEP#3: click on search button");
		page.click(read.readPropertiesFile("homepage.search.btn", ConstantPaths.tutorialsninja));
		log.info("STEP#4: navigate to product page");
		page.click(read.readPropertiesFile("productpage.product.img", ConstantPaths.tutorialsninja));
		log.info("STEP#5: click on the quantity box");
		page.click(read.readPropertiesFile("productpage.quantity.box", ConstantPaths.tutorialsninja));
		log.info("STEP#6: clear the value in quantity box");
		page.clear(read.readPropertiesFile("productpage.quantity.box", ConstantPaths.tutorialsninja));
		log.info("STEP#7: enter the quantity required");
		page.sendKeys(read.readPropertiesFile("productpage.quantity.box", ConstantPaths.tutorialsninja), values[2]);
		log.info("STEP#8: validate price of the product");
		validate.priceValidation(values);
		log.info("STEP#9: validate extax of product");
		validate.exTaxValidation(values);
		log.info("STEP#10: validate discription of product");
		validate.productDecriptionValidation(values);
		log.info("STEP#11: validate availability of product");
		validate.productaVailability(values);
		log.info("STEP#12: click on addtocart button");
		page.click(read.readPropertiesFile("productpage.addtocart.btn", ConstantPaths.tutorialsninja));
		log.info("STEP#13: click on homepage title");
		page.click(read.readPropertiesFile("homepage.title.txt", ConstantPaths.tutorialsninja));
		log.info("STEP#14: click on viewcart button");
		page.click(read.readPropertiesFile("productpage.viewkart.btn", ConstantPaths.tutorialsninja));
		log.info("STEP#15: validate ");
		validate.cartValidation(values);
		log.info("STEP#16 navigate to cartpage");
		page.click(read.readPropertiesFile("productpage.viewcartpage.btn", ConstantPaths.tutorialsninja));
		log.info("STEP#17: clear the values in quantity box");
		page.clear(read.readPropertiesFile("cartpage.productquantity.box", ConstantPaths.tutorialsninja));
		log.info("STEP#18: enter the quantiry required");
		page.sendKeys(read.readPropertiesFile("cartpage.productquantity.box", ConstantPaths.tutorialsninja), values[6]);
		log.info("STEP#19: click on update button");
		page.click(read.readPropertiesFile("cartpage.update.btn", ConstantPaths.tutorialsninja));
		log.info("STEP#20: validte the grand total");
		//validate.grandTotalValidation(values);
		ExtentReport.reportLog("addItemsTocart", "failed");

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
