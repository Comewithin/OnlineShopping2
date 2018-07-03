package com.homework02.service;


import com.homework02.jdbc.JDBC;

public class Delete_Trolley {

	private static String sql = null;
	
	public static int rs = 0;//用来接收executeUpdate方法返回的结果集
	
	public static boolean delete_Trolley(int[] str){
		boolean flag = false;
		sql = "delete from trolley where id = ?";
		rs = JDBC.executeUpdate(sql,str);
		
		if(rs!=0) flag = true;
		
		return flag;
	}
}
