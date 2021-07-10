package com.github.financereporting.user.interfaces;

import java.time.LocalDate;
import java.util.Objects;

import jamiesullivan.packages.code.*;
import com.github.financereporting.logic.FundingProcess;

public class FundingProcessUI {
	public static void initializeFundingUI() {
		
		boolean valid = false;
		
		while (!valid) {
			String dateString = ScannerInput.stringInput("Please enter the settlement date in the form DD/MM/YYYY : ");
			LocalDate settlementDate = CreateLocalDateObjectFromString.createDate(dateString);
			if (!Objects.isNull(settlementDate)) {
				valid = true;
				try {
					FundingProcess.initialize(settlementDate);
				} catch (IllegalArgumentException e) {
					
					System.out.println(e.getMessage());
				}
			} else {System.out.println("INVALID DATE");}
		}

		
	}
}
