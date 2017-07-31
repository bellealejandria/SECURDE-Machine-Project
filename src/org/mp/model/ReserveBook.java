package org.mp.model;

public class ReserveBook {
	private int idbook_reservation;
	private int idnumber;
	private int idbook;
	private String dateFrom;
	private String dateTo;
	
	public ReserveBook() {}

	public ReserveBook(int idbook_reservation, int idnumber, int idbook, String dateFrom, String dateTo) {
		this.idbook_reservation = idbook_reservation;
		this.idnumber = idnumber;
		this.idbook = idbook;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public int getIdbook_reservation() {
		return idbook_reservation;
	}

	public void setIdbook_reservation(int idbook_reservation) {
		this.idbook_reservation = idbook_reservation;
	}

	public int getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}

	public int getIdbook() {
		return idbook;
	}

	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	@Override
	public String toString() {
		return "ReserveBook [idbook_reservation=" + idbook_reservation + ", idnumber=" + idnumber + ", idbook=" + idbook
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}

	

	
	
}
