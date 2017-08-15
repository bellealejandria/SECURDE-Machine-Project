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
import org.mp.model.Book;

/**
 * Servlet implementation class MngrAddBookServlet
 */
@WebServlet("/MngrAddBookServlet")
public class MngrAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MngrAddBookServlet() {
    	bookdao = new BookDAOImplementation();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		
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
        
        book.setTitle( title );
		book.setLocation( location );
    	book.setAuthor( author );
    	book.setPublisher( publisher );
    	book.setYear( year );
    	
    	bookdao.addBook(book);
    	
		request.setAttribute("trigger", 1);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/addBook.jsp");
	    view.forward(request, response);
	}

}
