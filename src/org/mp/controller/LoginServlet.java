package org.mp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mp.dao.LoginDAO;
import org.mp.dao.LoginDAOImplementation;
import org.mp.dao.MemberDAO;
import org.mp.dao.MemberDAOImplementation;
import org.mp.model.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 
    private LoginDAO logindao;
    private MemberDAO memberdao;
    private static final long serialVersionUID = 1L;
    public static final String INDEX = "/index.jsp";
    public static final String LOGIN = "/login.jsp";
    public static final String REG = "/reg.jsp";
 
    public LoginServlet() {
        logindao = new LoginDAOImplementation();
        memberdao = new MemberDAOImplementation();
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
        if(request.getParameter("login") != null) {
            int idnumber = Integer.parseInt( request.getParameter("idnumber") );
            String password = request.getParameter("password");
    		  
            boolean validate = logindao.validate(idnumber, password);
    		  
            if(validate) {
    			Member memDetails = memberdao.getMember(idnumber);
    			request.setAttribute("member", memDetails.getFirstName());
    			HttpSession session = request.getSession();
    			switch(memDetails.getRole()) {
    				case "admin": 	session.setAttribute("role", "admin");
    								break;
    				case "mngr":	session.setAttribute("role", "mngr");
									break;
    				case "staff":	session.setAttribute("role", "staff");
									break;
    				case "stud":	session.setAttribute("role", "stud");
									break;
    				case "fac":		session.setAttribute("role", "fac");
									break;
    			}
    			RequestDispatcher view = request.getRequestDispatcher(INDEX);
    		    view.forward(request, response);
            }
            else {
    			System.out.println("Incorrect username/password");
    			RequestDispatcher view = request.getRequestDispatcher(LOGIN);
    		    view.forward(request, response);
            }		
		}
    			
        
        else if(request.getParameter("signup") != null) {
        	RequestDispatcher view = request.getRequestDispatcher(REG);
		    view.forward(request, response);
        }
	}

}
