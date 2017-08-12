package org.mp.dao;

import java.util.List;

import org.mp.model.ReserveBook;

public interface ReserveBookDAO {
	public List<ReserveBook> viewAllReserveBooks();
	public ReserveBook getReserveBook(int idbook);
	public ReserveBook getReserveBookByIdBook(int idbook);
	public void updateReserveBook(ReserveBook resbook);
	public void deleteReserveBook(int idbook_reservation);
	public void deleteByIdbook(int idbook);
	public int getIdBook(int idbook_reservation);
	public void addReserveBook(ReserveBook resbook);
	
	public List<ReserveBook> sortByID();
	public List<ReserveBook> sortByTitle();
	public List<ReserveBook> sortByStatus();
	public List<ReserveBook> sortByDateFrom();
	public List<ReserveBook> sortByDateTo();
}
