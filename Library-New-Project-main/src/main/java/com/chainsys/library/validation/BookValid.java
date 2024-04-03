package com.chainsys.library.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.relational.core.sql.IsNull;

import com.chainsys.library.model.Books;

public class BookValid {

	Logger logger = LoggerFactory.getLogger(BookValid.class);
	
	public boolean isValid(Books books) {
		String bookName = books.getBookName();
		String author = books.getAuthor();
		double price = books.getPrice();
		String bookCategory = books.getBookCategory();
		String status = books.getStatus();
		int publishedYear=books.getPublishedYear();
		int qtyInstock =books.getQtyInstock();
		
		boolean bookNameValidation = bookNameValid(bookName);
		boolean authorValidation = authorValid(author);
		boolean priceValidation = priceValid(price);
		boolean bookCategoryValidation = bookCategoryValid(bookCategory);
		boolean statusValidation = statusValid(status);
		boolean yearValidation = yearValid(publishedYear);
		
		if ((bookNameValidation == true) && (authorValidation == true) && (bookCategoryValidation == true)
				&& (priceValidation == true) && (statusValidation == true) && (yearValidation == true)) {
			return true;
		} else {
			logger.error("There is an Error in Book Validation at Java Level");
            return false;
            
		}
		
		
		
	}
	
	public boolean bookNameValid(String bookName) {
		if ((bookName != "") && (bookName != null)) {
			return true;
		} else {
			logger.error("There is an Error in BookName Validation at Java Level");
            return false;
		}
	}
	
	public boolean authorValid(String author) {
		if ((author != "") && (author != null)) {
			return true;
		} else {
			logger.error("There is an Error in Author Validation at Java Level");
            return false;
		}
	}
	
	public boolean bookCategoryValid(String bookCategory) {
		if ((bookCategory != "") && (bookCategory != null)) {
			return true;
		} else {
			logger.error("There is an Error in BookCategory Validation at Java Level");
            return false;
		}
	}
	
	public boolean statusValid(String status) {
		if ((status != "") && (status != null)) {
			return true;
		} else {
			logger.error("There is an Error in BookStatus Validation at Java Level");
            return false;
		}
	}
	
	public boolean priceValid(double price) {
		if ((price > 0)) {
			return true;
		} else {
			logger.error("There is an Error in BookPrice Validation at Java Level");
            return false;
		}
	}
	
	public boolean yearValid(int year) {
		String strYear = Integer.toString(year);
		String yearRegex = "^[12][0-9]{3}$";
		Pattern pattern =  Pattern.compile(yearRegex);
		Matcher matcher = pattern.matcher(strYear);
		if ((strYear != null)&&(strYear != "") && (matcher.find())) {
			return true;
		} else {
			logger.error("There is an Error in BookPublished Year Validation at Java Level");
            return false;
		}
	}
	
	public boolean stockValid(int stock) {
		if (stock >= 0) {
			return true;
		} else {
			logger.error("There is an Error in BookQty  Validation at Java Level");
            return false;
		}
	}
}
