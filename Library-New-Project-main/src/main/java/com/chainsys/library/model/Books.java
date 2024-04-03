package com.chainsys.library.model;

public class Books {

	private int bookId;
	private String bookName;
	private String author;
	private double price;
	private String bookCategory;
	private String status;
	private int publishedYear;
	private int qtyInstock;
	private String photoName;
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	public int getQtyInstock() {
		return qtyInstock;
	}
	public void setQtyInstock(int qtyInstock) {
		this.qtyInstock = qtyInstock;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", bookCategory=" + bookCategory + ", status=" + status + ", publishedYear=" + publishedYear
				+ ", qtyInstock=" + qtyInstock + ", photoName=" + photoName + "]";
	}
}


