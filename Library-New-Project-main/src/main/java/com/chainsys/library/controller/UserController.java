package com.chainsys.library.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.library.dao.AdminDaoImpl;
import com.chainsys.library.dao.UserDao;
import com.chainsys.library.dao.UserDaoImpl;
import com.chainsys.library.model.Books;
import com.chainsys.library.model.Cart;
import com.chainsys.library.model.Order;
import com.chainsys.library.model.User;
import com.chainsys.library.validation.BookValid;
import com.chainsys.library.validation.OrderValid;
import com.chainsys.library.validation.UserValid;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserDaoImpl userdao;
	
	@Autowired
	AdminDaoImpl admindaoImpl;
	
	
	UserValid userValid = new UserValid();
	BookValid bookValid = new BookValid();
	OrderValid orderValid = new OrderValid();
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	
	
	
	// Home Page
	@RequestMapping("/home")
	public String home(Model model) {
		List<Books> newBooks = userdao.newBook();
		List<Books> comicsBooks = userdao.comicsBook();
		List<Books> historicalBooks = userdao.historicalBook();
		model.addAttribute("newBook", newBooks);
		model.addAttribute("comicsBook", comicsBooks);
		model.addAttribute("historicalBook", historicalBooks);
		logger.info("mindKey WelCome User..");
		return  "home.html";
	}
	
	// user Home Page
	@RequestMapping("/userHome")
	public String userHome(Model model,@RequestParam("uid") int id) {
		User user = userdao.findOne(id);
		model.addAttribute("userobj", user);
		List<Books> newBooks = userdao.newBook();
		List<Books> comicsBooks = userdao.comicsBook();
		List<Books> historicalBooks = userdao.historicalBook();
		model.addAttribute("newBook", newBooks);
		model.addAttribute("comicsBook", comicsBooks);
		model.addAttribute("historicalBook", historicalBooks);
		return  "items.jsp";
	}
	
	//Register Page
	@RequestMapping("/reg")
	public String register() {
		return "register.jsp";
	}
	
	//User Register Added
	@GetMapping("/addUser")
	public String addUser(User user,Model model) {
		boolean usersValid = userValid.isValid(user);
		if (usersValid == true) {
			String email = user.getEmail();
			boolean checkUser = userdao.findUser(email);
			if (checkUser == true) {
				userdao.saveUser(user);
				model.addAttribute("success", "Register Successfully");
				logger.info("User Register is Validated");
				return "login.jsp";
			} else { 
				model.addAttribute("failed", "Email Already Exists");
				logger.error("User Email Already Exists");
				return "register.jsp";
			}
			
		} else {
			logger.error("User Register Not Validated");
			model.addAttribute("failed", "Register Not Validated");
            return "register.jsp";
            
		}
		
	}
	
	// Admin books added
	@GetMapping("/addBook")
	public String addBooks(Books books,Model model) {
		boolean booksValid = bookValid.isValid(books);
		if (booksValid) {
			boolean checkBook = userdao.findBook(books.getBookName());
			if (checkBook==true) {
				int addedbooks = admindaoImpl.addBooks(books);
				List<Books> book = admindaoImpl.bookList();
				model.addAttribute("book_list", book);
				model.addAttribute("bookAdd", "Books Added");
				return "additems.jsp";
			} else {
				List<Books> book = admindaoImpl.bookList();
				model.addAttribute("book_list", book);
				model.addAttribute("bookAdd", "This Book Already Exists");
				logger.error("Book Name Already Exists");
				return "additems.jsp";
			}
			
		} else {
			List<Books> book = admindaoImpl.bookList();
			model.addAttribute("book_list", book);
			model.addAttribute("bookAdd", "Books Not Validated");
			logger.error("Books Not Validated");
			return "additems.jsp";
		}

		
	}
	
	@RequestMapping("/adminHome")
	public String adminHome(Model model) {
		List<Order> order = admindaoImpl.getAllOrderList();
		model.addAttribute("allOrder", order);
		return "adminDashboard.jsp";
	}
	
	//login Page
	@GetMapping("/log")
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
		String adminEmail ="ahamednoorullah@gmail.com";
		String adminPassword = "12345678";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user =new User();
		if (email.contentEquals(adminEmail) && password.contentEquals(adminPassword)) {
			model.addAttribute("userobj", user);
			List<Order> order = admindaoImpl.getAllOrderList();
			model.addAttribute("allOrder", order);
			return "adminDashboard.jsp";
		} else {
			user = userdao.login(email, password);
			if (user != null) {
				String encodePassword = user.getPassword();
				boolean passwordMatches = encoder.matches(password, encodePassword);
				if (passwordMatches) {
					List<Books> newBooks = userdao.newBook();
					List<Books> comicsBooks = userdao.comicsBook();
					List<Books> historicalBooks = userdao.historicalBook();
					model.addAttribute("newBook", newBooks);
					model.addAttribute("comicsBook", comicsBooks);
					model.addAttribute("historicalBook", historicalBooks);
					model.addAttribute("userobj", user);
					logger.info("User Login Valided");
					return "items.jsp";	
				}
				else {
					model.addAttribute("failedMsg", "Email or Password Invalid");
	                logger.error("User Login Not Valided");
	                return "login.jsp";
				}
			} else {
                model.addAttribute("failedMsg", "Email or Password Invalid");
                logger.error("User Login Not Valided");
                return "login.jsp";
			}
		}
	}
	
	//Admin All Books Viewed
	@GetMapping("/allBooks")
	public String allBooks(Model model) {
		List<Books> books = admindaoImpl.bookList();
		model.addAttribute("book_list", books);
		return "additems.jsp";
	}
	
	//Admin Books Edited Page
	@GetMapping("/updateBooks")
	public String updateBook(@RequestParam("id") int id,Model model) {
		Books books = admindaoImpl.findone(id);
		model.addAttribute("bookFound", books);
		List<Books> book = admindaoImpl.bookList();
		model.addAttribute("book_list", book);
		return "editBooks.jsp";
	}
	
	// Admin Books Edited ViewPage
	@GetMapping("/updateBookData")
	public String updateBooksData(Books books,Model model) {
		int updateRows = admindaoImpl.update(books);
        Model addAttribute = model.addAttribute(updateRows);
        model.addAttribute("updateBook",books);
		return "redirect:allBooks";
	}
	
	//Admin Book Deleted Process 
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") int id,Model model) {
		Books books= new Books();
		int deleteRow = admindaoImpl.deleteBook(id);
		Model addAttribute = model.addAttribute(deleteRow);
        model.addAttribute("deleteBook",books);
        logger.info("Admin has deleted a Book ");
		return "redirect:allBooks";
	}

	@RequestMapping("/bookCategory")
	public String bookCategory(@RequestParam("uid") int userId,Model model,@RequestParam("bookCategory") String bookCategory) {
		List<Books> bookCate = userdao.bookCategory(bookCategory);
		User user = userdao.findOne(userId);
		model.addAttribute("bookCate", bookCate);
		model.addAttribute("userobj", user);
		model.addAttribute("bookCategory", bookCategory);
		return "viewitems.jsp";
		
	}
	
	//User Cart Added Process
	@GetMapping("/cart")
	public String addCart(@RequestParam("bid") int bookId,@RequestParam("uid") int userId,
			Cart cart,HttpSession session,Model model) {
		Books books = admindaoImpl.findone(bookId);
		User user = admindaoImpl.findUser(userId);
		cart.setBookId(bookId);
		cart.setUserId(userId);
		cart.setBookName(books.getBookName());
		cart.setAuthor(books.getAuthor());
		cart.setPhotoName(books.getPhotoName());
		cart.setPrice(books.getPrice());
		cart.setTotalPrice(books.getPrice());
		boolean f = userdao.addCart(cart);
		if (f) {
			logger.info("Cart Added Successfully");
			model.addAttribute("addCart", "Books Added to Carting");
			model.addAttribute("userobj", user);
			List<Books> newBooks = userdao.newBook();
			List<Books> comicsBooks = userdao.comicsBook();
			model.addAttribute("newBook", newBooks);
			model.addAttribute("comicsBook", comicsBooks);
			return "items.jsp";
		} else {
			List<Books> newBooks = userdao.newBook();
			List<Books> comicsBooks = userdao.comicsBook();
			model.addAttribute("newBook", newBooks);
			model.addAttribute("comicsBook", comicsBooks);
			logger.warn("Not Added to Cart");
            session.setAttribute("failed", "Something Went Wrong..");
			return "items.jsp";
		}
		
	}
	
	//User Cart View Page
	@GetMapping("/cartOut")
	public String cartDisplay(@RequestParam("uid") int userId,Model model) {
		//Date Format in Delivery Details
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR,7);
		Date resultDate = calendar.getTime();
		String formattedDate = sdf.format(resultDate);
		
		List<Cart> cart = userdao.getBooksbyUser(userId);
		User user = userdao.findOne(userId);
		model.addAttribute("cart", cart);
		model.addAttribute("userobj", user);
		model.addAttribute("deliveryDate", formattedDate);
		return "cartItems.jsp";
	}
	
	//User Cart remove Book Process
	@GetMapping("/removeBook")
	public String removeBooks(@RequestParam("cid") int cartId,@RequestParam("uid") int userId,Model model) {
		boolean f = userdao.removeBooks(cartId);
		if (f) {
			model.addAttribute("successMsg", "Book Removed From Cart");
			List<Cart> cart = userdao.getBooksbyUser(userId);
			User user = userdao.findOne(userId);
			model.addAttribute("cart", cart);
			model.addAttribute("userobj", user);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR,7);
			Date resultDate = calendar.getTime();
			String formattedDate = sdf.format(resultDate);
			model.addAttribute("deliveryDate", formattedDate);
			
			return "cartItems.jsp";
		} else {
			List<Cart> cart = userdao.getBooksbyUser(userId);
			User user = userdao.findOne(userId);
			model.addAttribute("cart", cart);
			model.addAttribute("userobj", user);
            model.addAttribute("failedMsg", "Something Went Wrong..");
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
        	Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR,7);
			Date resultDate = calendar.getTime();
			String formattedDate = sdf.format(resultDate);
			model.addAttribute("deliveryDate", formattedDate);
			
            return "cartItems.jsp";
		}
		
	}
	
	//User Order Process
	@GetMapping("/order")
	public String order(Model model,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address,@RequestParam("landmark") String landmark,@RequestParam("city") String city,
			@RequestParam("state") String state,@RequestParam("pincode") String pincode,@RequestParam("id") int id) {
		String fullAdd = address+","+landmark+","+city+","+state+","+pincode;

		boolean ordersValid = orderValid.isValid(name, email, phoneNumber, address, landmark, city, state, pincode);
		if (ordersValid) {
			List<Cart> blist = userdao.getBooksbyUser(id);
			User user = userdao.findOne(id);
			Order order = null;
			ArrayList<Order> orderList = new ArrayList<>();
			int i = 1;
			Random r = new Random();
			int qtyUpdate = 0;
			for (Cart c : blist) {
				order = new Order();
				order.setOrderId("BOOK-ORD-00" + r.nextInt(100));
				order.setUserName(name);
				order.setEmail(email);
				order.setPhoneNumber(phoneNumber);
				order.setFullAdd(fullAdd);
				order.setBookName(c.getBookName());
				order.setAuthor(c.getAuthor());
				order.setPrice(c.getPrice());
				order.setPaymentType("COD");
				orderList.add(order);
				Books books = admindaoImpl.findone(c.getBookId());
				qtyUpdate = books.getQtyInstock();
				qtyUpdate--;
				admindaoImpl.bookQtyUpdate(c.getBookName(), qtyUpdate);
				if(qtyUpdate == 0) {
					int deleteRow = admindaoImpl.deleteBook(c.getBookId());
				}
			}
	             boolean f = userdao.saveOrder(orderList);
	             if (f) {
	            	 for (Cart cartItem : blist) {
						boolean removeCart = userdao.removeBooks(cartItem.getCartId());
					}
	            	 logger.info("Order Success");
	            	 model.addAttribute("userobj", user);
	            	 return "thankyou.jsp";
					
				}else {
					logger.warn("Order Failed");
					List<Cart> cart = userdao.getBooksbyUser(id);
					User users = userdao.findOne(id);
					model.addAttribute("cart", cart);
					model.addAttribute("userobj", users);
					model.addAttribute("failedMsg", "Something Went Wrong..");
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.DAY_OF_YEAR,7);
					Date resultDate = calendar.getTime();
					String formattedDate = sdf.format(resultDate);
					model.addAttribute("deliveryDate", formattedDate);
					
					return "cartItems.jsp";
					
				}
		} else {
			logger.warn("Delivery Details Invalided");
			List<Cart> cart = userdao.getBooksbyUser(id);
			User users = userdao.findOne(id);
			model.addAttribute("cart", cart);
			model.addAttribute("userobj", users);
			model.addAttribute("failedMsg", "Order Details Invalided");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR,7);
			Date resultDate = calendar.getTime();
			String formattedDate = sdf.format(resultDate);
			model.addAttribute("deliveryDate", formattedDate);
			
              return "cartItems.jsp";
		}
		
		}

	
	//Admin All Orders View Page
	@GetMapping("/allOrders")
	public String getAllOrder(Model model) {
		List<Order> order = admindaoImpl.getAllOrderList();
		model.addAttribute("allOrder", order);
		return "allOrders.jsp";
	}
	
	//User Search Book Process
	@GetMapping("/searchBook")
	public String getSearchBook(@RequestParam("ch") String ch,@RequestParam("uid") int id,Model model) {
		//System.out.println("search Character .."+ch);
		List<Books> books = userdao.getBookBySearch(ch);
		User user = userdao.findOne(id);
		model.addAttribute("userobj", user);
		model.addAttribute("searchBook", books);
		//System.out.println("search Book .. "+books);
		return "search.jsp";
	}
		

}
