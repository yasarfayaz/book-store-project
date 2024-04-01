package com.chainsys.library.dao;

import java.util.List;

import com.chainsys.library.model.Books;
import com.chainsys.library.model.Cart;
import com.chainsys.library.model.Order;
import com.chainsys.library.model.User;

public interface UserDao {

	public void saveUser(User userRegister);
//	public List<User> userList();
	public User findOne(int userId);
	public boolean findUser(String email);
//	public int update(User user);
//	public int delete(String email);
	public List<Books> bookCategory(String bookCategory);
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
