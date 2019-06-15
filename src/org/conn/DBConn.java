package org.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection conn;

	public static Connection get() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (conn == null) {
				String url = "jdbc:mysql://localhost:3306/library";
				String usr = "root";
				String pass = "1234567";
				conn = DriverManager.getConnection(url, usr, pass);
			}
		} catch (SQLException | ClassNotFoundException e) {

		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(DBConn.get());
		System.out.println(DBConn.get());
		DBConn.close();
		System.out.println(DBConn.get());
		System.out.println(DBConn.get());
		DBConn.close();
	}
	private static void close() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}	
		}
		
		
	}
}
