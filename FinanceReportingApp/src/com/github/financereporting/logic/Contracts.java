package com.github.financereporting.logic;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Objects;


public class Contracts {
	
	private static ArrayList<String> contractNames = new ArrayList<String> ();
	
	private LinkedHashMap<String, LinkedHashMap<String, String>> contractValues = new LinkedHashMap<String, LinkedHashMap<String, String>> ();
	
	public static void setContractNames(ArrayList<String> cn) {
		contractNames = cn;
	}
	
	
	private boolean invalid = false;
	private int id;
	
	public Contracts(int identifier) {
		id = identifier;
	}
	
	
	private String contractNumber;
	private String customerCode;
	private String largeLongstandingClient;
	private String customerPostalCode;
	private String occupationCode;
	private String occupationDescription;
	private Date contractDate;
	private Date expiryDate;
	private BigDecimal principalInvoicePriceTotalRep;
	private BigDecimal brokerageStampDutyAgreeFee;
	private BigDecimal otherCharges;
	private BigDecimal termsCharges;
	private BigDecimal newContractPayment;
	private Date cutOffDate;
	private Date fundingdate;
	private BigDecimal fundingAmount;
	private String legalEntityCode;
	private String legalEntity;
	private String sellerCode;
	private BigDecimal outstandingBalanceLME;
	private BigDecimal outstandingBalanceLME_M1;
	private BigDecimal unearnedIncomeLME;
	private BigDecimal unearnedIncomeLME_M1;
	private BigDecimal GSTOutstandingBalanceLME;
	private BigDecimal GSTOutstandingBalanceLME_M1;
	private Date arrearsDateLME;
	private BigDecimal currentArrearsLME;
	private BigDecimal arrears30DaysLME;
	private BigDecimal arrears60DaysLME;
	private BigDecimal arrears90DaysLME;
	private BigDecimal arrears120DaysLME;
	private BigDecimal arrears150PlusDaysLME;
	private BigDecimal outstandingBalance;
	private BigDecimal unexpiredInterest;
	private BigDecimal GSTOutstanding;
	private BigDecimal theoreticalPrincipal;
	private BigDecimal maxLimit;
	private BigDecimal PDIOutstanding;
	private BigDecimal totalArrears;
	private BigDecimal currentArrears;
	private BigDecimal arrears30Days;
	private BigDecimal arrears60Days;
	private BigDecimal arrears90Days;
	private BigDecimal arrears120PlusDays;
	private Date oldestDueDate;
	private String productCode;
	private String interestType;
	private String dealerCode;
	private String dealerName;
	private String paidOutWrittenOffFlag;
	private Date paidOutWrittenOffDate;
	private BigDecimal monthlyRental;
	private String paymentFrequency;
	private BigDecimal term;
	private BigDecimal monthsExpired;
	private BigDecimal termsRemaining;
	private BigDecimal interestRate;
	private String principalBalanceLME_M1;
	private String principalBalance;
	private String newFundingAmount;
	private String groupExposureLLS_exclRTR;
	private String groupExposureOther;
	private String advanceRate;
	private String rtraa;
	private String cappedRtraa;
	private String adjustmentRate;
	private String advanceAmount;
	private String creditEnchancement;
	private String adjustedExposure;
	private String newCutoffDate;
	private String Transactions;

	
	private String errMsg = "";

	
	LinkedHashMap<String, LinkedHashMap<String, String>> values = new LinkedHashMap<String, LinkedHashMap<String, String>> ();
	
	
	public static ArrayList<String> getContractNames() {
		return contractNames;
	}


	public LinkedHashMap<String, LinkedHashMap<String, String>> getContractValues() {
		return contractValues;
	}


	public boolean isInvalid() {
		return invalid;
	}


	public int getId() {
		return id;
	}


	public String getContractNumber() {
		return contractNumber;
	}


	public String getCustomerCode() {
		return customerCode;
	}


	public String getLargeLongstandingClient() {
		return largeLongstandingClient;
	}


	public String getCustomerPostalCode() {
		return customerPostalCode;
	}


	public String getOccupationCode() {
		return occupationCode;
	}


	public String getOccupationDescription() {
		return occupationDescription;
	}


