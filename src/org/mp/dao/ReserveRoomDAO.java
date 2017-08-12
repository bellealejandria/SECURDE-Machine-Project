package org.mp.dao;

import java.util.List;

import org.mp.model.ReserveRoom;

public interface ReserveRoomDAO {
	public List<ReserveRoom> getAllRoom1();
	public List<ReserveRoom> getAllRoom2();
	public List<ReserveRoom> getAllRoom3();
	public List<ReserveRoom> getAllRoom4();
	public List<ReserveRoom> getAllRoom5();
	
	public void addReserveRoom(ReserveRoom resroom);
	public List<ReserveRoom> getAllReserveRooms();
	public void updateRoom(String roomCode, int idNumber);
	public void deleteReserveRoom(String roomCode);
}
