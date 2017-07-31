package org.mp.dao;

import java.util.List;

import org.mp.model.Book;

public interface BookDAO {

	public Book getBook(int idBook);
	public void addBook(Book book);
	public void updateBook(Book book);
	
	public List<Book> getAllBooks();
	public List<Book> filterByTitle(String search);
	public List<Book> filterByAuthor(String search);
	public List<Book> filterByPublisher(String search);
	public List<Book> filterByYear(int search);
	
	public List<Book> orderByTitle();
	public List<Book> orderByAuthor();
	public List<Book> orderByPublisher();
	public List<Book> orderByYear();
	
}
