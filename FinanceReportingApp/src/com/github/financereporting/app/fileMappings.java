/**
 * 
 */
package com.github.financereporting.app;

import java.util.LinkedHashMap;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

/**
 * @author jamiesullivan
 *
 */
public class fileMappings {
	

	
	private static LinkedHashMap<String, String>  mappings;
	private static Property contractMappingObj;
	private static String contractFileMappingLocation;
	
	private static void readMappings(String key) throws ExitStatus1Exception {
		mappings.put(key, ReadPropertiesMethods.readPropertiesString(contractMappingObj, key, null, contractFileMappingLocation));
	}
	
	
	public static void contractFileMappings() throws ExitStatus1Exception{
		Log.logInfo("Reading data from the " + contractFileMappingLocation + " file");

		
		contractMappingObj = new Property();
		contractFileMappingLocation = "src/resources/contractFileMappings.properties";
		contractMappingObj.readConfigFile(contractFileMappingLocation);
		mappings = new LinkedHashMap<String, String> ();
		
	    


	    readMappings("ContractNumber");
	    readMappings("CustomerCode");
	    readMappings("LargeLongstandingClient");
	    readMappings("CustomerPostalCode");
	    readMappings("OccupationCode");
	    readMappings("OccupationDescription");
	    readMappings("ContractDate");
	    readMappings("ExpiryDate");
	    readMappings("PrincipalInvoicePriceTotalRep");
	    readMappings("Brokerage_StampDuty_AgreeFee");
	    readMappings("OtherCharges");
	    readMappings("TermsCharges");
	    readMappings("NewContractPayment");
	    readMappings("CutOffDate");
	    readMappings("FundingDate");
	    readMappings("FundingAmount");
	    readMappings("LegalEntityCode");
	    readMappings("LegalEntity");
	    readMappings("seller_code");
	    readMappings("OutstandingBalance_lastMonthEnd");
	    readMappings("OutstandingBalance_lastMonthEnd_minus1");
	    readMappings("UnearnedIncome_lastMonthEnd");
	    readMappings("UnearnedIncome_lastMonthEnd_minus1");
	    readMappings("GST_outstandingBalance_lastMonthEnd");
	    readMappings("GST_outstandingBalance_lastMonthEnd_minus1");
	    readMappings("Arrears_date_lastMontEnd");
	    readMappings("Current_arrears_lastMonthEnd");
	    readMappings("Arrears_30_days_lastMonthEnd");
	    readMappings("Arrears_60_days_lastMonthEnd");
	    readMappings("Arrears_90_days_lastMonthEnd");
	    readMappings("Arrears_120_days_lastMonthEnd");
	    readMappings("Arrears_150plus_days_lastMonthEnd");
	    readMappings("OutstandingBalance");
	    readMappings("UnexpiredInterest");
	    readMappings("GST_Outstanding");
	    readMappings("TheoreticalPrincipal");
	    readMappings("MaxLimit");
	    readMappings("PDI_Outstanding");
	    readMappings("TotalArrears");
	    readMappings("CurrentArrears");
	    readMappings("Arrears_30_Days");
	    readMappings("Arrears_60_Days");
	    readMappings("Arrears_90_Days");
	    readMappings("Arrears_120plus_Days");
	    readMappings("OldestDueDate");
	    readMappings("ProductCode");
	    readMappings("InterestType");
	    readMappings("DealerCode");
	    readMappings("DealerName");
	    readMappings("PaidOutWrittenOff_Flag");
	    readMappings("PaidOutWrittenOff_date");
	    readMappings("MonthlyRental");
	    readMappings("PaymentFrequency");
	    readMappings("Term");
	    readMappings("MonthsExpired");
	    readMappings("TermRemaining");
	    readMappings("InterestRate");
	    
	    

	}
	
	
}
