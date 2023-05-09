package com.interview.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	static private Properties config;
	static {
		try {
			String xpath = "./src/test/resources/test-data/configuration.properties";
			FileInputStream input = new FileInputStream(xpath);
			config = new Properties();
			config.load(input);
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return config.getProperty(key);
	}

}
