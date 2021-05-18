package com.github.financereporting.app;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

import com.github.financereporting.logic.Contracts;

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

				
				for (int g=0; g < headings.size(); g++) {
					final int j = g;

					Object[] keyset = contractItems.keySet().toArray();
					for (int k = 0; k < keyset.length; k++)
					{
						
						if (!Objects.isNull(contractItems.get(keyset[k]).get("map")) && !Objects.isNull(headings.get(j))) {
								
							if( contractItems.get(keyset[k]).get("map").toString().replaceAll("\\n",",").trim().equals(headings.get(j).toString().replaceAll("^\"|\"$", "").replaceAll("\\n","").trim())) {
								contractItems.get(keyset[k]).put("index", Integer.toString(j));
								
	
							}
						} else {

						}
						
					}
				}

				
		
				Log.logInfo("Successfully read a contract file from " + path);
			
			} catch (FileNotFoundException e) {
				Warning.addAttentionRequiredMessage("File not found error: '" + path + "' does not exist");
			
			} catch (Exception f) {
				f.printStackTrace();
			}
			
		
		}
		Contracts[] contracts = new Contracts[contractDataArray.size()-1];
		
		for (int j=0; j < contractDataArray.size(); j++) {
			//System.out.println(contractDataArray.get(j).get(Integer.parseInt(contractItems.get("contractNumber").get("index"))));
			//System.out.println(contractItems.get("contractNumber").get("map"));
			if(!contractDataArray.get(j).get(Integer.parseInt(contractItems.get("contractNumber").get("index"))).replaceAll("^\"|\"$", "").trim().equals(contractItems.get("contractNumber").get("map").replaceAll("^\"|\"$", "").trim())) {
				//System.out.println(contractDataArray.get(j).get(0));
				contracts[j-1] = new Contracts(j-1);
				//System.out.println(g);
				//System.out.println(contractDataArray.get(g));
				contracts[j-1].fillValues(contractDataArray.get(j), contractItems);
				

			} 

		}

		
		
	}
}
