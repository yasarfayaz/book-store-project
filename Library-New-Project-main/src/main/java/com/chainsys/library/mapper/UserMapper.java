package com.chainsys.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.library.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		int id = rs.getInt("id");
		String userName = rs.getString("name");
		String email =rs.getString("email");
		String password = rs.getString("password");
		String phoneNumber = rs.getString("phone_no");
		String address = rs.getString("address");
		String landmark = rs.getString("landmark");
		String city = rs.getString("city");
		String state = rs.getString("state");
		String pincode = rs.getString("pincode");
		user.setId(id);
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);
		user.setLandmark(landmark);
		user.setCity(city);
		user.setState(state);
		user.setPincode(pincode);
		return user;
	}

}
