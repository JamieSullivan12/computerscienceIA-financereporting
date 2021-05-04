package com.github.financereporting.app;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

import jamiesullivan.packages.code.*;
public class ReadContracts{
	
	
	
	
	private static LinkedHashMap<String, LinkedHashMap<String, String>> contractItems;
	

	
	
	
	/**
	 * Reads contracts from the contracts file (requires the file mappings and other configuration settings to be extracted first)
	 * 
	 */
	public static void readContracts() {
		ArrayList<ArrayList<String>> contractDataArray = new ArrayList<ArrayList<String>>();
		
		String individualContractFileName;
		String path;
		
		String disincludedCharacters = "$"; //The characters in the excel file which must be ignored or else they may break the program
		
		
		
		contractItems = fileMappings.getContractMappings();

		//Looping through each contract file name from the config file (because the user may have given more than one contracts file if they have two data sources)
		for (var i=0; i < Config.getContractFileNamesFunding().length; i++) {
			

			
			individualContractFileName = Config.getContractFileNamesFunding()[i];
			//Merging the directory and file name into a single path
			//Trim removes any whitespace around the variables
			path = Config.getDefaultInputDirectoryFunding().trim() + "/" + individualContractFileName.trim(); 
			
			//Reading the file from that path - passing an exception if the file couldnt be found
			try {
				contractDataArray.addAll(ReadCSV.initReadCSV(path, disincludedCharacters));
				
				
				ArrayList<String> headings = contractDataArray.get(0);

				for (var g=0; g < headings.size(); g++) {
					final int j = g;

					for (String key : contractItems.keySet())
					{
						//System.out.println(contractItems.get(key).get("map"));
						if (!Objects.isNull(contractItems.get(key).get("map")) && !Objects.isNull(headings.get(j))) {
							//System.out.println(contractItems.get(key).get("map").toString());
							//System.out.println(headings.get(j).toString().replaceAll("^\"|\"$", ""));

							if( contractItems.get(key).get("map").toString().equals(headings.get(j).toString().replaceAll("^\"|\"$", ""))) {
								contractItems.get(key).put("index", Integer.toString(j));
								System.out.println(contractItems.get(key) + " " + contractItems.get(key).get("index"));
							}
						}
						
					};
				}
		
				Log.logInfo("Successfully read a contract file from " + path);
			} catch (FileNotFoundException e) {
				Warning.addAttentionRequiredMessage("File not found error: '" + path + "' does not exist");
			}
			
		
		}
		
		
		
	}
}
