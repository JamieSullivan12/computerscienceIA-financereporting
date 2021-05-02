package com.github.financereporting.logic;
import java.util.Date;


public class Contracts {
	
	
	private String ContractNumber_value;
	private String CustomerCode_value;
	private String LargeLongstandingClient_value;
	private int CustomerPostalCode_value;
	private String OcupationCode_value;
	private String OccupationDescription_value;
	private Date ContractDate;
	private Date ExpiryDate;
	private double PrincipalInvoicePriceTotalRep_value;
	private double Brokerage_StampDuty_AgreeFee_value;
	private double OtherCharges_value;
	private double TermsCharges_value;
	private double NewContractPayment_value;
	private Date CutOffDate;
	private Date FundingDate;
	private double FundingAmount_value;
	private int LegalEntityCode_value;
	private String LegalEntity_value;
	private int seller_code_value;
	private double OutstandingBalance_lastMonthEnd_value;
	private double OutstandingBalance_lastMonthEnd_minus1_value;
	private double UnearnedIncome_lastMonthEnd_value;
	private double UnearnedIncome_lastMonthEnd_minus1_value;
	private double GST_outstandingBalance_lastMonthEnd_value;
	private double GST_outstandingBalance_lastMonthEnd_minus1_value;
	private Date Arrears_date_lastMontEnd_value;
	private double Current_arrears_lastMonthEnd_value;
	private double Arrears_30_days_lastMonthEnd_value;
	private double Arrears_60_days_lastMonthEnd_value;
	private double Arrears_90_days_lastMonthEnd_value;
	private double Arrears_120_days_lastMonthEnd_value;
	private double Arrears_150plus_days_lastMonthEnd_value;
	private double OutstandingBalance_value;
	private double UnexpiredInterest_value;
	private double GST_Outstanding_value;
	private double TheoreticalPrincipal_value;
	private double MaxLimit_value;
	private double PDI_Outstanding_value;
	private double TotalArrears_value;
	private double CurrentArrears_value;
	private double Arrears_30_Days_value;
	private double Arrears_60_Days_value;
	private double Arrears_90_Days_value;
	private double Arrears_120plus_Days_value;
	private Date OldestDueDate;
	private String ProductCode_value;
	private String InterestType_value;
	private String DealerCode_value;
	private String DealerName_value;
	private String PaidOutWrittenOff_Flag_value;
	private Date PaidOutWrittenOff_date;
	private double MonthlyRental_value;
	private String PaymentFrequency_value;
	private int Term_value;
	private int MonthsExpired_value;
	private int TermRemaining_value;
	private double InterestRate_value;

	private String PrincipalBalance_LastMonthEnd_minus1_value;
	private String PrincipalBalance_value;
	private String newFundingAmount_value;
	private String GroupExposure_LLS_excl_RTR_value;
	private String GroupExposure_other_value;
	private String advanceRate_value;
	private String rtraa_value;
	private String cappedRtraa_value;
	private String adjustmentRate_value;
	private String advanceAmount_value;
	private String creditEnchancement_value;
	private String adjustedExposure_value;
	private String newcutoffdate_value;
	private String Transactions_value;


