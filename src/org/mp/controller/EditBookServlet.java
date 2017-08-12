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
import org.mp.dao.ReserveBookDAO;
import org.mp.dao.ReserveBookDAOImplementation;
import org.mp.model.Book;
import org.mp.model.ReserveBook;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;
	private ReserveBookDAO resbookdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
    	bookdao = new BookDAOImplementation();
    	resbookdao = new ReserveBookDAOImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher view = request.getRequestDispatcher("erroracct.html");
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("edit") != null) {
			
			Book book = new Book();
			
			int id = Integer.parseInt(request.getParameter("edit"));
			String title = request.getParameter( "title" );
			String author = request.getParameter( "author" );
			String publisher = request.getParameter( "publisher" );
			int year = Integer.parseInt(request.getParameter( "year" ) );
			
			
			String location = request.getParameter("location");
	        if(location.equals("C1")) 
	        	location = "000";
	        else if(location.equals("C2")) 
	        	location = "100";
	        else if(location.equals("C3")) 
	        	location = "200";
	        else if(location.equals("C4")) 
	        	location = "300";
	        else if(location.equals("C5")) 
	        	location = "400";
	        else if(location.equals("C6")) 
	        	location = "500";
	        else if(location.equals("C7")) 
	        	location = "600";
	        else if(location.equals("C8")) 
	        	location = "700";
	        else if(location.equals("C9")) 
	        	location = "800";
	        else if(location.equals("C10")) 
	        	location = "900";
	        
	        book.setIdBook( id );
	        book.setTitle( title );
			book.setLocation( location );
	    	book.setAuthor( author );
	    	book.setPublisher( publisher );
	    	book.setYear( year );
	    	
	    	bookdao.updateBook(book);
	    	
	    	ArrayList <Book> books = (ArrayList<Book>) bookdao.getAllBooks();
			request.setAttribute("listOfBooks", books);
			
	    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/editBook.jsp");
		    view.forward(request, response);
	    	
		}

		else if(request.getParameter("delete") != null) {
			
			int id = Integer.parseInt(request.getParameter("delete"));
			
			if(request.getSession(false).getAttribute("role").equals("mngr")) {
				resbookdao.deleteByIdbook(id);
			}
			
			bookdao.deleteBook(id);
			
			ArrayList <Book> books = (ArrayList<Book>) bookdao.getAllBooks();
			request.setAttribute("listOfBooks", books);
			
			
	    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/editBook.jsp");
		    view.forward(request, response);
			
		}
	}

}
