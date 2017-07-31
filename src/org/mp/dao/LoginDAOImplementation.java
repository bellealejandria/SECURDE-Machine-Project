package org.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.mp.model.Member;
import org.mp.util.DBConn;
 
public class LoginDAOImplementation implements LoginDAO {
 
    private Connection conn;
 
    public LoginDAOImplementation() {
        conn = DBConn.getConnection();
    }

    @Override
    public boolean validate( int idnumber, String password ) {
    	boolean status = false;
        try {
            String query = "select * from member where idnumber=? and password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idnumber);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


	@Override
	public boolean checkID( int idnumber ) {
    	boolean status = false;
        try {
            String query = "select * from member where idnumber=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idnumber);
            
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		boolean status = false;
        try {
            String query = "select * from member where email=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
	}
 
}
