package jamiesullivan.packages.code.userinterface;

import java.util.Objects;



import jamiesullivan.packages.code.ScannerInput;

public class UserInterfaceMenu {
	
	/**
	 * Does some basic actions which print the menu heading and options onto the screen
	 * @param heading		The heading of the menu (will be printed on top)
	 * @param options		The options in String[] format. There may be as many or as little as needed
	 * @return				A string containing the entire menu (with appropriate new lines \n and tabs \t where needed
	 */
	private static String showMenu(String[] options, String heading) {
		String menuString = "";
		
		menuString += Divider.get();
		
		if (!Objects.isNull(heading) && !heading.equals("")) {
			menuString += heading + "\n\n";
		}

		
		
		int i = 0;
		while (i < options.length) {
			if ( options[i] != null) {
			menuString += "\t>> (" + (i+1) + ") " + options[i] + '\n';
			
			}
			i = i + 1;
		}
		
		
		
		return menuString;	
	}
	
	/**
	 * Creates a menu which is printed onto the screen. The menu uses number selections. It will loop until the user enters a valid number
	 * @param options		The options which the menu will show in the format: (0).... (1).... Note that the numbers are generated automatically and that the string array simply needs to have the names of the options
	 * @param heading		The heading/title of the menu - Is shown on top when printed. Required to be filled in
	 * @param message		The message which is shown where the user needs to input a number. NOTE instructions are already printed for the user so this field may be left blank
	 * @return 				The integer value indicating the selection from the user
	 */
	public static int createMenu(String[] options, String heading, String message) {

		int intUserInput; //Converted string input is inserted into here

		
		//Prints the menu (see showMenu method description for more information)
		System.out.println(showMenu(options, heading));
		
		//Retrieving the users input (passes a message and returns a String value)
		String userInput = ScannerInput.stringInput(message);

		//Attempting to convert the input to an integer (which is used to check if the input is valid or not)
		try {
			intUserInput = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			//If it is 0, the program will know that the input is wrong and make the user try again
			intUserInput = 0;
		}
		
		//While input is invalid
		while (intUserInput > options.length || intUserInput <= 0) {
			//Show the menu
			System.out.println(showMenu(options, "Invalid Input: " + heading) );
			userInput = ScannerInput.stringInput(message); //Scanner input used to retrieve user input
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
