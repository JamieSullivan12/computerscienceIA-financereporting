package com.github.financereporting.user.interfaces;

import java.util.LinkedHashMap;
import java.util.Set;

import com.github.financereporting.app.Config;
import com.github.financereporting.app.Warning;

import jamiesullivan.packages.code.ScannerInput;
import jamiesullivan.packages.code.userinterface.BlankLines;
import jamiesullivan.packages.code.userinterface.Divider;
import jamiesullivan.packages.code.userinterface.UserInterfaceMenu;

public class EditFileMappingsUI {

	public static void initializeMappingsUI() {
		
		boolean goBack = false;
		//Endless loop until the user decides to break out of it
		while (!goBack) {
			
			System.out.println(BlankLines.get());
			
			//Messages that are printed out to warn/inform the user about actions they need to complete
			
			//If there is a warning that needs attending to, print the message
			if(Warning.getAttentionRequiredFlag()) {
				System.out.println(Warning.getAttentionRequiredMessage());
			}
			
			
			
			//If there are unsaved changes that need attending to, print the message(s)
			unsavedChanges = Config.getUnsavedChanges();
			
			
			
			if (!unsavedChanges.isBlank()) {
				System.out.println("##########\n\nYOU HAVE UNSAVED CHANGES. Enter the correct number below to save:");
				System.out.println(Config.getUnsavedChanges());
				System.out.println("##########");
			}

			
			
			//configItems are all the configuration keys and values which need to have been activated earlier
			LinkedHashMap<String, LinkedHashMap<String, String>> configItems = Config.getHashMap();
			
			//Used to loop through the map (creates a list of keys as a set object)
			Set<String> keys = configItems.keySet();
			
			//The menu array contain the options that are printed. The length needs to be keys.size() + 2 because there also needs to be a back button and potentially a save changes button
			String[] configurationMenuArray = new String[keys.size() + 3];
			
			
			
			//Iterate through each configuration items
			int i = 0;
			for (String key : keys) {
				
				//If there is a warning indication for the specific configuration field, then inform the user (any invalid fields should have "INVALID" in the menu)
				String warningIndication = "";
				if (configItems.get(key).get("warningFlag").equals("true")) {
					warningIndication = "INVALID: ";
				}
				
				//Add an option to the array with an automated index
				configurationMenuArray[i] = warningIndication + key + "\t...\t" + configItems.get(key).get("value");
		
				i += 1;
			}

			
			//Defining some options the user has once the above items have been printed in the menu
			//Save any unsaved changes (This will only be shown if the user has made a change but has not saved it yet)
			int unsavedChangesIndex = 0; //the index will be used later when checking what the user has selected
			if (!unsavedChanges.isBlank()) {
				configurationMenuArray[i] = "SAVE CHANGES";
				unsavedChangesIndex = i;
				i += 1;
			}
			
			//This button will reset all configuration items to default values (hard coded into the program)
			configurationMenuArray[i] = "RESET TO DEFAULT VALUES";
			int resetToDefaults = i;
			i += 1;
			
			
			//The back button (goes back to the main menu
			configurationMenuArray[i] = "BACK";
			int backIndex = i; //Save the "Back" index which is used later when the customer enters a selection in the menu
			
			
			
			
			
			//Creating the menu
			int result = UserInterfaceMenu.createMenu(configurationMenuArray, "Update confuration preferences (enter the respective number to edit):", "Enter selection: ");

			
			
			//Interpreting what the user has selected in the menu, and acting accordingly
			
			//Go back to the home page if the user selected back in the menu
			if (result-1 == backIndex) { //Run funding process 
				System.out.println("Going back...\n\n" + Divider.get());
				goBack = true; //a flag which keeps a loop going when it is false (changing to true will break loop)
			} 
			
			//If the user has selected to save the changes (if the unsavedChangesIndex = 0, that means it does not exist)
			else if (unsavedChangesIndex != 0 && result-1 == unsavedChangesIndex) {
				Config.saveChanges();
				System.out.println("Changes saved successfully\n\n" + Divider.get());
			} 
			
			//If the user has selected to reset all the configuration fields to their default values, confirm with a new menu, then execute the action
			else if (result - 1 == resetToDefaults) {
				String[] resetToDefaultsMenu = {"Yes", "No"};
				//Confirmation menu
				int resetDefaultResult = UserInterfaceMenu.createMenu(resetToDefaultsMenu, "Are you sure you want to continue? \nWARNING: Resetting to default value CANNOT be undone", "Do you wish to continue? (select from above)");
				if (resetDefaultResult == 1) {
					Config.resetDefault();
				}
			}
			
			
			//If the user has not selected any of the "special" methods above, that means they have selected to edit a configuration value
			else {
				//Request the new value
				String newValue = ScannerInput.stringInput("Enter new value for " + keys.toArray()[result-1] + " (enter nothing to cancel): ");
				
				if (!newValue.equals("")) {
					//Update the value using a method in the Config class
					System.out.println("Updating field...");
					Config.changeConfigField(keys.toArray()[result-1].toString(), newValue);

				} else {
					//If the user has not inputed anything, cancel
					System.out.println("Cancelling...");
				}

			}
			//Print some blank lines to clean up the UI
			System.out.println(BlankLines.get());
		}
		
		//Once broken out of the for loop (when the user selects "BACK"), return back to the menu
		return;
	}
	}
	
}
