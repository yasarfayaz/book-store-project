package com.chainsys.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.library.model.Cart;

public class CartMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		int cartId = rs.getInt("cart_id");
		int bookId = rs.getInt("book_id");
		int userId = rs.getInt("user_id");
		String bookName = rs.getString("book_name");
		String author = rs.getString("author");
		String photoName = rs.getString("photo");
		double price = rs.getDouble("price");
		double totalPrice = rs.getDouble("total_price");
		
		cart.setCartId(cartId);
		cart.setBookId(bookId);
		cart.setUserId(userId);
		cart.setBookName(bookName);
		cart.setAuthor(author);
		cart.setPhotoName(photoName);
		cart.setPrice(price);
		cart.setTotalPrice(totalPrice);
		return cart;
	}

}
