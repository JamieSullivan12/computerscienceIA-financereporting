package com.github.financereporting.user.interfaces;

public class TextBasedUI {
	
	private static String addDivider() {
		String divider = "----------------------\n";
		return divider;
	}
	
	private static String showMenu(String[] menuHeadings) {
		String menuString = "";
		
		menuString.concat(addDivider());
		int i = 0;
		System.out.println(menuString);
		while (i < menuHeadings.length) {
			menuString = menuString.concat("(" + (i+1) + ") " + menuHeadings[i] + '\n');
			i = i + 1;
		}
		
		System.out.println(menuString);
		return menuString;
		
		
	}
	
	public static void initializeMenu() {
		
		System.out.println("I got here");
		String[] initialMenuArray = {"Test1", "Test2", "Test3"};
		System.out.println( showMenu(initialMenuArray) );
	}
	
	
}
