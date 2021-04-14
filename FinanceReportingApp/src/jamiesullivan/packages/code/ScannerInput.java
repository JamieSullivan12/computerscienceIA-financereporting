package jamiesullivan.packages.code;



import java.util.Objects;
//Java program to demonstrate working of Scanner in Java
import java.util.Scanner;

public class ScannerInput {
	

	public static void main() {
		
	}
 
	 public static String stringInput(String message) {
		 Scanner in = new Scanner(System.in);
		 if (!Objects.isNull(message) && !message.equals("")) {
			 System.out.print(message);
		 }
		 
		 String input = in.nextLine();
	     return input;
	 }
	 
	 public static int intInput(String message) {
		 Scanner in = new Scanner(System.in);
		 if (!Objects.isNull(message) && !message.equals("")) {
			 System.out.print(message);
		 }
		 
		 int input = in.nextInt();
	     return input;
	 }
	 
	 public static float floatInput(String message) {
		 Scanner in = new Scanner(System.in);
		 if (!Objects.isNull(message) && !message.equals("")) {
			 System.out.print(message);
		 }
		 
		 float input = in.nextFloat();
	     return input;
	 }
}