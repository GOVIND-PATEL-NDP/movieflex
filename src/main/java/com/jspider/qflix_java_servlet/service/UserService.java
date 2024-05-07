package com.jspider.qflix_java_servlet.service;

import com.jspider.qflix_java_servlet.dao.UserDao;
import com.jspider.qflix_java_servlet.dto.User;
import com.jspider.qflix_java_servlet.varification.EmailPasswordVerification;

public class UserService {

	UserDao dao = new UserDao();
	
	public User userRegistrationService(User user) {
		String email=EmailPasswordVerification.emailVarification(user.getEmail());
		String password= EmailPasswordVerification.passwordVarification(user.getPassword());
		if((email !=null) && (password !=null)) {
			return dao.userRegistrationDao(user);
		}else {
			return null;
		}
	}
}
