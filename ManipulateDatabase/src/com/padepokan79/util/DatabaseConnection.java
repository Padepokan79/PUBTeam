package com.padepokan79.util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DatabaseConnection {
	String myDriver = "org.gjt.mm.mysql.Driver";
	String myUrl = "jdbc:mysql://192.168.2.192:3000/dbgajido";
	public static Connection conn = null;
	public DatabaseConnection(){
		try
		{
			if (conn == null){
				Class.forName(myDriver);
				// create our mysql database connection
				conn = (Connection) 
						DriverManager.getConnection(
								myUrl, "taspen", "taspen");
			}

		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
