package utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String URL = "jdbc:mysql://localhost:3306/consumerdb";
	private static String USERNAME ="root";
	private static String PASSWORD = "";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName(DRIVER);
			
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Successfully Connected...");
			
		}catch(Exception e) {
			System.out.println("Database connection is not success...");
		}
		
		return con;
	}

}
