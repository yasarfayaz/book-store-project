package com.chainsys.library.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.library.dao.AdminDaoImpl;
import com.chainsys.library.dao.UserDaoImpl;
import com.chainsys.library.model.Books;
import com.chainsys.library.model.Cart;
import com.chainsys.library.model.Order;
import com.chainsys.library.model.User;
import com.chainsys.library.validation.BookValid;
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
	
	
	// Home Page
	@RequestMapping("/home")
	public String home(Model model) {
		List<Books> newBooks = userdao.newBook();
		List<Books> comicsBooks = userdao.comicsBook();
		List<Books> historicalBooks = userdao.historicalBook();
		model.addAttribute("newBook", newBooks);
		model.addAttribute("comicsBook", comicsBooks);
		model.addAttribute("historicalBook", historicalBooks);
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
//		System.out.println(user.getEmail());
		boolean usersValid = userValid.isValid(user);
		if (usersValid == true) {
			String email = user.getEmail();
			boolean checkUser = userdao.findUser(email);
			if (checkUser == true) {
				userdao.saveUser(user);
				model.addAttribute("success", "Register Successfully");
			} else {
				model.addAttribute("failed", "Email Already Exists");
			}
			System.out.println("Register Valid");
			return "login.jsp";
		} else {
			System.out.println("Register Not Valid");
			model.addAttribute("failed", "Register Not Validated");
            return "register.jsp";
            
		}
		
	}
	
	// Admin books added
	@GetMapping("/addBook")
	public String addBooks(Books books,Model model) {
		boolean booksValid = bookValid.isValid(books);
		if (booksValid) {
			int addedbooks = admindaoImpl.addBooks(books);
			List<Books> book = admindaoImpl.bookList();
			model.addAttribute("book_list", book);
			model.addAttribute("bookAdd", "Books Added");
		} else {
			model.addAttribute("bookNotAdd", "Books Not Added");
		}

		return "additems.jsp";
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
//		System.out.println(email);
//		System.out.println(password);
		User user =new User();
		if (email.contentEquals(adminEmail) && password.contentEquals(adminPassword)) {
			model.addAttribute("userobj", user);
			List<Order> order = admindaoImpl.getAllOrderList();
			model.addAttribute("allOrder", order);
			return "adminDashboard.jsp";
		} else {
			user = userdao.login(email, password);
			if (user != null) {
				List<Books> newBooks = userdao.newBook();
				List<Books> comicsBooks = userdao.comicsBook();
				List<Books> historicalBooks = userdao.historicalBook();
				model.addAttribute("newBook", newBooks);
				model.addAttribute("comicsBook", comicsBooks);
				model.addAttribute("historicalBook", historicalBooks);
				model.addAttribute("userobj", user);
				return "items.jsp";
			} else {
                model.addAttribute("failedMsg", "Email or Password Invalid");
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
//		System.out.println("updateBook.."+books.getBookName());
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
		return "redirect:allBooks";
	}

	@RequestMapping("/bookCategory")
	public String bookCategory(@RequestParam("uid") int userId,Model model,@RequestParam("bookCategory") String bookCategory) {
		System.out.println("Book Category..."+bookCategory);
		List<Books> bookCate = userdao.bookCategory(bookCategory);
		System.out.println(bookCate);
		User user = userdao.findOne(userId);
		model.addAttribute("bookCate", bookCate);
		model.addAttribute("userobj", user);
		model.addAttribute("bookCategory", bookCategory);
		return "viewitems.jsp";
		
	}
	
	
//	//User NewBooks ViewPage
//	@RequestMapping("/newBook")
//	public String newBook(@RequestParam("uid") int userId,Model model) {
//		List<Books> newBooks = userdao.newBook();
//		User user = userdao.findOne(userId);
//		model.addAttribute("newBooks", newBooks);
//		model.addAttribute("userobj", user);
//		return "newBooks.jsp";
//	}
//	
//	//User ComicsBooks ViewPage
//	@RequestMapping("/comicsBook")
//	public String bestBook(@RequestParam("uid") int userId,Model model) {
//		List<Books> comicsBooks = userdao.comicsBook();
//		User user = userdao.findOne(userId);
//		model.addAttribute("comicsBooks", comicsBooks);
//		model.addAttribute("userobj", user);
//		return "comicsBooks.jsp";
//	}
//	
//	//User HistoricalBooks ViewPage
//	@RequestMapping("/historicalBook")
//	public String kidsBook(@RequestParam("uid") int userId,Model model) {
//		List<Books> historicalBooks = userdao.historicalBook();
//		User user = userdao.findOne(userId);
//		model.addAttribute("historicalBooks", historicalBooks);
//		model.addAttribute("userobj", user);
//		return "historicalBooks.jsp";
//	}
	
//	//User(without login) SelectedBook View Page
//	@GetMapping("/viewBooks")
//	public String viewBooks(@RequestParam("id") int id,@RequestParam("uid") int uid,Model model) {
//		Books books = admindaoImpl.findone(id);
//		User user = userdao.findOne(uid);
//		model.addAttribute("viewBooks", books);
//		model.addAttribute("userobj", user);
//		return "view_books.jsp";
//	}
//	
//	//User SelectedBook View Page
//	@GetMapping("/viewUserBooks")
//	public String viewUserBooks(@RequestParam("id") int id,@RequestParam("uid") int uid,Model model) {
//		Books books = admindaoImpl.findone(id);
//		User user = userdao.findOne(uid);
//		model.addAttribute("viewBooks", books);
//		model.addAttribute("userobj", user);
//		return "viewUserBooks.jsp";
//	}
	
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
			System.out.println("Add Cart Success");
//			session.setAttribute("addCart", "Books Added to Cart");
			model.addAttribute("addCart", "Books Added to Carting");
			model.addAttribute("userobj", user);
			List<Books> newBooks = userdao.newBook();
			List<Books> comicsBooks = userdao.comicsBook();
			List<Books> historicalBooks = userdao.historicalBook();
//			System.out.println(newBooks);
			model.addAttribute("newBook", newBooks);
			model.addAttribute("comicsBook", comicsBooks);
			model.addAttribute("historicalBook", historicalBooks);
			return "items.jsp";
		} else {
			List<Books> newBooks = userdao.newBook();
			List<Books> comicsBooks = userdao.comicsBook();
			model.addAttribute("newBook", newBooks);
			model.addAttribute("comicsBook", comicsBooks);
            System.out.println("Not Added to Cart");
            session.setAttribute("failed", "Something Went Wrong..");
			return "items.jsp";
		}
		
	}
	
	//User Cart View Page
	@GetMapping("/cartOut")
	public String cartDisplay(@RequestParam("uid") int userId,Model model) {
		List<Cart> cart = userdao.getBooksbyUser(userId);
		User user = userdao.findOne(userId);
		System.out.println("cart controller...."+cart);
		model.addAttribute("cart", cart);
		model.addAttribute("userobj", user);
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
			System.out.println("cart controller...."+cart);
			model.addAttribute("cart", cart);
			model.addAttribute("userobj", user);
			return "cartItems.jsp";
		} else {
			List<Cart> cart = userdao.getBooksbyUser(userId);
			User user = userdao.findOne(userId);
			model.addAttribute("cart", cart);
			model.addAttribute("userobj", user);
            model.addAttribute("failedMsg", "Something Went Wrong..");
            return "cartItems.jsp";
		}
		
	}
	
	//User Order Process
	@GetMapping("/order")
	public String order(Model model,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address,@RequestParam("landmark") String landmark,@RequestParam("city") String city,
			@RequestParam("state") String state,@RequestParam("pincode") String pincode,@RequestParam("id") int id) {
		String fullAdd = address+","+landmark+","+city+","+state+","+pincode;
		
		System.out.println( name+","+email+","+phoneNumber+","+fullAdd+",");
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
            	 System.out.println("order Success");
            	 model.addAttribute("userobj", user);
            	 return "thankyou.jsp";
				
			}else {
				System.out.println("order Failed");
				List<Cart> cart = userdao.getBooksbyUser(id);
				User users = userdao.findOne(id);
				model.addAttribute("cart", cart);
				model.addAttribute("userobj", users);
				model.addAttribute("failedMsg", "Something Went Wrong..");
				return "cartItems.jsp";
				
			}
		}

	
//	//User Order View Page
//	@GetMapping("/userOrder")
//	public String userOrder(@RequestParam("email") String email,Model model) {
//		List<Order> order = userdao.getOrderList(email);
//		System.out.println("userorder .."+order);
//		model.addAttribute("order",order);
//		return "user_order.jsp";
//	}
	
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
		System.out.println("search Character .."+ch);
		List<Books> books = userdao.getBookBySearch(ch);
		User user = userdao.findOne(id);
		model.addAttribute("userobj", user);
		model.addAttribute("searchBook", books);
		System.out.println("search Book .. "+books);
		return "search.jsp";
	}
	
//	//User(Without login) Search Book Process
//    @GetMapping("/searchHome")  
//	public String getSearchHomePage(@RequestParam("ch") String ch,Model model) {
//		List<Books> books = userdao.getBookBySearch(ch);
//		model.addAttribute("searchBook", books);
//		return "searchBookHomePage.jsp";
//	}
	

}
