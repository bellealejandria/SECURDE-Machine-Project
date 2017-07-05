package org.mp.dao;

import org.mp.model.Member;

public interface LoginDAO {
    public boolean validate( int idnumber, String password );
    public boolean checkID( int idnumber);
    public boolean checkEmail( String email);
    public void addMember( Member member );
}