package com.github.financereporting.logic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertToCSV {
	
	public ConvertToCSV() {
		
	}
	
	public ArrayList<String> convertToCSV(ArrayList<String[]> data) {
		ArrayList<String> returnData = new ArrayList<String>();
		for (var i=0; i < data.size(); i++) {
			ArrayList<String > newData = new ArrayList<String>();
			for (var g=0; g<data.get(i).length; g++) {

				newData.add(escapeSpecialCharacters(data.get(i)[g]));
				
				
			}
			String joinedResult = newData.stream().collect(Collectors.joining(",")).replace("null", "");
			returnData.add(joinedResult );

		}
		
		return returnData;
	}
	
	public String escapeSpecialCharacters(String data) {
	    String escapedData = data.replaceAll("\\R", " ");
	    if (data.contains(",") || data.contains("\"") || data.contains("'")) {
	        data = data.replace("\"", "\"\"");
	        escapedData = "\"" + data + "\"";
	    }
	    return escapedData;
	}
	
	public void givenDataArray_whenConvertToCSV_thenOutputCreated(String path, ArrayList<String> dataLines) throws IOException {
	    File csvOutputFile = new File(path);
	    try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
	        dataLines.stream()
	          .forEach(pw::println);
	    }
	    //assertTrue(csvOutputFile.exists());
	}
}
