package com.github.financereporting.app;

import java.util.logging.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;


import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


public class Main {
	
	public static Log log;
	
	
	//Logger
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	
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
		
		Log log = new Log("src/resources/log.txt");
		
		log.logger.info("Program started");
		
		ReadPropertyFile.readPropertyFile();	
	
	}

}


