package com.atmecs.assesment.qaautomation.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Configure the log4j file path.
 */
public class LogReports {

	Logger logger = null;

	public LogReports() {
		getlogger();
		logger = Logger.getLogger(LogReports.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(ConstantPaths.LOG4J_FILE);
	}

	public void info(String message) {

		logger.info(message);
	}
}
