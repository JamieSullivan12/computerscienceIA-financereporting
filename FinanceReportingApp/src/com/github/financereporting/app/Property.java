/**
 * 
 */
package com.github.financereporting.app;
import java.util.Objects;
import java.util.Properties;

import jamiesullivan.packages.exceptions.LimitedAccessException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * 
 * @author jamie
 * Class contains everything to do with reading a properties file and extracting information into the program
 */
public class Property {
	private String propertiesPath;
	private Properties properties;


	
	public static void main(String path) {
		
	}
	
	
	/**
	 * Reads a .properties file from a specified path, and loads it into a Java properties object
	 * If there is no properties file in the destination, one will be created
	 * @param path		the path to the properties file
	 */
	public void readConfigFile(String path) {
		propertiesPath = path;

		//New properties object (java class)
		properties = new Properties();

		//Will try and read the .properties file from the specified path. If it cannot be found, a FileNotFoundException will be handled by creating a new config file
		try {
			FileInputStream configStream = new FileInputStream(propertiesPath);
			
			try {
				properties.load(configStream); 
			} catch (IOException e) {}
	
		} catch (FileNotFoundException e) {
			//If no properties file could be found, create one and report it to the Warning class (which will later notify the user of the issue

			try {
				@SuppressWarnings({ "unused", "resource" })
				OutputStream newConfigStream = new FileOutputStream(path);
			} catch (FileNotFoundException e1) {
			    
				//Attempting to create the directory
				File file = new File(path);
				//Creating the directory
				try {
					file.mkdir();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					Log.logSevere("Attempt to fix fatal configuration file path error failed: " + e2.getLocalizedMessage());
				}
			      
				//If the program cannot make a new output configuration file (for whatever reason), the application will try fixing the issue and will have to quit and throw an error
				Main.endProgramUnsuccessful(3, "Program files have been modified externally. Please restart the program. If this error persists, plese reinstall the application ", e1);
				
			}
		}	
	}
	
	
	
	
	/**
	 * Returns a value from the properties object that this class has been initialized around
	 * @param key		The key to reference in the properties file
	 * @return			The value from the properties file
	 */
	public String getPropertiesValue (String key) {
		String value = null;

		return value;	
	}
	
	
	
	
	
	
	/**
	 * This will change a field in the properties file (It is not called directly from outside, but rather from another method below (setPropertiesValue)
	 * @throws LimitedAccessException		If something goes wrong, exit
	 */
	private void updatePropertiesFile() {
		FileOutputStream out = null;

		try {
			out = new FileOutputStream(propertiesPath);
		} catch (FileNotFoundException e1) {
			Main.endProgramUnsuccessful(3, "UPDATING CONFIGURATION FILENOTFOUND ERROR: There is no configuration file in the path '" + propertiesPath + "'; Please restart the program. If this issue persists, contact your system administrator", e1);
		}

		
		try {
			properties.store(out, null);
		} catch (IOException e) {
			Log.logWarning(e.toString());
		}
		try {
			out.close();
		} catch (IOException e) {
			Log.logWarning(e.toString());
		}
	}
	
	
	
	public void setPropertiesValue (String key, String value) {

		if (value == null) {
			properties.setProperty(key, "");
		} else {
			properties.setProperty(key, value);
		}
		updatePropertiesFile();
		
	}
	
	

	
	/**
	 * Reads an item from a properties object. Will automatically set any warnings or error messages regarding the retrieval of the value
	 * @param key			The key of the item from the configuration file
	 * @param defaultValue	The default value of that item (if null, then there is no default value, meaning if it doesn't exist in the configuration file, the program will terminate

	 * @param propertiesObj a Property object (another class in this package)
	 * @see Property
	 * 
	 * @return value		the value of the item from the configuration file
	 */
	public String readProperties(String key, String defaultValue, String propertiesFileLocation, int dataType) {

		
		//Getting the value from the properties object based on a key given by the user
		String value = null;
		try {
			String temp = properties.getProperty(key); //trim removes whitespace
			try {
				value = temp.trim();
			} catch (Exception e3) {
				value = temp;
			}
			if (Objects.isNull(value)) {
				//If the the key does not exist, create it with an empty value
				properties.setProperty(key, "");
			}
			
		} catch (Exception e) {
			Main.endProgramUnsuccessful(1, "Unknown error occured", e);
		}
		
	
		//If there is no value (null or empty)
		if (Objects.isNull(value) || value.isEmpty()) {
			if (!Objects.isNull(defaultValue)) {
				
				//If there is a default value, insert it into the file and continue as normal
				setPropertiesValue(key, defaultValue);
				
				try {
					value = defaultValue.trim();
				} catch (Exception e) {
					value = defaultValue;
				}		
		}
		
		
		}
		Log.logInfo("Successful retrieval from properties file " + propertiesPath + ": key: '" + key + "'; value: '" + value + "'");

		return value;
	
	}
	
	
	
	
	
}
