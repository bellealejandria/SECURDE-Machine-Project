package org.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mp.model.ReserveBook;
import org.mp.util.DBConn;

public class ReserveBookDAOImplementation implements ReserveBookDAO {
	
	private Connection conn;
	
	public ReserveBookDAOImplementation() {
		conn = DBConn.getConnection();
	}
	
	@Override
	public ReserveBook getReserveBook(int idbook) {
		ReserveBook resBook = new ReserveBook();
		
		try {
            String query = "select * from reservebook where idbook_reservation = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idbook);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	
            	resBook.setIdnumber(rs.getInt("idnumber"));
            	resBook.setIdbook(rs.getInt("idbook"));
            	resBook.setDateFrom(rs.getString("dateFrom"));
            	resBook.setDateTo(rs.getString("dateTo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return resBook;
		
	}

	@Override
	public void updateReserveBook(ReserveBook resbook) {
		try {
			
			String query = "UPDATE reservebook SET dateFrom = ?, dateTo = ? WHERE idbook = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            
            preparedStatement.setString( 1, resbook.getDateFrom());
            preparedStatement.setString( 2, resbook.getDateTo());
            preparedStatement.setInt( 3, resbook.getIdbook());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReserveBook(int idbook) {
		try {			
			String query = "DELETE FROM reservebook WHERE idbook = ?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, idbook);
			
			preparedStatement.executeUpdate();
            preparedStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
