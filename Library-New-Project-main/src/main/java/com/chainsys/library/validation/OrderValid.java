package com.chainsys.library.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.library.model.Order;

public class OrderValid {

	Logger logger = LoggerFactory.getLogger(OrderValid.class);
	public boolean isValid(String name,String email,String phoneNumber,String address,
			String landmark,String city,String state,String pincode) {

		boolean nameValidation = nameValid(name);
		boolean emailValidation = emailValid(email);
		boolean phoneValidation = phoneNumberValid(phoneNumber);
		boolean addressValidation = addressValid(address);
		boolean landmarkValidation = landmarkValid(landmark);
		boolean stateValidation = stateValid(state);
		boolean cityValidation = cityValid(city);
		boolean pincodeValidation = pincodeValid(pincode);
		
		//System.out.println("Full address in  Valid class .."+fullAdd);
		if ((nameValidation == true) && (emailValidation == true) && (phoneValidation == true) &&
				(addressValidation == true) && (landmarkValidation == true) && (stateValidation == true) &&
				(cityValidation == true) && (pincodeValidation == true) ) {
			return true;
		} else {
			logger.error("There is an Error in Order Validation at Java Level");
            return false;
		}
	}
	
	public boolean nameValid(String name) {
		if ((name != "") && (name != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order userName Validation at Java Level");
            return false;
		}
	}
	
	public boolean emailValid(String email) {
		if ((email != "") && (email != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order userEmail Validation at Java Level");
            return false;
		}
	}
	
	public boolean phoneNumberValid(String phoneNumber) {
		if ((phoneNumber != "") && (phoneNumber != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order userPhoneNumber Validation at Java Level");
            return false;
		}
	}
	
	public boolean addressValid(String address) {
		if ((address != "") && (address != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order useraddress Validation at Java Level");
            return false;
		}
	}
	
	public boolean landmarkValid(String landmark) {
		if ((landmark != "") && (landmark != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order userLandmark Validation at Java Level");
            return false;
		}
	}
	
	public boolean cityValid(String city) {
		if ((city != "") && (city != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order userCity Validation at Java Level");
            return false;
		}
	}
	
	public boolean stateValid(String state) {
		if ((state != "") && (state != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order userState Validation at Java Level");
            return false;
		}
	}
	
	public boolean pincodeValid(String pincode) {
		if ((pincode != "") && (pincode != null)) {
			return true;
		} else {
			logger.error("There is an Error in Order userPinCode Validation at Java Level");
            return false;
		}
	}
}
