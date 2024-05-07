package com.jspider.qflix_java_servlet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MovieFlexConnection {

	/*
	 * connection method
	 */
	
	public static Connection getMovieFlexConnection() {
		
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/qflex";
			String user ="root";
			String pass="root";
			
		return DriverManager.getConnection(url,user,pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
