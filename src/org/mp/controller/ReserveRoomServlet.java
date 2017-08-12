package org.mp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mp.dao.ReserveRoomDAO;
import org.mp.dao.ReserveRoomDAOImplementation;
import org.mp.model.ReserveRoom;

/**
 * Servlet implementation class ReserveRoomServlet
 */
@WebServlet("/ReserveRoomServlet")
public class ReserveRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReserveRoomDAO resroomdao;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveRoomServlet() {
        resroomdao = new ReserveRoomDAOImplementation();
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
		String roomCode = request.getParameter("reserveroom");
		System.out.println(roomCode);
		ReserveRoom resroom = new ReserveRoom();
		resroom.setRoomCode(roomCode);
		
		HttpSession session = request.getSession();
		String sessionID = session.getAttribute("idNumber").toString();
		resroom.setIdNumber(Integer.parseInt(sessionID));
		resroom.setStatus(1);
		
		resroomdao.addReserveRoom(resroom);
		
		ArrayList <ReserveRoom> resRoom1 = (ArrayList<ReserveRoom>) resroomdao.getAllRoom1();
		request.setAttribute("ListRoom1", resRoom1);
		
		ArrayList <ReserveRoom> resRoom2 = (ArrayList<ReserveRoom>) resroomdao.getAllRoom2();
		request.setAttribute("ListRoom2", resRoom2);
		
		ArrayList <ReserveRoom> resRoom3 = (ArrayList<ReserveRoom>) resroomdao.getAllRoom3();
		request.setAttribute("ListRoom3", resRoom3);
		
		ArrayList <ReserveRoom> resRoom4 = (ArrayList<ReserveRoom>) resroomdao.getAllRoom4();
		request.setAttribute("ListRoom4", resRoom4);
		
		ArrayList <ReserveRoom> resRoom5 = (ArrayList<ReserveRoom>) resroomdao.getAllRoom5();
		request.setAttribute("ListRoom5", resRoom5);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/reserveRoom.jsp");
	    view.forward(request, response);
		
		
	}

}
