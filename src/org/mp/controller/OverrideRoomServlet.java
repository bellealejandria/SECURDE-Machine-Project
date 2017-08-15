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
import org.mp.dao.ReserveRoomDAO;
import org.mp.dao.ReserveRoomDAOImplementation;
import org.mp.model.ReserveBook;
import org.mp.model.ReserveRoom;

/**
 * Servlet implementation class OverrideRoomServlet
 */
@WebServlet("/OverrideRoomServlet")
public class OverrideRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReserveRoomDAO resroomdao;
    private LoginDAO logindao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OverrideRoomServlet() {
        resroomdao = new ReserveRoomDAOImplementation();
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
		if(request.getParameter("edit") != null) {
			String roomCode = request.getParameter("edit");
			int idNumber = Integer.parseInt(request.getParameter("idnumber"));
			
			boolean checkID = logindao.checkID(idNumber);
		    
		    if(checkID) {
		    	resroomdao.updateRoom(roomCode, idNumber);
		    }
		    else{
		    	request.setAttribute("trigger", 1);
		    }
			
		}
		else if(request.getParameter("delete") != null) {
			String roomCode = request.getParameter("delete");
			int idNumber = Integer.parseInt(request.getParameter("idnumber"));
			resroomdao.deleteReserveRoom(roomCode);
		}
		
		ArrayList <ReserveRoom> rooms = (ArrayList<ReserveRoom>) resroomdao.getAllReserveRooms();
		request.setAttribute("listOfReserveRooms", rooms);
		
    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/overrideRoom.jsp");
	    view.forward(request, response);

	}

}
