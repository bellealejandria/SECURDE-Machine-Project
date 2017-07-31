package org.mp.dao;

public interface LoginDAO {
    public boolean validate( int idnumber, String password );
    public boolean checkID( int idnumber);
    public boolean checkEmail( String email);

}