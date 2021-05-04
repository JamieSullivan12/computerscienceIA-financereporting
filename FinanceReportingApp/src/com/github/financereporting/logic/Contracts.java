package com.github.financereporting.logic;
import java.util.Date;


public class Contracts {
	
	
	String contractNumber;
	String customerCode;
	String largeLongstandingClient;
	int customerPostalCode;
	String occupationCode;
	String occupationDescription;
	Date contractDate;
	Date expiryDate;
	double principalInvoicePriceTotalRep;
	double brokerageStampDutyAgreeFee;
	double otherCharges;
	double termsCharges;
	double newContractPayment;
	Date cutOffDate;
	Date fundingdate;
	double fundingAmount;
	int legalEntityCode;
	String legalEntity;
	int sellerCode;
	double outstandingBalanceLME;
	double outstandingBalanceLME_M1;
	double unearnedIncomeLME;
	double unearnedIncomeLME_M1;
	double GSTOutstandingBalanceLME;
	double GSTOutstandingBalanceLME_M1;
	Date arrearsDateLME;
	double currentArrearsLME;
	double arrears30DaysLME;
	double arrears60DaysLME;
	double arrears90DaysLME;
	double arrears120DaysLME;
	double arrears150PlusDaysLME;
	double outstandingBalance;
	double unexpiredInterest;
	double GSTOutstanding;
	double theoreticalPrincipal;
	double maxLimit;
	double PDIOutstanding;
	double totalArrears;
	double currentArrears;
	double arrears30Days;
	double arrears60Days;
	double arrears90Days;
	double arrears120PlusDays;
	Date oldestDueDate;
	String productCode;
	String interestType;
	String dealerCode;
	String dealerName;
	String paidOutWrittenOffFlag;
	Date paidOutWrittenOffDate;
	double monthlyRental;
	String paymentFrequency;
	int term;
	int monthsExpired;
	int termsRemaining;
	double interestRate;
	String principalBalanceLME_M1;
	String principalBalance;
	String newFundingAmount;
	String groupExposureLLS_exclRTR;
	String groupExposureOther;
	String advanceRate;
	String rtraa;
	String cappedRtraa;
	String adjustmentRate;
	String advanceAmount;
	String creditEnchancement;
	String adjustedExposure;
	String newCutoffDate;
	String Transactions;



	public static void main(String[] args) {

	}




