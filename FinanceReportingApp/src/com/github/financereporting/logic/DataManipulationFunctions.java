package com.github.financereporting.logic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Objects;

public class DataManipulationFunctions {

	
	String errMsg = "";
	boolean invalid = false;
	String defErrMsg = "";
	
	public DataManipulationFunctions(String m) {
		defErrMsg = m;
	}
	
	/**
	 * Converts a date (in the format DD/MM/YY or DD/MM/YY (note that DD and MM may be single digits) into a date object. Will create an error if an issue is found
	 * @param valueName The name of the value as referenced in the mappings object (is used to retrieve the field value)
	 * @param temp the array of values for a specific contract
	 * @param mappings each field f
	 * @return the date object
	 */
	public Date convertToDate(String valueName, ArrayList<String> temp, LinkedHashMap<String, LinkedHashMap<String, String>> mappings) {
		
		Date date = new Date();

		String stringDate = null;
		try {
			stringDate = temp.get(Integer.parseInt(mappings.get(valueName).get("index")));
		} catch (Exception e1) {
		}
		
		
		try { 
		
			if (!Objects.isNull(stringDate) && !stringDate.replaceAll("^\"|\"$", "").trim().isBlank()) {
				
				String[] listDate = stringDate.replaceAll("^\"|\"$", "").split("/");
	
				if (listDate[0].length() == 1) {
					listDate[0] = "0" + listDate[0];
				}
				if (listDate[1].length() == 1) {
					listDate[1] = "0" + listDate[1];
				}
				
			
				date = new SimpleDateFormat("dd/MM/yy").parse(listDate[0] + "/" + listDate[1] + "/" + listDate[2]); 
			
		
				}
				
				
				else {
					date = null;
				}
		
		
		} catch (Exception e) { 
			
			invalid = true;
			errMsg += defErrMsg + " - " + mappings.get(valueName).get("map") + " is invalid" ; 
		
		
		
		}
		
		return date;
		
	}
	
	
	/**
	 * Converts a value (integer, float or double) to a bigDecimal object
	 * @param valueName The name of the value as referenced in the mappings object (is used to retrieve the field value)
	 * @param temp the array of values for a specific contract
	 * @param mappings each field from temp is mapped with an index in this array
	 * @return the bigDecimal value
	 */
	public BigDecimal convertToBigDecimal(String valueName, ArrayList<String> temp, LinkedHashMap<String, LinkedHashMap<String, String>> mappings) {
		BigDecimal newValue = null;
		try {
			newValue = new BigDecimal(temp.get(Integer.parseInt(mappings.get(valueName).get("index"))).replaceAll("^\"|\"$", "").replaceAll("%", "").trim());
		} catch (Exception e) {
			invalid = true;
			errMsg += defErrMsg + " - " + mappings.get(valueName).get("map") + " is invalid. Must be a number";
		}
		return newValue;
	}
	
	public String getErrMsg() {
		return errMsg;
	}
	
}
