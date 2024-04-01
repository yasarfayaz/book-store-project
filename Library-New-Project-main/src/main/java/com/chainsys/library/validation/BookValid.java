package com.chainsys.library.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.relational.core.sql.IsNull;

import com.chainsys.library.model.Books;

public class BookValid {

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
            return false;
		}
		
		
		
	}
	
	private boolean bookNameValid(String bookName) {
		if ((bookName != "") && (bookName != null)) {
			return true;
		} else {
            return false;
		}
	}
	
	private boolean authorValid(String author) {
		if ((author != "") && (author != null)) {
			return true;
		} else {
            return false;
		}
	}
	
	private boolean bookCategoryValid(String bookCategory) {
		if ((bookCategory != "") && (bookCategory != null)) {
			return true;
		} else {
            return false;
		}
	}
	
	private boolean statusValid(String status) {
		if ((status != "") && (status != null)) {
			return true;
		} else {
            return false;
		}
	}
	
	private boolean priceValid(double price) {
		if ((price > 0)) {
			return true;
		} else {
            return false;
		}
	}
	
	private boolean yearValid(int year) {
		String strYear = Integer.toString(year);
		String yearRegex = "^[12][0-9]{3}$";
		Pattern pattern =  Pattern.compile(yearRegex);
		Matcher matcher = pattern.matcher(strYear);
		if ((strYear != null)&&(strYear != "") && (matcher.find())) {
			return true;
		} else {
            return false;
		}
	}
	
	private boolean stockValid(int stock) {
		if (stock >= 0) {
			return true;
		} else {
            return false;
		}
	}
}
