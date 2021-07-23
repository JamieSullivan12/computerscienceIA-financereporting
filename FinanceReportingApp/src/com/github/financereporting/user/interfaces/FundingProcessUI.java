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
					System.out.println("\nInitialising Funding Process\nPlease wait...");
					FundingProcess.initialize(settlementDate);
					System.out.println("Funding Process complete.");
				} catch (IllegalArgumentException e) {
					System.out.println("Aborting Funding Process\n");
					System.out.println(e.getMessage());
				}
			} else {System.out.println("INVALID DATE");}
		}

		
	}
}
