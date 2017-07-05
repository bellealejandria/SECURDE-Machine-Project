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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 
    private LoginDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String INDEX = "/index.jsp";
    public static final String REG = "/reg.jsp";
 
    public LoginServlet() {
        dao = new LoginDAOImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        String forward = "";
        
        if(request.getParameter("login") != null) {
        	forward = INDEX;
            int idnumber = Integer.parseInt( request.getParameter("idnumber") );
            String password = request.getParameter("password");
    		  
            boolean validate = dao.validate(idnumber, password);
    		  
            if(validate) {
            	System.out.println(idnumber);
            	RequestDispatcher view = request.getRequestDispatcher(forward);
    		    view.forward(request, response);
            }
    		else {
    			System.out.println("Incorrect username/password");
    		}
        }
        else if(request.getParameter("signup") != null) {
        	forward = REG;
        	RequestDispatcher view = request.getRequestDispatcher(forward);
		    view.forward(request, response);
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
