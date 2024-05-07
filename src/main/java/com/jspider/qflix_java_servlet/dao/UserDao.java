package com.jspider.qflix_java_servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.qflix_java_servlet.connection.MovieFlexConnection;
import com.jspider.qflix_java_servlet.dto.User;
import com.jspider.qflix_java_servlet.varification.EmailPasswordVerification;

/**
 * 
 * @author Govind Patel
 */

public class UserDao {

	private Connection connection=MovieFlexConnection.getMovieFlexConnection();
	
	private final String INSERT_USER_QUERY="insert into user(name,email,password,dob,phone,gender) values(?,?,?,?,?,?)";
	
	private final String FETCH_USER_BY_EMAIL_QUERY = "SELECT * from user where email=?";
	
	/**
	 * User Registration method which will help the programmer to register user and 
	 * save his/her details for permanent inside mysql table
	 * @param user
	 * @return
	 */
	public User userRegistrationDao(User user) {
		
		
		try {
			PreparedStatement ps=connection.prepareStatement(INSERT_USER_QUERY);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setObject(4, user.getDob());
			ps.setLong(5, user.getPhone());
			ps.setString(6, user.getName());
			
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * fetchUserByEmail for login
	 */
	
	public User fetchUserByEmailDao(String userEmail) {
		try {
			PreparedStatement ps=connection.prepareStatement(FETCH_USER_BY_EMAIL_QUERY);
			ps.setString(1, userEmail);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String email =rs.getString("email");
			String password=rs.getString("password");
			
			return new User(email, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
