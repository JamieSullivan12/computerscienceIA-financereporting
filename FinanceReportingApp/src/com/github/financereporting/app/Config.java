package com.github.financereporting.app;

import java.util.Arrays;
import java.util.List;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

public class Config {
	
	private static Property configObj;
	

	private static String name;
	private static List<String> contractFileNamesFunding;
	private static List<String> transactionFileNamesMonthEnd;
	private static List<String> contractFileNamesMonthEnd;
	private static String defaultInputDirectoryFunding;
	
	
	/**
	 * @return the contractsFileNamesMonthEnd
	 */
	public static List<String> getContractFileNamesMonthEnd() {
		return contractFileNamesMonthEnd;
	}
	/**
	 * @return the defaultInputDirectoryFunding
	 */
	public static String getDefaultInputDirectoryFunding() {
		return defaultInputDirectoryFunding;
	}
	/**
	 * @return the name
	 */
	public static String getName() {
		return name;
	}

	/**
	 * @return the contractFileNamesFunding
	 */
	public static List<String> getContractFileNamesFunding() {
		return contractFileNamesFunding;
	}
	/**
	 * @return the transactionFileNamesFunding
	 */
	public static List<String> getTransactionFileNamesMonthEnd() {
		return transactionFileNamesMonthEnd;
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
		
		
	
		name = ReadPropertiesMethods.readPropertiesString(configObj, "Name", "Funding App", configFileLocation);
		defaultInputDirectoryFunding = ReadPropertiesMethods.readPropertiesString(configObj, "DefaultInputDirectoryFunding", null, configFileLocation);
		contractFileNamesFunding = Arrays.asList(ReadPropertiesMethods.readPropertiesString(configObj, "ContractFileNamesFunding", null, configFileLocation).split(",")); 
		transactionFileNamesMonthEnd = Arrays.asList(ReadPropertiesMethods.readPropertiesString(configObj, "TransactionFileNamesMonthEnd", "", configFileLocation).split(","));
		contractFileNamesMonthEnd = Arrays.asList(ReadPropertiesMethods.readPropertiesString(configObj, "ContractFileNamesMonthEnd", "", configFileLocation).split(","));
		
	}
	

	
	

}
