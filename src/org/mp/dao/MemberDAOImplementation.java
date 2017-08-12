package org.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mp.model.Member;
import org.mp.util.DBConn;

public class MemberDAOImplementation implements MemberDAO {
 
    private Connection conn;
 
    public MemberDAOImplementation() {
        conn = DBConn.getConnection();
    }
    


	@Override
	public Member getMember(int idnumber) {
		// TODO Auto-generated method stub
		Member member = new Member();
		try {
            String query = "select * from member where idnumber=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idnumber);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            	member.setIdNumber(idnumber);
            	member.setFirstName(rs.getString("firstName"));
            	member.setLastName(rs.getString("lastName"));
            	member.setBirthday(rs.getString("birthday"));
            	member.setEmail(rs.getString("email"));
            	member.setRole(rs.getString("role"));
            	
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return member;
	}

	@Override
	public void addMember(Member member) {
		try {
            String query = "insert into member (idnumber, firstName, midInitial, lastName, birthday, email, password, secretQuestion, secretAns, role) values (?,?,?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString( 10, member.getRole() );

            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
