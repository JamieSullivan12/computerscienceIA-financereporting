package com.github.financereporting.app;

import java.util.Objects;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;



public class ReadPropertiesMethods {
	
	/**
	 * Write certain messages to the logger file
	 * @param key				The name of the key from the configuration file
	 * @param defaultValue		The default value associated with the key from the configuration file
	 */
	private static void writeLoggerDefaultValueWarning(String key, String defaultValue, String propertiesFileLocation) {
		Log.logWarning("PROPERTIES EMPTY FIELD WARNING; file location '" + propertiesFileLocation + "'; field name '" + key + "' message: This field has been set to the default value of '" + defaultValue + "'. While this is not detrimental to the program, it is recommended you configure the program to your own requirements");
	}
	private static void writeLoggerDefaultValueSevere(String key, String value, String propertiesFileLocation) throws ExitStatus1Exception {
		//Throw an exception which is handled in the main class
		//This exception will cause the program to exit (code 1) and will print the message below to the log:
		throw new ExitStatus1Exception("PROPERTIES EMPTY FIELD ERROR; file location '" + propertiesFileLocation + "'; field name '" + key + "'; message: This field MUST not be empty");
	}
	private static void writeLoggerSuccessfulRetrievalInfo(String key, String value, String propertiesFileLocation) {
		Log.logInfo(propertiesFileLocation + ": Successfully retrieved '" + key + "' field from the '" + propertiesFileLocation + "' file; '" + value + "'");

	}
	
	private static void writeLoggerIntSevere(String key, String stringValue, String propertiesFileLocation) throws ExitStatus1Exception {
		throw new ExitStatus1Exception("PROPERTIES NUMBER FIELD ERROR; file location '" + propertiesFileLocation + "'; field name '" + key + "'; message: This field MUST be a number");
	}

	
	/**
	 * 
	 * @param key			The key of the item from the configuration file
	 * @param defaultValue	The default value of that item (if null, then there is no default value, meaning if it doesn't exist in the configuration file, the program will terminate
	 * @return value		the value of the item from the configuration file
	 */
	public static String readPropertiesString(Property propertiesObj, String key, String defaultValue, String propertiesFileLocation) throws ExitStatus1Exception{
		String value = null;
		
		/**
		 * temp may either be:
		 * 		'null' - key doesn't exist
		 * 		Empty '' - key does exist but no value
		 * 		Something '###' - key does exist with a value
		 */
		String temp = propertiesObj.getPropertiesValue(key); //Temporary string in which the value fom the configuration file is held
		value = temp;
		
		//If there is no value (null or empty)
		if (Objects.isNull(temp) || temp.isEmpty()) {
			
			if (!Objects.isNull(defaultValue)) {
				//If there is a default value, insert it into the file and warn the user

				propertiesObj.setPropertiesValue(key, defaultValue); //Set the default value in the properties file
				value = temp; //Insert the value into the return variable
				
				//Log the issue in the log file
				writeLoggerDefaultValueWarning(key, defaultValue, propertiesFileLocation);
				
			} else { 
				//If there is no default value, insert the key into the configuration file and abort the program by throwing an exception

				propertiesObj.setPropertiesValue(key, "");
					writeLoggerDefaultValueSevere(key, value, propertiesFileLocation);
			}
			
		} else {
			//Success
			writeLoggerSuccessfulRetrievalInfo(key, value, propertiesFileLocation);	
		}
		
		return value;
		
	}
	
	public static int readPropertiesInteger(Property propertiesObj, String key, String defaultValue, String propertiesFileLocation) throws ExitStatus1Exception {
		
		@SuppressWarnings("null")
		int value = 0;
		
		/**
		 * temp may either be:
		 * 		'null' - key doesn't exist
		 * 		Empty '' - key does exist but no value
		 * 		Something '###' - key does exist with a value
		 */
		String stringValue = propertiesObj.getPropertiesValue(key); //Temporary string in which the value fom the configuration file is held
		boolean intError = false;
		
		//Converting string to integer
		try {
			value = Integer.parseInt(stringValue);
		} catch (NumberFormatException e) {
			//If conversion is not possible, flag
			intError = true;
		}
		
		
		//If there is no value from the field in the properties file (null or empty)
		if (Objects.isNull(stringValue) || stringValue.isEmpty()) {
			
			
			//If there is a default value, insert it into the file and warn the user
			
			if (!Objects.isNull(defaultValue)) {
				
				propertiesObj.setPropertiesValue(key, defaultValue);
				writeLoggerDefaultValueWarning(key, defaultValue, propertiesFileLocation);
				
				
				//Convert the default value to an int (it should never throw an error but the catch is there just in case)
				try {
					value = Integer.parseInt(defaultValue);
				} catch (NumberFormatException e) {
					//Abort the program if there is a conversion error
					writeLoggerIntSevere(key, stringValue, propertiesFileLocation);
				}
				
				
			} else {
				//If there is no default value, insert the key into the configuration file (without a value) and abort the program by throwing an error
				
				propertiesObj.setPropertiesValue(key, "");
				writeLoggerDefaultValueSevere(key, stringValue, propertiesFileLocation);
			}
			
		} else if (intError) {
			//Abort the program if there is a conversion error
			writeLoggerIntSevere(key, stringValue, propertiesFileLocation);
		} else {
			//Success
			writeLoggerSuccessfulRetrievalInfo(key, stringValue, propertiesFileLocation);	
		}
		
		return value;
		
		
	}
}
