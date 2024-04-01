package com.chainsys.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.library.model.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		int id = rs.getInt("id");
		String orderId = rs.getString("order_id");
		String userName =rs.getString("user_name");
		String email = rs.getString("email");
		String fullAdd = rs.getString("address");
		String phoneNumber = rs.getString("phone");
		String bookName=rs.getString("book_name");
		String author = rs.getString("author");
		double price = rs.getDouble("price");
		String paymentType = rs.getString("payment");
		
		order.setId(id);
		order.setOrderId(orderId);
		order.setUserName(userName);
		order.setEmail(email);
		order.setFullAdd(fullAdd);
		order.setPhoneNumber(phoneNumber);
		order.setBookName(bookName);
		order.setAuthor(author);
		order.setPrice(price);
		order.setPaymentType(paymentType);
		return order;
	}

}
