package com.github.financereporting.user.interfaces;

import java.util.Objects;
import com.github.financereporting.app.*;

import jamiesullivan.packages.code.*;
import jamiesullivan.packages.code.userinterface.*;
public class TextBasedUI {
	
	

	
	

	
	
	
	
	private static void exitProgram() {
		System.out.println("Exiting Program...");
		Main.exitProgramSuccess();
	}
	
	
	private static void initialMenu() {
		String[] initialMenuArray = {"Run Funding Process", "Modify Configuration Settings", "Exit"};
		int result = UserInterfaceMenu.createMenu(initialMenuArray, Config.getName() + " Menu. Please choose an action below:", "Make your selection: ");
		if (result == 1) { //Run funding process 
			FundingProcessUI.initializeFundingUI();
		} else if (result == 2) { //Modify configuration settings
			EditConfigurationUI.initializeConfigurationUI();
		} else if (result == 3) {
			exitProgram();
		}
	}
	
	public static void initializeUI() {
		initialMenu();

	}
	
	
}
