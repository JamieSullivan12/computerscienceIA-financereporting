package jamiesullivan.packages.exceptions;

/**
 * 
 * @author jamiesullivan
 *
 *
 *	Custom exception class used for terminating the program in the case of an error or check
 */
public class LimitedAccessException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	public LimitedAccessException(String message) {
		super(message);
	}

}
