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
 * Servlet implementation class MngrEditBookServlet
 */
@WebServlet("/MngrEditBookServlet")
public class MngrEditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MngrEditBookServlet() {
    	bookdao = new BookDAOImplementation();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <Book> books = (ArrayList<Book>) bookdao.getAllBooks();
		request.setAttribute("listOfBooks", books);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/editBook.jsp");
	    view.forward(request, response);
	}

}
