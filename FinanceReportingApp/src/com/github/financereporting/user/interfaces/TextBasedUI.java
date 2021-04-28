package com.github.financereporting.user.interfaces;


import com.github.financereporting.app.*;


import jamiesullivan.packages.code.userinterface.*;
public class TextBasedUI {
	
	
	/**
	 * Prints a line and then calls on a main function to exit the program
	 */
	private static void exitProgram() {
		System.out.println("Exiting Program...");
		Main.exitProgramSuccess();
	}
	
	
	/**
	 * Create the initial menu which the user uses to make an initial selection regarding what they would like to do
	 */
	private static void initialMenu() throws Exception {
		boolean exit = false;
		
		while (!exit) {		
			//Get any warnings that have been generated previously and show them to warn the user about any action they might ened to take
			if (Warning.getAttentionRequiredFlag()) { System.out.println(Warning.getAttentionRequiredMessage()); }
			
			//These will be the initial selections for the menu
			String[] initialMenuArray = {"Run Funding Process", "Modify Configuration Settings", "Exit"};
			int result = UserInterfaceMenu.createMenu(initialMenuArray, Config.getName() + " Menu. Please choose an action below:", "Make your selection: ");
			
			//Checking what the user has inputed and doing actions accordingly
			if (result == 1) { //Run funding process 
				FundingProcessUI.initializeFundingUI();
			} else if (result == 2) { //Modify configuration settings
				EditConfigurationUI.initializeConfigurationUI();
			} else if (result == 3) {
				exit = true ;
			}
			
			
		}
		System.out.println("EXIT");
		
		
		//Exit program once the loop has ended
		exitProgram();
	}
	
	
	/**
	 * Initialize the text based user interface which the user will use to interact with the program
	 * Ensure all configuration settings have been set previously
	 */
	public static void initializeUI()  throws Exception {
		initialMenu();

	}
	
	
}
