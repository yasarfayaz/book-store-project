package com.chainsys.library.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.chainsys.library.mapper.BookMapper;
import com.chainsys.library.mapper.CartMapper;
import com.chainsys.library.mapper.OrderMapper;
import com.chainsys.library.mapper.UserMapper;
import com.chainsys.library.model.Books;
import com.chainsys.library.model.Cart;
import com.chainsys.library.model.Order;
import com.chainsys.library.model.User;

@Repository
public class UserDaoImpl implements UserDao  {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	//User RegisterForm Added
	public void saveUser(User userRegister) {
		try {
			String password = userRegister.getPassword();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encoderPassword = encoder.encode(password);

			String sqlQuery = "INSERT INTO ebook.user (name,email,phone_no, password) VALUES (?,?,?,?)";
			Object[] params = {userRegister.getUserName(),userRegister.getEmail(),userRegister.getPhoneNumber(),encoderPassword};
			jdbcTemplate.update(sqlQuery,params);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("There is Some SQL Error in Adding User");
		}
		
	}

	
	
	
	//Bringing all new Books
	@Override
	public List<Books> newBook() {
		try {
			String sqlQuery = "select * from ebook.book_details where book_category='Science Fiction'";
			List<Books> bookList = jdbcTemplate.query(sqlQuery, new BookMapper());
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("There is Some SQL Error in bringing ScienceFiction Book List");
		    return null;
		}
		
	}

	//Bringing all Comics Books
	@Override
	public List<Books> comicsBook() {
		try {
			String sqlQuery = "select * from ebook.book_details where book_category='Comics'";
			List<Books> bookList = jdbcTemplate.query(sqlQuery, new BookMapper());
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("There is Some SQL Error in bringing Comics Book List");
		    return null;
		}
		
	}

	//Bringing all Historical Books
	@Override
	public List<Books> historicalBook() {
		try {
			String sqlQuery = "select * from ebook.book_details where book_category='Historical'";
			List<Books> bookList = jdbcTemplate.query(sqlQuery, new BookMapper());
			return bookList;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("There is Some SQL Error in bringing Historical Book List");
			return null;
		}
			}

	//User Login Process
	@Override
	public User login(String email, String password) {
		User user = null;
		try {
			String sqlQuery = "select * from ebook.user where email=?";
			 user = jdbcTemplate.queryForObject(sqlQuery, new UserMapper(),email);
			 return user;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Sql Error in Login Page");
			return user;
		}
		
	}

	//User Cart Added
	@Override
	public boolean addCart(Cart cart) {
		boolean f = false;
		try {
			String sqlQuery = "INSERT INTO ebook.cart (book_id,user_id,book_name, author,price,total_price,photo) VALUES (?,?,?,?,?,?,?)";
			Object[] params = {cart.getBookId(),cart.getUserId(),cart.getBookName(),cart.getAuthor(),cart.getPrice(),cart.getTotalPrice(),cart.getPhotoName()};
			int noOfRow = jdbcTemplate.update(sqlQuery, params);
			if (noOfRow == 1) {
				f = true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Cart Added Error in SQL");
		}
		
		return f;
	}

	//Bringing user All CartList
	@Override
	public List<Cart> getBooksbyUser(int userId) {
		List<Cart> cart = null;
		try {
			String sqlQuery = "select * from ebook.cart where user_id=?";
			cart = jdbcTemplate.query(sqlQuery, new CartMapper(),userId);
			return cart;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("There is Some SQL Error in Bringing All CartList");
		     return cart;
		}
		
	}

	//Bringing find one User
	@Override
	public User findOne(int userId) {
		try {
			String sqlQuery = "select * from ebook.user where id = ?";
			User oneRecord = jdbcTemplate.queryForObject(sqlQuery,new UserMapper(),userId);
			return oneRecord;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Findind one User Record Error in SQL Statement");
		    return null;
		}
	}

	//Remove Cart Items
	@Override
	public boolean removeBooks(int cartId) {
		boolean f = false;
		try {
			
			String sqlQuery = "delete from ebook.cart where cart_id='"+cartId+"'";
			int noOfRows = jdbcTemplate.update(sqlQuery);
			if (noOfRows == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Remove Cart Items Error In SQL Statement");
		}
				return f;
	}

	//User OrderList Saved
	@Override
	public boolean saveOrder(List<Order> olist) {
		boolean f =false;
		
		String sqlQuery = "insert into ebook.book_order(order_id,user_name,email,address,phone,book_name,author,price,payment) values(?,?,?,?,?,?,?,?,?)";
		for (Order order : olist) {
			Object[] params = {order.getOrderId(),order.getUserName(),order.getEmail(),order.getFullAdd(),order.getPhoneNumber(),order.getBookName(),order.getAuthor(),order.getPrice(),order.getPaymentType()};
		    jdbcTemplate.update(sqlQuery, params);
		}
		
		f = true;
		return f;
	}

	//Bringing All OrderList Items
	@Override
	public List<Order> getOrderList(String email) {
		List<Order> order = null;
		try {
			String sqlQuery = "select * from ebook.book_order where email=?";
			order = jdbcTemplate.query(sqlQuery, new OrderMapper(),email);
			return order;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Order ALL list Error in SQL Statement");
			return order;
		}
	
	}

	//Bringing Search Book List
	@Override
	public List<Books> getBookBySearch(String ch) {
		try {
			String sqlQuery = "select * from ebook.book_details where book_name like '%"+ch+"%' or author like '%"+ch+"%' or book_category like '%"+ch+"%' and status ='Active'";
			List<Books> bookList = jdbcTemplate.query(sqlQuery, new BookMapper());
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Search List Error in SQL statement");
			return null;
		}

	}

	//Bringing find one User from userlist
	@Override
	public boolean findUser(String email) {
		boolean userCheck =false;
		try {
			List<User>  user = null;
			String sqlQuery = "select * from ebook.user where email = '"+email+"'";
			 user = jdbcTemplate.query(sqlQuery, new UserMapper());
			if (user.isEmpty() ) {
				userCheck =true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Finding one User ERROR In SQL Statement");
		}
		return userCheck;
	}




	@Override
	public List<Books> bookCategory(String bookCategory) {
		try {
			String sqlQuery = "select * from ebook.book_details where book_category='"+bookCategory+"'";
			List<Books> bookList = jdbcTemplate.query(sqlQuery, new BookMapper());
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("There is Some SQL Error in bringing NewBook List");
			logger.error("There is Some SQL Error in Bringing BookCategory List");
		    return null;
		}
	}




	@Override
	public boolean findBook(String bookName) {
		boolean bookCheck = false;
		try {
			List<Books> book = null;
			String sqlQuery = "select * from ebook.book_details where book_name=?";
			book = jdbcTemplate.query(sqlQuery, new BookMapper(),bookName);
			System.out.println("book findone :"+book);
			if (book.isEmpty()) {
				bookCheck = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Findind one Book Record Error in SQL Statement");
		}
		return bookCheck;
	}




	
}
