package com.github.financereporting.user.interfaces;

import java.util.Objects;
import com.github.financereporting.app.*;

import jamiesullivan.packages.code.*;

public class TextBasedUI {
	
	

	
	
	private static String divider() {
		String divider = "------------------------------------\n";
		return divider;
	}
	
	
	private static String showMenu(String[] menuHeadings, String message, boolean topDivider) {
		String menuString = "";
		
		if (!Objects.isNull(message) && !message.equals("")) {
			menuString += message + '\n';
		}
		if (topDivider) {
			menuString += divider();
		}
		
		
		int i = 0;
		while (i < menuHeadings.length) {
			menuString += "\t>> (" + (i+1) + ") " + menuHeadings[i] + '\n';
			i = i + 1;
		}
		
		
		
		return menuString;	
	}
	
	private static void createMenu(String[] menuOptions) {
		System.out.println( showMenu(menuOptions, Config.getName() + " Menu", true) );
		String userInput = ScannerInput.stringInput("Make your selection: ");
		System.out.println(divider());
	}
	
	
	
	public static void initializeMenu() {
		String[] initialMenuArray = {"Test1", "Test2", "Test3"};
		createMenu(initialMenuArray);
	}
	
	
}
