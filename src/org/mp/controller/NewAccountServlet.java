package org.mp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mp.dao.MemberDAO;
import org.mp.dao.MemberDAOImplementation;
import org.mp.model.Member;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDAO memberdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountServlet() {
        memberdao = new MemberDAOImplementation();
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
		Member member = new Member();
		
		String role = request.getParameter( "position" );
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
	    
	    if(stringIdNum != null && firstName != null && midInitial != null && 
	    		lastName != null && birthday != null && email != null &&
	    		password != null && secretQuestion != null && secretAns != null) {
	    	
	    	if(role.equals("1"))
	    		member.setRole("mngr");
	    	else if(role.equals("2"))
	    		member.setRole("staff");
	    	
			member.setIdNumber( idNum );
			member.setFirstName( firstName );
	    	member.setMidInitial( midInitial );
	    	member.setLastName( lastName );
	    	member.setBirthday( birthday );
	    	member.setEmail( email );
	    	member.setPassword( password );
	        member.setSecretQuestion( secretQuestion );
	        member.setSecretAns( secretAns );

	        memberdao.addMember(member);
	        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		    view.forward(request, response);
	    }
	    else {
	    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/newAcct.jsp");
		    view.forward(request, response);
	    }
	}

}
