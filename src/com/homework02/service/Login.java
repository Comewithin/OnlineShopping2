package com.homework02.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.homework02.jdbc.JDBC;

public class Login {

    public static ResultSet rs = null;
	
	private static String sql = null; 
	
	public static boolean login(String[] phonenumber, String password){
		sql = "select password from users where phonenumber = ?";
		rs = JDBC.executeQuery1(sql, phonenumber);
		ArrayList<String> list = new ArrayList<String>();
		try {
			while(rs.next())
				list.add(rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list.contains(password))
			return true;
		return false;
	}
}
