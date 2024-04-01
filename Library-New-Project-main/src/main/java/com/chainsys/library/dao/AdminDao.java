package com.chainsys.library.dao;

import java.util.List;

import com.chainsys.library.model.Books;
import com.chainsys.library.model.Order;
import com.chainsys.library.model.User;

public interface AdminDao {

	public int addBooks(Books books);
	public List<Books> bookList();
	public Books findone(int id);
	public User findUser(int userId);
	public int update(Books books);
	public int deleteBook(int id);
	public List<Order> getAllOrderList();
	public int bookQtyUpdate(String bookName,int qtyUpdate);
	
}
