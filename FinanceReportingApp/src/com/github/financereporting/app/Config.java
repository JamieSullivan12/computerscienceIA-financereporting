package com.github.financereporting.app;


import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;



public class Config {
	
	private static Property configObj;
	private static LinkedHashMap<String, LinkedHashMap<String, String>> CI;
	private static String configFileLocation;
	
	
	
	/**
	 * Method is used to populate the configuration item with each configuration field. These are then populated later:
	 * @param key				The name of the property from the configuration file (this is also used as the key for the linkedhashMap
	 * @param defaultValue		The default value (null if there is no default value)
	 * @param dataTypeCode		The data type code:	0=String, 1=int, 2=decimal number
	 * 
	 * NOTE: The linkedHashMap has this structure: String(key): Another LinkedHashMap (the value for the first key) with defaultValue, dataTypeCode, value 
	 */
	private static void updateConfigItems(String key, String defaultValue, String dataTypeCode) {
		LinkedHashMap<String, String> configItem = new  LinkedHashMap<String, String>();
		configItem.put("defaultValue", defaultValue);
		configItem.put("dataTypeCode", dataTypeCode);
		configItem.put("value", "");
		configItem.put("warningFlag", "false");
		CI.put(key, configItem);
	}
	
	/**
	 * Method uses the LinkedHashMap to call a method from another class which interacts directly with the configuration file
	 * NOTE: CI is the LinkedHashMap
	 */
	private static void getConfigContents() {
		Set<String> keys = CI.keySet();
		for (String key : keys) {
			CI.get(key).put("value", configObj.readProperties(key, CI.get(key).get("defaultValue"), configFileLocation,  Integer.parseInt(CI.get(key).get("dataTypeCode")) ));
		}
	}
	
	
	
	/**
	 * Initiates the process to read files from the configuration file
	 */
	public static void readAllConfigContents () {
		
		//Creating a configuration object (where all the configuration settings and methods will be stored
		configObj = new Property();
		
		
		//Calling the readConfigFile method which reads the configuration file from the directory below, and saves its contents to the object
		configFileLocation = "src/resources/config.properties";
		configObj.readConfigFile(configFileLocation);
		
		Log.logInfo("Reading data from the " + configFileLocation + " file");
		
		//CI means ConfigItems
		CI = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		
		
		//This creates a LinkedHashMap (similair to a dictionary in python) of keys from the configuration file, with the values containing information such as the default value, actual value (which is populated later) and the datatype
		updateConfigItems("Name", "Funding App", "0");
		updateConfigItems("DefaultInputDirectoryFunding", "", "0");
		updateConfigItems("ContractFileNamesFunding", "", "0");
		updateConfigItems("TransactionFileNamesMonthEnd", "", "0");
		updateConfigItems("ContractFileNamesMonthEnd", "", "0");
		
		
		//Uses the LinkedHashMap from above and populates the value section using the Properties class
		getConfigContents();
		checkConfigValidity();
		
	}
	
	
	
	

	
	
	
	
	
	/**
	 * @return the contractsFileNamesMonthEnd as a String Array. Will return null if empty
	 */
	public static String[] getContractFileNamesMonthEnd() {
		String returnValue = CI.get("contractFileNamesMonthEnd").get("value");
		
		try {
			return returnValue.split(",");
		} catch (Exception e) {
			return null;
		}		
	}
	
	/**
	 * @return the defaultInputDirectoryFunding
	 */
	public static String getDefaultInputDirectoryFunding() {
		return CI.get("DefaultInputDirectoryFunding").get("value");
	}
	
	/**
	 * @return the name
	 */
	public static String getName() {
		return CI.get("Name").get("value");
	}

	/**
	 * @return the contractFileNamesFunding as a String Array. Will return null if empty
	 */
	
	public static String[] getContractFileNamesFunding() {
		String returnValue = CI.get("ContractFileNamesFunding").get("value");
		
		try {
			return returnValue.split(",");
		} catch (Exception e) {
			return null;
		}
		 
	}
	
