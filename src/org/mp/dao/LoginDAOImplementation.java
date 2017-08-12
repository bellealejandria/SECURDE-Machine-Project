package org.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	@Override
	public int getLoginAttempt(int idnumber) {
		int numOfTries = 0;
		
		try {
            String query = "select loginattempt from member where idnumber=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idnumber);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            	numOfTries = rs.getInt("loginattempt");
            }
            rs.close();
            ps.close();
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		return numOfTries;
	}

	@Override
	public void updateLogin(int idnumber, int ctr) {
		try {
			String query = "UPDATE member SET loginattempt = ? WHERE idnumber = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            
            preparedStatement.setInt( 1, ctr);
            preparedStatement.setInt( 2, idnumber);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getPass(int idNumber) {
		String pass = "";
		
		try {
            String query = "select password from member where idnumber=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idNumber);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            	pass = rs.getString("password");
            }
            rs.close();
            ps.close();
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		return pass;
	}

	@Override
	public void changePass(String password, int idNumber) {
		try {
			String query = "UPDATE member SET password = ? WHERE idnumber = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            
            preparedStatement.setString( 1, password);
            preparedStatement.setInt( 2, idNumber);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
 
}
