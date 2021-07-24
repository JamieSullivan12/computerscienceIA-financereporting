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
	private LocalDate contractDate;
	private BigDecimal principalInvoicePriceTotalRep;
	private BigDecimal brokerageStampDutyAgreeFee;
	
	public BigDecimal getBrokerageStampDutyAgreeFee() {
		return brokerageStampDutyAgreeFee;
	}


	public void setBrokerageStampDutyAgreeFee(BigDecimal brokerageStampDutyAgreeFee) {
		this.brokerageStampDutyAgreeFee = brokerageStampDutyAgreeFee;
	}


	private BigDecimal otherCharges;
	private LocalDate cutOffDate;
	private LocalDate fundingDate;
	private BigDecimal fundingAmount;
	private String legalEntityCode;
	private String legalEntity;
	private String sellerCode;
	private BigDecimal outstandingBalanceLME_M1;
	private BigDecimal unearnedIncomeLME_M1;
	private BigDecimal GSTOutstandingBalanceLME_M1;
	
	private BigDecimal outstandingBalance;
	private BigDecimal unexpiredInterest;
	private BigDecimal GSTOutstanding;
	private String paidOutWrittenOffFlag;
	
	
	private BigDecimal currentPrincipalBalance;
	private BigDecimal newFundingAmount;
	private LocalDate newCutoffDate;

	private BigDecimal CurrentPrincipalBalanceLME_M1 = new BigDecimal(0);
	
	public BigDecimal getCurrentPrincipalBalanceLME_M1() {
		return CurrentPrincipalBalanceLME_M1;
	}


	public void setCurrentPrincipalBalanceLME_M1(BigDecimal currentPrincipalBalanceLME_M1) {
		CurrentPrincipalBalanceLME_M1 = currentPrincipalBalanceLME_M1;
	}


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
		

		legalEntityCode = temp.get(Integer.parseInt(mappings.get("legalEntityCode").get("index")));
		sellerCode = temp.get(Integer.parseInt(mappings.get("sellerCode").get("index")));
		fundingAmount = dataManipFunctionsObj.convertToBigDecimal("fundingAmount", temp, mappings);
		brokerageStampDutyAgreeFee = dataManipFunctionsObj.convertToBigDecimal("brokerageStampDutyAgreeFee", temp, mappings);

		principalInvoicePriceTotalRep = dataManipFunctionsObj.convertToBigDecimal("principalInvoicePriceTotalRep", temp, mappings);
		otherCharges = dataManipFunctionsObj.convertToBigDecimal("otherCharges", temp, mappings);
		

		legalEntity = temp.get(Integer.parseInt(mappings.get("legalEntity").get("index")));

		outstandingBalanceLME_M1 = dataManipFunctionsObj.convertToBigDecimal("outstandingBalanceLME_M1", temp, mappings);

		unearnedIncomeLME_M1 = dataManipFunctionsObj.convertToBigDecimal("unearnedIncomeLME_M1", temp, mappings);

		GSTOutstandingBalanceLME_M1 = dataManipFunctionsObj.convertToBigDecimal("GSTOutstandingBalanceLME_M1", temp, mappings);

		outstandingBalance = dataManipFunctionsObj.convertToBigDecimal("outstandingBalance", temp, mappings);
		unexpiredInterest = dataManipFunctionsObj.convertToBigDecimal("unexpiredInterest", temp, mappings);
		GSTOutstanding = dataManipFunctionsObj.convertToBigDecimal("GSTOutstanding", temp, mappings);

		contractDate = dataManipFunctionsObj.convertToDate("contractDate", temp, mappings);

		cutOffDate = dataManipFunctionsObj.convertToDate("cutOffDate", temp, mappings);
		fundingDate = dataManipFunctionsObj.convertToDate("fundingDate", temp, mappings);

		paidOutWrittenOffFlag = temp.get(Integer.parseInt(mappings.get("paidOutWrittenOffFlag").get("index")));

		

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





	public String getContractNumber() {
		return contractNumber;
	}


	public LocalDate getContractDate() {
		return contractDate;
	}


	public BigDecimal getPrincipalInvoicePriceTotalRep() {
		return principalInvoicePriceTotalRep;
	}




	public BigDecimal getOtherCharges() {
		return otherCharges;
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


	public BigDecimal getOutstandingBalanceLME_M1() {
		return outstandingBalanceLME_M1;
	}


	public BigDecimal getUnearnedIncomeLME_M1() {
		return unearnedIncomeLME_M1;
	}


	public BigDecimal getGSTOutstandingBalanceLME_M1() {
		return GSTOutstandingBalanceLME_M1;
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


	public String getPaidOutWrittenOffFlag() {
		return paidOutWrittenOffFlag;
	}


	public BigDecimal getCurrentPrincipalBalance() {
		return currentPrincipalBalance;
	}


	public BigDecimal getNewFundingAmount() {
		return newFundingAmount;
	}


	public LocalDate getNewCutoffDate() {
		return newCutoffDate;
	}




	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}


	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}


	public void setPrincipalInvoicePriceTotalRep(BigDecimal principalInvoicePriceTotalRep) {
		this.principalInvoicePriceTotalRep = principalInvoicePriceTotalRep;
	}




	public void setOtherCharges(BigDecimal otherCharges) {
		this.otherCharges = otherCharges;
	}


	public void setCutOffDate(LocalDate cutOffDate) {
		this.cutOffDate = cutOffDate;
	}


	public void setFundingDate(LocalDate fundingDate) {
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


	public void setOutstandingBalanceLME_M1(BigDecimal outstandingBalanceLME_M1) {
		this.outstandingBalanceLME_M1 = outstandingBalanceLME_M1;
	}


	public void setUnearnedIncomeLME_M1(BigDecimal unearnedIncomeLME_M1) {
		this.unearnedIncomeLME_M1 = unearnedIncomeLME_M1;
	}


	public void setGSTOutstandingBalanceLME_M1(BigDecimal gSTOutstandingBalanceLME_M1) {
		GSTOutstandingBalanceLME_M1 = gSTOutstandingBalanceLME_M1;
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


	public void setPaidOutWrittenOffFlag(String paidOutWrittenOffFlag) {
		this.paidOutWrittenOffFlag = paidOutWrittenOffFlag;
	}


	public void setCurrentPrincipalBalance(BigDecimal currentPrincipalBalance) {
		this.currentPrincipalBalance = currentPrincipalBalance;
	}


	public void setNewFundingAmount(BigDecimal newFundingAmount) {
		this.newFundingAmount = newFundingAmount;
	}


	public void setNewCutoffDate(LocalDate newCutoffDate) {
		this.newCutoffDate = newCutoffDate;
	}


	public void setValues(LinkedHashMap<String, LinkedHashMap<String, String>> values) {
		this.values = values;
	}


	
}
