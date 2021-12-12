package com.siwggy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	static Properties properties = null;
	
	public static void loadProperties() {
		if(properties==null) {
			properties = new Properties();
			String projectDirPath = System.getProperty("user.dir");
			String propFilePath = projectDirPath + "/Project.properties";
			
			InputStream ins;
			try {
				ins = new FileInputStream(propFilePath);
				properties.load(ins);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static String get(String key) {
		loadProperties();
		return properties.getProperty(key);
	}

	
}
