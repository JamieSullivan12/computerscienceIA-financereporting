package jamiesullivan.packages.code;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  


public class ReadCSV {
	
	/**
	 * Method checks if a character is valid to be added to the filtered line (see the init method below for more information)
	 * @param character		The character being checked
	 * @param toggleQuotes		A boolean value indicating whether this character is surrounded in quotes (see init method below for more information about what this means in a CSV file)
	 * @param disincludedCharacters		A list of characters which must be removed because they may break the program
	 * @return
	 */
	private static boolean addCharacterToNewLine(String character, boolean toggleQuotes, String disincludedCharacters ) {
		boolean addCharacter = true;
		
		if (disincludedCharacters.contains(character)) {
			addCharacter = false;
		}
		
		if (character.equals(",")) {  //Checking if the character is a comma, and acting accordingly to the quote toggle
	    	if (toggleQuotes) {
	    		//If the comma IS NOT used to split values, do not add to the string - these commas are useless information when it comes to parsing numbers, and may break the program
	    		addCharacter = false;
	    	} else {
		    	//If the comma IS used to split values, include the comma in the string because it will later be used to split the line string into a list
		    	addCharacter = true;
		    }
		}
		return addCharacter;
	}
	
	
	/**
	 * 
	 * Method reads a CSV file (from a given path), calls on other methods to format the result, loads the file into an array list within an array list and returns it
	 * 
	 * @param path		The path of the file being read
	 * @return ArrayList<ArrayList<String>> fileList: 
	 * 				A list of lists of each line in the CSV file. Each line is its own list (with each new field being a new column seperated by columns)
	 * 				This list is then saved into the master fileList which is later returned to the caller
	 * 
	 * @throws FileNotFoundException		If there is an invalid file path, warn the user by throwing an excpetion
	 */
	public static ArrayList<ArrayList<String>> initReadCSV(String path, String disincludedCharacters) throws FileNotFoundException {
		ArrayList<ArrayList<String>> fileList = new ArrayList<ArrayList<String>>();
		
		

		
		//Ensure fileName has a .csv identifier on the end
		if (!path.contains(".csv")) {
			path.concat(".csv");
		}
		
		//parsing a CSV file into Scanner class constructor  
		Scanner fileScanner;

		fileScanner = new Scanner(new File(path));

		
		fileScanner.useDelimiter("\n");   //Splits the string up into sections, each section being a line in the CSV
		
		
		
		while (fileScanner.hasNext()) { //Loops through each line in the file
		  
			//In a CSV file, quotes mean there is a comma that does NOT count as a seperator. The entire field will be surrounded by quotes, thus requiring a toggle
			boolean toggleQuotes = false; 
			
			//Load the next line into a variable
			String nextLine = fileScanner.next();
			
			//The new line is loaded with each useful character from the original line. See below
			String newLine = "";
			
			//Loops through each character in the line
			for (int i = 0; i < nextLine.length(); i++){
			    String character = String.valueOf(nextLine.charAt(i));  //Gets the character as a string
			    
			    
			    //Checking if the character is a double quote ("). The \ is there because double quotes are also used to identify a string
			    if (character.equals("\"")) {
			    	//Flip the quote toggle
			    	if (!toggleQuotes) { toggleQuotes = true; }
			    	else { toggleQuotes = false; }
			    } 
			    
			    
			    if (addCharacterToNewLine(character, toggleQuotes, disincludedCharacters)) {
			    	//Add the character to the newline the method returns true
			    	newLine += character;
			    }  else {
			    	//DO NOTHING
			    }
			    
			}
			
			//Creating the array of the line (splitting the commas for each list field)
			ArrayList<String> newLineList = new ArrayList<String>(Arrays.asList(newLine.split("\\s*,\\s*")));
			//Adding this list to the file list (which has fields of all the lines)
			fileList.add(newLineList);
			
			
			
		}  
		
		fileScanner.close();  //closes the scanner 

		return fileList;
	}  
	

}
