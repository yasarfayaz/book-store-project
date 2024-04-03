package com.chainsys.library.model;

public class Cart {
	private int cartId;
	private int bookId;
	private int userId;
	private String bookName;
	private String author;
	private double price;
	private String photoName;
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	private double totalPrice;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", userId=" + userId + ", bookName=" + bookName
				+ ", author=" + author + ", price=" + price + ", photoName=" + photoName + ", totalPrice=" + totalPrice
				+ "]";
	}
	
	
	

}
