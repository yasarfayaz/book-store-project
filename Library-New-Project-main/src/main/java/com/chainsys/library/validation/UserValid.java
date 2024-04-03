package com.chainsys.library.validation;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.library.model.User;

public class UserValid {

	Logger logger = LoggerFactory.getLogger(UserValid.class);
	
	public boolean isValid(User user) {
		//get User Details
		String userName  = user.getUserName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		
		
		boolean nameValidation = userNameValid(userName);
		boolean emailValidation =emailValid(email);
		boolean passwordValidation = passwordValid(password);
		
		if ((nameValidation == true)&&(emailValidation == true)&&
				(passwordValidation == true)) {
			
			return true;
		} else {
			logger.error("There is an Error in User Validation at Java Level");
            return false;
		}
		
		
	}

	//UserName Validation
	public boolean userNameValid(String userName) {
		String nameRegex = "[a-z .A-Z]+$";
		Pattern pattern = Pattern.compile(nameRegex,Pattern.MULTILINE);
		
		if ((pattern.matcher(userName).matches())&&(userName != "")&&(userName != null)&&(userName.length() >= 3)) {
			return true;
		} else {
			logger.error("There is an Error in UserName Validation at Java Level");
            return false;
		}
		
	}
	

	//Email validation
	public boolean emailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                         "[a-zA-Z0-9_+&*-]+)*@"+
	                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                         "A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex,Pattern.MULTILINE);
		
		if ((pattern.matcher(email).matches())&&(email != "")&&(email != null)) {
			return true;
		} else {
			logger.error("There is an Error in Email Validation at Java Level");
            return false;
		}
	}
	
	
	//Password Validation
	public boolean passwordValid(String password) {
		if ((password != "")&&(password != null)&&((password.length() >= 6))) {
			return true;
		} else {
			logger.error("There is an Error in Password Validation at Java Level");
			return false;
		}
		
	}
	
	
}
