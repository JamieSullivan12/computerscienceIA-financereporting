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
	 * @return 
	 * 
	 */
	public static Contracts[] readContracts() {
		ArrayList<ArrayList<String>> contractDataArray = new ArrayList<ArrayList<String>>();
		
		String individualContractFileName;
		String path;
		
		String disincludedCharacters = "$"; //The "$" sign must be removed so the numbers can be used as numbers, not strings
		
		
		
		contractItems = fileMappings.getContractMappings();
		
		boolean error = false;
		
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

					boolean foundHeadingIndex = false;
					for (int k = 0; k < keyset.length; k++)
					{
						if (!Objects.isNull(contractItems.get(keyset[k]).get("map")) && !Objects.isNull(headings.get(j))) {	
							if( contractItems.get(keyset[k]).get("map").toString().replaceAll("\\n",",").trim().equals(headings.get(j).toString().replaceAll("^\"|\"$", "").replaceAll("\\n","").trim())) {
								contractItems.get(keyset[k]).put("index", Integer.toString(j));

								foundHeadingIndex = true;
							}
						} else {

						}
					}
					
					if (foundHeadingIndex == false) {;
						Warning.addAttentionRequiredMessage("Reading input file headings: Unknown field heading: " + headings.get(j) + ". Please ensure this matches the settings in the mapping file");
						error = true;
						Log.logSevere("Reading input file headings: Unknown field heading: " + headings.get(j) + ". Please ensure this matches the settings in the mapping file");
					}
					
					
				}

				Log.logInfo("Successfully read a contract file from " + path);
			
			} catch (FileNotFoundException e) {
				Warning.addAttentionRequiredMessage("File not found error: '" + path + "' does not exist");
				Log.logSevere("File not found error: '" + path + "' does not exist");

			} catch (Exception f) {
				f.printStackTrace();
			}
		}
		Contracts[] contracts = new Contracts[0];
		if (!error) {
		
			
			if (contractDataArray.size() != 0) {
				contracts = new Contracts[contractDataArray.size()-1];
	
			
				for (int j=0; j < contractDataArray.size(); j++) {
		
					if(!contractDataArray.get(j).get(Integer.parseInt(contractItems.get("contractNumber").get("index"))).replaceAll("^\"|\"$", "").trim().equals(contractItems.get("contractNumber").get("map").replaceAll("^\"|\"$", "").trim())) {
		
						contracts[j-1] = new Contracts(j-1);
		
						contracts[j-1].fillValues(contractDataArray.get(j), contractItems);
					} 
				}	
			}
		}
		if (error == true) {
			return null; //If an error has occured, prevent the program from continuing by returning null
		} 
		return contracts;
		
	}
	
}
