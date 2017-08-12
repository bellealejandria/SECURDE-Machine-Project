package org.mp.model;

public class ReserveRoom {
	private String roomCode;
	private int idNumber;
	private int status;
	private String timeFrom;
	private String timeTo;
	
	public ReserveRoom () {}

	public ReserveRoom(String roomCode, int idNumber, int status, String timeFrom, String timeTo) {
		this.roomCode = roomCode;
		this.idNumber = idNumber;
		this.status = status;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	@Override
	public String toString() {
		return "ReserveRoom [roomCode=" + roomCode + ", idNumber=" + idNumber + ", status=" + status + ", timeFrom="
				+ timeFrom + ", timeTo=" + timeTo + "]";
	}

	
	
}
