package org.mp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mp.dao.ReserveRoomDAO;
import org.mp.dao.ReserveRoomDAOImplementation;
import org.mp.model.ReserveRoom;

/**
 * Servlet implementation class MngrOverRoomServlet
 */
@WebServlet("/MngrOverRoomServlet")
public class MngrOverRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReserveRoomDAO resroomdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MngrOverRoomServlet() {
    	resroomdao = new ReserveRoomDAOImplementation();
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
		ArrayList <ReserveRoom> resRooms = (ArrayList<ReserveRoom>) resroomdao.getAllReserveRooms();
		request.setAttribute("listOfReserveRooms", resRooms);
		
    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/overrideRoom.jsp");
	    view.forward(request, response);
	}

}
