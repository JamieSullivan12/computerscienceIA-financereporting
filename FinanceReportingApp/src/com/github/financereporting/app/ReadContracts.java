package com.github.financereporting.app;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import jamiesullivan.packages.exceptions.*;
import jamiesullivan.packages.code.*;
public class ReadContracts{
	
	private static void loggerSuccessMessage(String message) {
		Log.logInfo(message);
	}
	
	
	//Throw a file not foung error if the ReadCSV method throws one
	private static void fileNotFound(String path) throws ExitStatus1Exception {
		throw new ExitStatus1Exception("FILE NOT FOUND ERROR; '" + path + "'; the file and/or folder does not exist. Please change the directory in the default directory and try again");
	}
	
	
	public static void readContracts() throws ExitStatus1Exception{
		ArrayList<ArrayList<String>> contractDataArray = new ArrayList<ArrayList<String>>();
		
		String individualContractFileName;
		String path;
		
		String disincludedCharacters = "$"; //The characters in the excel file which must be ignored or else they may break the program
		
		
		//Looping through each contract file name from the config file (because the user may have given more than one contracts file if they have two data sources)
		for (var i=0; i < Config.getContractFileNamesFunding().length; i++) {
			individualContractFileName = Config.getContractFileNamesFunding()[i];
			//Merging the directory and file name into a single path
			//Trim removes any whitespace around the variables
			path = Config.getDefaultInputDirectoryFunding().trim() + "/" + individualContractFileName.trim(); 
			
			//Reading the file from that path - passing an exception if the file couldnt be found
			try {
				contractDataArray.addAll(ReadCSV.initReadCSV(path, disincludedCharacters));
				loggerSuccessMessage("Successfully read a contract file from " + path);
			} catch (FileNotFoundException e) {
				fileNotFound(path);
			}
		}
		
		
	}
}
