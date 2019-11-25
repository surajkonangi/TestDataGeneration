package com.atmecs.assesment.qaautomation.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	private static DesiredCapabilities getBrowserCapabilities(String browserType) {
		switch (browserType) {

		case "firefox":
			DesiredCapabilities descapability = new DesiredCapabilities();
			descapability.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			return descapability;

		case "chrome":
			descapability = new DesiredCapabilities();
			descapability.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			return descapability;

		default:
			descapability = new DesiredCapabilities();
			descapability.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
			return descapability;

		}
	}

	public static RemoteWebDriver getGrid(String browser) throws MalformedURLException {
		System.out.println("grid is running");
		return new RemoteWebDriver(new URL("http://55.55.54.73:2000/wd/hub"), getBrowserCapabilities(browser));
	}
}
