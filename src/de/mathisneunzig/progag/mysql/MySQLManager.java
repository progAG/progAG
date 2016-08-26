package de.mathisneunzig.progag.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {
	
	private Connection connect = null;
	private Statement statement = null;
	
	public MySQLManager()
	{
		
	}
	
	public boolean connect(String host, String user, String password, String database)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database,user, password);
			if(!connect.isClosed())
			{
				
				statement = connect.createStatement();
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean Update(String table, String[] spalten, String[] values, String where)
	{
		if(spalten.length == values.length)
		{
			String query = "UPDATE "+table+" SET "+formatUpdate(spalten, values)+" WHERE "+where+";";
			try {
				statement.execute(query);
				return true;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ResultSet Select(String table, String[] spalten, String where)
	{
		String query = "SELECT "+formatCollection(spalten)+ " FROM "+table+" WHERE "+where+";";
		try
		{
			ResultSet result = statement.executeQuery(query);
			return result;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean InsertInto(String tableName, String[] spalten, String[] values)
	{
		if(spalten.length == values.length)
		{
			String query = "INSERT INTO "+tableName+" ("+formatCollection(spalten)+") VALUES ("+formatCollection(values)+");";
			try {
				statement.execute(query);
				return true;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("[MYSQL] Insert Error. Lenght mismatch!");
		}
		return false;
	}
	
	private String formatUpdate(String[] spalten, String[] values)
	{
		String format = "";
		
		for(int i = 0; i < spalten.length; i++)
		{
			format += (spalten[i]+"="+values[i]);
			if(i != spalten.length - 1)
				format += ",";
		}
		
		return format;
	}
	
	private String formatCollection(String[] collection)
	{
		String coll = "";
		for(int i = 0; i < collection.length; i++)
		{
			if(i != collection.length - 1)
			{
				coll += collection[i]+",";
			}
			else
			{
				coll += collection[i];
			}
		}
		return coll;
	}
	
	public boolean isConnected()
	{
		try
		{
			return !connect.isClosed();
		}catch(Exception ex)
		{
			return false;
		}
	}
	
	public void disconnect()
	{
		try
		{
			if(connect != null)
			{
				if(!connect.isClosed())
				{
					connect.close();
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
