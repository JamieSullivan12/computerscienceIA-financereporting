/**
 * 
 */
package com.github.financereporting.app;

import java.util.LinkedHashMap;


/**
 * @author jacontractMappingsesullivan
 *
 * This class reads all the mappings for the contract file. The mappings are to link variable names in the program with headings in the excel file (in no particular order)
 */
public class fileMappings {
	

	//A linkedHashMap of all the mappings: Key: Variable Name, Value: User defined mapping from the heading in the database
	private static LinkedHashMap<String, LinkedHashMap<String, String>>  contractMappings;
	private static LinkedHashMap<String, LinkedHashMap<String, String>>  contractMappingsHolder;

	private static Property contractMappingObj;
	private static String contractFileMappingLocation;
	
	
	
	private static void readMappings(String key) {
		LinkedHashMap<String, String> tempHashMap = new LinkedHashMap<String, String> ();
		tempHashMap.put("map", contractMappingObj.readProperties(key, null, contractFileMappingLocation, 0));
		tempHashMap.put("index", "");
		contractMappings.put(key, tempHashMap);
	}
	
	
	/**
	 * Returns the mappings object with all the mappings for a specific file
	 * @return LinkedHashMap<String, String>
	 */
	
	public static LinkedHashMap<String, LinkedHashMap<String, String>> getContractMappings() {
		return contractMappings;
	}
	
	

	
	private static void setContractMappingValues(String key, String defaultValue, String dataTypeCode) {
		LinkedHashMap<String, String> mappingItem = new  LinkedHashMap<String, String>();
		mappingItem.put("defaultValue", defaultValue);
		mappingItem.put("dataTypeCode", dataTypeCode);
		mappingItem.put("value", "");
		mappingItem.put("warningFlag", "false");
		contractMappingsHolder.put(key, mappingItem);
	}
	
	
	


	
	
	
	/**
	 * Reads all the contract file mappings and saves them to a LinkedHashMap<String, String>
	 */
	public static void contractFileMappings() {

		Log.logInfo("Reading data from the " + contractFileMappingLocation + " file");

		//Will contain all the fields from the properties file
		contractMappingObj = new Property();
		contractFileMappingLocation = "src/resources/contractFileMappings.properties";
		contractMappingObj.readConfigFile(contractFileMappingLocation);
		
		
		contractMappingsHolder = new LinkedHashMap<String, LinkedHashMap<String, String>> ();

		setContractMappingValues("contractNumber", "", "0");
		setContractMappingValues("contractDate", "", "0");
		setContractMappingValues("brokerageStampDutyAgreeFee", "", "0");
		setContractMappingValues("principalInvoicePriceTotalRep", "", "0");
		setContractMappingValues("otherCharges", "", "0");

		setContractMappingValues("cutOffDate", "", "0");
		setContractMappingValues("fundingDate", "", "0");
		setContractMappingValues("fundingAmount", "", "0");
		setContractMappingValues("legalEntityCode", "", "0");
		setContractMappingValues("legalEntity", "", "0");
		setContractMappingValues("sellerCode", "", "0");
		setContractMappingValues("outstandingBalanceLME_M1", "", "0");
		setContractMappingValues("unearnedIncomeLME_M1", "", "0");
		setContractMappingValues("GSTOutstandingBalanceLME_M1", "", "0");
		
		setContractMappingValues("outstandingBalance", "", "0");
		setContractMappingValues("unexpiredInterest", "", "0");
		setContractMappingValues("GSTOutstanding", "", "0");

		setContractMappingValues("paidOutWrittenOffFlag", "", "0");

		
		
		contractMappings = new LinkedHashMap<String, LinkedHashMap<String, String>> ();
		Object[] contractMappingsKeyset = contractMappingsHolder.keySet().toArray();
		for (var i=0; i < contractMappingsKeyset.length; i++) {

			readMappings(contractMappingsKeyset[i].toString());	
			
		}
		



	}
}
