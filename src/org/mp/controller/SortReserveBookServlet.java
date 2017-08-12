package org.mp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mp.dao.ReserveBookDAO;
import org.mp.dao.ReserveBookDAOImplementation;
import org.mp.model.Book;
import org.mp.model.ReserveBook;

/**
 * Servlet implementation class SortReserveBookServlet
 */
@WebServlet("/SortReserveBookServlet")
public class SortReserveBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReserveBookDAO reservebookdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortReserveBookServlet() {
        reservebookdao = new ReserveBookDAOImplementation();
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
		String sortby = request.getParameter("sortby");
		ArrayList <ReserveBook> resbooks = new ArrayList<ReserveBook>();
		
		if (sortby.equals("S1"))
			resbooks = (ArrayList<ReserveBook>) reservebookdao.viewAllReserveBooks();
		else if (sortby.equals("S2"))
			resbooks = (ArrayList<ReserveBook>) reservebookdao.sortByID();
		else if (sortby.equals("S3"))
			resbooks = (ArrayList<ReserveBook>) reservebookdao.sortByTitle();
		else if (sortby.equals("S4"))
			resbooks = (ArrayList<ReserveBook>) reservebookdao.sortByStatus();
		else if (sortby.equals("S5"))
			resbooks = (ArrayList<ReserveBook>) reservebookdao.sortByDateFrom();
		else if (sortby.equals("S6"))
			resbooks = (ArrayList<ReserveBook>) reservebookdao.sortByDateTo();
		
		request.setAttribute("listOfReserveBooks", resbooks);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/overrideBook.jsp");
	    view.forward(request, response);
		
	}

}
