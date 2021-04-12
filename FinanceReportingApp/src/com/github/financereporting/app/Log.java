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
	public Logger logger;
	FileHandler fh;
	
	
	public Log(String file_name, int fileSizeLimit, int maxFileCount, boolean override) {
		
		File f = new File(file_name);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {

			fh = new FileHandler(file_name, fileSizeLimit, maxFileCount, override);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		logger = Logger.getLogger("test");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		
		
	}

}
