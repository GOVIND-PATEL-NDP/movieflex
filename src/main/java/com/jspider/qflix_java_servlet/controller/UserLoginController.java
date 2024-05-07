package com.jspider.qflix_java_servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.qflix_java_servlet.dao.UserDao;
import com.jspider.qflix_java_servlet.dto.User;

@WebServlet(value = "/userLogin")
public class UserLoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		UserDao dao =new UserDao();
		
		String email=req.getParameter("userEmail");
		String password=req.getParameter("password");
		 
		User user=dao.fetchUserByEmailDao(email);
		
		if(user !=null) {
			if(user.getPassword().equals(password)) {
				
				req.getRequestDispatcher("user-hoome.jps").forward(req, resp);
			}else {
				req.setAttribute("userMsg", "password is invalid");
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("userMsg", "email is invalid");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
	}
}
