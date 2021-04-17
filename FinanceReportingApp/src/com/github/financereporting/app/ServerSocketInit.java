package com.github.financereporting.app;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

public class ServerSocketInit {
	
	private static String temp;
	private static int port;
	public static void readServerSocketProperties() throws ExitStatus1Exception {
		Property serverSocketObj = new Property();
		
		String serverSocketPath = "src/resources/serverSocket.properties";
		serverSocketObj.readConfigFile(serverSocketPath);
		
		temp = ReadPropertiesMethods.readProperties(serverSocketObj, "port", "32567", serverSocketPath, 1);
		port = Integer.parseInt(temp);
	}
	
	public static int getPort() {
		return port;
	}
}
