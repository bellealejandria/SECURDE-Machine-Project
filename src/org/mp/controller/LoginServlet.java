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
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 
    private LoginDAO logindao;
    private MemberDAO memberdao;
    private static final long serialVersionUID = 1L;
    public static final String INDEX = "/WEB-INF/jsp/index.jsp";
    public static final String LOGIN = "login.jsp";
    public static final String REG = "reg.jsp";
 
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
            int idnumber = Integer.parseInt( request.getParameter("idnumber"));
            String password = request.getParameter("password");
            password = new Encrypt().encrypt(password);
            
            int lockCount = 5;
            int loginCount = logindao.getLoginAttempt(idnumber);
            
            boolean validate = logindao.validate(idnumber, password);
            
            if(validate && (loginCount != lockCount)) {
            	
     			logindao.updateLogin(idnumber, 0);
     			
    			Member memDetails = memberdao.getMember(idnumber);
    			
    			
    			
    			HttpSession session = request.getSession();
    			switch(memDetails.getRole()) {
    				case "admin": 	session.setAttribute("role", "admin");
    								session.setAttribute("idNumber", memDetails.getIdNumber());
    								break;
    				case "mngr":	session.setAttribute("role", "mngr");
									session.setAttribute("idNumber", memDetails.getIdNumber());
									break;
    				case "staff":	session.setAttribute("role", "staff");
									session.setAttribute("idNumber", memDetails.getIdNumber());
									break;
    				case "stud":	session.setAttribute("role", "stud");
									session.setAttribute("idNumber", memDetails.getIdNumber());
									break;
    				case "fac":		session.setAttribute("role", "fac");
									session.setAttribute("idNumber", memDetails.getIdNumber());
									break;
    			}
    			RequestDispatcher view = request.getRequestDispatcher(INDEX);
    		    view.forward(request, response);
            }
            else if(loginCount < lockCount){
    			System.out.println("Incorrect username/password");
    			
    			int tempCtr = loginCount+1;
    			
    			logindao.updateLogin(idnumber, tempCtr);
    			
    			RequestDispatcher view = request.getRequestDispatcher(LOGIN);
    		    view.forward(request, response);
            }
            else {
            	RequestDispatcher view = request.getRequestDispatcher("acctlock.html");
    		    view.forward(request, response);
            }
		}
    			
        
        else if(request.getParameter("signup") != null) {
        	RequestDispatcher view = request.getRequestDispatcher(REG);
		    view.forward(request, response);
        }
        else if(request.getParameter("save") != null) {
        	HttpSession session = request.getSession();
    		int sessionID = Integer.parseInt(session.getAttribute("idNumber").toString());
    		
    		//encrypt typed old password
        	String oldpw = request.getParameter("oldpw");
    	    oldpw = new Encrypt().encrypt(oldpw);
    	    
    	    System.out.println(sessionID);
    	    
    	    //compare pw from db and if same set newpw as password
    	    if(logindao.getPass(sessionID) == oldpw) {
    	    	String newpw = request.getParameter("newpw");
    	    	newpw = new Encrypt().encrypt(newpw);
    	    	System.out.println(newpw);
    	    	logindao.changePass(newpw, sessionID);
    	    }
        	
        }

	}

}