	public Date getContractDate() {
		return contractDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public BigDecimal getPrincipalInvoicePriceTotalRep() {
		return principalInvoicePriceTotalRep;
	}


	public BigDecimal getBrokerageStampDutyAgreeFee() {
		return brokerageStampDutyAgreeFee;
	}


	public BigDecimal getOtherCharges() {
		return otherCharges;
	}


	public BigDecimal getTermsCharges() {
		return termsCharges;
	}


	public BigDecimal getNewContractPayment() {
		return newContractPayment;
	}


	public Date getCutOffDate() {
		return cutOffDate;
	}


	public Date getFundingdate() {
		return fundingdate;
	}


	public BigDecimal getFundingAmount() {
		return fundingAmount;
	}


	public String getLegalEntityCode() {
		return legalEntityCode;
	}


	public String getLegalEntity() {
		return legalEntity;
	}


	public String getSellerCode() {
		return sellerCode;
	}


	public BigDecimal getOutstandingBalanceLME() {
		return outstandingBalanceLME;
	}


	public BigDecimal getOutstandingBalanceLME_M1() {
		return outstandingBalanceLME_M1;
	}


	public BigDecimal getUnearnedIncomeLME() {
		return unearnedIncomeLME;
	}


	public BigDecimal getUnearnedIncomeLME_M1() {
		return unearnedIncomeLME_M1;
	}


	public BigDecimal getGSTOutstandingBalanceLME() {
		return GSTOutstandingBalanceLME;
	}


	public BigDecimal getGSTOutstandingBalanceLME_M1() {
		return GSTOutstandingBalanceLME_M1;
	}


	public Date getArrearsDateLME() {
		return arrearsDateLME;
	}


	public BigDecimal getCurrentArrearsLME() {
		return currentArrearsLME;
	}


	public BigDecimal getArrears30DaysLME() {
		return arrears30DaysLME;
	}


	public BigDecimal getArrears60DaysLME() {
		return arrears60DaysLME;
	}


	public BigDecimal getArrears90DaysLME() {
		return arrears90DaysLME;
	}


	public BigDecimal getArrears120DaysLME() {
		return arrears120DaysLME;
	}


	public BigDecimal getArrears150PlusDaysLME() {
		return arrears150PlusDaysLME;
	}


	public BigDecimal getOutstandingBalance() {
		return outstandingBalance;
	}


	public BigDecimal getUnexpiredInterest() {
		return unexpiredInterest;
	}


	public BigDecimal getGSTOutstanding() {
		return GSTOutstanding;
	}


	public BigDecimal getTheoreticalPrincipal() {
		return theoreticalPrincipal;
	}


	public BigDecimal getMaxLimit() {
		return maxLimit;
	}


	public BigDecimal getPDIOutstanding() {
		return PDIOutstanding;
	}


	public BigDecimal getTotalArrears() {
		return totalArrears;
	}


	public BigDecimal getCurrentArrears() {
		return currentArrears;
	}


	public BigDecimal getArrears30Days() {
		return arrears30Days;
	}


	public BigDecimal getArrears60Days() {
		return arrears60Days;
	}


	public BigDecimal getArrears90Days() {
		return arrears90Days;
	}


	public BigDecimal getArrears120PlusDays() {
		return arrears120PlusDays;
	}


	public Date getOldestDueDate() {
		return oldestDueDate;
	}


	public String getProductCode() {
		return productCode;
	}


	public String getInterestType() {
		return interestType;
	}


	public String getDealerCode() {
		return dealerCode;
	}


	public String getDealerName() {
		return dealerName;
	}


	public String getPaidOutWrittenOffFlag() {
		return paidOutWrittenOffFlag;
	}


	public Date getPaidOutWrittenOffDate() {
		return paidOutWrittenOffDate;
	}


	public BigDecimal getMonthlyRental() {
		return monthlyRental;
	}


	public String getPaymentFrequency() {
		return paymentFrequency;
	}


	public BigDecimal getTerm() {
		return term;
	}


	public BigDecimal getMonthsExpired() {
		return monthsExpired;
	}


	public BigDecimal getTermsRemaining() {
		return termsRemaining;
	}


	public BigDecimal getInterestRate() {
		return interestRate;
	}


	public String getPrincipalBalanceLME_M1() {
		return principalBalanceLME_M1;
	}


	public String getPrincipalBalance() {
		return principalBalance;
	}


	public String getNewFundingAmount() {
		return newFundingAmount;
	}


	public String getGroupExposureLLS_exclRTR() {
		return groupExposureLLS_exclRTR;
	}


	public String getGroupExposureOther() {
		return groupExposureOther;
	}


	public String getAdvanceRate() {
		return advanceRate;
	}


	public String getRtraa() {
		return rtraa;
	}


	public String getCappedRtraa() {
		return cappedRtraa;
	}


	public String getAdjustmentRate() {
		return adjustmentRate;
	}


	public String getAdvanceAmount() {
		return advanceAmount;
	}


	public String getCreditEnchancement() {
		return creditEnchancement;
	}


	public String getAdjustedExposure() {
		return adjustedExposure;
	}


	public String getNewCutoffDate() {
		return newCutoffDate;
	}


	public String getTransactions() {
		return Transactions;
	}


	public LinkedHashMap<String, LinkedHashMap<String, String>> getValues() {
		return values;
	}
	
	
	
	
	/**
	 * Fills the contract object values with data from the following fields
	 * @param temp	is a list of data for a specific contract (in no particular order - however the indexes are stored in the mappings object)
	 * @param mappings are the file mappings (indexes) generated when reading the contracts file which are used to retrieve the correct data from the temp variable 
	 */
	public void fillValues(ArrayList<String> temp, LinkedHashMap<String, LinkedHashMap<String, String>> mappings) {
		
		
		
		contractNumber = temp.get(Integer.parseInt(mappings.get("contractNumber").get("index")));
		
		DataManipulationFunctions dataManipFunctionsObj = new DataManipulationFunctions("Contracts Data Error ... Contract number '" + contractNumber + "'");
		
		customerCode = temp.get(Integer.parseInt(mappings.get("customerCode").get("index")));
		largeLongstandingClient = temp.get(Integer.parseInt(mappings.get("largeLongstandingClient").get("index")));
		customerPostalCode = temp.get(Integer.parseInt(mappings.get("customerPostalCode").get("index")));
		legalEntityCode = temp.get(Integer.parseInt(mappings.get("legalEntityCode").get("index")));
		sellerCode = temp.get(Integer.parseInt(mappings.get("sellerCode").get("index")));
		fundingAmount = dataManipFunctionsObj.convertToBigDecimal("fundingAmount", temp, mappings);
		interestRate = dataManipFunctionsObj.convertToBigDecimal("interestRate", temp, mappings);
		occupationCode = temp.get(Integer.parseInt(mappings.get("occupationCode").get("index")));
		occupationDescription = temp.get(Integer.parseInt(mappings.get("occupationDescription").get("index")));
		principalInvoicePriceTotalRep = dataManipFunctionsObj.convertToBigDecimal("principalInvoicePriceTotalRep", temp, mappings);
		brokerageStampDutyAgreeFee = dataManipFunctionsObj.convertToBigDecimal("brokerageStampDutyAgreeFee", temp, mappings);
		otherCharges = dataManipFunctionsObj.convertToBigDecimal("otherCharges", temp, mappings);
		termsCharges = dataManipFunctionsObj.convertToBigDecimal("termsCharges", temp, mappings);
		newContractPayment = dataManipFunctionsObj.convertToBigDecimal("newContractPayment", temp, mappings);
		legalEntity = temp.get(Integer.parseInt(mappings.get("legalEntity").get("index")));
		outstandingBalanceLME = dataManipFunctionsObj.convertToBigDecimal("outstandingBalanceLME", temp, mappings);
		outstandingBalanceLME_M1 = dataManipFunctionsObj.convertToBigDecimal("outstandingBalanceLME_M1", temp, mappings);
		unearnedIncomeLME = dataManipFunctionsObj.convertToBigDecimal("unearnedIncomeLME", temp, mappings);
		unearnedIncomeLME_M1 = dataManipFunctionsObj.convertToBigDecimal("unearnedIncomeLME_M1", temp, mappings);
		GSTOutstandingBalanceLME = dataManipFunctionsObj.convertToBigDecimal("GSTOutstandingBalanceLME", temp, mappings);
		GSTOutstandingBalanceLME_M1 = dataManipFunctionsObj.convertToBigDecimal("GSTOutstandingBalanceLME_M1", temp, mappings);
		currentArrearsLME = dataManipFunctionsObj.convertToBigDecimal("currentArrearsLME", temp, mappings);
		arrears30DaysLME = dataManipFunctionsObj.convertToBigDecimal("arrears30DaysLME", temp, mappings);
		arrears60DaysLME = dataManipFunctionsObj.convertToBigDecimal("arrears60DaysLME", temp, mappings);
		arrears90DaysLME = dataManipFunctionsObj.convertToBigDecimal("arrears90DaysLME", temp, mappings);
		arrears120DaysLME = dataManipFunctionsObj.convertToBigDecimal("arrears120DaysLME", temp, mappings);
		arrears150PlusDaysLME = dataManipFunctionsObj.convertToBigDecimal("arrears150PlusDaysLME", temp, mappings);
		outstandingBalance = dataManipFunctionsObj.convertToBigDecimal("outstandingBalance", temp, mappings);
		unexpiredInterest = dataManipFunctionsObj.convertToBigDecimal("unexpiredInterest", temp, mappings);
		GSTOutstanding = dataManipFunctionsObj.convertToBigDecimal("GSTOutstanding", temp, mappings);
		theoreticalPrincipal = dataManipFunctionsObj.convertToBigDecimal("theoreticalPrincipal", temp, mappings);
		maxLimit = dataManipFunctionsObj.convertToBigDecimal("maxLimit", temp, mappings);
		PDIOutstanding = dataManipFunctionsObj.convertToBigDecimal("PDIOutstanding", temp, mappings);
		totalArrears = dataManipFunctionsObj.convertToBigDecimal("totalArrears", temp, mappings);
		currentArrears = dataManipFunctionsObj.convertToBigDecimal("currentArrears", temp, mappings);
		arrears30Days = dataManipFunctionsObj.convertToBigDecimal("arrears30Days", temp, mappings);
		arrears60Days = dataManipFunctionsObj.convertToBigDecimal("arrears60Days", temp, mappings);
		arrears90Days = dataManipFunctionsObj.convertToBigDecimal("arrears90Days", temp, mappings);
		arrears120PlusDays = dataManipFunctionsObj.convertToBigDecimal("arrears120PlusDays", temp, mappings);
		contractDate = dataManipFunctionsObj.convertToDate("contractDate", temp, mappings);
		expiryDate = dataManipFunctionsObj.convertToDate("expiryDate", temp, mappings);
		cutOffDate = dataManipFunctionsObj.convertToDate("cutOffDate", temp, mappings);
		fundingdate = dataManipFunctionsObj.convertToDate("fundingdate", temp, mappings);
		arrearsDateLME = dataManipFunctionsObj.convertToDate("arrearsDateLME", temp, mappings);
		oldestDueDate = dataManipFunctionsObj.convertToDate("oldestDueDate", temp, mappings);
		paidOutWrittenOffDate = dataManipFunctionsObj.convertToDate("paidOutWrittenOffDate", temp, mappings);
		productCode = temp.get(Integer.parseInt(mappings.get("productCode").get("index")));
		interestType = temp.get(Integer.parseInt(mappings.get("interestType").get("index")));
		dealerCode = temp.get(Integer.parseInt(mappings.get("dealerCode").get("index")));
		dealerName = temp.get(Integer.parseInt(mappings.get("dealerName").get("index")));
		paidOutWrittenOffFlag = temp.get(Integer.parseInt(mappings.get("paidOutWrittenOffFlag").get("index")));
		monthlyRental = dataManipFunctionsObj.convertToBigDecimal("monthlyRental", temp, mappings);
		paymentFrequency = temp.get(Integer.parseInt(mappings.get("paymentFrequency").get("index")));
		term = dataManipFunctionsObj.convertToBigDecimal("term", temp, mappings);
		monthsExpired = dataManipFunctionsObj.convertToBigDecimal("monthsExpired", temp, mappings);
		termsRemaining = dataManipFunctionsObj.convertToBigDecimal("termsRemaining", temp, mappings);

		if (!dataManipFunctionsObj.getErrMsg().trim().equals("")) { 
			System.out.println(dataManipFunctionsObj.getErrMsg());
		}
	}
}
