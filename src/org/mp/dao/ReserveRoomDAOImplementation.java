package org.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mp.model.ReserveRoom;
import org.mp.util.DBConn;

public class ReserveRoomDAOImplementation implements ReserveRoomDAO {
	private Connection conn;
	
	public ReserveRoomDAOImplementation() {
		conn = DBConn.getConnection();
	}
	

	@Override
	public void addReserveRoom(ReserveRoom resroom) {
		try {
			String query = "insert into reserveroom (roomCode, idNumber) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, resroom.getRoomCode());
            ps.setInt(2, resroom.getIdNumber());

            ps.executeUpdate();
            ps.close();
            
            //update status from book
            String statusquery = "UPDATE room SET status = ? WHERE roomCode = ?";
            PreparedStatement pst = conn.prepareStatement( statusquery );
            
            pst.setInt(1, resroom.getStatus());
            pst.setString(2, resroom.getRoomCode());

            pst.executeUpdate();
            pst.close();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}


	@Override
	public List<ReserveRoom> getAllRoom1() {
		ArrayList<ReserveRoom> allRoom1 = new ArrayList<ReserveRoom>();
		try {
			String query = "select * from room where roomCode like '%R1%';";
	        PreparedStatement ps = conn.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	ReserveRoom resroom = new ReserveRoom();
	        	resroom.setRoomCode(rs.getString("roomCode"));
	        	resroom.setStatus(rs.getInt("status"));
	        	allRoom1.add(resroom);
	        }	
		}  catch (SQLException e) {
            e.printStackTrace();
        }
		
		return allRoom1;
	}


	@Override
	public List<ReserveRoom> getAllRoom2() {
		ArrayList<ReserveRoom> allRoom2 = new ArrayList<ReserveRoom>();
		try {
			String query = "select * from room where roomCode like '%R2%';";
	        PreparedStatement ps = conn.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	ReserveRoom resroom = new ReserveRoom();
	        	resroom.setRoomCode(rs.getString("roomCode"));
	        	resroom.setStatus(rs.getInt("status"));
	        	allRoom2.add(resroom);
	        }	
		}  catch (SQLException e) {
            e.printStackTrace();
        }
		return allRoom2;
	}


	@Override
	public List<ReserveRoom> getAllRoom3() {
		ArrayList<ReserveRoom> allRoom3 = new ArrayList<ReserveRoom>();
		try {
			String query = "select * from room where roomCode like '%R3%';";
	        PreparedStatement ps = conn.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	ReserveRoom resroom = new ReserveRoom();
	        	resroom.setRoomCode(rs.getString("roomCode"));
	        	resroom.setStatus(rs.getInt("status"));
	        	allRoom3.add(resroom);
	        }	
		}  catch (SQLException e) {
            e.printStackTrace();
        }
		return allRoom3;
	}


	@Override
	public List<ReserveRoom> getAllRoom4() {
		ArrayList<ReserveRoom> allRoom4 = new ArrayList<ReserveRoom>();
		try {
			String query = "select * from room where roomCode like '%R4%';";
	        PreparedStatement ps = conn.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	ReserveRoom resroom = new ReserveRoom();
	        	resroom.setRoomCode(rs.getString("roomCode"));
	        	resroom.setStatus(rs.getInt("status"));
	        	allRoom4.add(resroom);
	        }	
		}  catch (SQLException e) {
            e.printStackTrace();
        }
		return allRoom4;
	}


	@Override
	public List<ReserveRoom> getAllRoom5() {
		ArrayList<ReserveRoom> allRoom5 = new ArrayList<ReserveRoom>();
		try {
			String query = "select * from room where roomCode like '%R5%';";
	        PreparedStatement ps = conn.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	ReserveRoom resroom = new ReserveRoom();
	        	resroom.setRoomCode(rs.getString("roomCode"));
	        	resroom.setStatus(rs.getInt("status"));
	        	allRoom5.add(resroom);
	        }	
		}  catch (SQLException e) {
            e.printStackTrace();
        }
		return allRoom5;
	}


	@Override
	public void updateRoom(String roomCode, int idNumber) {
		try {
		//update status from book
        String statusquery = "UPDATE reserveroom SET idNumber = ? WHERE roomCode = ?";
        PreparedStatement ps = conn.prepareStatement( statusquery );
        
        ps.setInt(1, idNumber);
        ps.setString(2, roomCode);

        ps.executeUpdate();
        ps.close();
        
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<ReserveRoom> getAllReserveRooms() {
		ArrayList <ReserveRoom> resRooms = new ArrayList<ReserveRoom>();
		try {
			String query = "select r.idroom, r.roomCode, r.status, r.timeFrom, r.timeTo, rr.idNumber from room r, reserveroom rr where r.roomCode = rr.roomCode order by r.idroom;";
			PreparedStatement ps = conn.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	ReserveRoom resRoom = new ReserveRoom();
	        	resRoom.setRoomCode(rs.getString("roomCode"));
	        	resRoom.setIdNumber(rs.getInt("idNumber"));
	        	resRoom.setTimeFrom(rs.getString("timeFrom"));
	        	resRoom.setTimeTo(rs.getString("timeTo"));
	        	resRooms.add(resRoom);
	        }
		
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return resRooms;
	}


	@Override
	public void deleteReserveRoom(String roomCode) {
		try {
			
			String delquery = "DELETE FROM reserveroom WHERE roomCode = ?";
			PreparedStatement ps1 = conn.prepareStatement( delquery );
			ps1.setString(1, roomCode);
			
			ps1.executeUpdate();
            ps1.close();
            
            //change status
            String updatequery = "UPDATE room SET status = ? WHERE roomCode = ?";
			PreparedStatement ps2 = conn.prepareStatement( updatequery );
			ps2.setInt(1, 0);
			ps2.setString(2, roomCode);
			
			ps2.executeUpdate();
            ps2.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
