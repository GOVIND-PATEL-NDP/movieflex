package com.jspider.qflix_java_servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.qflix_java_servlet.dao.AdminDao;
import com.jspider.qflix_java_servlet.dto.Admin;

@WebServlet(value = "/adminLogin")
public class AdminLoginController  extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminDao dao=new AdminDao();
		
		String email=req.getParameter("adminEmail");
		String password=req.getParameter("adminpassword");
		 
		Admin admin=dao.fetchAdminByEmailForLoginDao(email);
		
		if(admin !=null) {
			if(admin.getAdminPassword().equals(password)) {
				
				req.getRequestDispatcher("admin-home.jps").forward(req, resp);
			}else {
				req.setAttribute("adminMsg", "password is invalid");
				req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("adminMsg", "email is invalid");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
		
	}
}