	public void setValues(String contractNumber_value, String customerCode_value, 
			String largeLongstandingClient_value, int customerPostalCode_value, 
			String occupationCode_value, String occupationDescription_value, Date contractDate_value, 
			Date expiryDate_value, double principalInvoicePriceTotalRep_value, double brokerageStampDutyAgreeFee_value, 
			double otherCharges_value, double termsCharges_value, double newContractPayment_value, 
			Date cutOffDate_value, Date fundingdate_value, double fundingAmount_value, int legalEntityCode_value, 
			String legalEntity_value, int sellerCode_value, double outstandingBalanceLME_value, 
			double outstandingBalanceLME_M1_value, double unearnedIncomeLME_value, 
			double unearnedIncomeLME_M1_value, double GSTOutstandingBalanceLME_value, 
			double GSTOutstandingBalanceLME_M1_value, Date arrearsDateLME_value, 
			double currentArrearsLME_value, double arrears30DaysLME_value, 
			double arrears60DaysLME_value, double arrears90DaysLME_value, 
			double arrears120DaysLME_value, double arrears150PlusDaysLME_value, 
			double outstandingBalance_value, double unexpiredInterest_value, double GSTOutstanding_value, 
			double theoreticalPrincipal_value, double maxLimit_value, double PDIOutstanding_value, 
			double totalArrears_value, double currentArrears_value, double arrears30Days_value, 
			double arrears60Days_value, double arrears90Days_value, double arrears120PlusDays_value, 
			Date oldestDueDate_value, String productCode_value, String interestType_value, String dealerCode_value, 
			String dealerName_value, String paidOutWrittenOffFlag_value, Date paidOutWrittenOffDate_value, 
			double monthlyRental_value, String paymentFrequency_value, int term_value, int monthsExpired_value, 
			int termsRemaining_value, double interestRate_value, String principalBalanceLME_M1_value, 
			String principalBalance_value, String newFundingAmount_value, String groupExposureLLS_exclRTR_value, 
			String groupExposureOther_value, String advanceRate_value, String rtraa_value, String cappedRtraa_value, 
			String adjustmentRate_value, String advanceAmount_value, String creditEnchancement_value, 
			String adjustedExposure_value, String newCutoffDate_value, String Transactions_value
			) { 
        
        this.contractNumber = contractNumber_value;
        this.customerCode = customerCode_value;
        this.largeLongstandingClient = largeLongstandingClient_value;
        this.customerPostalCode = customerPostalCode_value;
        this.occupationCode = occupationCode_value;
        this.occupationDescription = occupationDescription_value;
        
        //This later needs to be moved to an addons file
        if (occupationDescription_value.toLowerCase().equals("to be advised")){
            this.occupationDescription = "Consumer Rentals";
        } else {
        	occupationDescription = occupationDescription_value;
        }
        
        this.contractDate = contractDate_value;
        this.expiryDate = expiryDate_value;
        this.principalInvoicePriceTotalRep = principalInvoicePriceTotalRep_value;
        this.brokerageStampDutyAgreeFee = brokerageStampDutyAgreeFee_value;
        this.otherCharges = otherCharges_value;
        this.termsCharges = termsCharges_value;
        this.newContractPayment = newContractPayment_value;
        this.cutOffDate = cutOffDate_value;
        this.fundingdate = fundingdate_value;
        this.fundingAmount = fundingAmount_value;
        this.legalEntityCode = legalEntityCode_value;
        this.legalEntity = legalEntity_value;
        this.sellerCode = sellerCode_value;
        this.outstandingBalanceLME = outstandingBalanceLME_value;
        this.outstandingBalanceLME_M1 = outstandingBalanceLME_M1_value;
        this.unearnedIncomeLME = unearnedIncomeLME_value;
        this.unearnedIncomeLME_M1 = unearnedIncomeLME_M1_value;
        this.GSTOutstandingBalanceLME = GSTOutstandingBalanceLME_value;
        this.GSTOutstandingBalanceLME_M1 = GSTOutstandingBalanceLME_M1_value;
        this.arrearsDateLME = arrearsDateLME_value;
        this.currentArrearsLME = currentArrearsLME_value;
        this.arrears30DaysLME = arrears30DaysLME_value;
        this.arrears60DaysLME = arrears60DaysLME_value;
        this.arrears90DaysLME = arrears90DaysLME_value;
        this.arrears120DaysLME = arrears120DaysLME_value;
        this.arrears150PlusDaysLME = arrears150PlusDaysLME_value;
        this.outstandingBalance = outstandingBalance_value;
        this.unexpiredInterest = unexpiredInterest_value;
        this.GSTOutstanding = GSTOutstanding_value;
        this.theoreticalPrincipal = theoreticalPrincipal_value;
        this.maxLimit = maxLimit_value;
        this.PDIOutstanding = PDIOutstanding_value;
        this.totalArrears = totalArrears_value;
        this.currentArrears = currentArrears_value;
        this.arrears30Days = arrears30Days_value;
        this.arrears60Days = arrears60Days_value;
        this.arrears90Days = arrears90Days_value;
        this.arrears120PlusDays = arrears120PlusDays_value;
        this.oldestDueDate = oldestDueDate_value;
        this.productCode = productCode_value;
        this.interestType = interestType_value;
        this.dealerCode = dealerCode_value;
        this.dealerName = dealerName_value;
        this.paidOutWrittenOffFlag = paidOutWrittenOffFlag_value;
        this.paidOutWrittenOffDate = paidOutWrittenOffDate_value;
        this.monthlyRental = monthlyRental_value;
        this.paymentFrequency = paymentFrequency_value;
        this.term = term_value;
        this.monthsExpired = monthsExpired_value;
        this.termsRemaining = termsRemaining_value;
        this.interestRate = interestRate_value;
        this.principalBalanceLME_M1 = principalBalanceLME_M1_value;
        this.principalBalance = principalBalance_value;
        this.newFundingAmount = newFundingAmount_value;
        this.groupExposureLLS_exclRTR = groupExposureLLS_exclRTR_value;
        this.groupExposureOther = groupExposureOther_value;
        this.advanceRate = advanceRate_value;
        this.rtraa = rtraa_value;
        this.cappedRtraa = cappedRtraa_value;
        this.adjustmentRate = adjustmentRate_value;
        this.advanceAmount = advanceAmount_value;
        this.creditEnchancement = creditEnchancement_value;
        this.adjustedExposure = adjustedExposure_value;
        this.newCutoffDate = newCutoffDate_value;
        this.Transactions = Transactions_value;



        
		
	}
	
}
