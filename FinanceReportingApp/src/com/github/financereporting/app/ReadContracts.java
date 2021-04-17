package com.github.financereporting.app;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import jamiesullivan.packages.code.*;
public class ReadContracts{
	

	/**
	 * Reads contracts from the contracts file (requires the file mappings and other configuration settings to be extracted first)
	 * 
	 */
	public static void readContracts() {
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
				Log.logInfo("Successfully read a contract file from " + path);
			} catch (FileNotFoundException e) {
				Warning.addAttentionRequiredMessage("File not found error: '" + path + "' does not exist");
			}
		}
		
		
	}
}
