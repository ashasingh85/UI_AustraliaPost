package com.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	public static Properties getProperty() {   
		Properties prop = new Properties();
		FileInputStream fs;
		
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\resources\\data.properties");
			prop.load(fs);
		}
		catch(IOException e ){
			
		}
		return prop;
		
	}
	
	public static String getStringValue(String key) {
		return getProperty().getProperty(key);
		
	}

	public static long getIntValue(String time) {
		return Integer.parseInt(getProperty().getProperty(time));
		
	}
	
	
}
