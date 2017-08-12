package org.mp.dao;

public interface LoginDAO {
    public boolean validate( int idnumber, String password );
    public boolean checkID( int idnumber);
    public boolean checkEmail( String email);
    public int getLoginAttempt(int idnumber);
    public void updateLogin(int idnumber, int ctr);
    public String getPass(int idNumber);
    public void changePass(String pw, int idNumber);

}