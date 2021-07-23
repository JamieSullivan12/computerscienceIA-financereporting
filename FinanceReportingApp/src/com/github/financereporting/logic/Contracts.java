package com.github.financereporting.logic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;

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
	private LocalDate contractDate;
	private LocalDate expiryDate;
	private BigDecimal principalInvoicePriceTotalRep;
	private BigDecimal brokerageStampDutyAgreeFee;
	private BigDecimal otherCharges;
	private BigDecimal termsCharges;
	private BigDecimal newContractPayment;
	private LocalDate cutOffDate;
	private LocalDate fundingDate;
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
	private LocalDate arrearsDateLME;
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
	private LocalDate oldestDueDate;
	private String productCode;
	private String interestType;
	private String dealerCode;
	private String dealerName;
	private String paidOutWrittenOffFlag;
	private LocalDate paidOutWrittenOffDate;
	private BigDecimal monthlyRental;
	private String paymentFrequency;
	private BigDecimal term;
	private BigDecimal monthsExpired;
	private BigDecimal termsRemaining;
	private BigDecimal interestRate;
	private BigDecimal currentPrincipalBalanceLME_M1;
	private BigDecimal currentPrincipalBalance;
	private BigDecimal newFundingAmount;
	private String groupExposureLLS_exclRTR;
	private String groupExposureOther;
	private String advanceRate;
	private String rtraa;
	private String cappedRtraa;
	private String adjustmentRate;
	private String advanceAmount;
	private String creditEnchancement;
	private String adjustedExposure;
	private LocalDate newCutoffDate;
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


	public LocalDate getContractDate() {
		return contractDate;
	}


	public LocalDate getExpiryDate() {
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


	public LocalDate getCutOffDate() {
		return cutOffDate;
	}


	public LocalDate getFundingDate() {
		return fundingDate;
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


	public LocalDate getArrearsDateLME() {
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


	public LocalDate getOldestDueDate() {
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


	public LocalDate getPaidOutWrittenOffDate() {
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


	public BigDecimal getCurrentPrincipalBalanceLME_M1() {
		return currentPrincipalBalanceLME_M1;
	}


	public BigDecimal getCurrentPrincipalBalance() {
		return currentPrincipalBalance;
	}


	public BigDecimal getNewFundingAmount() {
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


	public LocalDate getNewCutoffDate() {
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
		fundingDate = dataManipFunctionsObj.convertToDate("fundingDate", temp, mappings);
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


	public String getErrMsg() {
		return errMsg;
	}


	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}


	public void setContractValues(LinkedHashMap<String, LinkedHashMap<String, String>> contractValues) {
		this.contractValues = contractValues;
	}


	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}


	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}


	public void setLargeLongstandingClient(String largeLongstandingClient) {
		this.largeLongstandingClient = largeLongstandingClient;
	}


	public void setCustomerPostalCode(String customerPostalCode) {
		this.customerPostalCode = customerPostalCode;
	}


	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}


	public void setOccupationDescription(String occupationDescription) {
		this.occupationDescription = occupationDescription;
	}


	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}


	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	public void setPrincipalInvoicePriceTotalRep(BigDecimal principalInvoicePriceTotalRep) {
		this.principalInvoicePriceTotalRep = principalInvoicePriceTotalRep;
	}


	public void setBrokerageStampDutyAgreeFee(BigDecimal brokerageStampDutyAgreeFee) {
		this.brokerageStampDutyAgreeFee = brokerageStampDutyAgreeFee;
	}


	public void setOtherCharges(BigDecimal otherCharges) {
		this.otherCharges = otherCharges;
	}


	public void setTermsCharges(BigDecimal termsCharges) {
		this.termsCharges = termsCharges;
	}


	public void setNewContractPayment(BigDecimal newContractPayment) {
		this.newContractPayment = newContractPayment;
	}


	public void setCutOffDate(LocalDate cutOffDate) {
		this.cutOffDate = cutOffDate;
	}


	public void setFundingdate(LocalDate fundingDate) {
		this.fundingDate = fundingDate;
	}


	public void setFundingAmount(BigDecimal fundingAmount) {
		this.fundingAmount = fundingAmount;
	}


	public void setLegalEntityCode(String legalEntityCode) {
		this.legalEntityCode = legalEntityCode;
	}


	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}


	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}


	public void setOutstandingBalanceLME(BigDecimal outstandingBalanceLME) {
		this.outstandingBalanceLME = outstandingBalanceLME;
	}


	public void setOutstandingBalanceLME_M1(BigDecimal outstandingBalanceLME_M1) {
		this.outstandingBalanceLME_M1 = outstandingBalanceLME_M1;
	}


	public void setUnearnedIncomeLME(BigDecimal unearnedIncomeLME) {
		this.unearnedIncomeLME = unearnedIncomeLME;
	}


	public void setUnearnedIncomeLME_M1(BigDecimal unearnedIncomeLME_M1) {
		this.unearnedIncomeLME_M1 = unearnedIncomeLME_M1;
	}


	public void setGSTOutstandingBalanceLME(BigDecimal gSTOutstandingBalanceLME) {
		GSTOutstandingBalanceLME = gSTOutstandingBalanceLME;
	}


	public void setGSTOutstandingBalanceLME_M1(BigDecimal gSTOutstandingBalanceLME_M1) {
		GSTOutstandingBalanceLME_M1 = gSTOutstandingBalanceLME_M1;
	}


	public void setArrearsDateLME(LocalDate arrearsDateLME) {
		this.arrearsDateLME = arrearsDateLME;
	}


	public void setCurrentArrearsLME(BigDecimal currentArrearsLME) {
		this.currentArrearsLME = currentArrearsLME;
	}


	public void setArrears30DaysLME(BigDecimal arrears30DaysLME) {
		this.arrears30DaysLME = arrears30DaysLME;
	}


	public void setArrears60DaysLME(BigDecimal arrears60DaysLME) {
		this.arrears60DaysLME = arrears60DaysLME;
	}


	public void setArrears90DaysLME(BigDecimal arrears90DaysLME) {
		this.arrears90DaysLME = arrears90DaysLME;
	}


	public void setArrears120DaysLME(BigDecimal arrears120DaysLME) {
		this.arrears120DaysLME = arrears120DaysLME;
	}


	public void setArrears150PlusDaysLME(BigDecimal arrears150PlusDaysLME) {
		this.arrears150PlusDaysLME = arrears150PlusDaysLME;
	}


	public void setOutstandingBalance(BigDecimal outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}


	public void setUnexpiredInterest(BigDecimal unexpiredInterest) {
		this.unexpiredInterest = unexpiredInterest;
	}


	public void setGSTOutstanding(BigDecimal gSTOutstanding) {
		GSTOutstanding = gSTOutstanding;
	}


	public void setTheoreticalPrincipal(BigDecimal theoreticalPrincipal) {
		this.theoreticalPrincipal = theoreticalPrincipal;
	}


	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}


	public void setPDIOutstanding(BigDecimal pDIOutstanding) {
		PDIOutstanding = pDIOutstanding;
	}


	public void setTotalArrears(BigDecimal totalArrears) {
		this.totalArrears = totalArrears;
	}


	public void setCurrentArrears(BigDecimal currentArrears) {
		this.currentArrears = currentArrears;
	}


	public void setArrears30Days(BigDecimal arrears30Days) {
		this.arrears30Days = arrears30Days;
	}


	public void setArrears60Days(BigDecimal arrears60Days) {
		this.arrears60Days = arrears60Days;
	}


	public void setArrears90Days(BigDecimal arrears90Days) {
		this.arrears90Days = arrears90Days;
	}


	public void setArrears120PlusDays(BigDecimal arrears120PlusDays) {
		this.arrears120PlusDays = arrears120PlusDays;
	}


	public void setOldestDueDate(LocalDate oldestDueDate) {
		this.oldestDueDate = oldestDueDate;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}


	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}


	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	public void setPaidOutWrittenOffFlag(String paidOutWrittenOffFlag) {
		this.paidOutWrittenOffFlag = paidOutWrittenOffFlag;
	}


	public void setPaidOutWrittenOffDate(LocalDate paidOutWrittenOffDate) {
		this.paidOutWrittenOffDate = paidOutWrittenOffDate;
	}


	public void setMonthlyRental(BigDecimal monthlyRental) {
		this.monthlyRental = monthlyRental;
	}


	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}


	public void setTerm(BigDecimal term) {
		this.term = term;
	}


	public void setMonthsExpired(BigDecimal monthsExpired) {
		this.monthsExpired = monthsExpired;
	}


	public void setTermsRemaining(BigDecimal termsRemaining) {
		this.termsRemaining = termsRemaining;
	}


	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}


	public void setCurrentPrincipalBalanceLME_M1(BigDecimal principalBalanceLME_M1) {
		this.currentPrincipalBalanceLME_M1 = principalBalanceLME_M1;
	}


	public void setCurrentPrincipalBalance(BigDecimal principalBalance) {
		this.currentPrincipalBalance = principalBalance;
	}


	public void setNewFundingAmount(BigDecimal newFundingAmount) {
		this.newFundingAmount = newFundingAmount;
	}


	public void setGroupExposureLLS_exclRTR(String groupExposureLLS_exclRTR) {
		this.groupExposureLLS_exclRTR = groupExposureLLS_exclRTR;
	}


	public void setGroupExposureOther(String groupExposureOther) {
		this.groupExposureOther = groupExposureOther;
	}


	public void setAdvanceRate(String advanceRate) {
		this.advanceRate = advanceRate;
	}


	public void setRtraa(String rtraa) {
		this.rtraa = rtraa;
	}


	public void setCappedRtraa(String cappedRtraa) {
		this.cappedRtraa = cappedRtraa;
	}


	public void setAdjustmentRate(String adjustmentRate) {
		this.adjustmentRate = adjustmentRate;
	}


	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}


	public void setCreditEnchancement(String creditEnchancement) {
		this.creditEnchancement = creditEnchancement;
	}


	public void setAdjustedExposure(String adjustedExposure) {
		this.adjustedExposure = adjustedExposure;
	}


	public void setNewCutoffDate(LocalDate newCutoffDate) {
		this.newCutoffDate = newCutoffDate;
	}


	public void setTransactions(String transactions) {
		Transactions = transactions;
	}
}
