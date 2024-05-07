package com.jspider.qflix_java_servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.qflix_java_servlet.connection.MovieFlexConnection;
import com.jspider.qflix_java_servlet.dto.Admin;

/*
 * govind
 * 
 */

public class AdminDao {
	
	private Connection connection=MovieFlexConnection.getMovieFlexConnection();
	/*
	 * database queries...
	 */
	
	private final String  SELECT_QUERY_FOR_LOGIN="SEELECT email,password FROM admin WHERE email=?";
	/**
	 * created fetchAdminByEmailForLogin() method
	 */
	
	public Admin fetchAdminByEmailForLoginDao(String adminEmail) {
		
		try {
		
		PreparedStatement prepareStatement=connection.prepareStatement(SELECT_QUERY_FOR_LOGIN);
		
		prepareStatement.setString(1, adminEmail);
		
		ResultSet resulSet=prepareStatement.executeQuery();
		
		resulSet.next();
		
		String email = resulSet.getString("email");
		String password=resulSet.getString("password");
		
		return new Admin(email,password);
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}

}
