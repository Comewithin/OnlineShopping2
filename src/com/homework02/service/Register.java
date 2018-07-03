package com.homework02.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.homework02.jdbc.JDBC;

public class Register {

	public static int rs1 = 0;//用来接收executeUpdate方法返回的结果集
	
	public static ResultSet rs2 = null;
	
	private static String sql = null;
	
	public static int insert(String[] str){
		sql = "insert into users (username, password, realname, gender, address, phonenumber) values(?, ?, ?, ?, ?, ?)";
		rs1 = JDBC.executeUpdate1(sql,str);
		return rs1;
	}
	
	public static boolean isExist(String str){
		sql = "select phonenumber from users";
		rs2 = JDBC.executeQuery1(sql, null);
		ArrayList<String> list = new ArrayList<String>();
		try {
			while(rs2.next())
				list.add(rs2.getString("phonenumber"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list.contains(str))
			return true;
		return false;
	}
}
