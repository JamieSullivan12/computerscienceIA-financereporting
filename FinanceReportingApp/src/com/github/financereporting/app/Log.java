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

    

	
	public Log(String file_name, int fileSizeLimit, int maxFileCount, boolean override) {
		
		//Loading the preferences for the logger
		Properties preferences = new Properties();
		try {
		    FileInputStream configFileLog = new FileInputStream("/path/to/app.properties");
		    preferences.load(configFileLog);
		    LogManager.getLogManager().readConfiguration(configFileLog);
		} catch(Exception e) {
			
		}
		

		logger = Logger.getLogger(Log.class.getName());

        try {
			fileTxt = new FileHandler(file_name, fileSizeLimit, maxFileCount, override);
		} catch (SecurityException e) {
			//DO NOTHING
		} catch (IOException e) {
			//DO NOTHING
		}

        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
        
        
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");

        
	}

}
