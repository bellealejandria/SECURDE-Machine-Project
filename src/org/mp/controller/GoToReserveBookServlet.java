package org.mp.controller;

import java.io.IOException;

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
 * Servlet implementation class GoToReserveBookServlet
 */
@WebServlet("/GoToReserveBookServlet")
public class GoToReserveBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToReserveBookServlet() {
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

		int id = Integer.parseInt(request.getParameter("reserve"));
		
		Book book = bookdao.getBook(id);
		request.setAttribute("book", book);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/addReserveBook.jsp");
	    view.forward(request, response);
	
	}

}
