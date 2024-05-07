package com.jspider.qflix_java_servlet.varification;

import java.util.regex.Pattern;

/**
 * @author Govind Patel
 */

public class EmailPasswordVerification {

	public static String emailVarification(String emailVarificatioin) {
		
	 boolean character=	Pattern.compile("[a-z]").matcher(emailVarificatioin).find();
	 boolean number=	Pattern.compile("[0-9]").matcher(emailVarificatioin).find();
	 boolean special=	Pattern.compile("[@.]").matcher(emailVarificatioin).find();
	 return (character)?emailVarificatioin:null;
	}
	public static String passwordVarification(String password) {
		
		boolean character=	Pattern.compile("[a-zA-Z]").matcher(password).find();
		boolean number=	Pattern.compile("[0-9]").matcher(password).find();
		boolean special=	Pattern.compile("[@$%&*]").matcher(password).find();
		
		return (character)?password:null;
	}
	
}
