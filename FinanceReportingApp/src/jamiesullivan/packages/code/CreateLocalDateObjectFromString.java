package jamiesullivan.packages.code;

import java.time.LocalDate;
import java.util.Objects;

public class CreateLocalDateObjectFromString {
	public static LocalDate createDate(String stringDate) {
		
		
		if (!Objects.isNull(stringDate) && !stringDate.replaceAll("^\"|\"$", "").trim().isBlank()) {
			
			String[] listDate = stringDate.replaceAll("^\"|\"$", "").split("/");
			if (listDate.length == 3) {
				if (listDate[0].length() == 1) {
					listDate[0] = "0" + listDate[0];
				}
				
				if (!(listDate[0].length() == 2)) {
					return null;
				}
				
				
				if (listDate[1].length() == 1) {
					listDate[1] = "0" + listDate[1];
				}
				
				
				
				if (!(listDate[1].length() == 2)) {
					return null;
				}
				
				if (listDate[2].length() == 2) {
					listDate[2] = "20" + listDate[2];
				}
				if (!(listDate[2].length() == 4)) {
					return null;
				}
			} else {return null;}
			
			LocalDate date;
			try {
				date = LocalDate.of(Integer.parseInt(listDate[2]), Integer.parseInt(listDate[1]), Integer.parseInt(listDate[0]));
			
			} catch (Exception e) {
				return null;
			}
			
			
			
			return date;
		
		} else {return null;}
}
}
