/**
 * 
 */
package com.github.financereporting.app;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;
/**
 * @author jamie
 *
 *
 *CREATES THE LOG FILE
 */

public class Log {
	private static String resourcesDirectory;
	private static String deletedMessages;
	/**
	 * Method deletes any extra log files in the resources folder. It also removes and .lck (Lock) files which are there because a process 
	 * never finished (i.e. another iteration of the program is still running) which prevents the main log file
	 * from being used. This method should theoretically never be used (because the main file checks for if the code is already being run) 
	 * but it exists just in case
	 * @param pathName		The path to the log file
	 * @param fileName		The name of the log file
	 */
	static void deletePreviousLogFiles(String pathName, String fileName) {
		resourcesDirectory = "";
		deletedMessages = "";
	    File path = new File(pathName);
	    File [] files = path.listFiles();
	    
	    for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){ //this line weeds out other directories/folders
	            String oldFilePath = files[i].toString(); //Converting the path to a string used in the IF statement below
	            resourcesDirectory += oldFilePath + "\n";
	            //If the path does NOT equal the actual log file name, and it includes the name for the log file (i.e. log.txt.1 or log.txt.lck)
	            //then delete it because it doesnt need to be there
	            if (!oldFilePath.equals(pathName + fileName) && oldFilePath.contains(fileName)) {
	    			if (files[i].delete()) {
	    				
	    				deletedMessages += "DELETED: " + oldFilePath + "\n";
	    			}
	    		}
	        }
	    }
	 }
		
	    

	
	
	static private Logger logger;

    static private FileHandler fileHandler;
    static private SimpleFormatter formatterTxt;

    

	/**
	 * This method creates and initializes the log file
	 * 
	 * @param file_name		The location of the log file
	 * @param fileSizeLimit	The max size of the log file (bytes). 1,000,000 bytes = 1 mb
	 * @param maxFileCount	The number of log files that can be created
	 * @param override		Boolean value indicating whether the log file will be overwritten each time
	 * @return 
	 */
	public static void initializeLog(String pathName, String fileName, boolean override) {


		
		//Some file checking to avoid issues further on (see method description for more info)
		deletePreviousLogFiles(pathName, fileName);
		
		//Initializing the logger
		logger = Logger.getLogger(Log.class.getName());

		
		//Create the file handler
        try {
			fileHandler = new FileHandler(pathName + fileName, 1000000, 1, override);
		} catch (SecurityException e) {
			//DO NOTHING
		} catch (IOException e) {
			//DO NOTHING
		}

        
        // create a TXT (text) formatter - this creates a human-readable format in which the log file is written (instead of an XML file)
        formatterTxt = new SimpleFormatter();
        fileHandler.setFormatter(formatterTxt);
        logger.addHandler(fileHandler);
        
        
        
        // DISABLE CONSOLE LOGGER FOR PRODUCTION CODE (set to true)
        boolean disableConsoleLogger = false;
        
        if (disableConsoleLogger) {
        	logger.setUseParentHandlers(false);
        } else {
            //Formatting the console logger (does not apply to the log file but is instead used for debugging)
            System.setProperty("java.util.logging.SimpleFormatter.format",
                    "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        }   
        
        //Logging some information regarding the generation of the log file (useful for debugging)
        logInfo("Resources Directory Files:\n" + resourcesDirectory);
        logInfo("Resources Deleted Files:\n" + deletedMessages);
   
	}
	
	/**
	 * Will log an 'info' level severity to the logger
	 * @param message the message which needs to be logged
	 */
	public static void logInfo(String message) {
		try {
			logger.info(message);
		} catch (Exception e) { }
	}
	/**
	 * Will log a 'warning' level severity to the logger
	 * @param message the message which needs to be logged
	 */
	public static void logWarning(String message) {
		try {
			logger.warning(message);
		} catch (Exception e) { }
	}
	/**
	 * Will log a 'severe' level severity to the logger
	 * @param message the message which needs to be logged
	 */
	public static void logSevere(String message) {
		try {
			logger.severe(message);
		} catch (Exception e) { }
		

	}
	

	/**
	 * Closes the file handler at the end of the program excecution (removes the lock file from the logger allowing for it to be edited next time the program is run)
	 */
	public static void fileHandlerClose() {
		//Remove ALL the handlers
		
		try {
			for(Handler h:logger.getHandlers())
			{
			    h.close();   //must call h.close or a .LCK file will remain.
			}
		} catch (Exception e) {
			//DO NOTHING
		}
		
		
	}

}
