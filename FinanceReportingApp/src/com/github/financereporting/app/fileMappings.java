/**
 * 
 */
package com.github.financereporting.app;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

/**
 * @author jamiesullivan
 *
 */
public class fileMappings {
	
	private static String ContractNumber;
	private static String CustomerCode;
	private static String LargeLongstandingClient;
	private static String CustomerPostalCode;
	private static String OcupationCode;
	private static String OccupationDescription;
	private static String ContractDate;
	private static String ExpiryDate;
	private static String PrincipalInvoicePriceTotalRep;
	private static String Brokerage_StampDuty_AgreeFee;
	private static String OtherCharges;
	private static String TermsCharges;
	private static String NewContractPayment;
	private static String CutOffDate;
	private static String FundingDate;
	private static String FundingAmount;
	private static String LegalEntityCode;
	private static String LegalEntity;
	private static String seller_code;
	private static String OutstandingBalance_lastMonthEnd;
	private static String OutstandingBalance_lastMonthEnd_minus1;
	private static String UnearnedIncome_lastMonthEnd;
	private static String UnearnedIncome_lastMonthEnd_minus1;
	private static String GST_outstandingBalance_lastMonthEnd;
	private static String GST_outstandingBalance_lastMonthEnd_minus1;
	private static String Arrears_date_lastMontEnd;
	private static String Current_arrears_lastMonthEnd;
	private static String Arrears_30_days_lastMonthEnd;
	private static String Arrears_60_days_lastMonthEnd;
	private static String Arrears_90_days_lastMonthEnd;
	private static String Arrears_120_days_lastMonthEnd;
	private static String Arrears_150plus_days_lastMonthEnd;
	private static String OutstandingBalance;
	private static String UnexpiredInterest;
	private static String GST_Outstanding;
	private static String TheoreticalPrincipal;
	private static String MaxLimit;
	private static String PDI_Outstanding;
	private static String TotalArrears;
	private static String CurrentArrears;
	private static String Arrears_30_Days;
	private static String Arrears_60_Days;
	private static String Arrears_90_Days;
	private static String Arrears_120plus_Days;
	private static String OldestDueDate;
	private static String ProductCode;
	private static String InterestType;
	private static String DealerCode;
	private static String DealerName;
	private static String PaidOutWrittenOff_Flag;
	private static String PaidOutWrittenOff_date;
	private static String MonthlyRental;
	private static String PaymentFrequency;
	private static String Term;
	private static String MonthsExpired;
	private static String TermRemaining;
	private static String InterestRate;
	
	
	public static void contractFileMappings() throws ExitStatus1Exception{
		Property contractMappingObj = new Property();
		
		String contractFileMappingLocation = "src/resources/contractFileMappings.properties";
		contractMappingObj.readConfigFile(contractFileMappingLocation);
		
		Log.logInfo("Reading data from the " + contractFileMappingLocation + " file");



		ContractNumber = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "ContractNumber", "ContractNumber", contractFileMappingLocation );
		CustomerCode = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "CustomerCode", "CustomerCode", contractFileMappingLocation );
		LargeLongstandingClient = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "LargeLongstandingClient", "LargeLongstandingClient", contractFileMappingLocation );
		CustomerPostalCode = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "CustomerPostalCode", "CustomerPostalCode", contractFileMappingLocation );
		OcupationCode = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "OcupationCode", "OcupationCode", contractFileMappingLocation );
		OccupationDescription = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "OccupationDescription", "OccupationDescription", contractFileMappingLocation );
		ContractDate = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "ContractDate", "ContractDate", contractFileMappingLocation );
		ExpiryDate = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "ExpiryDate", "ExpiryDate", contractFileMappingLocation );
		PrincipalInvoicePriceTotalRep = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "PrincipalInvoicePriceTotalRep", "PrincipalInvoicePriceTotalRep", contractFileMappingLocation );
		Brokerage_StampDuty_AgreeFee = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Brokerage_StampDuty_AgreeFee", "Brokerage_StampDuty_AgreeFee", contractFileMappingLocation );
		OtherCharges = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "OtherCharges", "OtherCharges", contractFileMappingLocation );
		TermsCharges = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "TermsCharges", "TermsCharges", contractFileMappingLocation );
		NewContractPayment = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "NewContractPayment", "NewContractPayment", contractFileMappingLocation );
		CutOffDate = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "CutOffDate", "CutOffDate", contractFileMappingLocation );
		FundingDate = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "FundingDate", "FundingDate", contractFileMappingLocation );
		FundingAmount = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "FundingAmount", "FundingAmount", contractFileMappingLocation );
		LegalEntityCode = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "LegalEntityCode", "LegalEntityCode", contractFileMappingLocation );
		LegalEntity = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "LegalEntity", "LegalEntity", contractFileMappingLocation );
		seller_code = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "seller_code", "seller_code", contractFileMappingLocation );
		OutstandingBalance_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "OutstandingBalance_lastMonthEnd", "OutstandingBalance_lastMonthEnd", contractFileMappingLocation );
		OutstandingBalance_lastMonthEnd_minus1 = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "OutstandingBalance_lastMonthEnd_minus1", "OutstandingBalance_lastMonthEnd_minus1", contractFileMappingLocation );
		UnearnedIncome_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "UnearnedIncome_lastMonthEnd", "UnearnedIncome_lastMonthEnd", contractFileMappingLocation );
		UnearnedIncome_lastMonthEnd_minus1 = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "UnearnedIncome_lastMonthEnd_minus1", "UnearnedIncome_lastMonthEnd_minus1", contractFileMappingLocation );
		GST_outstandingBalance_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "GST_outstandingBalance_lastMonthEnd", "GST_outstandingBalance_lastMonthEnd", contractFileMappingLocation );
		GST_outstandingBalance_lastMonthEnd_minus1 = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "GST_outstandingBalance_lastMonthEnd_minus1", "GST_outstandingBalance_lastMonthEnd_minus1", contractFileMappingLocation );
		Arrears_date_lastMontEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_date_lastMontEnd", "Arrears_date_lastMontEnd", contractFileMappingLocation );
		Current_arrears_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Current_arrears_lastMonthEnd", "Current_arrears_lastMonthEnd", contractFileMappingLocation );
		Arrears_30_days_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_30_days_lastMonthEnd", "Arrears_30_days_lastMonthEnd", contractFileMappingLocation );
		Arrears_60_days_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_60_days_lastMonthEnd", "Arrears_60_days_lastMonthEnd", contractFileMappingLocation );
		Arrears_90_days_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_90_days_lastMonthEnd", null, contractFileMappingLocation );
		Arrears_120_days_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_120_days_lastMonthEnd", "Arrears_120_days_lastMonthEnd", contractFileMappingLocation );
		Arrears_150plus_days_lastMonthEnd = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_150plus_days_lastMonthEnd", "Arrears_150plus_days_lastMonthEnd", contractFileMappingLocation );
		OutstandingBalance = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "OutstandingBalance", "OutstandingBalance", contractFileMappingLocation );
		UnexpiredInterest = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "UnexpiredInterest", "UnexpiredInterest", contractFileMappingLocation );
		GST_Outstanding = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "GST_Outstanding", "GST_Outstanding", contractFileMappingLocation );
		TheoreticalPrincipal = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "TheoreticalPrincipal", "TheoreticalPrincipal", contractFileMappingLocation );
		MaxLimit = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "MaxLimit", "MaxLimit", contractFileMappingLocation );
		PDI_Outstanding = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "PDI_Outstanding", "PDI_Outstanding", contractFileMappingLocation );
		TotalArrears = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "TotalArrears", "TotalArrears", contractFileMappingLocation );
		CurrentArrears = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "CurrentArrears", "CurrentArrears", contractFileMappingLocation );
		Arrears_30_Days = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_30_Days", "Arrears_30_Days", contractFileMappingLocation );
		Arrears_60_Days = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_60_Days", "Arrears_60_Days", contractFileMappingLocation );
		Arrears_90_Days = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_90_Days", "Arrears_90_Days", contractFileMappingLocation );
		Arrears_120plus_Days = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Arrears_120plus_Days", "Arrears_120plus_Days", contractFileMappingLocation );
		OldestDueDate = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "OldestDueDate", "OldestDueDate", contractFileMappingLocation );
		ProductCode = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "ProductCode", "ProductCode", contractFileMappingLocation );
		InterestType = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "InterestType", "InterestType", contractFileMappingLocation );
		DealerCode = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "DealerCode", "DealerCode", contractFileMappingLocation );
		DealerName = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "DealerName", "DealerName", contractFileMappingLocation );
		PaidOutWrittenOff_Flag = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "PaidOutWrittenOff_Flag", "PaidOutWrittenOff_Flag", contractFileMappingLocation );
		PaidOutWrittenOff_date = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "PaidOutWrittenOff_date", "PaidOutWrittenOff_date", contractFileMappingLocation );
		MonthlyRental = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "MonthlyRental", "MonthlyRental", contractFileMappingLocation );
		PaymentFrequency = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "PaymentFrequency", "PaymentFrequency", contractFileMappingLocation );
		Term = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "Term", "Term", contractFileMappingLocation );
		MonthsExpired = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "MonthsExpired", "MonthsExpired", contractFileMappingLocation );
		TermRemaining = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "TermRemaining", "TermRemaining", contractFileMappingLocation );
		InterestRate = ReadPropertiesMethods.readPropertiesString(contractMappingObj, "InterestRate", "InterestRate", contractFileMappingLocation );


	}
	
	
}
