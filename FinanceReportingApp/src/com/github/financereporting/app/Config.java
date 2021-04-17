package com.github.financereporting.app;


import java.util.LinkedHashMap;
import java.util.Set;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

public class Config {
	
	private static Property configObj;
	

	private static LinkedHashMap<String, LinkedHashMap<String, String>> CI;
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
	 * @throws ExitStatus1Exception  	This will terminate the program it could be called for many reasons such as an unexpected error, an incorrect datatype in the configuration file or a non-existing field in the configuration file 
	 */
	private static void getConfigContents() throws ExitStatus1Exception {
		Set<String> keys = CI.keySet();
		for (String key : keys) {
			CI.get(key).put("value", ReadPropertiesMethods.readProperties(configObj, key, CI.get(key).get("defaultValue"), configFileLocation,  Integer.parseInt(CI.get(key).get("dataTypeCode")) ));
		}
	}
	
	
	
	/**
	 * Initiates the process to read files from the configuration file
	 */
	public static void readAllConfigContents () throws ExitStatus1Exception{
		
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
		
	}
	
	
	
	
	//GETTERS
	
	/**
	 * @return the contractsFileNamesMonthEnd
	 */
	public static String[] getContractFileNamesMonthEnd() {
		return CI.get("contractFileNamesMonthEnd").get("value").split(",");
	}
	/**
	 * @return the defaultInputDirectoryFunding
	 */
	public static String getDefaultInputDirectoryFunding() {
		//out.println(CI.get("DefaultInputDirectoryFunding")CI.get("value"));
		return CI.get("DefaultInputDirectoryFunding").get("value");
	}
	/**
	 * @return the name
	 */
	public static String getName() {
		return CI.get("Name").get("value");
	}

	/**
	 * @return the contractFileNamesFunding
	 */
	public static String[] getContractFileNamesFunding() {
		return CI.get("ContractFileNamesFunding").get("value").split(",");
	}
	/**
	 * @return the transactionFileNamesFunding
	 */
	public static String[] getTransactionFileNamesMonthEnd() {
		return CI.get("transactionFileNamesMonthEnd").get("value").split(",");
	}
	
	public static LinkedHashMap<String, LinkedHashMap<String, String>> getHashMap() {
		return CI;
	}
	


	
	

}
