package com.chainsys.library.dao;

import java.util.List;

import com.chainsys.library.model.Books;
import com.chainsys.library.model.Cart;
import com.chainsys.library.model.Order;
import com.chainsys.library.model.User;

public interface UserDao {

	public void saveUser(User userRegister);
	public User findOne(int userId);
	public boolean findUser(String email);
	public List<Books> bookCategory(String bookCategory);
	public boolean findBook(String bookName);
	public List<Books> newBook();
	public List<Books> comicsBook();
	public List<Books> historicalBook();
	public User login(String email,String pasword);
	public boolean addCart(Cart cart);
	public List<Cart> getBooksbyUser(int userId);
	public boolean removeBooks(int cartId);
	public boolean saveOrder(List<Order> olist);
	public List<Order> getOrderList(String email);
	public List<Books> getBookBySearch(String ch);
}
