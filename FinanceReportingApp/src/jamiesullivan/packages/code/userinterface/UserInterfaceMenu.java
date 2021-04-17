package jamiesullivan.packages.code.userinterface;

import java.util.Objects;

import jamiesullivan.packages.code.ScannerInput;

public class UserInterfaceMenu {
	private static String showMenu(String[] menuHeadings, String message) {
		String menuString = "";
		
		menuString += Divider.get();
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
	public static int createMenu(String[] menuOptions, String menuName, String menuMessage) {
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
		System.out.println(Divider.get());
		return intUserInput;
		
		
		
		
		
	}
}
