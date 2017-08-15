package org.mp.controller;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.mp.util.DBConn;

public class AdminExportData {
	private Connection conn;
	
	public AdminExportData() {
		conn = DBConn.getConnection();
	}
	
	public void exportBook(String filename) {
		
    	 try {
             FileWriter fw = new FileWriter(filename);
          
             String query = "select * from book";
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             while (rs.next()) {
                 fw.append(rs.getString(1));
                 fw.append(',');
                 fw.append(rs.getString(2));
                 fw.append(',');
                 fw.append(rs.getString(3));
                 fw.append(',');
                 fw.append(rs.getString(4));
                 fw.append(',');
                 fw.append(rs.getString(5));
                 fw.append(',');
                 fw.append(rs.getString(6));
                 fw.append(',');
                 fw.append(rs.getString(7));
                 fw.append('\n');
                }
             fw.flush();
             fw.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
	     
	}
	
	public void exportRoom(String filename) {
		
   	 try {
            FileWriter fw = new FileWriter(filename);
         
            String query = "select * from room";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append('\n');
               }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	     
	}
}
