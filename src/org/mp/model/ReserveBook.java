package org.mp.model;

public class ReserveBook {
	private int idbook_reservation;
	private int idnumber;
	private int idbook;
	private String title;
	private int status;
	private String dateFrom;
	private String dateTo;
	
	public ReserveBook() {}

	public ReserveBook(int idbook_reservation, int idnumber, int idbook, String title, int status, String dateFrom,
			String dateTo) {
		this.idbook_reservation = idbook_reservation;
		this.idnumber = idnumber;
		this.idbook = idbook;
		this.title = title;
		this.status = status;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
				+ ", title=" + title + ", status=" + status + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}

	
	

	
	
}
