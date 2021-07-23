package com.github.financereporting.app;

/**
 * Contains all the functions that help with tracking warnings throughout the program
 * @author jamiesullivan
 *
 */
public class Warning {
	
	private static String attentionRequiredMessage = "";
	
	
	public static void resetAttentionRequiredMessage() {
		attentionRequiredMessage = "";
	}
	
	/**
	 * Appends to the string that controls the attention required message variable. 
	 * This message will be shown in the user interface if the user interface if the user
	 * needs to take action before running a process
	 * @param message 	The message which needs to be appended to the string
	 */
	public static void addAttentionRequiredMessage (String message) {
		attentionRequiredMessage += message + "\n";
	}
	
	
	/**
	 * Returns true if there is attention required by the user
	 * and false if not
	 * @return		A boolean value regarding whether attention is required by the user
	 */
	public static boolean getAttentionRequiredFlag () {
		return !attentionRequiredMessage.isEmpty();
	}
	
	/**
	 * Returns the value of the attention required message
	 * @return		the attentionRequiredMessage as a string
	 */
	public static String getAttentionRequiredMessage () {
		return attentionRequiredMessage;
	}
	



	
	
	
	
	
}
