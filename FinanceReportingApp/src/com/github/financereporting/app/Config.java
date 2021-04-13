package com.github.financereporting.app;

import java.util.Objects;
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
		private boolean fieldBool;
		
	
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
			Main.log.logger.info("Reading " + configKey + " from the configuration file");

			try {
				fieldValue = ReadConfigFile.config.getProperty(configKey);
				if (Objects.isNull(fieldValue)) {
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
		 * @throws Exception 
		 */
		public void setInteger(boolean minValueIdentifier, int minValue, boolean maxValueIdentifier, int maxValue) throws Exception {
			try {
				fieldInteger = Integer.parseInt(fieldValue);
				Main.log.logger.info("Successfully read " + configKey + " from the configuration file");
			} catch (NumberFormatException e) {
				Main.log.logger.warning("Reading configuration file: " + configKey + " is not a number (" + fieldValue + ")");
			}
			
			if (Objects.isNull(fieldInteger)) {
				throw new Exception("EmptyVariableException");
			} else {
				if (minValueIdentifier && !Objects.isNull(minValue)) {
					if (fieldInteger < minValue) {
						Main.log.logger.warning("ConfigurationFileError: " + configKey + " is below the recommended value, and may be detrimental to the program. Currently: " + fieldInteger + "; Recommended minimum: " + minValue);
					}
				} else if (maxValueIdentifier && !Objects.isNull(maxValue)) {
					if (fieldInteger > maxValue) {
						Main.log.logger.warning("ConfigurationFileError: " + configKey + " is above the reccomended value, and may be detrimental to the program. Currently: " + fieldInteger + "; Recommended maximum: \" + minValue");
					}
				}
			}
		}
		
		
		/**
		 * Sets the value from the config file to a string
		 */
		public void setString() {
			
			fieldString = fieldValue;
			Main.log.logger.info("Successfully read " + configKey + " from the configuration file");

		}
		
		
		public void setBoolean() {
			
			fieldBool = Boolean.parseBoolean(fieldValue);
			Main.log.logger.info("Successfully read " + configKey + " from the configuration file");

		}
		
		
		/**
		 * GETTERS
		 * @throws Exception 
		 */
		
		public int getInteger() throws Exception {

			if (Objects.isNull(fieldInteger)) {
				throw new Exception("EmptyVariableException");
			} else {
				return fieldInteger;
			}
		}
		
		public String getString() throws Exception {
			if (Objects.isNull(fieldString)) {
				throw new Exception("EmptyVariableException");
			}
			return fieldString;
		}
		
		public boolean getBoolean() throws Exception {
			if (Objects.isNull(fieldBool)) {
				throw new Exception("EmptyVariableException");
			}
			return fieldBool;
		}
		
	}
	
	
	private static int logLimit = 1000000;
	private static int logCount = 1;
	private static boolean logAppend = true;
	private static String logLevel = "ALL";

	
	/**
	 * @return the logLimit
	 */
	public static int getLogLimit() {
		return logLimit;
	}





	/**
	 * @return the logCount
	 */
	public static int getLogCount() {
		return logCount;
	}





	/**
	 * @return the logAppend
	 */
	public static boolean isLogAppend() {
		return logAppend;
	}





	/**
	 * @return the logLevel
	 */
	public static String getLogLevel() {
		return logLevel;
	}





	/**
	 * Loads the initial values from the config file which control the log file (these fields need to be done first to ensure the log file works properly)
	 * 
	 * @param logMaxSize	The maximum size the log file may become (in bytes)
	 */
	public static void loadConfigurationLog() {
		
		
		
		
		ConfigItem limitObj = new ConfigItem("log.limit", false, "1000000");
		try {
			limitObj.setInteger(true, 100000, false, 0);
			logLimit = limitObj.getInteger();
		} catch (Exception e1) {
		}
		
		ConfigItem countObj = new ConfigItem("log.count", false, "1");
		try {
			countObj.setInteger(true, 1, true, 10);
			logCount = countObj.getInteger();
		} catch (Exception e1) {
		}
		
		ConfigItem appendObj = new ConfigItem("log.append", false, "false");
		try {
			countObj.setInteger(true, 1, true, 10);
			logCount = countObj.getInteger();
		} catch (Exception e1) {
		}

		
		
		


	}
	
	

	
	
	public static void loadOtherConfigObjects() {
		//TODO
	}
	
}
