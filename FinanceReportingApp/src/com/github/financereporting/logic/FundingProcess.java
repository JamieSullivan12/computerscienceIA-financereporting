package com.github.financereporting.logic;

import jamiesullivan.packages.code.*;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

import com.github.financereporting.app.Config;
import com.github.financereporting.app.Log;
import com.github.financereporting.app.Main;
import com.github.financereporting.app.ReadContracts;
import com.github.financereporting.app.fileMappings;

public class FundingProcess {
	
	public static void initialize(LocalDate settlementDate) throws IllegalArgumentException {
		
		Contracts[] contracts = ReadContracts.readContracts();
		if (contracts.length == 0) {
			throw new IllegalArgumentException ("No contract data was found");
		}
		
		LinkedHashMap<String, LinkedHashMap<String, String>> contractItems = fileMappings.getContractMappings();
		

		ArrayList<String[]> dataLinesPoolcut = new ArrayList<>();
		ArrayList<String[]> dataLinesOfferWholesale = new ArrayList<>();
		ArrayList<String[]> dataLinesOfferAsset = new ArrayList<>();
		ArrayList<String[]> dataLinesUploadWholesale = new ArrayList<>();
		ArrayList<String[]> dataLinesUploadAsset = new ArrayList<>();
		
		String formattedSettlementDate = settlementDate.format(DateTimeFormatter.ofPattern("yyMMdd"));
		
		String currentPrincipalHeading = "Current Principal Balance";
		String newFundingAmountHeading = "New Funding Amount";
		String newCutoffDateHeading = "New Cut Off Date";
		dataLinesPoolcut.add(new String[] {contractItems.get("contractNumber").get("map"), contractItems.get("contractDate").get("map"), contractItems.get("principalInvoicePriceTotalRep").get("map"), contractItems.get("brokerageStampDutyAgreeFee").get("map"), contractItems.get("otherCharges").get("map"), contractItems.get("cutOffDate").get("map"), contractItems.get("fundingDate").get("map"), contractItems.get("fundingAmount").get("map"), contractItems.get("legalEntityCode").get("map"), contractItems.get("sellerCode").get("map"), contractItems.get("outstandingBalanceLME_M1").get("map"), contractItems.get("unearnedIncomeLME_M1").get("map"), contractItems.get("GSTOutstandingBalanceLME_M1").get("map"), contractItems.get("outstandingBalance").get("map"), contractItems.get("unexpiredInterest").get("map"), contractItems.get("GSTOutstanding").get("map"), contractItems.get("paidOutWrittenOffFlag").get("map"), currentPrincipalHeading, newFundingAmountHeading, newCutoffDateHeading}); 		
		
		dataLinesOfferWholesale.add(new String[] {"Business","Cut-Off Date","Funding Date","Funding Amount","Contract Number"}); 		
		dataLinesOfferAsset.add(new String[] {"Business","Cut-Off Date","Funding Date","Funding Amount","Contract Number"}); 		
		dataLinesUploadWholesale.add(new String[] {"Contract Number","Funding Date","Funding Amount","Legal Entity","Cut Off Date","Seller Code"}); 		
		dataLinesUploadAsset.add(new String[] {"Contract Number","Funding Date","Funding Amount","Legal Entity","Cut Off Date","Seller Code"}); 		

		
		
		for (var i=0; i < contracts.length; i ++) {
			if (!Objects.isNull(contracts[i])) {
				
				Contracts c = contracts[i];

				calculatePrincipalBalance(c);
				calculateNewFundingAmount(c);
				calculateNewCutoffDate(c);
				
				if (c.getLegalEntityCode().equals("1")) {
					dataLinesOfferWholesale.add(new String[] { c.getLegalEntity().toString(), c.getNewCutoffDate().toString(), settlementDate.toString(), c.getNewFundingAmount().toString(), c.getContractNumber().toString()});
				
					String formattedNewCutoffDate = c.getNewCutoffDate().format(DateTimeFormatter.ofPattern("yyMMdd"));
					dataLinesUploadWholesale.add(new String[] { c.getContractNumber().toString(), formattedSettlementDate, c.getNewFundingAmount().toString(), "3", formattedNewCutoffDate, c.getSellerCode().toString()});

				
				}
				if (c.getLegalEntityCode().equals("2")) {
					dataLinesOfferAsset.add(new String[] { c.getLegalEntity().toString(), c.getNewCutoffDate().toString(), settlementDate.toString(), c.getNewFundingAmount().toString(), c.getContractNumber().toString()});
				
					String formattedNewCutoffDate = c.getNewCutoffDate().format(DateTimeFormatter.ofPattern("yyMMdd"));
					dataLinesUploadAsset.add(new String[] { c.getContractNumber().toString(), formattedSettlementDate, c.getNewFundingAmount().toString(), "3", formattedNewCutoffDate, c.getSellerCode().toString()});

				
				}
				
				
				
				
	
				
				
				dataLinesPoolcut.add(new String[] {String.valueOf(c.getContractNumber()), String.valueOf(c.getContractDate()), String.valueOf(c.getPrincipalInvoicePriceTotalRep()), String.valueOf(c.getBrokerageStampDutyAgreeFee()), String.valueOf(c.getOtherCharges()), String.valueOf(c.getCutOffDate()), String.valueOf(c.getFundingDate()), String.valueOf(c.getFundingAmount()), String.valueOf(c.getLegalEntityCode()), String.valueOf(c.getSellerCode()), String.valueOf(c.getOutstandingBalanceLME_M1()), String.valueOf(c.getUnearnedIncomeLME_M1()), String.valueOf(c.getGSTOutstandingBalanceLME_M1()), String.valueOf(c.getOutstandingBalance()), String.valueOf(c.getUnexpiredInterest()), String.valueOf(c.getGSTOutstanding()), String.valueOf(c.getPaidOutWrittenOffFlag()), String.valueOf(c.getCurrentPrincipalBalance()), String.valueOf(c.getNewFundingAmount()), String.valueOf(c.getNewCutoffDate())}); 
				
				
			}
		}
		
		ConvertToCSV CSVconverter = new ConvertToCSV();
		ArrayList<String> csvFormatPoolcut = CSVconverter.convertToCSV(dataLinesPoolcut);
		ArrayList<String> csvFormatOfferWholesale = CSVconverter.convertToCSV(dataLinesOfferWholesale);
		ArrayList<String> csvFormatOfferAsset = CSVconverter.convertToCSV(dataLinesOfferAsset);
		ArrayList<String> csvFormatUploadWholesale = CSVconverter.convertToCSV(dataLinesUploadWholesale);
		ArrayList<String> csvFormatUploadAsset = CSVconverter.convertToCSV(dataLinesUploadAsset);


		try {
			
			String path = Config.getDefaultOutputDirectoryFunding().trim() + "/" + "poolcut.csv".trim(); 
			CSVconverter.givenDataArray_whenConvertToCSV_thenOutputCreated(path,csvFormatPoolcut);
			
			
			path = Config.getDefaultOutputDirectoryFunding().trim() + "/" + "OfferWholesale.csv".trim(); 
			CSVconverter.givenDataArray_whenConvertToCSV_thenOutputCreated(path,csvFormatOfferWholesale);
			
			
			path = Config.getDefaultOutputDirectoryFunding().trim() + "/" + "OfferAsset.csv".trim();
			
			CSVconverter.givenDataArray_whenConvertToCSV_thenOutputCreated(path,csvFormatOfferAsset);
			
			
			path = Config.getDefaultOutputDirectoryFunding().trim() + "/" + "UploadWholesale.csv".trim(); 
			CSVconverter.givenDataArray_whenConvertToCSV_thenOutputCreated(path,csvFormatUploadWholesale);
			
			path = Config.getDefaultOutputDirectoryFunding().trim() + "/" + "UploadAsset.csv".trim(); 
			CSVconverter.givenDataArray_whenConvertToCSV_thenOutputCreated(path,csvFormatUploadAsset);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Calculates the newFundingAmount for a given Contracts object
	 * @param contract_obj
	 * @return 
	 */
	private static void calculateNewFundingAmount(Contracts c) {
		BigDecimal newFundingAmount = BigDecimal.ZERO;
		
		LocalDate current_date = Main.getCurDate();
		
		
		
		if ( checkSameMonth( current_date, c.getContractDate())) {
			
		
			if (RemoveQuotes.remove(c.getLegalEntityCode()).equals("1")) {
				
				if (RemoveQuotes.remove(Character.toString(c.getContractNumber().charAt(0))).equals("H")) {
					
					newFundingAmount = c.getPrincipalInvoicePriceTotalRep().add(c.getBrokerageStampDutyAgreeFee().add(c.getOtherCharges()));
				} else {
					newFundingAmount = c.getPrincipalInvoicePriceTotalRep().add(c.getBrokerageStampDutyAgreeFee().add(c.getOtherCharges())).multiply(BigDecimal.valueOf(1.1));
				}
			} else if (RemoveQuotes.remove(c.getLegalEntityCode()).equals("2")) {
				newFundingAmount = c.getPrincipalInvoicePriceTotalRep().add(c.getBrokerageStampDutyAgreeFee().add(c.getOtherCharges()));
			}
		
		} else {
			if (RemoveQuotes.remove(c.getLegalEntityCode()).equals("1") || RemoveQuotes.remove(c.getLegalEntityCode()).equals("2")) {
				newFundingAmount = c.getCurrentPrincipalBalanceLME_M1();
				
			}
		}
			
		if (RemoveQuotes.remove(c.getPaidOutWrittenOffFlag()).equals("W") || RemoveQuotes.remove(c.getPaidOutWrittenOffFlag()).equals("Y") || RemoveQuotes.remove(c.getPaidOutWrittenOffFlag()).equals("L")) {
			newFundingAmount = BigDecimal.valueOf(0);
		}

		
		
		
		
		
		try {
			c.setNewFundingAmount(newFundingAmount.setScale(2, RoundingMode.HALF_EVEN)) ;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Log.logWarning(e.getStackTrace().toString());
		}
		
	}
	
	
	private static void calculatePrincipalBalance(Contracts c) {
		
		BigDecimal currentPrincipalBalance = BigDecimal.ZERO;

		BigDecimal currentPrincipalBalanceLME_M1 = BigDecimal.ZERO;

		LocalDate current_date = Main.getCurDate();
		if (RemoveQuotes.remove(c.getPaidOutWrittenOffFlag()).equals("N")) {
			
			if (RemoveQuotes.remove(c.getSellerCode()).equals("1")) {
				
				if (checkSameMonth( current_date, c.getContractDate())) {
					
					if (RemoveQuotes.remove(Character.toString(c.getContractNumber().charAt(0))).equals("H")) {
						currentPrincipalBalance = c.getOutstandingBalance().subtract(c.getUnexpiredInterest().multiply(BigDecimal.valueOf(1.1)));
					} else {
						currentPrincipalBalance = c.getOutstandingBalance().subtract(c.getUnexpiredInterest());
					}
				} else {
					currentPrincipalBalance = c.getOutstandingBalance().subtract(c.getUnexpiredInterest()).subtract(c.getGSTOutstanding());
				}
				
			} else if (RemoveQuotes.remove(c.getSellerCode()).equals("2")) {
				currentPrincipalBalance = c.getOutstandingBalance().subtract(c.getUnexpiredInterest()).subtract(c.getGSTOutstanding());
			} else if (RemoveQuotes.remove(c.getSellerCode()).equals("3") || RemoveQuotes.remove(c.getSellerCode()).equals("4")) {
				currentPrincipalBalance = c.getOutstandingBalance();
			}
		}
		
		if (RemoveQuotes.remove(c.getSellerCode()).equals("1") || RemoveQuotes.remove(c.getSellerCode()).equals("2")) {
			currentPrincipalBalanceLME_M1 = c.getOutstandingBalance().subtract(c.getOutstandingBalanceLME_M1()).subtract(c.getUnearnedIncomeLME_M1()).subtract(c.getGSTOutstandingBalanceLME_M1());
		} else {
			currentPrincipalBalanceLME_M1 = c.getOutstandingBalanceLME_M1();
		}
		
		c.setCurrentPrincipalBalanceLME_M1(currentPrincipalBalanceLME_M1);
		c.setCurrentPrincipalBalance(currentPrincipalBalance);
		

	}

	
	private static void calculateNewCutoffDate(Contracts c) {
		LocalDate newCutoffDate = null;
		newCutoffDate = LocalDate.of(1, 1, 1);
		
		LocalDate currentDate = Main.getCurDate();
		
		if (checkSameMonth( currentDate, c.getContractDate())) {
			newCutoffDate = c.getContractDate();
			
		} else {
			LocalDate placeholder = currentDate.minusMonths(1);
			int lengthOfMonth = placeholder.lengthOfMonth();
			placeholder = placeholder.withDayOfMonth(lengthOfMonth);
			newCutoffDate = placeholder;
		}
		
		if (RemoveQuotes.remove(c.getLegalEntityCode()).equals("3") || RemoveQuotes.remove(c.getLegalEntityCode()).equals("4")  || RemoveQuotes.remove(c.getLegalEntityCode()).equals("5")) {
			newCutoffDate = LocalDate.of(1, 1, 1);
		}
		if (RemoveQuotes.remove(c.getPaidOutWrittenOffFlag()).equals("W") || RemoveQuotes.remove(c.getPaidOutWrittenOffFlag()).equals("Y") || RemoveQuotes.remove(c.getPaidOutWrittenOffFlag()).equals("L")) {
			newCutoffDate = LocalDate.of(1, 1, 1);
		}


		c.setNewCutoffDate(newCutoffDate);
		
	}

	private static boolean checkSameMonth(LocalDate date1, LocalDate date2) {	
		
		if (!Objects.isNull(date1) && !Objects.isNull(date2)) {
			if ( date1.getMonthValue() == date2.getMonthValue() &&  date1.getYear() == date2.getYear()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
		
}