	/**
	 * @return the transactionFileNamesFunding as a String Array. Will return null if empty
	 */
	public static String[] getTransactionFileNamesMonthEnd() {
		String returnValue = CI.get("transactionFileNamesMonthEnd").get("value");
		
		try {
			return returnValue.split(",");
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	/**
	 * Returns the hashed map which contains all the fields of a config file plus additional information such as: Name, Value, Default Value and Data Type
	 * To access an item, use hashMap.get("Name of key in quotes").get("Name of value item - eg. value, defaultValue, dataTypeCode")
	 * @return LinkedHashMap<String, LinkedHashMap<String, String>> 
	 */
	public static LinkedHashMap<String, LinkedHashMap<String, String>> getHashMap() {
		return CI;
	}
	
	
	/**
	 * Updates a configuration key with a new value. 
	 * 
	 * @param key	the key of the field needing to be changed
	 * @param newValue	The new value of that field
	 * @warning This will not save the changes, but rather save them to memory. The changes must be pushed to the configuration file through a different method
	 * 
	 * @see saveChanges()
	 */
	public static void changeConfigField(String key, String newValue) {
		Log.logInfo("Changing config field: " + key + ". New value: " + newValue);
		CI.get(key).put("newValue", newValue);
		

	}
	
	
	
	/**
	 * Returns a list of unsaved changes in the configuration file
	 * 
	 * @return a string with each unsaved change on a new line
	 */
	public static String getUnsavedChanges() throws Exception {
		String returnString = "";
		
		//Used to loop through the configuration items
		Set<String> keys = CI.keySet();
		for (String key : keys) {
			//If there is a value in the newValue section (a field which when populated, means the field has been updated) which is different from the old value, then note the disrepency (which means a change has been made)
			if (!CI.get(key).get("value").equals(CI.get(key).get("newValue")) && CI.get(key).get("newValue") != null) { 
				returnString += key + "\t...\t" + CI.get(key).get("newValue").toString() + "\n";
			}
		}
		Log.logInfo("Unsaved configuration changes (if nothing, then empty): " + returnString);

		return returnString;
	}
	
	
	
	/**
	 * Saves any unsaved changes in the configuration object. These changes will have been made using the changeConfigField() method
	 * 
	 * @see changeConfigField
	 */
	public static void saveChanges() {
		//Loop through each of the configuration fields
		Set<String> keys = CI.keySet();
		for (String key : keys) {
			//If there is a value in the newValue section (a field which when populated, means the field has been updated), then save the change
			if (!CI.get(key).get("value").equals(CI.get(key).get("newValue")) && CI.get(key).get("newValue") != null) { 
				
				Log.logInfo("Saving configuration changes: " + key + ". Old value: " + CI.get(key).get("value") + ". New value: " + CI.get(key).get("newValue"));

				CI.get(key).put("value", CI.get(key).get("newValue") );
				configObj.setPropertiesValue(key, CI.get(key).get("newValue"));
				
				Log.logInfo("Successfully saved change for " + key);

			}
		}
		checkConfigValidity();	//Checks the new fields are valid
	}
	
	
	
	/**
	 * Resets all fields in the configuration file to their default values. 
	 * 
	 * It will also complete validity checks and call on methods to update the warnings after the reset has occured
	 */
	public static void resetDefault() {
		Log.logInfo("RESETTING TO DEFAULT CONFIGURATION SETTINGS");

		//Used to loop through each of the fields
		Set<String> keys = CI.keySet();
		for (String key : keys) {
			//Set the value of that field to the default value
			configObj.setPropertiesValue(key, CI.get(key).get("defaultValue"));
			Log.logInfo("Reset " + key + ", to: " + CI.get(key).get("defaultValue"));
		}
		//Because it is such a large scale change, the readAllConfigContents method is read to ensure all parallel arrays are up to date, and all validity checks have been done properly
		readAllConfigContents();
			
	}
	

	
	
	
	/**
	 * Checks if there are any fields in the configuration file that are empty but are not allowed to be (using the default values).
	 * If the default value for a field is null, that means it MUST be filled by the user.
	 * If the default value for a field is an empty string, that means it is allowed to be empty.
	 */
	private static void checkConfigValidity() {
		Set<String> keys = CI.keySet();
		
		
		Warning.resetAttentionRequiredMessage(); //will reset the warning message (removes any warning messages which have been fixed and prepares the attribute of the class to be filled with new warning messages)
		//Loop through each configuration item
		for (String key : keys) {
			String warningMessage = ""; //Any warning messages will be added to this streng, then will be sent to the Warning class later
			String value = CI.get(key).get("value"); //Variable is used a lot in this piece of code so better to pre-define it
			
			//If the field is empty and the default value is null, this means it MUST have a user defined field
			if (Objects.isNull(value) || value.isEmpty() && Objects.isNull(CI.get(key).get("defaultValue"))) {
				warningMessage += "WARNING: Update your configuration preferences: " + key + " does not have a value or a default value";	
				
			} else {

				//If the datatype for this field is 1 (an integer), check if it can be an integer and act accordingly
				if (Integer.parseInt(CI.get(key).get("dataTypeCode")) == 1) {
					try { Integer.parseInt(value); //Try converting to an integer and potentially catch an error
					} catch (NumberFormatException e) {
						warningMessage += "WARNING: Update your configuration preferences: " + key + " must be a number (without decimal places)";
					} 
				}
				
				//If the datatype for this field is 2 (a float), check if it can be a float and act accordingly
				else if (Integer.parseInt(CI.get(key).get("dataTypeCode")) == 2) {
					try { Float.parseFloat(value); //Try converting to a float and potentially catch an error
					} catch (NumberFormatException e) {
						warningMessage += "WARNING: Update your configuration preferences: " + key + " must be a number";
					}
				}
			}
			
			//Write the message to the warning class (if there is a warning) and flag the configuration field which has the issue
			if (!warningMessage.isBlank()) {
				Warning.addAttentionRequiredMessage(warningMessage);
				CI.get(key).put("warningFlag", "true");
			} else {
				CI.get(key).put("warningFlag", "false");
			}
		}
	} 
	
	

}
