package com.github.financereporting.app;

import java.io.*;
import java.net.ServerSocket;
import com.github.financereporting.user.interfaces.*;
import java.time.LocalDate;
import java.util.Objects;    
//import com.github.financereporting.gui.*;

public class Main {
	

	private static LocalDate date;
	
	
	
	private static ServerSocket socket;
	
	
	
	
	public static void main(String[] args) {
		socket = null;
	    
		try {
			

			//This ServerSocket allows the program to check if it is already running
			//If it is running, it will throw an IOException which is caught below

			
			
			ServerSocketInit.readServerSocketProperties("src/resources/serverSocket.properties");
			int serverSocketPort = ServerSocketInit.getPort();
			socket = new ServerSocket(serverSocketPort);
			
			
			/**
			 * Creating the log file
			 * initializeLog(Log file location, maximum size of log file in bytes, maximum number of log files which can be created, Whether the log file should be overwritten each time the program is run); 
			 */
			Log.initializeLog("src/resources/", "log.txt", false); 
			Log.logInfo("\n####################\nProgram Started on Port: " + serverSocketPort + "\n####################");
			
		} catch (IOException ex) {
	    	//If the port is already running or is invalid
	    	
	    	//Theoretically, the file handler wont have been initialized yet, but in case it has...
	    	Log.fileHandlerClose();
	    	
			//Error message
	    	System.out.println("\n\tWARNING: There was an error starting the program:");
	    	System.out.println("\t* The app is already running");
	    	System.exit(1); //Exit

	    } catch (IllegalArgumentException ey) {
	    	//If the port in the serverSocket.properties file contains illegal arguments
	    	
	    	//Theoretically, the file handler wont have been initialized yet, but in case it has...
	    	Log.fileHandlerClose();
			
	    	//Error message
	    	System.out.println("\n\tWARNING: There was an error starting the program:");
	    	System.out.println("\n\t* The port in 'src/resources/serverSocket.properties > port' is invalid"
	    			+ "\n\t\t- TO FIX: Change the port value in the 'serverSocket.properties' file (Must be between 1 and 65535)"
	    			+ "\n\t\t- If this still does not work, contact your system administrator");
	    	System.exit(1);
	    }
			
			
			//
			//
			//
			// MAIN CODE BELOW
			
			


			
			//Using the configuration settings, the ExtractConfig class is responsible for saving all the configuration values to an attribute, ensuring all the values required are in the log file

			Config.readAllConfigContents();


			fileMappings.contractFileMappings();
	
			
			date = LocalDate.now();
			
			
			try {
				TextBasedUI.initializeUI();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				endProgramUnsuccessful(3, "Unknown error occured", e);
			}

			
			// MAIN CODE ABOVE ^^
			//
			//
			//
			
		
	    
		
		
	    finally {

	    	//If the code has finished properly (when socket doesnt equal null), activate proper exit procedures
	    	if (socket != null)
	    		exitProgramSuccess();

	    }
		
	}
	
	
	
	
	/**
	 * Ends the program properly in case of an error/issue during the running of the code.
	 * Special exit status codes may be used in the case of an unsuccessful termination of the program
	 * @param exitStatus		A code from 0-255 (any code greater than 255 will default to 128). See src/resources/ErrorCodes/properties for more details
	 * @param optionalMessage	An optional message to print to the error log
	 * @param traceBack			An error traceback (MUST be a part of the Exception class)
	 */
	public static void endProgramUnsuccessful (int exitStatus, String optionalMessage, Exception traceBack) {
		if (!(exitStatus > 0) || !(exitStatus < 256) ) {
			exitStatus = 128;
		}
		if (!optionalMessage.isBlank()) {
			Log.logSevere("ERROR CODE " + exitStatus + ": A fatal error has occured. \nMessage: " + optionalMessage);
			System.out.println("ERROR CODE " + exitStatus + ": A fatal error has occured. \nMessage: " + optionalMessage);
		} else {
			Log.logSevere("ERROR CODE " + exitStatus + ": A fatal error has occured.");
			System.out.println("ERROR CODE " + exitStatus + ": A fatal error has occured.");
		}
		if (!Objects.isNull(traceBack)) {
			if (!traceBack.toString().isBlank()) {
				Log.logInfo("Trace Back (Useful for debugging): \n" + traceBack.getLocalizedMessage());
				System.out.println("Trace Back (Useful for debugging): \n" + traceBack.getLocalizedMessage());
			} else {
				Log.logInfo("No traceback found");
				System.out.println("No traceback found");
			}
		} else {
			Log.logInfo("No traceback found");
			System.out.println("No traceback found");
		}
		
		try {
			Log.fileHandlerClose();
		} catch (Exception e) {
			Log.logWarning("Unable to close fileHandler:\n" + e.getLocalizedMessage());
			System.out.println("Unable to close fileHandler:\n" + e.getLocalizedMessage());
		}
		
		System.out.println("Program Terminated");
		Log.logSevere("Program Terminated");
		
		System.exit(exitStatus);
	}
	
	
	
	
	/**
	 * Will successfully terminate the program, shutting down all processes which need to be shut down, then terminating on exit status 0
	 */
	public static void exitProgramSuccess () {
		//Print final message to logger, then close it
		try { Log.logInfo("EXIT STATUS 0: Successful completion of the program"); } catch (Exception e) {}
		try { Log.fileHandlerClose(); } catch (Exception e) {}
		//Properly close the port so that the program can run again
		try{ socket.close(); } catch(Exception e){}
		System.exit(0);
	}


	public static LocalDate getCurDate() {
		return date;
	}

}


