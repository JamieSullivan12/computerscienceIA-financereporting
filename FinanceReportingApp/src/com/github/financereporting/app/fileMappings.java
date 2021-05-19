/**
 * 
 */
package com.github.financereporting.app;

import java.util.ArrayList;
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
	
	
	
	
	private static ArrayList<String> contractNames = new ArrayList<String>();
	
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
		setContractMappingValues("customerCode", "", "0");
		setContractMappingValues("largeLongstandingClient", "", "0");
		setContractMappingValues("customerPostalCode", "", "0");
		setContractMappingValues("occupationCode", "", "0");
		setContractMappingValues("occupationDescription", "", "0");
		setContractMappingValues("contractDate", "", "0");
		setContractMappingValues("expiryDate", "", "0");
		setContractMappingValues("principalInvoicePriceTotalRep", "", "0");
		setContractMappingValues("brokerageStampDutyAgreeFee", "", "0");
		setContractMappingValues("otherCharges", "", "0");
		setContractMappingValues("termsCharges", "", "0");
		setContractMappingValues("newContractPayment", "", "0");
		setContractMappingValues("cutOffDate", "", "0");
		setContractMappingValues("fundingdate", "", "0");
		setContractMappingValues("fundingAmount", "", "0");
		setContractMappingValues("legalEntityCode", "", "0");
		setContractMappingValues("legalEntity", "", "0");
		setContractMappingValues("sellerCode", "", "0");
		setContractMappingValues("outstandingBalanceLME", "", "0");
		setContractMappingValues("outstandingBalanceLME_M1", "", "0");
		setContractMappingValues("unearnedIncomeLME", "", "0");
		setContractMappingValues("unearnedIncomeLME_M1", "", "0");
		setContractMappingValues("GSTOutstandingBalanceLME", "", "0");
		setContractMappingValues("GSTOutstandingBalanceLME_M1", "", "0");
		setContractMappingValues("arrearsDateLME", "", "0");
		setContractMappingValues("currentArrearsLME", "", "0");
		setContractMappingValues("arrears30DaysLME", "", "0");
		setContractMappingValues("arrears60DaysLME", "", "0");
		setContractMappingValues("arrears90DaysLME", "", "0");
		setContractMappingValues("arrears120DaysLME", "", "0");
		setContractMappingValues("arrears150PlusDaysLME", "", "0");
		setContractMappingValues("outstandingBalance", "", "0");
		setContractMappingValues("unexpiredInterest", "", "0");
		setContractMappingValues("GSTOutstanding", "", "0");
		setContractMappingValues("theoreticalPrincipal", "", "0");
		setContractMappingValues("maxLimit", "", "0");
		setContractMappingValues("PDIOutstanding", "", "0");
		setContractMappingValues("totalArrears", "", "0");
		setContractMappingValues("currentArrears", "", "0");
		setContractMappingValues("arrears30Days", "", "0");
		setContractMappingValues("arrears60Days", "", "0");
		setContractMappingValues("arrears90Days", "", "0");
		setContractMappingValues("arrears120PlusDays", "", "0");
		setContractMappingValues("oldestDueDate", "", "0");
		setContractMappingValues("productCode", "", "0");
		setContractMappingValues("interestType", "", "0");
		setContractMappingValues("dealerCode", "", "0");
		setContractMappingValues("dealerName", "", "0");
		setContractMappingValues("paidOutWrittenOffFlag", "", "0");
		setContractMappingValues("paidOutWrittenOffDate", "", "0");
		setContractMappingValues("monthlyRental", "", "0");
		setContractMappingValues("paymentFrequency", "", "0");
		setContractMappingValues("term", "", "0");
		setContractMappingValues("monthsExpired", "", "0");
		setContractMappingValues("termsRemaining", "", "0");
		setContractMappingValues("interestRate", "", "0");
		
		
		contractMappings = new LinkedHashMap<String, LinkedHashMap<String, String>> ();
		Object[] contractMappingsKeyset = contractMappingsHolder.keySet().toArray();
		for (var i=0; i < contractMappingsKeyset.length; i++) {

			readMappings(contractMappingsKeyset[i].toString());	
			
		}
		



	}
}
