package org.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mp.model.Book;
import org.mp.util.DBConn;

public class BookDAOImplementation implements BookDAO {
	private Connection conn;
	
	public BookDAOImplementation() {
		conn = DBConn.getConnection();
	}

	
	
	@Override
	public Book getBook(int idbook) {
		Book book = new Book();
		
		try {
            String query = "select * from book where idbook=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idbook);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return book;

	}
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		try {
            String query = "insert into book (title, author, location, publisher, year, status) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            
            preparedStatement.setString( 1, book.getTitle() );
            preparedStatement.setString( 2, book.getAuthor() );
            preparedStatement.setString( 3, book.getLocation() );
            preparedStatement.setString( 4, book.getPublisher() );
            preparedStatement.setInt( 5, book.getYear() );
            preparedStatement.setInt( 6, 0 );

            preparedStatement.executeUpdate();
            preparedStatement.close();
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void updateBook(Book book) {
		try {
		
			String query = "UPDATE book SET title = ?, author = ?, location = ?, publisher = ?, year=?, status=? WHERE idbook = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            
            preparedStatement.setString( 1, book.getTitle() );
            preparedStatement.setString( 2, book.getAuthor() );
            preparedStatement.setString( 3, book.getLocation() );
            preparedStatement.setString( 4, book.getPublisher() );
            preparedStatement.setInt( 5, book.getYear() );
            preparedStatement.setInt( 6, book.getStatus() );
            preparedStatement.setInt( 7, book.getIdBook() );
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));

            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> filterByTitle(String search) {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book where title like ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));

            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}


	@Override
	public List<Book> filterByAuthor(String search) {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book where author like ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));

            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}


	@Override
	public List<Book> filterByPublisher(String search) {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book where publisher like ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));
            	
            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}


	@Override
	public List<Book> filterByYear(int search) {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book where year like ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, search);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));
            	
            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> orderByTitle() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book order by title";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));
            	
            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public List<Book> orderByAuthor() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book order by author";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));
            	
            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public List<Book> orderByPublisher() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book order by publisher";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));

            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public List<Book> orderByYear() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
            String query = "select * from book order by year";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Book book = new Book();
            	
            	book.setIdBook(rs.getInt("idbook"));
            	book.setTitle(rs.getString("title"));
            	book.setAuthor(rs.getString("author"));
            	book.setYear(rs.getInt("year"));
            	book.setPublisher(rs.getString("publisher"));
            	book.setLocation(rs.getString("location"));
            	book.setStatus(rs.getInt("status"));

            	books.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
