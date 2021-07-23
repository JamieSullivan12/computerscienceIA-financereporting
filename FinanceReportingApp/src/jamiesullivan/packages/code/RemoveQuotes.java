package jamiesullivan.packages.code;

public class RemoveQuotes {
	
	public RemoveQuotes() {
		
	}
	
	public static String remove(String string) {
		return string.replaceAll("^\"+|\"+$", "");
	}
}
