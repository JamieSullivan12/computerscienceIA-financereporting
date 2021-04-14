package com.github.financereporting.app;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

public class Config {
	
	private static Property configObj;
	
	
	
	private static String name;
	private static String contractFileNamesME;
	private static String transactionFileNamesME;
	
	
	
	/**
	 * @return the name
	 */
	public static String getName() {
		return name;
	}
	/**
	 * @return the contractFileNamesME
	 */
	public static String getContractFileNamesME() {
		return contractFileNamesME;
	}
	/**
	 * @return the transactionFileNamesME
	 */
	public static String getTransactionFileNamesME() {
		return transactionFileNamesME;
	}
	
	
	
	
	/**
	 * 
	 * @param c_obj		The object from the Property class which contains the Properties object with all the configuration settings
	 */
	public static void readAllConfigContents () throws ExitStatus1Exception{
		
		//Creating a configuration object (where all the configuration settings and methods will be stored
		
		
		Property configObj = new Property();
		//Calling the readConfigFile method which reads the configuration file from the directory below, and saves its contents to the object
		
		String configFileLocation = "src/resources/config.properties";
		configObj.readConfigFile(configFileLocation);
		
		Log.logInfo("Reading data from the " + configFileLocation + " file");
		
		
	
		name = ReadPropertiesMethods.readPropertiesString(configObj, "name", "Funding App", configFileLocation);
		contractFileNamesME = ReadPropertiesMethods.readPropertiesString(configObj, "contractsFileNamesMonthEnd", null, configFileLocation);
		transactionFileNamesME = ReadPropertiesMethods.readPropertiesString(configObj, "transactionFileNamesMonthEnd", null, configFileLocation);
		
	}
	

	
	

}
