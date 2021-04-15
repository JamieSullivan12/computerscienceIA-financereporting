/**
 * 
 */
package com.github.financereporting.app;
import java.util.Objects;
import java.util.Properties;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author jamie
 *
 */
public class Property {
	private String configLocation;
	private Properties properties;


	public static void main() {
		
	}
	
	/**
	 * This method reads the configuration file and saves it in a Java Property object
	 * @throws ConfigFileNotFound 
	 */
	public void readConfigFile(String c_location) throws ExitStatus1Exception {
		//"src/resources/config.properties"
		configLocation = c_location;

		properties = new Properties(); //Properties is a Java class which is used to store elements from a .properties file
		
		
		try {
			
			//This will try to read the properties file, then feed it into the properties object
			FileInputStream configStream = new FileInputStream(configLocation);
			
			
			try {
				properties.load(configStream); 
			
			} catch (IOException e) {
				//DO NOTHING
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			//If no properties file could be found, create one and return an error 
			
			try {
				@SuppressWarnings("unused")
				OutputStream newConfigStream = new FileOutputStream(configLocation);
			} catch (FileNotFoundException e1) {
				throw new ExitStatus1Exception("CONFIGURATION FILENOTFOUND ERROR. Path '" + configLocation + "'. Please restart the program. If the issue persists, contact your system administrator");
			}
			
		}
		
	}
	
	
	public String getPropertiesValue (String key) {
		
		String value = null;
		try {
			value = properties.getProperty(key);
			if (Objects.isNull(value)) {
				properties.setProperty(key, "");
			} else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	private void updatePropertiesFile() throws ExitStatus1Exception{
		FileOutputStream out = null;

		try {
			out = new FileOutputStream(configLocation);
		} catch (FileNotFoundException e1) {
			throw new ExitStatus1Exception("UPDATING CONFIGURATION FILENOTFOUNG ERROR: There is no configuration file in the path '" + configLocation + "'; Please restart the program. If this issue persists, contact your system administrator");
		}

		
		try {
			properties.store(out, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.logWarning(e.toString());
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.logWarning(e.toString());
		}
	}
	
	
	public void setPropertiesValue (String key, String value) throws ExitStatus1Exception {
		properties.setProperty(key, value);
		updatePropertiesFile();
	}
	
	

}
