package com.github.financereporting.app;

import java.io.FileNotFoundException;
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
	
	private static void writeLoggerNumberSevere(String key, String stringValue, String propertiesFileLocation, boolean isFloat) throws ExitStatus1Exception {
		
		String addon;
		if (isFloat) {
			addon = "number (decimal places allowed)";
		} else {
			addon = "whole number";
		}
		
		throw new ExitStatus1Exception("PROPERTIES NUMBER FIELD ERROR; file location '" + propertiesFileLocation + "'; field name '" + key + "'; message: This field MUST be a " + addon);
	}

	
	/**
	 * 
	 * @param key			The key of the item from the configuration file
	 * @param defaultValue	The default value of that item (if null, then there is no default value, meaning if it doesn't exist in the configuration file, the program will terminate
	 * @return value		the value of the item from the configuration file
	 */
	public static String readProperties(Property propertiesObj, String key, String defaultValue, String propertiesFileLocation, int dataType) throws ExitStatus1Exception{
		String value = null;
		
		/**
		 * temp may either be:
		 * 		'null' - key doesn't exist
		 * 		Empty '' - key does exist but no value
		 * 		Something '###' - key does exist with a value
		 */
		
		String temp = propertiesObj.getPropertiesValue(key); //Temporary string in which the value fom the configuration file is held
		
		try {
			value = temp.trim(); //Remove whitespace
		} catch (Exception e) {
			//DO NOTHING - if this fails, it is not detrimental
		}
		
		
		//If there is no value (null or empty)
		if (Objects.isNull(temp) || temp.isEmpty()) {
			
			if (!Objects.isNull(defaultValue)) {
				//If there is a default value, insert it into the file and warn the user


				propertiesObj.setPropertiesValue(key, defaultValue);
				temp = defaultValue;
				
				//Set the default value in the properties file
				value = temp.trim(); //Insert the value into the return variable. Trim the whitespace
				
				//Log the issue in the log file
				writeLoggerDefaultValueWarning(key, defaultValue, propertiesFileLocation);
				
			} else { 
				//If there is no default value, insert the key into the configuration file and abort the program by throwing an exception

				propertiesObj.setPropertiesValue(key, "");
					writeLoggerDefaultValueSevere(key, value, propertiesFileLocation);
			}
			
		} else {
			
			//If the datatype for this field is 0 (a string), return the value as there is no more checking to do
			if (dataType == 0) {
				//Do nothing - no action to be taken
			} 
			
			//If the datatype for this field is 1 (an integer), check if it can be an integer, then return the string value
			else if (dataType == 1) {
				try {
					Integer.parseInt(value);
				} catch (NumberFormatException e) {
					//Abort the program if there is a conversion error
					writeLoggerNumberSevere(key, value, propertiesFileLocation, false);
				} 
			}
			
			//If the datatype for this field is 2 (a float), check if it can be a float, then return the string value
			else if (dataType == 2) {
				try {
					Float.parseFloat(value);
				} catch (NumberFormatException e) {
					//Abort the program if there is a conversion error
					writeLoggerNumberSevere(key, value, propertiesFileLocation, true);
				}
			}
			
			
			//Success
			writeLoggerSuccessfulRetrievalInfo(key, value, propertiesFileLocation);
			return value;
		}
		
		
		
		return value;
		
	}
	
}
