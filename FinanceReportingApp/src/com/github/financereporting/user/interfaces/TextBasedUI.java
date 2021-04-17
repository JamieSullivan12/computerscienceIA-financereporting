package com.github.financereporting.user.interfaces;

import java.util.Objects;
import com.github.financereporting.app.*;

import jamiesullivan.packages.code.*;

public class TextBasedUI {
	
	

	
	
	private static String divider() {
		String divider = "------------------------------------\n";
		return divider;
	}
	
	
	private static String showMenu(String[] menuHeadings, String message) {
		String menuString = "";
		
		menuString += divider();
		if (!Objects.isNull(message) && !message.equals("")) {
			menuString += message + "\n\n";
		}

		
		
		int i = 0;
		while (i < menuHeadings.length) {
			menuString += "\t>> (" + (i+1) + ") " + menuHeadings[i] + '\n';
			i = i + 1;
		}
		
		
		
		return menuString;	
	}
	
	/**
	 * Method creates a menu which is printed onto the screen
	 * @param menuOptions		The options which the menu needs to show (in a String array)
	 * @param menuName			The name/title of the menu - Is shown when printed
	 * @param menuMessage		The message which is shown where the user needs to input a number
	 * @return 
	 */
	private static int createMenu(String[] menuOptions, String menuName, String menuMessage) {
		int numberOfSelections = menuOptions.length; //Used to verify the user has types a correct input
		int intUserInput; //Converted string input is inserted into here
		
		//Printing the menu using another function (with a divider at the start)
		System.out.println(showMenu(menuOptions, menuName));
		String userInput = ScannerInput.stringInput(menuMessage); //Scanner input used to retrieve user input

		//Attempting to convert the input to an integer (which is used to check if the input is valid or not)
		try {
			intUserInput = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			//If it is 0, the program will know that the input is wrong and make the user try again
			intUserInput = 0;
		}
		
		//While input is invalid
		while (intUserInput > numberOfSelections || intUserInput <= 0) {
			//Show the menu
			System.out.println(showMenu(menuOptions, "Invalid Input: " + menuName) );
			userInput = ScannerInput.stringInput(menuMessage); //Scanner input used to retrieve user input
			//Attempt converting to integer
			try {
				intUserInput = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				intUserInput = 0;
			}
			
		}
		
		//Once the input is valid, close the menu with a divider and return the integer value
		System.out.println(divider());
		return intUserInput;
		
		
		
		
		
	}
	
	private static void exitProgram() {
		System.out.println("Exiting Program...");
		Main.exitProgramSuccess();
	}
	
	
	private static void initialMenu() {
		String[] initialMenuArray = {"Run Funding Process", "Modify Configuration Settings", "Exit"};
		int result = createMenu(initialMenuArray, Config.getName() + " Menu. Please choose an action below:", "Make your selection: ");
		if (result == 0) { //Run funding process 
			FundingProcessUI.initializeFundingUI();
		} else if (result == 1) { //Modify configuration settings
			EditConfigurationUI.initializeConfigurationUI();
		} else if (result == 2) {
			exitProgram();
		}
	}
	
	public static void initializeUI() {
		initialMenu();

	}
	
	
}
