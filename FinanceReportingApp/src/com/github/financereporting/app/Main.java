package com.github.financereporting.app;

import java.util.logging.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


public class Main {
	
	public static Log log;
	

	
	/**
	 * Check the validity of the arguments given by the user
	 * 
	 * @param args		the array of arguments passed into the program when it is run
	 * @return valid	the value which indicates whether the arguments provided are valid
	 */
	private static boolean checkArgs(String[] args) {
		boolean valid = false;
		
		return valid;
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log = new Log("src/resources/log.txt", 1000000, 1, false); //Initializing the initial load file
		
		ReadConfigFile.readConfigFile();
		Config.loadConfigObjects();
		
		log = new Log("src/resources/log.txt", 1000000, 1, true); //Initializing the primary log file (with the preferences saved)
	
	}

}


