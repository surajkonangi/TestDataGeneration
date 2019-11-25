package com.atmecs.assesment.qaautomation.utils;

import java.io.File;

public class ConstantPaths {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String tutorialsninja = USER_HOME + File.separator + "resources" + File.separator + "locators"
			+ File.separator + "tutorialsninja.properties";
	
	public final static String phptravels = USER_HOME + File.separator + "resources" + File.separator + "locators"
			+ File.separator + "phptravels.properties";

	public final static String heatclinic = USER_HOME + File.separator + "resources" + File.separator + "locators"
			+ File.separator + "heatclinic.properties";

	public final static String CONFIG_FILE = USER_HOME + File.separator + "resources" + File.separator + "config"
			+ File.separator + "config.properties";

	public final static String TESTDATA_FILE = USER_HOME + File.separator + "resources" + File.separator + "testdata"
			+ File.separator + "test.xlsx";
	public final static String TESTDATA_FILE1 = USER_HOME + File.separator + "resources" + File.separator + "testdata"
			+ File.separator + "test2.xlsx";
	public final static String LOG4J_FILE = USER_HOME + File.separator + "resources" + File.separator + "log4j"
			+ File.separator + "log4j.properties";

	public final static String CHROME_FILE = USER_HOME + "lib" + File.separator + "chromedriver.exe";

	public final static String FIREFOX_FILE = USER_HOME + "lib" + File.separator + "geckodriver.exe";

	public final static String IE_FILE = USER_HOME + "lib" + File.separator + "IEDriverServer.exe";

	public static final String EXTENT_REPORTFILE = "extentreport.html";

}
