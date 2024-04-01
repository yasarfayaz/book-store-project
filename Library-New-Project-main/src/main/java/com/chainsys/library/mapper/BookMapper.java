package com.chainsys.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.library.model.Books;

public class BookMapper implements RowMapper<Books>{

	@Override
	public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
		Books books = new Books();
		int bookId = rs.getInt("book_id");
		String bookName = rs.getString("book_name");
		String author = rs.getString("author");
		double price = rs.getDouble("price");
		String bookCategory = rs.getString("book_category");
		String status = rs.getString("status");
		int publishedYear = rs.getInt("published_year");
		int qtyInstock = rs.getInt("qty_instock");
		String photoName = rs.getString("photo");
		
		books.setBookId(bookId);
		books.setBookName(bookName);
		books.setAuthor(author);
		books.setPrice(price);
		books.setBookCategory(bookCategory);
		books.setStatus(status);
		books.setPublishedYear(publishedYear);
		books.setQtyInstock(qtyInstock);
		books.setPhotoName(photoName);
	//	System.out.println(bookId+","+bookName+","+author+","+price+","+bookCategory
		//		+","+status+","+publishedYear+","+qtyInstock+","+photoName);
		return books;
	}

}
