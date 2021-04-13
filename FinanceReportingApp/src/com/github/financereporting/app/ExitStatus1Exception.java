package com.github.financereporting.app;

/**
 * 
 * @author jamiesullivan
 *
 *
 *	Custom exception class used for terminating the program in the case of an error or check
 */
public class ExitStatus1Exception extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	public ExitStatus1Exception(String message) {
		super(message);
	}

}
