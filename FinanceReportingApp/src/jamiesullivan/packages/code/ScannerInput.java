package jamiesullivan.packages.code;



import java.util.Objects;
//Java program to demonstrate working of Scanner in Java
import java.util.Scanner;

/**
 * A class with methods which interact with scanners
 * @author jamiesullivan
 *
 */
public class ScannerInput {
	

	public static void main() {
		
	}
 
	/**
	 * Prints a message and gets scanner input as a string
	 * @param message	The optional message which may be printed where the user needs to input a value
	 * @return			The user input as a string
	 */
	 public static String stringInput(String message) {
		 Scanner in = new Scanner(System.in);
		 if (!Objects.isNull(message) && !message.equals("")) {
			 System.out.print(message);
		 }
		 
		 String input = in.nextLine();
		 in.close();
	     return input;
	 }
	 
	 /**
		 * Prints a message and gets scanner input as an integer
		 * @param message	The optional message which may be printed where the user needs to input a value
		 * @return			The user input as an integer
		 */
	 public static int intInput(String message) {
		 Scanner in = new Scanner(System.in);
		 if (!Objects.isNull(message) && !message.equals("")) {
			 System.out.print(message);
		 }
		 
		 int input = in.nextInt();
		 in.close();
	     return input;
	 }
	 
	 /**
		 * Prints a message and gets scanner input as a float
		 * @param message	The optional message which may be printed where the user needs to input a value
		 * @return			The user input as a float
		 */
	 public static float floatInput(String message) {
		 Scanner in = new Scanner(System.in);
		 if (!Objects.isNull(message) && !message.equals("")) {
			 System.out.print(message);
		 }
		 
		 float input = in.nextFloat();
		 in.close();
	     return input;
	 }
}