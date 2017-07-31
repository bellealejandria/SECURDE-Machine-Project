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
 * Servlet implementation class MngrGoToServlet
 */
@WebServlet("/MngrGoToServlet")
public class MngrGoToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MngrGoToServlet() {
    	bookdao = new BookDAOImplementation();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action");
		//add book
		if(action.equals("addbook")) {
			RequestDispatcher view = request.getRequestDispatcher("addBook.jsp");
		    view.forward(request, response);
		}
		
		//edit book
		else if(action.equals("editbook")) {
			ArrayList <Book> books = (ArrayList<Book>) bookdao.getAllBooks();
			request.setAttribute("listOfBooks", books);
			
			RequestDispatcher view = request.getRequestDispatcher("editBook.jsp");
		    view.forward(request, response);
		}
		
		//override reservations
		else if(action.equals("overridebook")) {
			RequestDispatcher view = request.getRequestDispatcher("overrideBook.jsp");
		    view.forward(request, response);
		}
		
		//export 
		else if(action.equals("export")) {
			
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
