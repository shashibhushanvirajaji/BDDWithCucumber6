package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;
	
	// this method return properties 
	public Properties initializeProperties() {
		properties = new Properties();
		try {
			FileInputStream fip = new FileInputStream("./src/test/resources/configuration/configurations.properties");
			properties.load(fip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

}
