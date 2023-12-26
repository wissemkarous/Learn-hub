package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static Connection con;
	 static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver ok");
		    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reviews","root","");
			System.out.println("connected");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	 }
		public static Connection getConnection() {
			return con ;
		}
		
	}
