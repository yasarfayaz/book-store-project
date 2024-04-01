package com.chainsys.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chainsys.library.mapper.BookMapper;
import com.chainsys.library.mapper.OrderMapper;
import com.chainsys.library.mapper.UserMapper;
import com.chainsys.library.model.Books;
import com.chainsys.library.model.Order;
import com.chainsys.library.model.User;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public int addBooks(Books books) {
		String sqlQuery = "INSERT INTO ebook.book_details (book_name,author,price,book_category,status,published_year,qty_instock,photo) VALUES (?,?,?,?,?,?,?,?)";
		Object[] params = {books.getBookName(),books.getAuthor(),books.getPrice(),books.getBookCategory(),books.getStatus(),books.getPublishedYear(),books.getQtyInstock(),books.getPhotoName()};
		int noOfRow=jdbcTemplate.update(sqlQuery,params);
		return noOfRow;
	}
	@Override
	public List<Books> bookList() {
		String sqlQuery = "select * from ebook.book_details";
		List<Books> bookList = jdbcTemplate.query(sqlQuery, new BookMapper());
		return bookList;
	}
	@Override
	public Books findone(int id) {
		String sqlQuery = "select * from ebook.book_details where book_id = ?";
		Books oneRecord = jdbcTemplate.queryForObject(sqlQuery,new BookMapper(),id);
		return oneRecord;
	}
	@Override
	public int update(Books books) {
		String sqlQuery = "update ebook.book_details set book_name=?,author=?,price=?,book_category=?,status=?,published_year=?,qty_instock=?,photo=? where book_id=?";
		Object[] params = {books.getBookName(),books.getAuthor(),books.getPrice(),books.getBookCategory(),books.getStatus(),books.getPublishedYear(),books.getQtyInstock(),books.getPhotoName(),books.getBookId()};
		//System.out.println("dao update.."+books.getBookName()+","+books.getQtyInstock()+","+books.getBookId());
		int noOfRow = jdbcTemplate.update(sqlQuery, params);
		return noOfRow;
	}
	@Override
	public int deleteBook(int id) {
		String sqlQuery = "delete from ebook.book_details where book_id='"+id+"'";
		int noOfRows = jdbcTemplate.update(sqlQuery);
		return noOfRows;
	}
	@Override
	public User findUser(int userId) {
		String sqlQuery = "select * from ebook.user where id = ?";
	User oneRecord = jdbcTemplate.queryForObject(sqlQuery,new UserMapper(),userId);
		return oneRecord;
	
	}
	@Override
	public List<Order> getAllOrderList() {
		List<Order> order = null;
		String sqlQuery = "select * from ebook.book_order";
		order = jdbcTemplate.query(sqlQuery, new OrderMapper());
		return order;

	}
	@Override
	public int bookQtyUpdate(String bookName,int qtyUpdate) {
		String sqlQuery = "update ebook.book_details set qty_instock='"+qtyUpdate+"' where book_name='"+bookName+"'";
		int noOfRow = jdbcTemplate.update(sqlQuery);
		return noOfRow;
	}
	

	
}
