package BidMeAPI.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	
	final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://mysqldatabase.conyij17tmif.us-west-1.rds.amazonaws.com:3306";
	final static String USER = "mysqldatabase";
	final static String PASSWORD = "mysqldatabase";
	public static Connection conn = null;
	
	public static Connection openConnection() throws SQLException {
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Successful Connection.");
		}
			catch (Exception e) {
			System.out.println("Unsucessful connection.");
			e.printStackTrace();
		}
		
		return conn;
		
	}
}

