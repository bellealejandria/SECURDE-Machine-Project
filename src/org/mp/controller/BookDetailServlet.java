package org.mp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mp.dao.BookDAO;
import org.mp.dao.BookDAOImplementation;
import org.mp.dao.ReserveBookDAO;
import org.mp.dao.ReserveBookDAOImplementation;
import org.mp.model.Book;
import org.mp.model.ReserveBook;

/**
 * Servlet implementation class BookDetailServlet
 */
@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;
	private ReserveBookDAO resbookdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailServlet() {
        bookdao = new BookDAOImplementation();
        resbookdao = new ReserveBookDAOImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("edit") != null) {
			Book book = new Book();
			
			int idbook = Integer.parseInt(request.getParameter("edit"));
			book = bookdao.getBook(idbook);
			
			request.setAttribute("book", book);
			
			if(book.getStatus() == 1 || book.getStatus() == 2) {
				ReserveBook resBook = new ReserveBook();
				resBook = resbookdao.getReserveBook(idbook);
				
				if(resBook != null)
					request.setAttribute("resBook", resBook);
			}
			RequestDispatcher view = request.getRequestDispatcher("editBook.jsp");
		    view.forward(request, response);
		}
		else if(request.getParameter("search") != null) {
			
			String search = request.getParameter("stringToSearch");
			String filter = request.getParameter("filter");
			
			if(search.equals("")) {
				if(filter.equalsIgnoreCase("all")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.getAllBooks();
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("title")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.orderByTitle();
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("author")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.orderByAuthor();
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("publisher")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.orderByPublisher();
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("year")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.orderByYear();
					request.setAttribute("listOfBooks", books);
				}
			}
			else {
				if(filter.equalsIgnoreCase("all")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.getAllBooks();
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("title")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.filterByTitle(search);
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("author")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.filterByAuthor(search);
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("publisher")) {
					ArrayList <Book> books = (ArrayList<Book>) bookdao.filterByPublisher(search);
					request.setAttribute("listOfBooks", books);
				}
				else if(filter.equalsIgnoreCase("year")) {
					int year = Integer.parseInt(request.getParameter("stringToSearch"));
					ArrayList <Book> books = (ArrayList<Book>) bookdao.filterByYear(year);
					request.setAttribute("listOfBooks", books);
				}
			}

			RequestDispatcher view = request.getRequestDispatcher("viewBooks.jsp");
		    view.forward(request, response);
		}
		
		else if(request.getParameter("delete") != null) {
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
