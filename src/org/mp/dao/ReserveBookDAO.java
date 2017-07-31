package org.mp.dao;

import org.mp.model.ReserveBook;

public interface ReserveBookDAO {
	public ReserveBook getReserveBook(int idbook);
	public void updateReserveBook(ReserveBook resbook);
	public void deleteReserveBook(int idbook);
}
