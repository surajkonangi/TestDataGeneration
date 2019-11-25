package com.atmecs.assesment.qaautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readproperties {

	public String readPropertiesFile(String elements, String path) throws IOException {

		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(path);
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String data = prop.getProperty(elements);
		return data;

	}

}