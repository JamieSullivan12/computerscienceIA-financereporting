package com.github.financereporting.app;

import java.util.Properties;

public class Config {
	
	/**
	 *	Constructor - calls other functions in this file in order to read the config file properly
	 */
	public static void loadConfigObjects() {
		loadConfigurationLog();
		loadOtherConfigObjects();
	}
	
	

	
	
	/**
	 * 
	 * @author jamie
	 *
	 *
	 * This class does many things regarding reading individual fields from the config file
	 */
	public static class ConfigItem {
		/**
		 * fieldInteger, String, Float and Double are variables where the value in the config file may be held (depending on the datatype)
		 */
		private String configKey;
		private String defaultValue;
		private String fieldValue;
		private int fieldInteger;
		private String fieldString;
		private float fieldFloat;
		private double fieldDouble;
		
	
		/**
		 * 
		 * Constructor method
		 * 
		 * @param confKey	The key in the config file
		 * @param severe	The severity if this value does not exist (true means the program quits, false means the program can go on and use a default value (if supplied)
		 * @param d_value	The default value, which is used if there is no value and the severity is false
		 */
		public ConfigItem(String confKey, boolean severe, String d_value) {
			configKey = confKey;
			defaultValue = d_value;
			
			try {
				fieldValue = ReadConfigFile.config.getProperty(configKey);
				if (fieldValue.equals(null)) {
					ReadConfigFile.config.setProperty(configKey, defaultValue);
					
					if (severe) {
						Main.log.logger.severe("Reading configuration file: " + configKey + " does not have a value. This is detrimental to the functionality of the program. Please enter a value in the menu or directly into the configuration file. Program Exit");
						System.exit(0);
					} else {
						Main.log.logger.warning("Reading configuration file: " + configKey + " does not have a value. This may be harmful to the functionality of the program. Please enter a value in the menu or directly configuration file");
						fieldValue = defaultValue;
					}
				}
			} catch (Exception e) {
				Main.log.logger.severe("An unknown error has occured: " + e);
			}
		}

		/**
		 * Sets the value from the config file to an integer
		 */
		public void setInteger() {
			try {
				fieldInteger = Integer.parseInt(fieldValue);
			} catch (NumberFormatException e) {
				Main.log.logger.warning("Reading configuration file: " + configKey + " is not a number (" + fieldValue + ")");
			}
		}
		
		
		/**
		 * GETTERS
		 */
		
		public int getInteger() {
			return fieldInteger;
		}
	}
	
	
	
	

	
	/**
	 * Loads the initial values from the config file which control the log file (these fields need to be done first to ensure the log file works properly)
	 * 
	 * @param logMaxSize	The maximum size the log file may become (in bytes)
	 */
	public static void loadConfigurationLog() {

		ConfigItem maxSizeObj = new ConfigItem("log.maxSize", false, "1000000");
		maxSizeObj.setInteger();
		int logMaxSize = maxSizeObj.getInteger();

	}
	
	

	
	
	public static void loadOtherConfigObjects() {
		//TODO
	}
	
}
