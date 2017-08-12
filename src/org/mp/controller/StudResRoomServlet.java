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
 * Servlet implementation class StudResRoomServlet
 */
@WebServlet("/StudResRoomServlet")
public class StudResRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ReserveRoomDAO resroomdao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudResRoomServlet() {
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
