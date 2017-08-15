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
 * Servlet implementation class ReserveBookServlet
 */
@WebServlet("/ReserveBookServlet")
public class ReserveBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookdao;
	private ReserveBookDAO resbookdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveBookServlet() {
        bookdao = new BookDAOImplementation();
        resbookdao = new ReserveBookDAOImplementation();
        // TODO Auto-generated constructor stub
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
		Book book = new Book();
		
		int id = Integer.parseInt(request.getParameter("reserve"));
		HttpSession session = request.getSession();
		String sessionID = session.getAttribute("idNumber").toString();
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		
		if(dateFrom.compareTo(dateTo)<0) {
			ReserveBook resbook = new ReserveBook();
			resbook.setIdnumber(Integer.parseInt(sessionID));
			resbook.setIdbook(id);
			resbook.setDateFrom(dateFrom);
			resbook.setDateTo(dateTo);
			
			resbookdao.addReserveBook(resbook);
			request.setAttribute("trigger", 1);
		}
		else
			request.setAttribute("trigger", 2);
		
		
		ArrayList <Book> books = (ArrayList<Book>) bookdao.getAllBooks();
		request.setAttribute("listOfBooks", books);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/reserveBook.jsp");
	    view.forward(request, response);
		
	}

}
