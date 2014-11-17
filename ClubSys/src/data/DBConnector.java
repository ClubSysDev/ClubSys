package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	/* Class for static access to connecting and disconnecting the database
	 * in all the database classes  
	 */

	private static Connection conn = null;
	private static String dbURL = "localhost";
	private static String dbUser = "";
	private static String dbPass = ""; // De her ting skal måske ligge i en klasse.

	public static void connect()
	{
		try
		{
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		if (conn != null) 
		{
			System.out.println("Connected!");
		}
		else
		{
			System.out.println("Error connecting");
		}
	}

	public static void disconnect()
	{
		try 
		{
			conn.close();
			System.out.println("Disconnected!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		return conn;
	}
}
