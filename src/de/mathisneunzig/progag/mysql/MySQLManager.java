package de.mathisneunzig.progag.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLManager {
	
	private Connection connect = null;
	@SuppressWarnings("unused")
	private Statement statement = null;
	
	public boolean connect(String host, String user, String password, String database) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database,user, password);
			
			if(!connect.isClosed()) {	
				
				statement = connect.createStatement();
				return true;
				
			}
			
		}
		
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return false;
	}
	
}
