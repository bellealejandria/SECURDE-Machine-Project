package org.mp.model;


public class Book {
	
	private int idBook;
	private String title;
	private String location;
	private String author;
	private String publisher;
	private int year;
	private int status;

	
	public Book() {}

	public Book(int idBook, String title, String location, String author, String publisher,
			int year, int status) {
		this.idBook = idBook;
		this.title = title;
		this.location = location;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.status = status;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", title=" + title + ", location=" + location + ", author=" + author
				+ ", publisher=" + publisher + ", year=" + year + ", status=" + status +  "]";
	}

	
	
	
}
