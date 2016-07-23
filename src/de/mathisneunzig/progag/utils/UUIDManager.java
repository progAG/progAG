package de.mathisneunzig.progag.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UUIDManager {
	
	public static String getValue(String input) {
		
		try {
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("http://api.ketrwu.de/" + input + "/").openStream()));
			return bufferedReader.readLine();
			
		} catch (Exception e) { 
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
}