	public static void main(String[] args) {

	}


		
	public void setValues(String ContractNumber, String CustomerCode, 
			String LargeLongstandingClient, int CustomerPostalCode, 
			String OcupationCode, String OccupationDescription, Date ContractDate, 
			Date ExpiryDate, double PrincipalInvoicePriceTotalRep, double Brokerage_StampDuty_AgreeFee, 
			double OtherCharges, double TermsCharges, double NewContractPayment, 
			Date CutOffDate, Date FundingDate, double FundingAmount, int LegalEntityCode, 
			String LegalEntity, int seller_code, double OutstandingBalance_lastMonthEnd, 
			double OutstandingBalance_lastMonthEnd_minus1, double UnearnedIncome_lastMonthEnd, 
			double UnearnedIncome_lastMonthEnd_minus1, double GST_outstandingBalance_lastMonthEnd, 
			double GST_outstandingBalance_lastMonthEnd_minus1, Date Arrears_date_lastMontEnd, 
			double Current_arrears_lastMonthEnd, double Arrears_30_days_lastMonthEnd, 
			double Arrears_60_days_lastMonthEnd, double Arrears_90_days_lastMonthEnd, 
			double Arrears_120_days_lastMonthEnd, double Arrears_150plus_days_lastMonthEnd, 
			double OutstandingBalance, double UnexpiredInterest, double GST_Outstanding, 
			double TheoreticalPrincipal, double MaxLimit, double PDI_Outstanding, 
			double TotalArrears, double CurrentArrears, double Arrears_30_Days, 
			double Arrears_60_Days, double Arrears_90_Days, double Arrears_120plus_Days, 
			Date OldestDueDate, String ProductCode, String InterestType, String DealerCode, 
			String DealerName, String PaidOutWrittenOff_Flag, Date PaidOutWrittenOff_date, 
			double MonthlyRental, String PaymentFrequency, int Term, int MonthsExpired, 
			int TermRemaining, double InterestRate, String PrincipalBalance_LastMonthEnd_minus1, 
			String PrincipalBalance, String newFundingAmount, String GroupExposure_LLS_excl_RTR, 
			String GroupExposure_other, String advanceRate, String rtraa, String cappedRtraa, 
			String adjustmentRate, String advanceAmount, String creditEnchancement, 
			String adjustedExposure, String newcutoffdate, String Transactions
			
			
			
			) {
        
    	
    	
    	

        
        

        
        
        
        this.ContractNumber_value = ContractNumber;
        this.CustomerCode_value = CustomerCode;
        this.LargeLongstandingClient_value = LargeLongstandingClient;
        this.CustomerPostalCode_value = CustomerPostalCode;
        this.OcupationCode_value = OcupationCode;
        
        //This later needs to be moved to an addons file
        if (OccupationDescription.toLowerCase().equals("to be advised")){
            this.OccupationDescription_value = "Consumer Rentals";
        } else {
            OccupationDescription_value = OccupationDescription_value;
        }
        
        this.ContractDate = Contra;
        this.ExpiryDate = Expi;
        this.PrincipalInvoicePriceTotalRep_value = PrincipalInvoicePriceTotalRep;
        this.Brokerage_StampDuty_AgreeFee_value = Brokerage_StampDuty_AgreeFee;
        this.OtherCharges_value = OtherCharges;
        this.TermsCharges_value = TermsCharges;
        this.NewContractPayment_value = NewContractPayment;
        this.CutOffDate = CutO;
        this.FundingDate = Fundi;
        this.FundingAmount_value = FundingAmount;
        this.LegalEntityCode_value = LegalEntityCode;
        this.LegalEntity_value = LegalEntity;
        this.seller_code_value = seller_code;
        this.OutstandingBalance_lastMonthEnd_value = OutstandingBalance_lastMonthEnd;
        this.OutstandingBalance_lastMonthEnd_minus1_value = OutstandingBalance_lastMonthEnd_minus1;
        this.UnearnedIncome_lastMonthEnd_value = UnearnedIncome_lastMonthEnd;
        this.UnearnedIncome_lastMonthEnd_minus1_value = UnearnedIncome_lastMonthEnd_minus1;
        this.GST_outstandingBalance_lastMonthEnd_value = GST_outstandingBalance_lastMonthEnd;
        this.GST_outstandingBalance_lastMonthEnd_minus1_value = GST_outstandingBalance_lastMonthEnd_minus1;
        this.Arrears_date_lastMontEnd_value = Arrears_date_lastMontEnd;
        this.Current_arrears_lastMonthEnd_value = Current_arrears_lastMonthEnd;
        this.Arrears_30_days_lastMonthEnd_value = Arrears_30_days_lastMonthEnd;
        this.Arrears_60_days_lastMonthEnd_value = Arrears_60_days_lastMonthEnd;
        this.Arrears_90_days_lastMonthEnd_value = Arrears_90_days_lastMonthEnd;
        this.Arrears_120_days_lastMonthEnd_value = Arrears_120_days_lastMonthEnd;
        this.Arrears_150plus_days_lastMonthEnd_value = Arrears_150plus_days_lastMonthEnd;
        this.OutstandingBalance_value = OutstandingBalance;
        this.UnexpiredInterest_value = UnexpiredInterest;
        this.GST_Outstanding_value = GST_Outstanding;
        this.TheoreticalPrincipal_value = TheoreticalPrincipal;
        this.MaxLimit_value = MaxLimit;
        this.PDI_Outstanding_value = PDI_Outstanding;
        this.TotalArrears_value = TotalArrears;
        this.CurrentArrears_value = CurrentArrears;
        this.Arrears_30_Days_value = Arrears_30_Days;
        this.Arrears_60_Days_value = Arrears_60_Days;
        this.Arrears_90_Days_value = Arrears_90_Days;
        this.Arrears_120plus_Days_value = Arrears_120plus_Days;
        this.OldestDueDate = OldestD;
        this.ProductCode_value = ProductCode;
        this.InterestType_value = InterestType;
        this.DealerCode_value = DealerCode;
        this.DealerName_value = DealerName;
        this.PaidOutWrittenOff_Flag_value = PaidOutWrittenOff_Flag;
        this.PaidOutWrittenOff_date = PaidOutWrittenOff_date;
        this.MonthlyRental_value = MonthlyRental;
        this.PaymentFrequency_value = PaymentFrequency;
        this.Term_value = Term;
        this.MonthsExpired_value = MonthsExpired;
        this.TermRemaining_value = TermRemaining;
        this.InterestRate_value = InterestRate;

        this.PrincipalBalance_LastMonthEnd_minus1_value = PrincipalBalance_LastMonthEnd_minus1;
        this.PrincipalBalance_value = PrincipalBalance;
        this.newFundingAmount_value = newFundingAmount;
        this.GroupExposure_LLS_excl_RTR_value = GroupExposure_LLS_excl_RTR;
        this.GroupExposure_other_value = GroupExposure_other;
        this.advanceRate_value = advanceRate;
        this.rtraa_value = rtraa;
        this.cappedRtraa_value = cappedRtraa;
        this.adjustmentRate_value = adjustmentRate;
        this.advanceAmount_value = advanceAmount;
        this.creditEnchancement_value = creditEnchancement;
        this.adjustedExposure_value = adjustedExposure;
        this.newcutoffdate_value = newcutoffdate;
        this.Transactions_value = Transactions;



        
		
	}
	
}
