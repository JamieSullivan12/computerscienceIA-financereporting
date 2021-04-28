package com.github.financereporting.app;


import java.util.LinkedHashMap;
import java.util.Set;



public class Config {
	
	private static Property configObj;
	

	private static LinkedHashMap<String, LinkedHashMap<String, String>> CI;
	private static LinkedHashMap<String, LinkedHashMap<String, String>> CI_STATIC;
	private static String configFileLocation;
	
	


	
	/**
	 * Method is used to populate the LinkedHashMap (CI = the LinkedHashMap) with a few values:
	 * @param key				The name of the property from the configuration file (this is also used as the key for the linkedhashMap
	 * @param defaultValue		The default value (null if there is no default value)
	 * @param dataTypeCode		The data type code:	0=String, 1=int, 2=float
	 * 
	 * NOTE: The linkedHashMap has this structure: String(key): Another LinkedHashMap (the value for the first key) with defaultValue, dataTypeCode, value 
	 */
	private static void updateConfigItems(String key, String defaultValue, String dataTypeCode) {
		LinkedHashMap<String, String> configItem = new  LinkedHashMap<String, String>();
		configItem.put("defaultValue", defaultValue);
		configItem.put("dataTypeCode", dataTypeCode);
		configItem.put("value", "");
		CI.put(key, configItem);
	}
	
	/**
	 * Method uses the LinkedHashMap to call a method from another class which interacts directly with the configuration file
	 * NOTE: CI is the LinkedHashMap
	 * @throws LimitedAccessException  	This will terminate the program it could be called for many reasons such as an unexpected error, an incorrect datatype in the configuration file or a non-existing field in the configuration file 
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
		updateConfigItems("DefaultInputDirectoryFunding", null, "0");
		updateConfigItems("ContractFileNamesFunding", null, "0");
		updateConfigItems("TransactionFileNamesMonthEnd", "", "0");
		updateConfigItems("ContractFileNamesMonthEnd", "", "0");
		
		//Uses the LinkedHashMap from above and populates the value section using the Properties class
		getConfigContents();
		
		CI_STATIC = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		
	}
	
	
	
	
	//GETTERS
	
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
	 * @param key
	 * @param newValue
	 * @warning This will not save the changes, but rather save them to memory. The changes must be pushed to the configuration file through a different method
	 */
	public static void changeConfigField(String key, String newValue) {
		CI.get(key).put("newValue", newValue);
	}
	
	
	public static String getUnsavedChanges() {
		String returnString = "";
		
		//Used to loop through the map (creates a list of keys as a set object)
		Set<String> keys = CI.keySet();
		
		System.out.println("Y");
		int i = 0;
		for (String key : keys) {
			System.out.println(key);
			System.out.println(CI.get(key).get("value").equals(CI.get(key).get("newValue")));
			if (!CI.get(key).get("value").equals(CI.get(key).get("newValue"))) { 
				System.out.println("H");
				System.out.println(key + "\t...\t" + CI.get(key).get("newValue"));
				returnString += key + "\t...\t" + CI.get(key).get("newValue").toString();
				i += 1;
			}
		System.out.println(returnString);
		return returnString;
			
		}
				

		
		
		readAllConfigContents();
		
		return returnString;
	}
	


	
	

}
