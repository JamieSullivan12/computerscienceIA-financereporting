package com.github.financereporting.app;

import jamiesullivan.packages.exceptions.ExitStatus1Exception;

public class ServerSocketInit {
	
	private static int port;
	public static void readServerSocketProperties() throws ExitStatus1Exception {
		Property serverSocketObj = new Property();
		
		String serverSocketPath = "src/resources/serverSocket.properties";
		serverSocketObj.readConfigFile(serverSocketPath);
		
		port = ReadPropertiesMethods.readPropertiesInteger(serverSocketObj, "port", "32567", serverSocketPath);

	}
	
	public static int getPort() {
		return port;
	}
}
