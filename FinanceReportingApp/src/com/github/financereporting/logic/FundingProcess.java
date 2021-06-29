package com.github.financereporting.logic;

import jamiesullivan.packages.code.*;

import java.awt.List;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.financereporting.app.Config;
import com.github.financereporting.app.Log;
import com.github.financereporting.app.Main;
import com.github.financereporting.app.ReadContracts;

public class FundingProcess {
	
	public static void initialize() {
		ArrayList<String[]> dataLines = new ArrayList<>();
		String path = Config.getDefaultOutputDirectoryFunding().trim() + "/" + "poolcut.csv".trim(); 
		
		Contracts[] contracts = ReadContracts.readContracts();
		for (var i=0; i < contracts.length; i ++) {
			if (!Objects.isNull(contracts[i])) {
				
				Contracts c = contracts[i];

				calculatePrincipalBalance(c);
				calculateNewFundingAmount(c);
				calculateNewCutoffDate(c);
				
				
				dataLines.add(new String[] {String.valueOf(c.getContractNumber()), String.valueOf(c.getContractDate()), String.valueOf(c.getPrincipalInvoicePriceTotalRep()), String.valueOf(c.getBrokerageStampDutyAgreeFee()), String.valueOf(c.getOtherCharges()), String.valueOf(c.getCutOffDate()), String.valueOf(c.getFundingDate()), String.valueOf(c.getFundingAmount()), String.valueOf(c.getLegalEntityCode()), String.valueOf(c.getSellerCode()), String.valueOf(c.getOutstandingBalanceLME_M1()), String.valueOf(c.getUnearnedIncomeLME_M1()), String.valueOf(c.getGSTOutstandingBalanceLME_M1()), String.valueOf(c.getOutstandingBalance()), String.valueOf(c.getUnexpiredInterest()), String.valueOf(c.getGSTOutstanding()), String.valueOf(c.getPaidOutWrittenOffFlag()), String.valueOf(c.getCurrentPrincipalBalance()), String.valueOf(c.getNewFundingAmount()), String.valueOf(c.getNewCutoffDate())}); 
				
				
			}
		}
		
		ConvertToCSV CSVconverter = new ConvertToCSV();
		ArrayList<String> csvFormat = CSVconverter.convertToCSV(dataLines);


		try {
			CSVconverter.givenDataArray_whenConvertToCSV_thenOutputCreated(path,csvFormat);
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
		if ( date1.getMonthValue() == date2.getMonthValue() &&  date1.getYear() == date2.getYear()) {
			return true;
		} else {
			return false;
		}
	}
		
}

