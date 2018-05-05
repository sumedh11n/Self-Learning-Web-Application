package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/icsi518_hw4"; // MySQL URL followed by the database name
		String username = "icsi518"; // MySQL username
		String password = "secretICSI518"; // MySQL password
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // loading MySQL drivers
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, username, password); // attempting to connect to MySQL database
			//System.out.println("Printing connection object " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}