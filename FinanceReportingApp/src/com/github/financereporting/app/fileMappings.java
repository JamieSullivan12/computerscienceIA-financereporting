/**
 * 
 */
package com.github.financereporting.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * @author jamiesullivan
 *
 * This class reads all the mappings for the contract file. The mappings are to link variable names in the program with headings in the excel file (in no particular order)
 */
public class fileMappings {
	

	//A linkedHashMap of all the mappings: Key: Variable Name, Value: User defined mapping from the heading in the database
	private static LinkedHashMap<String, LinkedHashMap<String, String>>  contractMappings;
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
	
	private static void setContractFields() {
		contractNames.add("contractNumber");
		contractNames.add("customerCode");
		contractNames.add("largeLongstandingClient");
		contractNames.add("customerPostalCode");
		contractNames.add("occupationCode");
		contractNames.add("occupationDescription");
		contractNames.add("contractDate");
		contractNames.add("expiryDate");
		contractNames.add("principalInvoicePriceTotalRep");
		contractNames.add("brokerageStampDutyAgreeFee");
		contractNames.add("otherCharges");
		contractNames.add("termsCharges");
		contractNames.add("newContractPayment");
		contractNames.add("cutOffDate");
		contractNames.add("fundingDate");
		contractNames.add("fundingAmount");
		contractNames.add("legalEntityCode");
		contractNames.add("legalEntity");
		contractNames.add("sellerCode");
		contractNames.add("outstandingBalanceLME");
		contractNames.add("outstandingBalanceLME_M1");
		contractNames.add("unearnedIncomeLME");
		contractNames.add("unearnedIncomeLME_M1");
		contractNames.add("GSTOutstandingBalanceLME");
		contractNames.add("GSTOutstandingBalanceLME_M1");
		contractNames.add("arrearsDateLME");
		contractNames.add("currentArrearsLME");
		contractNames.add("arrears30DaysLME");
		contractNames.add("arrears60DaysLME");
		contractNames.add("arrears90DaysLME");
		contractNames.add("arrears120DaysLME");
		contractNames.add("arrears150PlusDaysLME");
		contractNames.add("outstandingBalance");
		contractNames.add("unexpiredInterest");
		contractNames.add("GSTOutstanding");
		contractNames.add("theoreticalPrincipal");
		contractNames.add("maxLimit");
		contractNames.add("PDIOutstanding");
		contractNames.add("totalArrears");
		contractNames.add("currentArrears");
		contractNames.add("arrears30Days");
		contractNames.add("arrears60Days");
		contractNames.add("arrears90Days");
		contractNames.add("arrears120PlusDays");
		contractNames.add("oldestDueDate");
		contractNames.add("productCode");
		contractNames.add("interestType");
		contractNames.add("dealerCode");
		contractNames.add("dealerName");
		contractNames.add("paidOutWrittenOffFlag");
		contractNames.add("paidOutWrittenOffDate");
		contractNames.add("monthlyRental");
		contractNames.add("paymentFrequency");
		contractNames.add("term");
		contractNames.add("monthsExpired");
		contractNames.add("termsRemaining");
		contractNames.add("interestRate");

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
		
		
		contractMappings = new LinkedHashMap<String, LinkedHashMap<String, String>> ();

		setContractFields();
		contractNames.forEach((mapping) -> {
			readMappings(mapping.toString());	
		});
			





	}
}
