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
public class ReadPropertyFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
	

	}
	
	
	
	public static void readPropertyFile() {
		
		
		//Main.log.logger.info("Reading Config File");
		/*
		//Reading the version from a version file
		try {
			
			Properties versionProp = new Properties(); //Properties is a Java class
			
			
			//This will try to read the config file, then feed it into the prop class
			FileInputStream versionStream = new FileInputStream("src/version/version.properties");
			
			try {
				versionProp.load(versionStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			
			try {
				OutputStream newConfigStream = new FileOutputStream("src/resources/configs.properties");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
		}
		*/
		
		Properties prop = new Properties(); //Properties is a Java class
		try {
			
			
			
			//This will try to read the config file, then feed it into the prop class
			FileInputStream configStream = new FileInputStream("src/resources/config.properties");
			System.out.println(configStream);
			
			try {
				prop.load(configStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			//Main.log.logger.warning("Config file not foung. Creating new one");
			try {
				OutputStream newConfigStream = new FileOutputStream("src/resources/config.properties");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
		}
		
		String version = prop.getProperty("version");
		System.out.println(version);
		
	}

}
