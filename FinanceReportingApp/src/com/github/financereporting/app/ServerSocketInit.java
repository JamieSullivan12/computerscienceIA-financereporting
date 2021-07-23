package com.github.financereporting.app;

import jamiesullivan.packages.exceptions.LimitedAccessException;

public class ServerSocketInit {
	
	private static String temp;
	private static int port;
	
	/**
	 * Reads the server socket port from the properties file
	 * @param path the path of the .properties file which has the port on which the program will run
	 * @throws LimitedAccessException
	 */
	public static void readServerSocketProperties(String path) {
		Property serverSocketObj = new Property();
		
		String serverSocketPath = path;
		serverSocketObj.readConfigFile(serverSocketPath);
		
		temp = serverSocketObj.readProperties("port", "32567", serverSocketPath, 1);
		port = Integer.parseInt(temp);
	}
	
	/**
	 * Returns the port from the server socket configuration file
	 * @return a port as an integer
	 */
	public static int getPort() {
		return port;
	}
}
