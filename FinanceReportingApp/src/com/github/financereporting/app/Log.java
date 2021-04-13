/**
 * 
 */
package com.github.financereporting.app;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * @author jamie
 *
 *
 *CREATES THE LOG FILE
 */
public class Log {
	static public Logger logger;

    static private FileHandler fileTxt;
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
	public static void initializeLog(String file_name, int fileSizeLimit, int maxFileCount, boolean override) {
		
		//See java.util.logger docs online for information on what the code below means
		
		logger = Logger.getLogger(Log.class.getName());

        try {
			fileTxt = new FileHandler(file_name, fileSizeLimit, maxFileCount, override);
		} catch (SecurityException e) {
			//DO NOTHING
		} catch (IOException e) {
			//DO NOTHING
		}

        // create a TXT (text) formatter - this creates a human-readable format in which the log file is written (instead of an XML file)
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
        
        
        //Formatting the console logger (does not apply to the log file but is instead used for debugging)
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");

        
	}

}
