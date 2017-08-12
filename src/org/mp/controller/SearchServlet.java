package org.mp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mp.dao.BookDAO;
import org.mp.dao.BookDAOImplementation;
import org.mp.model.Book;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
       bookdao = new BookDAOImplementation();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("searchButton") != null) {
			
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
			
			String session = request.getSession(false).getAttribute("role").toString();
			if(session.equalsIgnoreCase("mngr") || session.equalsIgnoreCase("staff")) {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/editBook.jsp");
			    view.forward(request, response);
			}
			else if(session.equalsIgnoreCase("stud") || session.equalsIgnoreCase("fac")){
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/reserveBook.jsp");
			    view.forward(request, response);
			}
		}
		
	}

}
