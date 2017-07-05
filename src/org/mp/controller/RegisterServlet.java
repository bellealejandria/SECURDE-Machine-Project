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
import org.mp.model.Member;
 
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private LoginDAO dao;
	private static final long serialVersionUID = 1L;
	public RegisterServlet() {
        dao = new LoginDAOImplementation();
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
		//doGet(request, response);
		Member member = new Member();
		
		int idNum = Integer.parseInt(request.getParameter( "idnumber" ) );
		String stringIdNum = request.getParameter( "idnumber" );
		String firstName = request.getParameter( "firstName" );
	    String midInitial = request.getParameter( "midInitial" ); 
	    String lastName = request.getParameter( "lastName" );
	    String birthday = request.getParameter( "birthday" );
	    String email = request.getParameter( "email" );
	    String password = request.getParameter( "password" );
	    String secretQuestion = request.getParameter( "secretQuestion" );
	    String secretAns = request.getParameter( "secretAns" );
	    String occ = "";
	    
	    if(stringIdNum != null && firstName != null && midInitial != null && 
	    		lastName != null && birthday != null && email != null &&
	    		password != null && secretQuestion != null && secretAns != null) {
	    	
	    	if(((int) Math.floor(idNum / Math.pow(10, Math.floor(Math.log10(idNum))))) == 1)
				member.setOcc( "student" );
			else if(((int) Math.floor(idNum / Math.pow(10, Math.floor(Math.log10(idNum))))) == 2)
				member.setOcc( "faculty" );
			
			member.setIdNumber( idNum );
			member.setFirstName( firstName );
	    	member.setMidInitial( midInitial );
	    	member.setLastName( lastName );
	    	member.setBirthday( birthday );
	    	member.setEmail( email );
	    	member.setPassword( password );
	        member.setSecretQuestion( secretQuestion );
	        member.setSecretAns( secretAns );
	        
	        dao.addMember(member);
	        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		    view.forward(request, response);
	    }
	    else {
	    	RequestDispatcher view = request.getRequestDispatcher("reg.jsp");
		    view.forward(request, response);
	    }
		
        
        
        
        
        
	}

}
