package com.github.financereporting.user.interfaces;
import java.util.LinkedHashMap;
import java.util.Set;

import com.github.financereporting.app.*;

import jamiesullivan.packages.code.userinterface.*;
import jamiesullivan.packages.code.*;

public class EditConfigurationUI {
	
	
	/**
	 * Load the UI for editing configuration. Needs to be done AFTER initial configuration extraction
	 */
	public static void initializeConfigurationUI() {
		
		boolean goBack = false;
		
		
		while (!goBack) {
				
		
		
			
			//Configitems are all the configuration keys and values which need to have been activated earlier
			LinkedHashMap<String, LinkedHashMap<String, String>> configItems = Config.getHashMap();
			
			//Used to loop through the map (creates a list of keys as a set object)
			Set<String> keys = configItems.keySet();
			
			//The menu array contain the options that are printed. The length needs to be keys.size() + 1 because there also needs to be a back button
			String[] configurationMenuArray = new String[keys.size() + 1];
			int i = 0;
			for (String key : keys) {
				//Add an option to the array with an automated index
				configurationMenuArray[i] = key + "\t...\t" + configItems.get(key).get("value");
				i += 1;
			}
			//The back button
			configurationMenuArray[i] = "BACK";
			int backIndex = i; //Save the "Back" index which is used later when the customer enters a number
			
			//Creating the menu
			int result = UserInterfaceMenu.createMenu(configurationMenuArray, "Update confuration preferences:", "Which field do you want to edit: ");

			
			
			//Go back to the home page if the user selected back (it is the last selection in the menu)
			if (result-1 == backIndex) { //Run funding process 

				goBack = true;
				
			} else {
	
				String newValue = ScannerInput.stringInput("Enter new value for " + keys.toArray()[result-1] + ": ");
				
				if (!newValue.equals("")) {
					System.out.println("I GOT HERE");
					Config.changeConfigField(keys.toArray()[result-1].toString(), newValue);
					System.out.println("I GOT HERE1");
				}
				
				System.out.println("I GOT HERE2");
				
				
				String[] commitChangesMenu = {"Yes", "No"};
				System.out.println(Config.getUnsavedChanges());
				int commitChangesSelection = UserInterfaceMenu.createMenu(commitChangesMenu, "Are you sure you want to continue?\n" + Config.getUnsavedChanges(),"m");
				System.out.println(commitChangesSelection);
				
				System.out.println("I GOT HERE4");
				//System.out.println(Config.getUnsavedChanges());
				//System.out.println("RETURN1");
			
			}
		
		}
		System.out.println("RETURN");
		return;
	}
	
	
	
}
