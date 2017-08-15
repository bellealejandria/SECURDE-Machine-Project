package org.mp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminExportServlet
 */
@WebServlet("/AdminExportServlet")
public class AdminExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminExportServlet() {
        super();
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
		// TODO Auto-generated method stub
		String session = request.getSession(false).getAttribute("role").toString();
		
		if(session.equals("admin") || session.equals("mngr")) {
			AdminExportData exp = new AdminExportData();
			exp.exportBook(System.getProperty("user.home") + System.getProperty("file.separator") + "book.csv");
			exp.exportRoom(System.getProperty("user.home") + System.getProperty("file.separator") + "room.csv");
			
			request.setAttribute("trigger", 1);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		    view.forward(request, response);
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("erroracct.html");
		    view.forward(request, response);
		}
		
	}

}
