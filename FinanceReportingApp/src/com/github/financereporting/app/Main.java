package com.github.financereporting.app;

import java.util.logging.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    








public class Main {
	
	
	public static void main(String[] args) {

		/**
		 * Creating the log file
		 * initializeLog(Log file location, maximum size of log file in bytes, maximum number of log files which can be created, Whether the log file should be overwritten each time the program is run); 
		 */
		Log.initializeLog("src/resources/log.txt", 1000000, 1, false); 

		//Creating a configuration object (where all the configuration settings and methods will be stored
		Property configObj = new Property();
		//Calling the readConfigFile method which reads the configuration file from the directory below, and saves its contents to the object
		configObj.readConfigFile("src/resources/config.properties");
		
		
		//Using the configuration settings, the ExtractConfig class is responsible for saving all the configuration values to an attribute, ensuring all the values required are in the log file
		try {
			ExtractConfig.readAllConfigContents(configObj);
		} catch (ExitStatus1Exception e) {
			Log.logger.severe(e.getMessage());
			Log.logger.severe("EXIT STATUS 1: Program Terminated");
		}
		

	}




}


