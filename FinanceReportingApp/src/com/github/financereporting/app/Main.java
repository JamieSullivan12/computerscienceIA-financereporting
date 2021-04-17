package com.github.financereporting.app;

import java.awt.Desktop;
import java.io.*;
import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import com.github.financereporting.user.interfaces.*;

import jamiesullivan.packages.code.OpenDialogueExplorer;
import jamiesullivan.packages.exceptions.ExitStatus1Exception;





public class Main {
	
	private static ServerSocket socket;
	
	public static void main(String[] args) {
		socket = null;
	    
		try {
			
			
			
			//This ServerSocket allows the program to check if it is already running
			//If it is running, it will throw an IOException which is caught below

			
			
			try {
				ServerSocketInit.readServerSocketProperties();
			} catch (ExitStatus1Exception e1) {
				//Catch invalid ports (eg. ports with letters)
		    	System.out.println("\n\tWARNING: There was an error starting the program:");
		    	System.out.println("\n\t* The port in 'src/resources/serverSocket.properties > port' is invalid because it contains characters other than numbers"
		    			+ "\n\t\t- TO FIX: Change the port value in the 'serverSocket.properties' file (Must be between 1 and 65535)"
		    			+ "\n\t\t- If this still does not work, contact your system administrator");
		    	System.exit(1);
			}

			
			int serverSocketPort = ServerSocketInit.getPort();

			socket = new ServerSocket(serverSocketPort);
			
			//
			//
			//
			// MAIN CODE BELOW
			
			/**
			// on Windows, retrieve the path of the "Program Files" folder
		    File file = new File(System.getenv("programfiles"));

		    try {
		      if (Desktop.isDesktopSupported()) {
		         Desktop desktop = Desktop.getDesktop();
		         desktop.open(file);
		      } else {
		    	  Log.logInfo("Desktop not supported");
		      }
		    } catch(Exception e) {
		    	Log.logWarning(e.toString());
		    }
		    **/
		    
			
		    
			
			
			
			
			/**
			 * Creating the log file
			 * initializeLog(Log file location, maximum size of log file in bytes, maximum number of log files which can be created, Whether the log file should be overwritten each time the program is run); 
			 */
			Log.initializeLog("src/resources/", "log.txt", false); 
			
			Log.logInfo("\n####################\nProgram Started on Port: " + serverSocketPort + "\n####################");
	
			
			//Using the configuration settings, the ExtractConfig class is responsible for saving all the configuration values to an attribute, ensuring all the values required are in the log file
			try {

				Config.readAllConfigContents();

				fileMappings.contractFileMappings();
				ReadContracts.readContracts();
				
			} catch (ExitStatus1Exception e) {
				//If a known exit error occurs, print it and exit
				Log.logSevere(e.getMessage());
				Log.logSevere("EXIT STATUS 1: Program Terminated");
				Log.fileHandlerClose();
				System.exit(1);
				
				
			} catch (Exception e) {
				//If a random error occurs, print it and exit
				Log.logSevere(e.fillInStackTrace().toString());
				Log.logSevere("EXIT STATUS 1: Program Terminated");
				Log.fileHandlerClose();
				System.exit(1);
			}
			

			

			TextBasedUI.initializeUI();

			
			// MAIN CODE ABOVE ^^
			//
			//
			//
			
		
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
		
		
	    finally {

	    	//If the code has finished properly (when socket doesnt equal null), activate proper exit procedures
	    	if (socket != null)
	    		exitProgramSuccess();

	    }
		
		
		
		
	}
	
	public static void exitProgramSuccess () {
		//Print final message to logger, then close it
		try { Log.logInfo("EXIT STATUS 0: Successful completion of the program"); } catch (Exception e) {}
		try { Log.fileHandlerClose(); } catch (Exception e) {}
		//Properly close the port so that the program can run again
		try{ socket.close(); } catch(Exception e){}
		System.exit(0);
	}




}


