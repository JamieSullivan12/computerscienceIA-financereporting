/**
 * 
 */
package com.github.financereporting.app;
import java.util.Properties;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author jamie
 *
 */
public class ReadConfigFile {
	
	public static Properties config;
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
	

	}
	
	
	/**
	 * This method reads the configuration file and saves it in a Java Property object
	 */
	public static void readConfigFile() {
		
		
		Main.log.logger.info("Reading Config File");
		
		
		config = new Properties(); //Properties is a Java class
		try {
			
			//This will try to read the config file, then feed it into the prop class
			FileInputStream configStream = new FileInputStream("src/resources/config.properties");
			
			try {
				config.load(configStream); //Load the contents of the config file into the properties object
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			try {
				@SuppressWarnings("unused")
				OutputStream newConfigStream = new FileOutputStream("src/resources/config.properties");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
		}
		

		
	}

}
