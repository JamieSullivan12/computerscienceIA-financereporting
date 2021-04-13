package com.github.financereporting.app;

import java.util.Objects;

public class ExtractConfig {
	
	private static Property configObj;
	
	
	/**
	 * Write certain messages to the logger file
	 * @param key				The name of the key from the configuration file
	 * @param defaultValue		The default value associated with the key from the configuration file
	 */
	private static void writeLoggerDefaultValueWarning(String key, String defaultValue) {
		Log.logger.warning("Configuration file: The '" + key + "' field has been set to the default value of '" + defaultValue + "' because it was previously empty");
	}
	private static void writeLoggerDefaultValueSevere(String key) throws ExitStatus1Exception {
		throw new ExitStatus1Exception("Configuration file: Empty field '" + key + "' MUST have a value. Please enter a value, and then try again");
	}
	private static void writeLoggerSuccessfulRetrievalInfo(String key, String value) {
		Log.logger.info("Configuration file: Successfully retrieved the '" + key + "' field from the configuration file - value: '" + value + "'");

	}
	
	
	
	
	
	/**
	 * 
	 * @param key			The key of the item from the configuration file
	 * @param defaultValue	The default value of that item (if null, then there is no default value, meaning if it doesn't exist in the configuration file, the program will terminate
	 * @return value		the value of the item from the configuration file
	 */
	private static String readConfigString(String key, String defaultValue) throws ExitStatus1Exception{
		String value = null;
		
		/**
		 * temp may either be:
		 * 		'null' - key doesn't exist
		 * 		Empty '' - key does exist but no value
		 * 		Something '###' - key does exist with a value
		 */
		String temp = configObj.getPropertiesValue(key); //Temporary string in which the value fom the configuration file is held
		
		//If there is no value (null or empty)
		if (Objects.isNull(temp) || temp.isEmpty()) {
			
			//If there is a default value, insert it into the file and warn the user
			//If there is no default value, insert the key into the configuration file and abort the program
			if (!Objects.isNull(defaultValue)) {
				configObj.setPropertiesValue(key, defaultValue);
				value = temp;
				writeLoggerDefaultValueWarning(key, defaultValue);
			} else { 
				configObj.setPropertiesValue(key, "");

					writeLoggerDefaultValueSevere(key);
			
			}
			
		} else {
			value = temp;
			writeLoggerSuccessfulRetrievalInfo(key, value);	
		}
		
		return value;
		
	}
	
	
	/**
	 * 
	 * @param c_obj		The object from the Property class which contains the Properties object with all the configuration settings
	 */
	public static void readAllConfigContents (Property c_obj) throws ExitStatus1Exception{
		Log.logger.info("Reading data from the configuration file");
		configObj = c_obj;
		
	
		String name = readConfigString("name", "Funding App");
		String contractFileNamesME = readConfigString("contractsFileNamesMonthEnd", null);
		String transactionFileNamesME = readConfigString("transactionFileNamesMonthEnd", null);
		
	}
	
	

}
