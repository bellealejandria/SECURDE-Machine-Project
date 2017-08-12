package org.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.mp.model.Book;
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
	public ReserveBook getReserveBookByIdBook(int idbook) {
		ReserveBook resBook = new ReserveBook();
		try {
            String query = "select * from reservebook where idbook = ? ";
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
			//upodate reserve book
			String query = "UPDATE reservebook SET idnumber = ?, dateFrom = ?, dateTo = ? WHERE idbook_reservation = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            
            preparedStatement.setInt( 1, resbook.getIdnumber());
            preparedStatement.setString( 2, resbook.getDateFrom());
            preparedStatement.setString( 3, resbook.getDateTo());
            preparedStatement.setInt( 4, resbook.getIdbook_reservation());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            //update status from book
            String statusquery = "UPDATE book SET status = ? WHERE idbook = ?";
            PreparedStatement ps = conn.prepareStatement( statusquery );
            
            ps.setInt(1, resbook.getStatus());
            ps.setInt(2, resbook.getIdbook());

            ps.executeUpdate();
            ps.close();
            
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReserveBook(int idbook_reservation) {
		try {
			//get idbook
			int idbook = this.getIdBook(idbook_reservation);
			
			String delquery = "DELETE FROM reservebook WHERE idbook_reservation = ?";
			PreparedStatement ps1 = conn.prepareStatement( delquery );
			ps1.setInt(1, idbook_reservation);
			
			ps1.executeUpdate();
            ps1.close();
            
            //change status
            String updatequery = "UPDATE book SET status = ? WHERE idbook = ?";
			PreparedStatement ps2 = conn.prepareStatement( updatequery );
			ps2.setInt(1, 0);
			ps2.setInt(2, idbook);
			ps2.executeUpdate();
            ps2.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteByIdbook(int idbook) {
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

	
	@Override
	public List<ReserveBook> viewAllReserveBooks() {
		ArrayList<ReserveBook> resBooks = new ArrayList<ReserveBook>();
		 
		
		try {
            String query = "select * from reservebook";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	ReserveBook resBook = new ReserveBook();
            	
            	resBook.setIdbook_reservation(rs.getInt("idbook_reservation"));
            	resBook.setIdnumber(rs.getInt("idnumber"));
            	resBook.setIdbook(rs.getInt("idbook"));
            	
            	//get title and status from book table
            	BookDAO bookdao = new BookDAOImplementation();
            	Book book = new Book();
            	int idbook = rs.getInt("idbook");
            	book = bookdao.getBook(idbook);
            	
            	resBook.setTitle(book.getTitle());
            	resBook.setStatus(book.getStatus());
            	resBook.setDateFrom(rs.getString("dateFrom"));
            	resBook.setDateTo(rs.getString("dateTo"));
            	
            	resBooks.add(resBook);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resBooks;
	}

	@Override
	public int getIdBook(int idbook_reservation) {
		int idbook = 0;
		try {
			String query = "select idbook from reservebook where idbook_reservation = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, idbook_reservation);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	idbook = rs.getInt("idbook");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idbook;
	}

	@Override
	public List<ReserveBook> sortByID() {
		ArrayList<ReserveBook> resBooks = new ArrayList<ReserveBook>();
		try {
            String query = "select r.idbook_reservation,  r.idnumber, r.idbook, b.title, b.status, r.dateFrom, r.dateTo from reservebook r, book b where b.idbook = r.idbook order by r.idnumber asc;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	ReserveBook resBook = new ReserveBook();
            	
            	resBook.setIdbook_reservation(rs.getInt("idbook_reservation"));
            	resBook.setIdnumber(rs.getInt("idnumber"));
            	resBook.setIdbook(rs.getInt("idbook"));
            	resBook.setTitle(rs.getString("title"));
            	resBook.setStatus(rs.getInt("status"));
            	resBook.setDateFrom(rs.getString("dateFrom"));
            	resBook.setDateTo(rs.getString("dateTo"));
            	
            	resBooks.add(resBook);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resBooks;
	}
	
	@Override
	public List<ReserveBook> sortByTitle() {
		ArrayList<ReserveBook> resBooks = new ArrayList<ReserveBook>();
		try {
            String query = "select r.idbook_reservation,  r.idnumber, r.idbook, b.title, b.status, r.dateFrom, r.dateTo from reservebook r, book b where b.idbook = r.idbook order by b.title asc;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	ReserveBook resBook = new ReserveBook();
            	
            	resBook.setIdbook_reservation(rs.getInt("idbook_reservation"));
            	resBook.setIdnumber(rs.getInt("idnumber"));
            	resBook.setIdbook(rs.getInt("idbook"));
            	resBook.setTitle(rs.getString("title"));
            	resBook.setStatus(rs.getInt("status"));
            	resBook.setDateFrom(rs.getString("dateFrom"));
            	resBook.setDateTo(rs.getString("dateTo"));
            	
            	resBooks.add(resBook);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resBooks;
	}
	
	@Override
	public List<ReserveBook> sortByStatus() {
		ArrayList<ReserveBook> resBooks = new ArrayList<ReserveBook>();
		try {
            String query = "select r.idbook_reservation,  r.idnumber, r.idbook, b.title, b.status, r.dateFrom, r.dateTo from reservebook r, book b where b.idbook = r.idbook order by b.status asc;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	ReserveBook resBook = new ReserveBook();
            	
            	resBook.setIdbook_reservation(rs.getInt("idbook_reservation"));
            	resBook.setIdnumber(rs.getInt("idnumber"));
            	resBook.setIdbook(rs.getInt("idbook"));
            	resBook.setTitle(rs.getString("title"));
            	resBook.setStatus(rs.getInt("status"));
            	resBook.setDateFrom(rs.getString("dateFrom"));
            	resBook.setDateTo(rs.getString("dateTo"));
            	
            	resBooks.add(resBook);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resBooks;
	}
	
	@Override
	public List<ReserveBook> sortByDateFrom() {
		ArrayList<ReserveBook> resBooks = new ArrayList<ReserveBook>();
		try {
            String query = "select r.idbook_reservation,  r.idnumber, r.idbook, b.title, b.status, r.dateFrom, r.dateTo from reservebook r, book b where b.idbook = r.idbook order by r.dateFrom desc;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	ReserveBook resBook = new ReserveBook();
            	
            	resBook.setIdbook_reservation(rs.getInt("idbook_reservation"));
            	resBook.setIdnumber(rs.getInt("idnumber"));
            	resBook.setIdbook(rs.getInt("idbook"));
            	resBook.setTitle(rs.getString("title"));
            	resBook.setStatus(rs.getInt("status"));
            	resBook.setDateFrom(rs.getString("dateFrom"));
            	resBook.setDateTo(rs.getString("dateTo"));
            	
            	resBooks.add(resBook);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resBooks;
	}
	
	@Override
	public List<ReserveBook> sortByDateTo() {
		ArrayList<ReserveBook> resBooks = new ArrayList<ReserveBook>();
		try {
            String query = "select r.idbook_reservation,  r.idnumber, r.idbook, b.title, b.status, r.dateFrom, r.dateTo from reservebook r, book b where b.idbook = r.idbook order by r.dateTo desc;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	ReserveBook resBook = new ReserveBook();
            	
            	resBook.setIdbook_reservation(rs.getInt("idbook_reservation"));
            	resBook.setIdnumber(rs.getInt("idnumber"));
            	resBook.setIdbook(rs.getInt("idbook"));
            	resBook.setTitle(rs.getString("title"));
            	resBook.setStatus(rs.getInt("status"));
            	resBook.setDateFrom(rs.getString("dateFrom"));
            	resBook.setDateTo(rs.getString("dateTo"));
            	
            	resBooks.add(resBook);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resBooks;
	}
	
	public void updateStatus() {
		
	}
	
	@Override
	public void addReserveBook(ReserveBook resbook) {
		// TODO Auto-generated method stub
		try {

            String query = "insert into reservebook (idnumber, idbook, dateFrom, dateTo) values (?,?,?,?)";
        
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt( 1, resbook.getIdnumber());
            preparedStatement.setInt( 2, resbook.getIdbook());
            preparedStatement.setString( 3, resbook.getDateFrom());
            preparedStatement.setString( 4, resbook.getDateTo());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            //update status from book
            String statusquery = "UPDATE book SET status = ? WHERE idbook = ?";
            PreparedStatement ps = conn.prepareStatement( statusquery );
            
            ps.setInt(1, 1);
            ps.setInt(2, resbook.getIdbook());

            ps.executeUpdate();
            ps.close();
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
	}

	
}
