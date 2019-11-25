package com.atmecs.assesment.qaautomation.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class TestBase extends ExtentReport{

	public WebDriver driver;
	LogReports log = new LogReports();
	public Readproperties read;

	// @Parameters("browsername")
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void invokeBrowser() throws IOException {
		read = new Readproperties();

		String modeofrunning = "browser";
		if (modeofrunning.equalsIgnoreCase("grid")) {
			// driver =SeleniumGrid.getGrid(browsername);
			// System.out.println(driver);
		}

		else {
			String browsername = read.readPropertiesFile("Browser", ConstantPaths.CONFIG_FILE);
			//String browsername=System.getenv("browserName");
			if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
				driver = new ChromeDriver();
				log.info("Chrome browser launched...");

			} else if (browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("Firefox browser launched...");

			} else if (browsername.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
				driver = new InternetExplorerDriver(ieCaps);
				log.info("IE browser started...");
			}
			// driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log.info("Application is open...");
			
			
		}

//      @AfterSuite
//     	public void closeBrowser() {
//     	driver.quit();
//     	}

	}
}