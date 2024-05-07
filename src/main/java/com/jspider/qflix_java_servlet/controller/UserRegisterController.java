package com.jspider.qflix_java_servlet.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.qflix_java_servlet.dto.User;
import com.jspider.qflix_java_servlet.service.UserService;

public class UserRegisterController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

UserService service=new UserService();
		
		User user=new User("Amit", "amit12@gmail.com", "Amit@123", LocalDate.parse("1998-10-23"), 32456789, "male");
		
		User user2=service.userRegistrationService(user);
		
		
		super.doPost(req, resp);
	}
		
		
		
	}


