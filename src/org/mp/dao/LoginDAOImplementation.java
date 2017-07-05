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
	public void addMember(Member member) {
		try {
            String query = "insert into member (idnumber, firstName, midInitial, lastName, birthday, email, password, secretQuestion, secretAns, occ) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt( 1, member.getIdNumber() );
            preparedStatement.setString( 2, member.getFirstName() );
            preparedStatement.setString( 3, member.getMidInitial() );
            preparedStatement.setString( 4, member.getLastName() );
            preparedStatement.setString( 5, member.getBirthday() );
            preparedStatement.setString( 6, member.getEmail() );
            preparedStatement.setString( 7, member.getPassword() );
            preparedStatement.setString( 8, member.getSecretQuestion() );
            preparedStatement.setString( 9, member.getSecretAns() );
            preparedStatement.setString( 10, member.getOcc() );

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
