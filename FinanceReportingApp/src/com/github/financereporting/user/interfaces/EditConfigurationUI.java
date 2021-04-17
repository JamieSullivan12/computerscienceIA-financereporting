package com.github.financereporting.user.interfaces;
import java.util.LinkedHashMap;
import java.util.Set;

import com.github.financereporting.app.*;

import jamiesullivan.packages.code.userinterface.UserInterfaceMenu;

public class EditConfigurationUI {
	
	
	
	public static void initializeConfigurationUI() {
		LinkedHashMap<String, LinkedHashMap<String, String>> configItems = Config.getHashMap();
		
		
		
		
		Set<String> keys = configItems.keySet();
		String[] configurationMenuArray = new String[keys.size() + 1];
		int i = 0;
		for (String key : keys) {
			configurationMenuArray[i] = key + "\t...\t" + configItems.get(key).get("value");
			i += 1;
		}
		configurationMenuArray[i] = "BACK";
		int backIndex = i;
		
		
		int result = UserInterfaceMenu.createMenu(configurationMenuArray, "Update confuration preferences:", "Which field do you want to edit: ");
		System.out.println(result);
		if (result == backIndex) { //Run funding process 
			System.out.println("GOING BACK");
			TextBasedUI.initializeUI();
		} else {
			
			System.out.println("Editing: " + keys.toArray()[result-1] + configItems.get(keys.toArray()[result-1]).get("value"));
			
		
		
		
		
		}
		
	}
	
	
	
}
