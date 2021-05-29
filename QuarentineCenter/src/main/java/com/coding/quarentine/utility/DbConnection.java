package com.coding.quarentine.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	final static  String dbUrl="jdbc:mysql://localhost:3306/quarentinecenter";
	final static String dbUser="root";
	final static String dbPassword="Nikhil@79";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection con =null;
		try{
			con=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			System.out.println("Connected");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	
	}
}
