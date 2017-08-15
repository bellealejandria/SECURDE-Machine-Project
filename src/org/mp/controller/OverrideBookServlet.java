package org.mp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mp.dao.LoginDAO;
import org.mp.dao.LoginDAOImplementation;
import org.mp.dao.ReserveBookDAO;
import org.mp.dao.ReserveBookDAOImplementation;
import org.mp.model.ReserveBook;

/**
 * Servlet implementation class OverrideBookServlet
 */
@WebServlet("/OverrideBookServlet")
public class OverrideBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReserveBookDAO resbookdao;
	private LoginDAO logindao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OverrideBookServlet() {
        resbookdao = new ReserveBookDAOImplementation();
        logindao = new LoginDAOImplementation();
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
		if(request.getParameter("edit") != null ){
			ReserveBook resbook = new ReserveBook();
			
			int id = Integer.parseInt(request.getParameter("edit"));
			int idbook = resbookdao.getIdBook(id);
			int idnumber = Integer.parseInt(request.getParameter("idnumber"));
			int status = Integer.parseInt(request.getParameter( "status" ));
			String dateFrom = request.getParameter("dateFrom");
			String dateTo = request.getParameter("dateTo");			

			boolean checkID = logindao.checkID(idnumber);
		    
		    if(checkID) {
		    	resbook.setIdbook_reservation(id);
				resbook.setIdbook(idbook);
				resbook.setIdnumber(idnumber);
				resbook.setStatus(status);
				resbook.setDateFrom(dateFrom);
				resbook.setDateTo(dateTo);
				
				resbookdao.updateReserveBook(resbook);

				ArrayList <ReserveBook> books = (ArrayList<ReserveBook>) resbookdao.viewAllReserveBooks();
				request.setAttribute("listOfReserveBooks", books);
				
		    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/overrideBook.jsp");
			    view.forward(request, response);
		    }
		    else {
		    	ArrayList <ReserveBook> books = (ArrayList<ReserveBook>) resbookdao.viewAllReserveBooks();
				request.setAttribute("listOfReserveBooks", books);
				
				request.setAttribute("trigger", 1);
		    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/overrideBook.jsp");
			    view.forward(request, response);
		    }
			
		}
		else if(request.getParameter("delete") != null ){
			int id = Integer.parseInt(request.getParameter("delete"));
			resbookdao.deleteReserveBook(id);
			
			ArrayList <ReserveBook> books = (ArrayList<ReserveBook>) resbookdao.viewAllReserveBooks();
			request.setAttribute("listOfReserveBooks", books);
			
	    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/overrideBook.jsp");
		    view.forward(request, response);
		}
	}

}
