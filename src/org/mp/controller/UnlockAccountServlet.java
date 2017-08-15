package org.mp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mp.dao.LoginDAO;
import org.mp.dao.LoginDAOImplementation;

/**
 * Servlet implementation class UnlockAccountServlet
 */
@WebServlet("/UnlockAccountServlet")
public class UnlockAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO logindao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnlockAccountServlet() {
    	logindao = new LoginDAOImplementation();
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
		int idNumber = Integer.parseInt(request.getParameter("idnumber"));
		logindao.updateLogin(idNumber, 0);
		request.setAttribute("trigger", 1);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/unlock.jsp");
	    view.forward(request, response);
		
	}

}
